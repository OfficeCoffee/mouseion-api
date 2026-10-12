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

@Data
@Entity
@Table(name = "decks")
public class decks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id", nullable = false)
    Integer deck_id;
    
    @Column(name = "deck_name", length = 50, nullable = false)
    String deckName;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp(source = SourceType.DB) //datetime datatype?
    Instant created_at;
}
