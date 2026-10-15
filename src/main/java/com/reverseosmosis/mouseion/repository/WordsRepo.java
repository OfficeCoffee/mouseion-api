package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Words;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepo extends JpaRepository<Words, Integer> {

  @Query(
      value = "SELECT word, origin, definition FROM words w WHERE w.word = ?1",
      nativeQuery = true)
  Optional<Words> findByWord(String word);
}
