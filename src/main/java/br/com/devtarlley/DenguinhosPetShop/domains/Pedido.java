package br.com.devtarlley.DenguinhosPetShop.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Pedido {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
     private Date instante;

     @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
     private Pagamento pagamento;

     @ManyToOne
     @JoinColumn(name = "proprietario_id")
     private Proprietario proprietario;

     @ManyToOne
     @JoinColumn(name = "endereco_entrega_id")
     private Endereco endereco;

     private Set<ItemPedido> itens = new HashSet<>();

     public Pedido(Integer id, Date instante, Proprietario proprietario, Endereco endereco) {
          this.id = id;
          this.instante = instante;
          this.proprietario = proprietario;
          this.endereco = endereco;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
          Pedido pedido = (Pedido) o;
          return Objects.equals(id, pedido.id);
     }

     @Override
     public int hashCode() {
          return 0;
     }
}
