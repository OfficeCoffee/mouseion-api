package com.reverseosmosis.mouseion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "decks")
public class Decks {

  @Id
  @Column(name = "deck_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer deckId;

  @Column(name = "deck_name", nullable = false, unique = true, length = 50)
  private String deckName;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp(source = SourceType.DB)
  private Instant dateAdded;
}
