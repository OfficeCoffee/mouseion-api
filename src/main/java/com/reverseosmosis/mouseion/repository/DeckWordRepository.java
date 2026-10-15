package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.composite.DeckWordId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckWordRepository extends JpaRepository<DeckWord, DeckWordId> {
  // Find the combination of deck and word using the ids (composite key)
  Optional<DeckWord> findByDeckWordId_DeckIdAndDeckWordId_WordId(Integer deckId, Integer wordId);

  // Find all decks containing the passed in word id
  List<DeckWord> findByDeckWordId_WordId(Integer wordId);

  // Find all words contained in the passed in deck id
  List<DeckWord> findByDeckWordId_DeckId(Integer deckId);
}
