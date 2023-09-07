package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "telefones")

public class Telefones implements Serializable {
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private  Pessoas pessoas;

    @Column(nullable = false, length = 3)
    private String ddd;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 1)
    private String tipo;

}
