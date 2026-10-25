package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.mapper.DeckWordDtoMapper;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.model.composite.DeckWordId;
import com.reverseosmosis.mouseion.repository.DeckWordRepository;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import com.reverseosmosis.mouseion.repository.WordsRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeckWordService {

  private final DeckWordRepository deckWordRepository;

  private final DeckWordDtoMapper deckWordDtoMapper;

  private final DecksRepository decksRepository;

  private final WordsRepo wordsRepository;

  public DeckWord createDeckWordRequest(DeckWordDto deckWordDto) throws EntityNotFoundException {
    DeckWord deckWord = deckWordDtoMapper.toEntity(deckWordDto);

    Decks deck = decksRepository
        .findById(deckWordDto.deckId())
        .orElseThrow(() -> new EntityNotFoundException("Deck not found"));

    Words word = wordsRepository
        .findById(deckWordDto.wordId())
        .orElseThrow(() -> new EntityNotFoundException("Word not found"));

    deckWord.setDeck(deck);
    deckWord.setWord(word);

    return deckWordRepository.saveAndFlush(deckWord);
  }

  public DeckWord updateDeckWordRequest(Integer deckId, Integer oldWordId, Integer newWordId)
      throws EntityNotFoundException {
    DeckWord oldDeckWord = deckWordRepository
        .findById(new DeckWordId(deckId, oldWordId))
        .orElseThrow(() -> new EntityNotFoundException("DeckWord reltaionship not found."));

    Decks deck = oldDeckWord.getDeck();

    Words newWord = wordsRepository
        .findById(newWordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found."));

    // Remove old relationship
    deckWordRepository.delete(oldDeckWord);
    deckWordRepository.flush();

    // Add new relationship
    DeckWord newDeckWord = new DeckWord();
    newDeckWord.setDeck(deck);
    newDeckWord.setWord(newWord);
    newDeckWord.setDeckWordId(new DeckWordId(deckId, newWordId));

    return deckWordRepository.save(newDeckWord);
  }

  public DeckWord getWordByDeckId(Integer deckId, Integer wordId) throws EntityNotFoundException {

    return deckWordRepository
        .findByDeckWordId_DeckIdAndDeckWordId_WordId(deckId, wordId)
        .orElseThrow(() -> new EntityNotFoundException("That word is not in this deck"));
  }

  public List<DeckWord> getAllWordsInDeck(Integer deckId) {
    return deckWordRepository.findByDeckWordId_DeckId(deckId);
  }

  public List<DeckWord> getAllDecksWithWord(Integer wordId) {
    return deckWordRepository.findByDeckWordId_WordId(wordId);
  }

  // public void deleteDeckWord(Integer deckId, Integer wordId) throws EntityNotFoundException {

  //   deckWordRepository
  //       .findByDeckWordId_DeckIdAndDeckWordId_WordId(deckId, wordId)
  //       .orElseThrow(() -> new EntityNotFoundException(
  //           "DeckWord " + deckId + deckId + " not found")); // Stops before deleting non-existing
  // deck
  //   deckWordRepository.deleteById(deckId);

  // }

}
