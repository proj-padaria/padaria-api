package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
    @Entity
    @Table(name = "clientes")

    public class Cliente implements Serializable {
        private static final long serialVersion = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @OneToOne
        @JoinColumn(name = "pessoa_id", foreignKey = @ForeignKey(name = "pessoa_id"))
        private Pessoa pessoa;

        @Column(nullable = false)
        private Date data_nascimento;

        @Column(length = 14)
        private String  renda_mensal;

        @Column(nullable = false, length = 20)
        private String documento;

        @Column(length = 14)
        private String  limite_de_credito;

        @Column(nullable = false)
        private Integer dia_vencimento_fiado;
       }



