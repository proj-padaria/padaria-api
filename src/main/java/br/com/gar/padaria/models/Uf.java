package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ufs")
public class Uf implements Serializable {
    private static final long serialVersion = 1L;

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(nullable = false, length = 2)
    private String sigla;

    @Column(nullable = false, length = 25)
    private String nome;

}
