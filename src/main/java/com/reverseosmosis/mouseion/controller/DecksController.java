package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.DecksDto;
import com.reverseosmosis.mouseion.dto.DecksPutPostDto;
import com.reverseosmosis.mouseion.mapper.DecksDtoMapper;
import com.reverseosmosis.mouseion.mapper.DecksPutPostDtoMapper;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.service.DecksService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "decks", produces = MediaType.APPLICATION_JSON_VALUE)
public class DecksController {

  private final DecksDtoMapper decksDtoMapper;
  private final DecksService decksService;
  private final DecksPutPostDtoMapper decksPutPostDtoMapper;

  @GetMapping
  ResponseEntity<List<DecksDto>> getAllDecks() {
    return new ResponseEntity<>(
        decksDtoMapper.toDtoList(decksService.getAllDecks()), HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  ResponseEntity<DecksDto> getDeckById(@PathVariable Integer id) throws EntityNotFoundException {
    return new ResponseEntity<>(decksDtoMapper.toDto(decksService.getDeckById(id)), HttpStatus.OK);
  }

  @GetMapping("/name/{name}")
  ResponseEntity<List<DecksDto>> getDecksByName(@PathVariable String name)
      throws EntityNotFoundException { // Get specific deck by name?
    return new ResponseEntity<>(
        decksDtoMapper.toDtoList(decksService.getDecksByName(name)), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> createDeck(@RequestBody DecksPutPostDto decksPutPostDto) {
    Decks deck;
    try {
      deck = decksService.createDeck(decksPutPostDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(deck, HttpStatus.OK);
  }

  @PutMapping(path = "/{id}")
  ResponseEntity<Object> updateDeck(
      @PathVariable("id") Integer id, @RequestBody DecksPutPostDto decksPutPostDto) {
    Decks deck;
    try {
      deck = decksService.putDeck(id, decksPutPostDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(deck, HttpStatus.OK);
  }
}
