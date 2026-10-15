package com.reverseosmosis.mouseion.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.reverseosmosis.mouseion.dto.DeckWordDto;
import com.reverseosmosis.mouseion.model.DeckWord;
import com.reverseosmosis.mouseion.service.DeckWordService;

import jakarta.persistence.EntityNotFoundException;

@Mapper (
    componentModel = "spring",
    uses = {DeckWordService.class})
public interface DeckWordDtoMapper {
    
    DeckWord toEntity(DeckWordDto deckWordDto) throws EntityNotFoundException;

    DeckWordDto toDto(DeckWord deckWord) throws EntityNotFoundException;

    List<DeckWordDto> toDtoList(List<DeckWord> deckWordList) throws EntityNotFoundException;
} 
