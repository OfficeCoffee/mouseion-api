package com.reverseosmosis.mouseion.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class WordsDto {
  Integer word_id;

  String word;

  String origin;

  String definition;

  Instant dateAdded;
}
