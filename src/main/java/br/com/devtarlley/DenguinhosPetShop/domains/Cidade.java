package br.com.devtarlley.DenguinhosPetShop.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@ToString
@Entity
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "cidade" )
    @ToString.Exclude
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
