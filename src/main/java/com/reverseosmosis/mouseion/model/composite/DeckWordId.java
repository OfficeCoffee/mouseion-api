package com.reverseosmosis.mouseion.model.composite;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Data 
@Embeddable 
@NoArgsConstructor 
public class DeckWordId implements Serializable{

    private Integer deck_id;
    private Integer word_id;
}