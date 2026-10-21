package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.DecksDto;
import com.reverseosmosis.mouseion.dto.DecksPutPostDto;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.service.DecksService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {DecksService.class})
public class DecksPutPostDtoMapper {
    
  Decks toEntity(DecksDto decksDto) throws EntityNotFoundException;

  DecksDto toDto(Decks decks) throws EntityNotFoundException;

  List<DecksDto> toDtoList(List<Decks> decksList) throws EntityNotFoundException;
  
  @InheritConfiguration
  Decks updateEntity(DecksPutPostDto decksPutPostDto, @MappingTarget Decks decks) throws EntityNotFoundException;

  Decks createEntity(DecksPutPostDto decksPutPostDto) throws EntityNotFoundException;
}
