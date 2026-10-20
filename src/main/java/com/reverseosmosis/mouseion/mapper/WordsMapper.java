package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.PostPutWordsDto;
import com.reverseosmosis.mouseion.dto.WordsDto;
import com.reverseosmosis.mouseion.model.Words;
import com.reverseosmosis.mouseion.service.WordsService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {WordsService.class})
public interface WordsMapper {

  Words toEntity(WordsDto wordsDto) throws EntityNotFoundException;

  WordsDto toDto(Words words) throws EntityNotFoundException;

  List<WordsDto> toDtoList(List<Words> wordsList) throws EntityNotFoundException;

  Words createEntity(PostPutWordsDto postPutWordsDto) throws EntityNotFoundException;

  @InheritConfiguration
  Words updateEntity(PostPutWordsDto postPutWordsDto, @MappingTarget Words word)
      throws EntityNotFoundException;
}
