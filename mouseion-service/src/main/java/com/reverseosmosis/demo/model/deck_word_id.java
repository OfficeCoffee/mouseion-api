package com.reverseosmosis.demo.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
//import com.reverseosmosis.demo.model.decks;
//import com.reverseosmosis.demo.model.words;



@AllArgsConstructor
@Data
@Embeddable
@NoArgsConstructor
public class deck_word_id implements Serializable {
    
    @JoinColumn(name = "deck_id", nullable = false)
    @ManyToOne
    decks deck_id;

    @JoinColumn(name = "word_id", nullable = false)
    @ManyToOne
    words word_id;
}
