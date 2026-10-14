package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.repository.DecksRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DecksService { // Problem with syntax + .findAll initially not found
    private final DecksRepository decksRepository;

    public List<Decks> getAllDecks() {
        return decksRepository.findAll();
    }

    public Decks getDeckById(Integer id) throws EntityNotFoundException{
        return decksRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Deck " + id + " not found"));
    }
}
