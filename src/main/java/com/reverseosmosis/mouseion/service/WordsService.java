package com.reverseosmosis.mouseion.service;

import com.reverseosmosis.mouseion.dto.PostPutWordsDto;
import com.reverseosmosis.mouseion.mapper.WordsMapper;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.repository.WordsRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WordsService {

  private final WordsRepo wordsRepository;

  private final WordsMapper wordsMapper;

  // Find all entities
  public List<Words> getAllWords() {
    return wordsRepository.findAll();
  }

  // Find entity by id
  public Words getWordById(@NonNull Integer id) throws EntityNotFoundException {
    return wordsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Word (" + id + ") not found"));
  }

  // Find entity by search string (similar to finding Student by firstName in the overview)
  public List<Words> getWordByName(String word) throws EntityNotFoundException {
    return wordsRepository.findByWord(word);
  }

  // Post (Create) a new word
  public Words createWord(PostPutWordsDto postPutWordsDto) throws EntityNotFoundException {
    return wordsRepository.saveAndFlush(wordsMapper.createEntity(postPutWordsDto));
  }

  // Put (Update) an existing word
  public Words putWord(Integer id, PostPutWordsDto postPutWordsDto) throws EntityNotFoundException {
    Words word = wordsRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Word (" + id + ") not found"));
    return wordsRepository.saveAndFlush(wordsMapper.updateEntity(postPutWordsDto, word));
  }

  // public void deleteWord(Integer id) throws EntityNotFoundException {

  //   wordsRepository
  //       .findById(id)
  //       .orElseThrow(() -> new EntityNotFoundException(
  //           "Word " + id + " not found")); // Stops before deleting non-existing deck
  //   wordsRepository.deleteById(id);
  // }

}
