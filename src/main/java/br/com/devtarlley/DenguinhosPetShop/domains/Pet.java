package br.com.devtarlley.DenguinhosPetShop.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date idadeProvavel;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "especie_pet_id")
    private Especie especie_pet;

//    public Pet(Integer id, String nome, Date idadeProvavel, Especie especie) {
//        this.id = id;
//        this.nome = nome;
//        this.idadeProvavel = idadeProvavel;
//        this.especie = especie;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
