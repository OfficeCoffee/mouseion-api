package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.service.DeckWordService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {DeckWordService.class})
public interface DeckWordDtoMapper {

  @Mapping(target = "deckId", source = "deck.deckId")
  @Mapping(target = "deckName", source = "deck.deckName")
  @Mapping(target = "wordId", source = "word.wordId")
  @Mapping(target = "wordValue", source = "word.word")
  DeckWordDto toDto(DeckWord deckWord);

  List<DeckWordDto> toDtoList(List<DeckWord> deckWordList);
}
