package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.ComprasItens;
import br.com.gar.padaria.repositories.ComprasItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "compras_itens")
public class ComprasItensController {
    @Autowired
    private ComprasItensRepository comprasItensRepository;

    @GetMapping("list")
    public List<ComprasItens> findAll() {

        return comprasItensRepository.findAll();
    }

    @GetMapping("id/{id}")
    public ComprasItens selectedById(@PathVariable Integer id) {

        return comprasItensRepository.findById(id).get();
    }

    @PostMapping("save")
    public ComprasItens comprasItensSave(@RequestBody ComprasItens comprasItensModel) {
        ComprasItens comprasItens = comprasItensRepository.save(comprasItensModel);
        return comprasItens;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {

        comprasItensRepository.deleteById(id);
    }
}
