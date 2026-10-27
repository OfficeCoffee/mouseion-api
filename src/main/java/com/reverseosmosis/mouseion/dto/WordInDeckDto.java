package com.reverseosmosis.mouseion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record WordInDeckDto(@NotNull Integer wordId, @NotNull String word) {}
