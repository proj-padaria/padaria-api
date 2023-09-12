package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="empresa")

public class Empresa implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    //private Integer Id;   Aqui é obrigatorio a criacao do ID com o @ porem se criar a propriedade
                                                                        // da erro na tabela
    @Column(nullable=false, length=40)
    private String razaoSocial;

    @Column(nullable=false, length=20)
    private String nomeFantasia;

    @Column(nullable=false, length=10)
    private String dbVersao;


}
