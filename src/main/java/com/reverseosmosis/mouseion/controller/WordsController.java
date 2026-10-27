package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.PostPutWordsDto;
import com.reverseosmosis.mouseion.dto.WordsDto;
import com.reverseosmosis.mouseion.mapper.WordsMapper;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.service.WordsService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping(path = "words", produces = MediaType.APPLICATION_JSON_VALUE)
public class WordsController {

  private final WordsMapper wordsMapper;
  private final WordsService wordService;

  // Find all entities
  @GetMapping
  ResponseEntity<List<WordsDto>> getAllWords() {
    wordService.getAllWords();
    return new ResponseEntity<>(wordsMapper.toDtoList(wordService.getAllWords()), HttpStatus.OK);
  }

  // Find entity by id
  @GetMapping(path = "/id/{id}")
  ResponseEntity<?> getWordById(@PathVariable Integer id) throws EntityNotFoundException {

    try {
      new ResponseEntity<>(wordsMapper.toDto(wordService.getWordById(id)), HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(wordsMapper.toDto(wordService.getWordById(id)), HttpStatus.OK);
  }

  // Find entity by search string (similar to finding Student by firstName in the overview)
  @GetMapping(path = "/name/{name}")
  ResponseEntity<List<WordsDto>> getWordByName(@PathVariable String name)
      throws EntityNotFoundException {
    return new ResponseEntity<>(
        wordsMapper.toDtoList(wordService.getWordByName(name)), HttpStatus.OK);
  }

  // Post (Create) a new word
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> submitWord(@RequestBody PostPutWordsDto postPutWordsDto) {
    Words word;
    try {
      word = wordService.createWord(postPutWordsDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(word, HttpStatus.OK);
  }

  // Put (Update) an existing word
  @PutMapping(path = "/{id}")
  ResponseEntity<Object> updateWorkOrder(
      @PathVariable("id") Integer id, @RequestBody PostPutWordsDto postPutWordsDto) {
    Words word;
    try {
      word = wordService.putWord(id, postPutWordsDto);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(word, HttpStatus.OK);
  }
}
