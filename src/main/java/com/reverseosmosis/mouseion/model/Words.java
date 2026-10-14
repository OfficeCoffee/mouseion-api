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
@Table(name = "words")
public class Words {

  @Id
  @Column(name = "word_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer word_id;

  @Column(name = "word", nullable = false, length = 50)
  private String word;

  @Column(name = "origin", length = 200)
  private String origin;

  @Column(name = "definition", nullable = false, length = 200)
  private String definition;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreationTimestamp(source = SourceType.DB)
  Instant dateAdded;
}
