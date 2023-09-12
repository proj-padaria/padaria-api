package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.PlanoPagamento;
import br.com.gar.padaria.repositories.PlanoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/planos_pagamento")

public class PlanoPagamentoController {
    @Autowired
    private PlanoPagamentoRepository planosPagamentoRepository;

    @GetMapping("list")
    public List<PlanoPagamento> findAll() {
        return planosPagamentoRepository.findAll();
    }

    @GetMapping("id/{id}")
    public PlanoPagamento selectById(@PathVariable("id") Integer id) {
        return planosPagamentoRepository.findById(id).get();
    }
}
