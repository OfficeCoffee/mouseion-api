package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.repository.WordsRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordsService {

  private final WordsRepo wordsRepository;

  // Find all entities
  public List<Words> getAllWords() {
    return wordsRepository.findAll();
  }

  // Find entity by id
  public Words getWordById(Integer id) throws EntityNotFoundException {
    return wordsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Word (" + id + ") not found"));
  }

  // Find entity by search string (similar to finding Student by firstName in the overview)
  public Words getWordByName(String word) throws EntityNotFoundException {
    return wordsRepository
        .findByWord(word)
        .orElseThrow(() -> new EntityNotFoundException("Word (" + word + ") not found"));
  }
}