package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Compra;
import br.com.gar.padaria.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "compras")
public class CompraController {
    @Autowired
    private CompraRepository compraRepository;

    @GetMapping("list")
    public List<Compra> findAll() {

        return compraRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Compra selectedById(@PathVariable Integer id) {

        return compraRepository.findById(id).get();
    }

    @PostMapping("save")
    public Compra comprasSave(@RequestBody Compra compraModel) {
        Compra compra = compraRepository.save(compraModel);
        return compra;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {

        compraRepository.deleteById(id);
    }
}
