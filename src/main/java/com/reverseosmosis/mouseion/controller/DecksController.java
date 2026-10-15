package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.DecksDto;
import com.reverseosmosis.mouseion.mapper.DecksDtoMapper;
import com.reverseosmosis.mouseion.service.DecksService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "decks", produces = MediaType.APPLICATION_JSON_VALUE)
public class DecksController {

  private final DecksService decksService;

  @GetMapping
  ResponseEntity<List<DecksDto>> getAllDecks() { // Get all decks
    return new ResponseEntity<>(
        decksDtoMapper.toDtoList(decksService.getAllDecks()), HttpStatus.OK);
  }

  @GetMapping("{id}")
  ResponseEntity<DecksDto> getDeckById(@PathVariable Integer id) { // Get specific deck by id?
    return new ResponseEntity<>(decksDtoMapper.toDto(decksService.getDeckById(id)), HttpStatus.OK);
  }

  //Questions: How to get name specific search working? How to get repo into Bruno for testing?
  @GetMapping("{name}")
  ResponseEntity<DecksDto> getDecksByName(@RequestParam String name) throws EntityNotFoundException { // Get specific deck by name?
    return new ResponseEntity<>(
        decksDtoMapper.toDto(decksService.getDecksByName(name)), HttpStatus.OK);
  }
}
