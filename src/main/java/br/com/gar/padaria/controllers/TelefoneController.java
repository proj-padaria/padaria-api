package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Telefones;
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
    public List<Telefones> findAll(){
        return telefoneRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Telefones selectedById(@PathVariable Integer id) {
        return telefoneRepository.findById(id).get();
    }

    @PostMapping("save")
    public Telefones telefonesSave(@RequestBody Telefones telefonesModel) {
        Telefones telefones = telefoneRepository.save(telefonesModel);
        return telefones;
    }

    @GetMapping("ddd/{ddd}")
    public List<Telefones> selectById(@PathVariable String ddd){
        return telefoneRepository.findAllByDdd(ddd);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        telefoneRepository.deleteById(id);
    }
}
