package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

    @Data
    @Entity
    @Table(name="cidades")

    public class Cidade implements Serializable {
        private static final long serialVersion = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer Id;

        @ManyToOne
        @JoinColumn(name = "uf_id")
        private Uf uf;

        @Column(nullable=false, length=35)
        private String nome;
}
