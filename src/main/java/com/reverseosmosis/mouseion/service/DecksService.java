package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.dto.DecksPutPostDto;
import com.reverseosmosis.mouseion.mapper.DecksPutPostDtoMapper;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.repository.DeckWordRepository;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import com.reverseosmosis.mouseion.repository.WordsRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DecksService {
  private final DecksRepository decksRepository;
  private final DecksPutPostDtoMapper decksPutPostDtoMapper;

  private final DeckWordRepository deckWordRepository;
  private final WordsRepo wordsRepository;

  // GET all Decks
  public List<Decks> getAllDecks() {
    return decksRepository.findAll();
  }

  // GET Deck by ID
  public Decks getDeckById(@NonNull Integer id) throws EntityNotFoundException {
    return decksRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));
  }

  // GET Deck by name
  public List<Decks> getDecksByName(String name) throws EntityNotFoundException {
    return decksRepository.findByDeckName(name);
  }

  // POST, Create new Deck
  public Decks createDeck(DecksPutPostDto decksPutPostDto) throws EntityNotFoundException {
    return decksRepository.saveAndFlush(decksPutPostDtoMapper.createEntity(decksPutPostDto));
  }

  // PUT, Update existing deck
  public Decks putDeck(Integer id, DecksPutPostDto decksPutPostDto) throws EntityNotFoundException {
    Decks deck =
        decksRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));

    return decksRepository.saveAndFlush(decksPutPostDtoMapper.updateEntity(decksPutPostDto, deck));
  }

  @Transactional
  public void deleteDeck(Integer deckId) {
    Decks deck =
        decksRepository
            .findById(deckId)
            .orElseThrow(() -> new EntityNotFoundException("Deck not found."));

    // TODO: Convert this to a stream mapping later (monad :D)
    List<Integer> wordIds = new ArrayList<>();

    // Adds all the word ids in the deck into wordIds
    for (DeckWord dw : deckWordRepository.findDeckWordByDeckId(deckId)) {
      wordIds.add(dw.getWord().getWordId());
    }

    // Delete the relationship
    deckWordRepository.deleteAll(deckWordRepository.findDeckWordByDeckId(deckId));

    // Delete the deck
    decksRepository.delete(deck);

    deckWordRepository.flush();

    // Delete every hanging child / word
    for (Integer wordId : wordIds) {
      if (deckWordRepository.findDeckWordByWordId(wordId).isEmpty()) {
        wordsRepository.deleteById(wordId);
      }
    }
  }
}
