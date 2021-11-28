package br.com.devtarlley.DenguinhosPetShop.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;




    @JsonIgnore
    @OneToMany(mappedBy = "especie")
    private List<Raca> racas = new ArrayList<>();

    public Especie(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Especie especie = (Especie) o;
        return Objects.equals(id, especie.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
