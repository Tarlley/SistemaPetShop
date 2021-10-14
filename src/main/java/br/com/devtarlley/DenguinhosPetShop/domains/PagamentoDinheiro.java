package br.com.devtarlley.DenguinhosPetShop.domains;

import br.com.devtarlley.DenguinhosPetShop.domains.Enum.EstadoPagamento;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Entity
public class PagamentoDinheiro extends Pagamento {

    private Date dataPagamento;

    public PagamentoDinheiro(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PagamentoDinheiro that = (PagamentoDinheiro) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
