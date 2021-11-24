package br.com.devtarlley.DenguinhosPetShop.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Proprietario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Data

public class ProprietarioDto {

    private Integer id;
    private String CPF;
    private String nome;
    private String email;

    private Set<String> telefones = new HashSet<>();

    public ProprietarioDto(Proprietario obj){
        id = obj.getId();
        nome = obj.getNome();
        CPF = obj.getCPF();
        email = obj.getEmail();
        telefones = obj.getTelefones();
    }

}
