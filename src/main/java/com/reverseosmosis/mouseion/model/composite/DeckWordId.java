package com.reverseosmosis.mouseion.model.composite;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Data 
@Embeddable 
@NoArgsConstructor 
public class DeckWordId implements Serializable{

    @Column(name = "deck_id")
    private Integer deckId;

    @Column(name = "word_id")
    private Integer wordId;
}