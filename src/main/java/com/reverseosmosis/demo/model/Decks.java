package com.reverseosmosis.demo.model;

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
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "Deck")
public class Deck {

  @Id
  @Column(name = "deck_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer deckId;

  @Column(name = "deck_name", length = 50, nullable = false)
  String deckName;

  @Column(name = "created_at")
  @CreationTimestamp(source = SourceType.DB)
  Instant createdAt;
}
