package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Decks;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DecksRepository extends JpaRepository<Decks, Integer> {

  @Query(
      value = "SELECT deck_id, deck_name FROM decks d where d.deck_name = ?1",
      nativeQuery = true)
  Optional<Decks> findByDeckName(String name);

  // List<Decks> findByDeckName(String name);
  // Optional<List<Decks>> findByDeckId(Integer id);
  // List<Decks>
}
