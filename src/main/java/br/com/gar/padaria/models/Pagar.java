package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pagar")

public class Pagar implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = true, length = 8)
    private String data_vencimento;

    @Column(nullable = true, length = 8)
    private String data_pagamento;

    @Column(nullable = false)
    private Double valor_pago;
}
