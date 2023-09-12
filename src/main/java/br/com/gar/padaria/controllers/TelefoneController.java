package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Telefone;
import br.com.gar.padaria.repositories.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "telefones")

public class TelefoneController {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping("list")
    public List<Telefone> findAll(){
        return telefoneRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Telefone selectedById(@PathVariable Integer id) {
        return telefoneRepository.findById(id).get();
    }

    @PostMapping("save")
    public Telefone telefonesSave(@RequestBody Telefone telefonesModel) {
        Telefone telefones = telefoneRepository.save(telefonesModel);
        return telefones;
    }

    @GetMapping("ddd/{ddd}")
    public List<Telefone> selectById(@PathVariable String ddd){
        return telefoneRepository.findAllByDdd(ddd);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        telefoneRepository.deleteById(id);
    }
}
