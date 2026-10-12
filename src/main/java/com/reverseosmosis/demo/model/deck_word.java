package com.reverseosmosis.demo.model;

import com.reverseosmosis.mouseion.model.composite.DeckWordId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "Deck_Word")
public class Deck_Word {

  @EmbeddedId 
  DeckToWordId id;

  @JoinColumn(name = "deck_id")
  @ManyToOne
  @MapsId("deck_id")
  Integer deckId;

  @JoinColumn(name = "word_id")
  @ManyToOne
  @MapsId("word_id")
  Integer wordId;
}
