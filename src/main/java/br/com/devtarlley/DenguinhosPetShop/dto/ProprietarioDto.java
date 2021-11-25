package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class ProprietarioDto {

    private Integer id;
    @CPF(message = "Por faovr preencha um CPF válido")
    private String CPF;
    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, message = "Nome deve ter no minimo 3 caracteres")
    private String nome;
    @NotNull
    @Email(message = "email deve ser preenchido")
    private String email;


    public ProprietarioDto(Proprietario obj){
        id = obj.getId();
        nome = obj.getNome();
        CPF = obj.getCPF();
        email = obj.getEmail();
    }

}
