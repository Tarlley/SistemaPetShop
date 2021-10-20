package br.com.devtarlley.DenguinhosPetShop.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Embeddable
public class ItemPedidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return item.equals(that.item) && pedido.equals(that.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, pedido);
    }
}
