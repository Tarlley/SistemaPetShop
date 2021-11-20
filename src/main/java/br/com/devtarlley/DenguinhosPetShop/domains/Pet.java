package br.com.devtarlley.DenguinhosPetShop.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    @NotNull @NotBlank @NotEmpty
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "especie_pet_id")
    private Especie especie_pet;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets")
    @ToString.Exclude
    private List<Proprietario> proprietarios = new ArrayList<>();


   @ManyToOne
   @JoinColumn(name = "endereco_entrega_id")
   private Endereco enderecoEntrega;

//4

    public Pet(Integer id, String nome, Date nascimento, Especie especie_pet, Endereco enderecoEntrega) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.especie_pet = especie_pet;
        this.enderecoEntrega = enderecoEntrega;
    }

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
