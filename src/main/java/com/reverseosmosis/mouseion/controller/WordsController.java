package com.reverseosmosis.mouseion.controller;

import com.reverseosmosis.mouseion.dto.WordsDto;
import com.reverseosmosis.mouseion.mapper.WordsMapper;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.service.WordsService;
import jakarta.persistence.EntityNotFoundException;
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
@RequestMapping(path = "words", produces = MediaType.APPLICATION_JSON_VALUE)
public class WordsController {

  private final WordsMapper wordsMapper;
  private final WordsService wordService;

  // Find all entities
  @GetMapping
  ResponseEntity<List<WordsDto>> getAllWords() {
    List<Words> test = wordService.getAllWords();
    System.out.println(test);
    return new ResponseEntity<>(wordsMapper.toDtoList(wordService.getAllWords()), HttpStatus.OK);
  }

  // Find entity by id
  @GetMapping(path = "/id/{id}")
  ResponseEntity<WordsDto> getWordById(@PathVariable Integer id) throws EntityNotFoundException {
    return new ResponseEntity<>(wordsMapper.toDto(wordService.getWordById(id)), HttpStatus.OK);
  }

  // Find entity by search string (similar to finding Student by firstName in the overview)
  @GetMapping(path = "/name/{name}")
  ResponseEntity<List<WordsDto>> getWordByName(@PathVariable String name)
      throws EntityNotFoundException {
    return new ResponseEntity<>(
        wordsMapper.toDtoList(wordService.getWordByName(name)), HttpStatus.OK);
  }
}
