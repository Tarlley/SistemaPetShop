package br.com.devtarlley.DenguinhosPetShop.domains;


import br.com.devtarlley.DenguinhosPetShop.domains.Enum.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;




    @ManyToOne
    @JoinColumn(name = "raca_pet_id")
    private Raca raca_pet;

    @JsonIgnore
    @ManyToMany(mappedBy = "pets")
    @ToString.Exclude
    private List<Proprietario> proprietarios = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

//4

    public Pet(Integer id, String nome, Date nascimento, Endereco enderecoEntrega, Raca raca_pet) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.enderecoEntrega = enderecoEntrega;
        this.raca_pet = raca_pet;
    }

    public Pet(Integer id, String nome, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
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

