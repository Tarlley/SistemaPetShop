package br.com.devtarlley.DenguinhosPetShop.domains.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

@Getter
public enum Tipo {
    SERVICO(1,"Serviço"),
    PRODUTO(2,"Produto");

    private int cod;
    private String descricao;


    public static Tipo toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Tipo x : Tipo.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
