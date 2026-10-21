package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import com.reverseosmosis.mouseion.mapper.DecksDtoMapper;
import com.reverseosmosis.mouseion.mapper.DecksPutPostDtoMapper;
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
    //saveAndFlush? -> purpose?
  }

  // PUT, Update existing deck
  public Decks putDeck(Integer id, DecksPutPostDto decksPutPostDto) throws EntityNotFoundException {
    Decks deck = decksRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));
    
    return decksRepository.saveAndFlush(decksPutPostDtoMapper.updateEntity(decksPutPostDto, deck));
  }
}

// PUT = update existing resources
// POST = create new resources
