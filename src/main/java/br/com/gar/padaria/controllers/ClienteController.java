package br.com.gar.padaria.controllers;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Cliente;
import br.com.gar.padaria.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "clientes")

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("list")
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Cliente selectById(@PathVariable("id") Integer id) {
        return clienteRepository.findById(id).get();
    }

    @PostMapping(value = "/save")
    public Cliente clientesSave(@RequestBody Cliente clienteModel) {
            return clienteRepository.save(clienteModel);
        }

    @DeleteMapping(value = "delete/{id}")
    public void clienteDeleteById(@PathVariable Integer id) {
        clienteRepository.deleteById(id);
    }

    @GetMapping("clientesInadimplentes")
    public List<ClientesInadimplentesDTO> clientes_inadimplentes() {
        return clienteRepository.clientes_inadimplentes();
    }

}


