package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.mapper.DeckWordDtoMapper;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.repository.DeckWordRepository;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import com.reverseosmosis.mouseion.repository.WordsRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

  @Transactional
  public void deleteWordFromDeck(Integer deckId, Integer wordId) throws EntityNotFoundException {

    decksRepository
        .findById(deckId)
        .orElseThrow(() -> new EntityNotFoundException("Deck not found."));
    wordsRepository
        .findById(wordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found."));

    DeckWord deckWord = deckWordRepository
        .findDeckWord(deckId, wordId)
        .orElseThrow(() -> new EntityNotFoundException("This word is not in this deck."));

    deckWordRepository.delete(deckWord);
    deckWordRepository.flush();

    if (deckWordRepository.findDeckWordByWordId(wordId).isEmpty()) {
      wordsRepository.deleteById(wordId);
    }
  }

  public DeckWord getWordByDeckId(Integer deckId, Integer wordId) throws EntityNotFoundException {

    return deckWordRepository
        .findDeckWord(deckId, wordId)
        .orElseThrow(() -> new EntityNotFoundException("That word is not in this deck"));
  }

  public List<DeckWord> getAllWordsInDeck(Integer deckId) throws EntityNotFoundException {

    decksRepository
        .findById(deckId)
        .orElseThrow(() -> new EntityNotFoundException("Deck not foud."));

    return deckWordRepository.findDeckWordByDeckId(deckId);
  }

  public List<DeckWord> getAllDecksWithWord(Integer wordId) {

    wordsRepository
        .findById(wordId)
        .orElseThrow(() -> new EntityNotFoundException("Word not found"));

    return deckWordRepository.findDeckWordByWordId(wordId);
  }
}
