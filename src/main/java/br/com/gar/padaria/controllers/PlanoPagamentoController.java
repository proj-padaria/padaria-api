package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.PlanoPagamento;
import br.com.gar.padaria.repositories.PlanoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("delete/{id}")
    public void planoPagamentoDeleteById (@PathVariable Integer id){
        planosPagamentoRepository.deleteById(id);
    }

    @PostMapping("save")
    public PlanoPagamento planoPagamentoSave (@RequestBody PlanoPagamento planoPagamentoModel){ // oq é isso plano pagamento model?
        PlanoPagamento planoPagamento = planosPagamentoRepository.save(planoPagamentoModel);
        return planoPagamento;
    }
}
