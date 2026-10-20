package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.GetDeckWordDto;
import com.reverseosmosis.mouseion.mapper.DeckWordDtoMapper;
import com.reverseosmosis.mouseion.service.DeckWordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "deckWord", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeckWordController {

  private final DeckWordDtoMapper deckWordDtoMapper;

  private final DeckWordService deckWordService;

  @GetMapping(path = "deck/{deckId}/word/{wordId}")
  public ResponseEntity<GetDeckWordDto> getWordByDeckId(
      @PathVariable Integer deckId, @PathVariable Integer wordId) {
    return new ResponseEntity<>(
        deckWordDtoMapper.toDto(deckWordService.getWordByDeckId(deckId, wordId)), HttpStatus.OK);
  }

  @GetMapping(path = "deck/{deckId}")
  public ResponseEntity<List<GetDeckWordDto>> getAllWordsInDeck(@PathVariable Integer deckId) {
    return new ResponseEntity<>(
        deckWordDtoMapper.toDtoList(deckWordService.getAllWordsInDeck(deckId)), HttpStatus.OK);
  }

  @GetMapping(path = "word/{wordId}")
  public ResponseEntity<List<GetDeckWordDto>> getAllDecksWithWord(@PathVariable Integer wordId) {
    return new ResponseEntity<>(
        deckWordDtoMapper.toDtoList(deckWordService.getAllDecksWithWord(wordId)), HttpStatus.OK);
  }

  // Testing method to make sure the connection is working
  // @GetMapping("/test")
  // public String test() {
  //   return "Rose was here :D";
  // }
}
