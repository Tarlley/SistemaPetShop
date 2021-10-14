package br.com.devtarlley.DenguinhosPetShop.domains;

import br.com.devtarlley.DenguinhosPetShop.domains.Enum.EstadoPagamento;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import java.util.Objects;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@Entity
public class PagamentoCartao extends Pagamento{

    private Integer parcelas;

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer parcelas) {
        super(id, estado, pedido);
        this.parcelas = parcelas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PagamentoCartao that = (PagamentoCartao) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
