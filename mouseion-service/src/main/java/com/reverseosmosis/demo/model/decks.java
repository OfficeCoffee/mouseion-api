package main.java.com.reverseosmosis.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "decks")
public class decks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deck_id", nullable = false)
    SmallInteger deckId;

    @Column(name = "deck_name", length = 50, nullable = false)
    String deckName;

    @Column(name = "created_at", nullable = false)
    @CreationTimeStamp(source = SourceType.DATABASE) //datetime datatype?
    Instant created_at;
}
