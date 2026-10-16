package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Words;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepo extends JpaRepository<Words, Integer> {

  List<Words> findByWord(String name);

  // @Query(
  //     value = "SELECT word, origin, definition, created_at FROM words WHERE word = ?1",
  //     nativeQuery = true)
  // Optional<Words> findByWord(String word);
}
