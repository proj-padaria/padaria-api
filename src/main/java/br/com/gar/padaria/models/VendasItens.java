package br.com.gar.padaria.models;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name="vendas_itens")

public class VendasItens implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @OneToOne
    @JoinColumn(name = "venda_id")
    private Vendas vendas;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produtos;

    @Column(length = 12)
    private String  quantidade;

    @Column(length = 14)
    private String  preco_venda;

    @Column(length = 14)
    private String  total_da_linha;
}