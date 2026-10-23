package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.dto.DecksPutPostDto;
import com.reverseosmosis.mouseion.mapper.DecksPutPostDtoMapper;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DecksService {
  private final DecksRepository decksRepository;
  private final DecksPutPostDtoMapper decksPutPostDtoMapper;

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
    // Deck only has string (name) when created. ID and dateAdded generated on DB end
    return decksRepository.saveAndFlush(decksPutPostDtoMapper.createEntity(decksPutPostDto));
  }

  // PUT, Update existing deck
  public Decks putDeck(Integer id, DecksPutPostDto decksPutPostDto) throws EntityNotFoundException {
    Decks deck = decksRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));

    return decksRepository.saveAndFlush(decksPutPostDtoMapper.updateEntity(decksPutPostDto, deck));
  }

  public void deleteDeck(Integer id) throws EntityNotFoundException {

    decksRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException(
            "Deck " + id + " not found")); // Stops before deleting non-existing deck
    System.out.printf("test");
    decksRepository.deleteById(id);
    //decksRepository.count()).isEqualTo(1);

    // decksRepository.findById(id)
    // for loop for delete all words, count() for i?
  }
}

