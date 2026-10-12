package com.reverseosmosis.mouseion.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

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
public class Decks {

@Id 
@Column(name = "deck_id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer deck_id;

@Column(name = "deck_name", nullable = false, unique = true, length = 50)
private String deck_name;

@Column(name = "created_at", nullable = false, updatable = false)
@CreationTimestamp(source = SourceType.DB)
Instant dateAdded;
}
