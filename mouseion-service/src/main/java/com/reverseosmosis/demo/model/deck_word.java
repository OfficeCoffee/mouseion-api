package com.reverseosmosis.demo.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "deck_word")
public class deck_word {
    
    @EmbeddedId
    deck_word_id deck_word_id;
}