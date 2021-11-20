package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Data
public class PetDto {

    private Integer id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;


    public PetDto(Pet obj){
        id = obj.getId();
        nome = obj.getNome();
        nascimento = obj.getNascimento();
    }
}
