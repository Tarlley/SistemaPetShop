package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Pet;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Data
public class PetDto {

    private Integer id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, message = "Nome deve ter no minimo 3 caracteres")
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;


    public PetDto(Pet obj){
        id = obj.getId();
        nome = obj.getNome();
        nascimento = obj.getNascimento();
    }
}
