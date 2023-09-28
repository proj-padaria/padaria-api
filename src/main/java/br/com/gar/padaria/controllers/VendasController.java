package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Vendas;
import br.com.gar.padaria.repositories.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas")


public class VendasController {

    @Autowired
    private VendasRepository vendasRepository;

    @GetMapping("list")
    public List<Vendas> findAll() {
        return vendasRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Vendas selectedById(@PathVariable Integer id) {
        return vendasRepository.findById(id).get();
    }

    }
