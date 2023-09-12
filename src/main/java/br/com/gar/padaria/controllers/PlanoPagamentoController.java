package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.Cidade;
import br.com.gar.padaria.models.PlanosPagamento;
import br.com.gar.padaria.repositories.PlanosPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/planos_pagamento")

public class PlanosPagamentoController {
    @Autowired
    private PlanosPagamentoRepository planosPagamentoRepository;

    @GetMapping("list")
    public List<PlanosPagamento> findAll() {
        return planosPagamentoRepository.findAll();
    }

    @GetMapping("id/{id}")
    public PlanosPagamento selectById(@PathVariable("id") Integer id) {
        return planosPagamentoRepository.findById(id).get();
    }
}
