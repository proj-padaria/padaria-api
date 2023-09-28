package br.com.gar.padaria.controllers;


import br.com.gar.padaria.models.Fornecedor;
import br.com.gar.padaria.repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "fornecedores")


public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @GetMapping("list")
    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }
}
