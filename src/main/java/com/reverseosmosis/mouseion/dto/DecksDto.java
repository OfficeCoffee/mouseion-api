package com.reverseosmosis.mouseion.dto;

//import com.fasterxml.jackson.annotation.JsonFormat;
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

  //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss:Z", timezone = "UTC")
  Instant dateAdded;
}
