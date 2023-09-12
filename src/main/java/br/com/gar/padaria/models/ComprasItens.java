package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "compras_itens")

public class ComprasItens implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produtos produtos;

    @Column(nullable = false, length = 12)
    private String quantidade_comprada;

    @Column(nullable = false, length = 12)
    private String quantidade_recebida;

    @Column(nullable = true, length = 14)
    private String preco_unitario;

    @Column(nullable = false, length = 14)
    private String total_da_linha;
}
