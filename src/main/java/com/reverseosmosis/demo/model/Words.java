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
@Table(name = "Words")
public class Words {

  @Id
  @Column(name = "word_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer wordId;

  @Column(name = "word", length = 50, nullable = false)
  String word;

  @Column(name = "origin", length = 200)
  String origin;

  @Column(name = "definition", length = 2000)
  String definition;

  @Column(name = "created_at")
  @CreationTimestamp(source = SourceType.DB)
  Instant createdAt;
}
