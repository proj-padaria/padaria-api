package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "compras")

public class Compras implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "plano_pagamento_id")
    private PlanoPagamento planoPagamento;

    @Column(nullable = false, length = 8)
    private String data_compra;

    @Column(nullable = false, length = 12)
    private String valor_total_comprado;

    @Column(nullable = true, length = 12)
    private String valort_total_recebido;

    @Column(nullable = true, length = 8)
    private String data_recebimento;

    @Column(nullable = true, length = 8)
    private String data_faturamento;
}
