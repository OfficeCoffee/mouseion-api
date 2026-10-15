package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.WordsDto;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.service.WordsService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {WordsService.class})
public interface WordsMapper {

  Words toEntity(WordsDto wordsDto) throws EntityNotFoundException;

// Made static for the controller
  static WordsDto toDto(Words words) throws EntityNotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'toDto'");
}

// Made static for the controller
  static List<WordsDto> toDtoList(List<Words> wordsList) throws EntityNotFoundException {
    throw new UnsupportedOperationException("Unimplemented method 'toDtoList'");
}
}