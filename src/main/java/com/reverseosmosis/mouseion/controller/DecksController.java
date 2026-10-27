package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.dto.DecksDto;
import com.reverseosmosis.mouseion.dto.DecksPutPostDto;
import com.reverseosmosis.mouseion.mapper.DeckWordDtoMapper;
import com.reverseosmosis.mouseion.mapper.DecksDtoMapper;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.service.DeckWordService;
import com.reverseosmosis.mouseion.service.DecksService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

  private final DeckWordDtoMapper deckWordDtoMapper;
  private final DeckWordService deckWordService;

  @GetMapping
  ResponseEntity<List<DecksDto>> getAllDecks() {
    return new ResponseEntity<>(
        decksDtoMapper.toDtoList(decksService.getAllDecks()), HttpStatus.OK);
  }

  @GetMapping("/id/{id}")
  ResponseEntity<?> getDeckById(@PathVariable Integer id) throws EntityNotFoundException {
    try {
      new ResponseEntity<>(decksDtoMapper.toDto(decksService.getDeckById(id)), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(decksDtoMapper.toDto(decksService.getDeckById(id)), HttpStatus.OK);
  }

  @GetMapping("/name/{name}")
  ResponseEntity<?> getDecksByName(@PathVariable String name) throws EntityNotFoundException {
    return new ResponseEntity<>(
        decksDtoMapper.toDtoList(decksService.getDecksByName(name)), HttpStatus.OK);
  }

  // Find all words in deck
  @GetMapping(path = "{deckId}/words")
  ResponseEntity<Object> getWordsInDeck(@PathVariable Integer deckId) {
    try {
      return new ResponseEntity<>(
          deckWordDtoMapper.toWordInDeckDtoList(deckWordService.getAllWordsInDeck(deckId)),
          HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
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

  // Post (create) add word to deck
  @PostMapping("{wordId}/deck/{deckId}")
  ResponseEntity<DeckWordDto> addWordToDeck(
      @PathVariable Integer wordId, @PathVariable Integer deckId) {

    DeckWordDto deckWordDto = new DeckWordDto(deckId, wordId);

    DeckWord deckWord = deckWordService.createDeckWordRequest(deckWordDto);

    return ResponseEntity.status(HttpStatus.CREATED).body(deckWordDtoMapper.toDto(deckWord));
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

  @DeleteMapping(path = "/delete/{deckId}")
  ResponseEntity<Object> deleteDeck(@PathVariable("deckId") Integer deck_id) {
    try {
      decksService.deleteDeck(deck_id);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping(path = "/delete/{deckId}/word/{wordId}")
  ResponseEntity<Object> deleteWordFromDeck(
      @PathVariable("deckId") Integer deckId, @PathVariable("wordId") Integer wordId) {
    try {
      deckWordService.deleteWordFromDeck(deckId, wordId);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
