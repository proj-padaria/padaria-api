package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Compras;
import br.com.gar.padaria.repositories.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "compras")
public class ComprasController {
    @Autowired
    private ComprasRepository comprasRepository;

    @GetMapping("list")
    public List<Compras> findAll() {

        return comprasRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Compras selectedById(@PathVariable Integer id) {

        return comprasRepository.findById(id).get();
    }

    @PostMapping("save")
    public Compras comprasSave(@RequestBody Compras comprasModel) {
        Compras compras = comprasRepository.save(comprasModel);
        return compras;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {

        comprasRepository.deleteById(id);
    }
}
