package com.reverseosmosis.demo.model.composite;

import com.reverseosmosis.demo.model.Words;
import com.reverseosmosis.demo.model.Decks;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class DeckWordId implements Serializable {

  @JoinColumn(name = "deck_id", nullable = false)
  @ManyToOne
  Integer deckId;

  @JoinColumn(name = "word_id", nullable = false)
  @ManyToOne
  Integer wordId;
}
