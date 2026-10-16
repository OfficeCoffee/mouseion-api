package com.reverseosmosis.mouseion.service;

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

  public List<Decks> getAllDecks() {
    return decksRepository.findAll();
  }

  public Decks getDeckById(@NonNull Integer id) throws EntityNotFoundException {
    return decksRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));
  }

  public List<Decks> getDecksByName(String name) throws EntityNotFoundException {
    return decksRepository.findByDeckName(name);
    // .orElseThrow(() -> new EntityNotFoundException("Deck " + name + " not found"));
  }

  //   public List<Decks> getDecksByName(String name) {
  //     Optional<List<Decks>> result = decksRepository.findByDeckName(deckName);
  //     if (result.isPresent() && result.get().isEmpty()) {
  //       throw new EntityNotFoundException("Decks with name " + deckName + " not found");
  //     }
  //     return result.get();
  //   }
}
