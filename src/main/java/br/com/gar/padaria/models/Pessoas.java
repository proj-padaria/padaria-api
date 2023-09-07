package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;
import org.w3c.dom.Text;

import java.io.Serializable;

@Data
@Entity
@Table(name = "pessoas")

public class Pessoas implements Serializable {
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "telefone_id")
    private Telefones telefones;

    @Column(nullable = false, length = 40)
    private String nome;


    @Column(nullable = false, length = 40)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String logradouroNumero;

    @Column(nullable = false, length = 30)
    private String bairro;

    @Column(nullable = false, length = 10)
    private String cep;

    @Column(nullable = true)
    private Text email;

    @Column(nullable = false, length = 8)
    private String data_do_cadastro;

}
