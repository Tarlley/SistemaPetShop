package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.services.validation.ProprietarioInsert;
import br.com.devtarlley.DenguinhosPetShop.services.validation.ProprietarioUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ProprietarioInsert
public class ProprietarioNewDto {

    private Integer id;
    @NotNull
    @org.hibernate.validator.constraints.br.CPF(message = "Por faovr preencha um CPF válido")
    private String CPF;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 3, message = "Nome deve ter no minimo 3 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "email deve ser preenchido")
    @Column(unique = true)
    private String email;

}
