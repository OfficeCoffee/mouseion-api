package com.reverseosmosis.mouseion.model;

import com.reverseosmosis.mouseion.model.composite.DeckWordId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deck_word")
public class DeckWord {
  @EmbeddedId
  private DeckWordId deckWordId = new DeckWordId();

  @JoinColumn(name = "deck_id", nullable = false)
  @ManyToOne
  @MapsId("deckId")
  private Decks deck;

  @JoinColumn(name = "word_id", nullable = false)
  @ManyToOne
  @MapsId("wordId")
  private Words word;
}
