package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="vendas")

public class Vendas implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente clientes;

    @Column(nullable = false)
    private Date data;

    @Column(length = 14)
    private String  valor_total;

    @Column(length = 14)
    private String  pago_dinheiro;

    @Column(length = 14)
    private String  pago_cartao;

    @Column(length = 14)
    private String  fiado;
}
