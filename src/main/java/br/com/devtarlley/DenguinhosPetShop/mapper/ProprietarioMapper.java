package br.com.devtarlley.DenguinhosPetShop.mapper;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProprietarioMapper {


    Proprietario toEntity(ProprietarioDto proprietarioDto);

    List<Proprietario> toEntity(List<ProprietarioDto> proprietarioDto);

    ProprietarioDto toDto(Proprietario proprietario);
    List<ProprietarioDto> toDto(List<Proprietario> proprietario);
}
