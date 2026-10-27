package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.model.composite.DeckWordId;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckWordRepository extends JpaRepository<DeckWord, DeckWordId> {

  // Find the combination of deck and word using the ids (composite key)
  @Query("SELECT dw from DeckWord dw WHERE dw.deck.deckId = :deckId and dw.word.wordId = :wordId")
  Optional<DeckWord> findDeckWord(@Param("deckId") Integer deckId, @Param("wordId") Integer wordId);

  // Find all words contained in the passed in deck id
  @Query("SELECT dw from DeckWord dw where dw.deck.deckId = :deckId")
  List<DeckWord> findDeckWordByDeckId(@Param("deckId") Integer deckId);

  // Find all decks containing the passed in word id
  @Query("SELECT dw from DeckWord dw where dw.word.wordId = :wordId")
  List<DeckWord> findDeckWordByWordId(@Param("wordId") Integer wordId);
}
