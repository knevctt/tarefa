package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Modelo não pode ser nulo")
    private String modelo;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @NotNull(message = "Ano não pode ser nulo")
    private int ano;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carros")
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carro_proprietario")
    private List<Proprietario> proprietarios;

}
