package br.com.devtarlley.DenguinhosPetShop.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class ItemPedido {

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    @JsonIgnore
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    public Pedido getPedido(){
        return id.getPedido();
    }

    public Item getItem(){
        return id.getItem();
    }

    public ItemPedido(Double desconto, Integer quantidade, Double preco, Pedido pedido, Item item) {
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
        id.setPedido(pedido);
        id.setItem(item);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
