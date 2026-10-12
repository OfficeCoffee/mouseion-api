package com.reverseosmosis.demo.model;

import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "words")
public class words {
    
    @Id
    @Column(name = "word_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer word_id;

    @Column(name = "word", length = 50, nullable = false)
    String word;

    @Column(name = "origin", length = 200, nullable = true)
    String origin;

    @Column(name = "definition", length = 2000, nullable = false)
    String definition;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp(source = SourceType.DB) //datetime datatype?
    Instant created_at;

}
