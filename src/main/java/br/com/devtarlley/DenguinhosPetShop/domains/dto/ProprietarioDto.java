package br.com.devtarlley.DenguinhosPetShop.domains.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import br.com.devtarlley.DenguinhosPetShop.services.validation.ProprietarioInsert;
import br.com.devtarlley.DenguinhosPetShop.services.validation.ProprietarioUpdate;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

@ProprietarioUpdate
public class ProprietarioDto {

    private Integer id;
//    @NotNull
//    @CPF(message = "Por faovr preencha um CPF válido")
//    private String CPF;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 3, message = "Nome deve ter no minimo 3 caracteres")
    private String nome;
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "email deve ser preenchido")
    @Column(unique = true)
    private String email;


    public ProprietarioDto(Proprietario obj){
        id = obj.getId();
        nome = obj.getNome();
//        CPF = obj.getCPF();
        email = obj.getEmail();
    }

}
