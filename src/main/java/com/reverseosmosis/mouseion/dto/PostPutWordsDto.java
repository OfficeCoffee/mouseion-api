package com.reverseosmosis.mouseion.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class PostPutWordsDto {
  String word;

  String origin;

  String definition;
}
