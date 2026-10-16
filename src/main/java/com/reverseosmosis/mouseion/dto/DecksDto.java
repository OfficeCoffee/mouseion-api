package com.reverseosmosis.mouseion.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class DecksDto {

  Integer deckId;

  String deckName;

  Instant dateAdded;
}
