package br.com.devtarlley.DenguinhosPetShop.mapper;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.PetDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PetMapper {


    Pet toEntity(PetDto petDto);

    List<Pet> toEntity(List<PetDto> petDto);

    PetDto toDto(Pet pet);
    List<PetDto> toDto(List<Pet> pet);
}
