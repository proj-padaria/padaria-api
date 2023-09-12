package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {
    private static final long serialVersion = 1L;


    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 20)
    private String nomeAbreviado;

    @Column(nullable = false)
    private Double precoVenda;

    @Column(nullable = false)
    private Double quantidadeEmEstoque;

    @Column(nullable = false)
    private String codigoBarra;

    @Column(nullable = false)
    private Integer pontoPedido;

}

