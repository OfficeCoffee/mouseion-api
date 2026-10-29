package com.reverseosmosis.mouseion.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PostPutWordsDto(@NotNull String word, String origin, @NotNull String definition) {}
