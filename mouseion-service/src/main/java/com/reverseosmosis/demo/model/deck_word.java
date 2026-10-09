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
@Table(name = "deck_word")
public class deck_word {
    
    @EmbeddedId
    deck_word_id id;
    // How to make composite key?/reference word_id and deck_id?
    // Example Room.java only has following...
}