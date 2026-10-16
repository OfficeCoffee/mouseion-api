package com.reverseosmosis.mouseion.repository;

import java.util.List;
import java.util.Optional;
import java.util.List;
import com.reverseosmosis.mouseion.model.Decks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DecksRepository extends JpaRepository<Decks, Integer> {

    List<Decks> findByActiveTrue();

    @Query (value = "SELECT deck_id, deck_name, created_at FROM decks d where d.deck_name = ?1", nativeQuery = true)
    Optional<Decks> findByDecksName(String name);
}
