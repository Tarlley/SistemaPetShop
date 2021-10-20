package br.com.devtarlley.DenguinhosPetShop.domains;


import br.com.devtarlley.DenguinhosPetShop.domains.Enum.Tipo;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    private Set<ItemPedido> itens = new HashSet<>();

    public List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido x : itens){
            lista.add(x.getPedido());
        }
        return lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
