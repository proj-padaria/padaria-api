package br.com.gar.padaria.models;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "planos_pagamento_dias")

public class PlanoPagamentoDias implements Serializable {
    private static final long serialVersion = 1L;


    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @ManyToOne      //Aqui preciso confirmar o tipo de ligação
    @JoinColumn(name = "plano_pagamento_id")
    private PlanoPagamento planosPagamento;

    @Column(nullable = false)
    private Integer diasDoVencimento;

    @Column(nullable = false)
    private Integer percentualPagamento;
}
