package com.reverseosmosis.mouseion.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class DecksPutPostDto {
    
    String deckName;

}
