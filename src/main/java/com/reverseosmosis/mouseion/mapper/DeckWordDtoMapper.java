package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.dto.WordInDeckDto;
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
  @Mapping(target = "wordId", source = "word.wordId")
  DeckWordDto toDto(DeckWord deckWord);

  @Mapping(target = "deck", ignore = true)
  @Mapping(target = "word", ignore = true)
  DeckWord toEntity(DeckWordDto deckWordDto);

  List<DeckWordDto> toDtoList(List<DeckWord> deckWordList);

  @Mapping(target = "wordId", source = "word.wordId")
  @Mapping(target = "word", source = "word.word")
  WordInDeckDto toWordInDeckDto(DeckWord deckWord);

  List<WordInDeckDto> toWordInDeckDtoList(List<DeckWord> deckWords);
}
