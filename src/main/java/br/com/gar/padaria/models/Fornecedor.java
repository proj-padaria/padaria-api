package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "fornecedores")


public class Fornecedor implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoas;

    @Column(nullable = false, length = 15)
    private String cnpj;
}
