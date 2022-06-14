package br.com.devtarlley.DenguinhosPetShop.domains.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class PetNewDto {

    private Integer id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private Integer especie;

    private Integer cidadeId;

}
