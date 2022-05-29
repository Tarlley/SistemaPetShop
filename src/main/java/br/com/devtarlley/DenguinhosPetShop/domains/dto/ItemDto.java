package br.com.devtarlley.DenguinhosPetShop.domains.dto;

import br.com.devtarlley.DenguinhosPetShop.domains.Item;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Timer;

@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
@ToString
public class ItemDto {

    private Integer id;
    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 3, message = "O nome do item deve ter no mínimo 3 caracteres")
    private String nome;
    @NotNull
    private Double preco;

    public ItemDto (Item obj){
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
    }
}
