package br.com.gar.padaria.controllers;
import br.com.gar.padaria.dtos.ClientesInadimplentesDTO;
<<<<<<< HEAD
import br.com.gar.padaria.dtos.ClientesSemComprarDTO;
=======
import br.com.gar.padaria.dtos.ClientesMaiorCompraIntervaloDTO;
>>>>>>> d020ddaeabe47bc525b38a5ec6109bbfc5114b66
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

<<<<<<< HEAD
    @GetMapping("clientesSemComprar")
    public List<ClientesSemComprarDTO> clientes_sem_comprar_mais_vinte_dias() {
        return clienteRepository.clientes_sem_comprar_mais_vinte_dias();
    }
}


