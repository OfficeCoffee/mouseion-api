package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Decks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecksRepository extends JpaRepository<Decks, Integer> {}
