package com.reverseosmosis.mouseion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record AddWordToDeckDto(
    @NotNull String word, String origin, @NotNull String definition, @NotNull Integer deckId) {}
