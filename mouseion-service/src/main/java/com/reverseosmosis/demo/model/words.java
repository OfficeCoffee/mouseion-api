package main.java.com.reverseosmosis.demo.model;

import java.lang.annotation.Inherited;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;





@Data
@Entity
@Table(name = "words")
public class words {
    
    @Inherited 
    @Column(name = "word_id", nullable = false)
    @GerativeValue(strategy = GenerationType.IDENTITY)
    MediumInteger word_id;

    @Column(name = "word", length = 50, nullable = false)
    String word;

    @Column(name = "origin", length = 200, nullable = true)
    String origin;

    @Column(name = "definition", length = 2000, nullable = false)
    String definition;

    @Column(name = "created_at", nullable = false)
    @CreationTimeStamp(source = SourceType.DATABASE) //datetime datatype?
    Instant created_at;



}
