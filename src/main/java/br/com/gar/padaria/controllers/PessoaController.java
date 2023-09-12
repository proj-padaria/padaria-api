package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.Pessoas;
import br.com.gar.padaria.repositories.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class PessoasController {
    @Autowired
    private PessoasRepository pessoasRepository;

    @GetMapping("list")
    public List<Pessoas> findAll() {
        return pessoasRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Pessoas selectedById(@PathVariable Integer id) {
        return pessoasRepository.findById(id).get();
    }

    @PostMapping("save")
    public Pessoas pessoasSave(@RequestBody Pessoas pessoasModel) {
        Pessoas pessoas = pessoasRepository.save(pessoasModel);
        return pessoas;
    }

    @GetMapping("nome/{nome}")
    public Pessoas selectedByNome(@PathVariable String nome) {
        return pessoasRepository.findByNomeIgnoreCase(nome);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        pessoasRepository.deleteById(id);
    }

    @GetMapping("list/{ascDesc}")
    public List<Pessoas> findAllSortNome(@PathVariable String ascDesc) {
        if (ascDesc.toUpperCase().equals("ASC")){
            return pessoasRepository.findByOrderByNomeAsc();
        }
        else if (ascDesc.toUpperCase().equals("DESC")) {
            return pessoasRepository.findByOrderByNomeDesc();
        } else {
            System.out.println("* * * E R R O * * * Uso: /clientes/list/ASC/ ou /clientes/list/DESC");
            throw new ArithmeticException("Parâmetro pode ser ASC ou DESC, case insensitive.");
        }
    }

}
