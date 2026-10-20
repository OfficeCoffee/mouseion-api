package com.reverseosmosis.mouseion.dto;

import lombok.Builder;

@Builder
public record GetDeckWordDto(Integer deckId, String deckName, Integer wordId, String wordValue) {}
