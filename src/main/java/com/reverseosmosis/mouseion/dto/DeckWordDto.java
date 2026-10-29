package com.reverseosmosis.mouseion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record DeckWordDto(@NotNull Integer deckId, @NotNull Integer wordId) {}
