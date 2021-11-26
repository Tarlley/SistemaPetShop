package br.com.devtarlley.DenguinhosPetShop.dto;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Data
public class ProprietarioNewDto {

    private String CPF;
    private String nome;
    private String email;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;

    private String telefone1;
    private String telefone2;
    private String telefone3;

    private Integer cidadeId;
}
