package br.com.devtarlley.DenguinhosPetShop.domains.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class ProprietarioDto {

    private Integer id;
    @NotNull
    @CPF(message = "Por faovr preencha um CPF válido")
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
