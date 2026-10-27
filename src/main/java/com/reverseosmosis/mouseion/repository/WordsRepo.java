package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Words;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordsRepo extends JpaRepository<Words, Integer> {
  List<Words> findByWord(String name);

  @Query(value = "SELECT * FROM words ORDER BY created_at DESC LIMIT 10", nativeQuery = true)
  List<Words> findTenWordsByDate();
}
