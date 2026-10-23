package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.repository.DeckWordRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeckWordService {

  private final DeckWordRepository deckWordRepository;

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
