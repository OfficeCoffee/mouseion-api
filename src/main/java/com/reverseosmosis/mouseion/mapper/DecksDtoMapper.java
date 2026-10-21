package com.reverseosmosis.mouseion.mapper;

import com.reverseosmosis.mouseion.dto.DecksDto;
import com.reverseosmosis.mouseion.model.Decks;
import com.reverseosmosis.mouseion.service.DecksService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {DecksService.class})
public interface DecksDtoMapper {

  Decks toEntity(DecksDto decksDto) throws EntityNotFoundException;

  DecksDto toDto(Decks decks) throws EntityNotFoundException;

  List<DecksDto> toDtoList(List<Decks> decksList) throws EntityNotFoundException;
  
}
