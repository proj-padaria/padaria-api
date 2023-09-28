package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.VendasItens;
import br.com.gar.padaria.repositories.VendasItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vendas_itens")

public class VendasItensController {

    @Autowired
    private VendasItensRepository vendasItensRepository;

    @GetMapping("list")
    public List<VendasItens> findAll() {
        return vendasItensRepository.findAll();
    }

    @GetMapping("id/{id}")
    public VendasItens selectedById(@PathVariable Integer id) {
        return vendasItensRepository.findById(id).get();
    }

    @DeleteMapping(value = "delete/{id}")
    public void clienteDeleteById(@PathVariable Integer id) {
        vendasItensRepository.deleteById(id);
    }

}
