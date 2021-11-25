package br.com.devtarlley.DenguinhosPetShop.domains;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Proprietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String CPF;
    private String nome;
    private String email;


    @ManyToMany
    @ToString.Exclude
    @JoinTable(name = "Proprietario_Pets",
            joinColumns = @JoinColumn(name = "proprietario_id"),
            inverseJoinColumns = @JoinColumn(name = "pets_id"))
    private List<Pet> pets = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "Telefone")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "proprietario")
    private List<Pedido> pedidos = new ArrayList<>();

    public Proprietario(Integer id, String CPF, String nome, String email) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
    }
//    public Proprietario(Integer id, String CPF, String nome, String email, Set<String> telefones) {
//        this.id = id;
//        this.CPF = CPF;
//        this.nome = nome;
//        this.email = email;
//        this.telefones = getTelefones();
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Proprietario that = (Proprietario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
