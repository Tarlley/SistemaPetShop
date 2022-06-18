package br.com.devtarlley.DenguinhosPetShop.domains.dto;

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
    @Size(min = 2, message = "Nome deve ter no minimo 2 caracteres")
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

}
