package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class ProprietarioDto {

    private Integer id;
    private String CPF;
    private String nome;
    private String email;


    public ProprietarioDto(Proprietario obj){
        id = obj.getId();
        nome = obj.getNome();
        CPF = obj.getCPF();
        email = obj.getEmail();
    }

}
