package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.Cidade;
import br.com.gar.padaria.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")

public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping("list")
    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    //findById
    @GetMapping("id/{id}")
    public Cidade selectById(@PathVariable("id") Integer id) {
        return cidadeRepository.findById(id).get();
    }
    @DeleteMapping("delete/{id}")
    public void cidadeDeleteById (@PathVariable Integer id){
        cidadeRepository.deleteById(id);
    }
    //save
    @PostMapping("save")
    public Cidade cidadeSave (@RequestBody Cidade cidadeModel){
        Cidade cidade = cidadeRepository.save(cidadeModel);
        return cidade;
    }
}
