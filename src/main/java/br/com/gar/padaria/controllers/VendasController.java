package br.com.gar.padaria.controllers;

import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Cliente;
import br.com.gar.padaria.models.Vendas;
import br.com.gar.padaria.repositories.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/save")
    public Vendas vendasSave(@RequestBody Vendas vendasModel) {
        return vendasRepository.save(vendasModel);
    }

    @DeleteMapping(value = "delete/{id}")
    public void clienteDeleteById(@PathVariable Integer id) {
        vendasRepository.deleteById(id);
    }

    @GetMapping("clientesMaiorCompraIntervalo")
    public List<ClientesMaiorCompraIntervaloDTO> clientes_maior_compra_intervalo() {
        return vendasRepository.clientes_maior_compra_intervalo();
    }
}