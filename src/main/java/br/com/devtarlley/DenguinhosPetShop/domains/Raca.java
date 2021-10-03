package br.com.devtarlley.DenguinhosPetShop.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Raca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "especie_raca_id")
    private Especie especie_raca;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Raca raca = (Raca) o;
        return Objects.equals(id, raca.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
