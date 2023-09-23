package br.com.gar.padaria.controllers;

//import br.com.gar.padaria.dtos.ClienteMaiorCompraIntervaloDTO;
import br.com.gar.padaria.models.Pessoa;
import br.com.gar.padaria.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("list")
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Pessoa selectedById(@PathVariable Integer id) {
        return pessoaRepository.findById(id).get();
    }

    @PostMapping("save")
    public Pessoa pessoasSave(@RequestBody Pessoa pessoasModel) {
        Pessoa pessoas = pessoaRepository.save(pessoasModel);
        return pessoas;
    }

    @GetMapping("nome/{nome}")
    public Pessoa selectedByNome(@PathVariable String nome) {
        return pessoaRepository.findByNomeIgnoreCase(nome);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        pessoaRepository.deleteById(id);
    }

    @GetMapping("list/{ascDesc}")
    public List<Pessoa> findAllSortNome(@PathVariable String ascDesc) {
        if (ascDesc.toUpperCase().equals("ASC")){
            return pessoaRepository.findByOrderByNomeAsc();
        }
        else if (ascDesc.toUpperCase().equals("DESC")) {
            return pessoaRepository.findByOrderByNomeDesc();
        } else {
            System.out.println("* * * E R R O * * * Uso: /clientes/list/ASC/ ou /clientes/list/DESC");
            throw new ArithmeticException("Parâmetro pode ser ASC ou DESC, case insensitive.");
        }
    }

   /* @Autowired
    private ClienteMaiorCompraIntervaloDTO clienteMaiorCompraIntervaloDTO; */

   /* @GetMapping("/maior-compra")
    public ResponseEntity<Pessoa> encontrarClienteComMaiorCompraNoIntervalo(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        Pessoa pessoa = clienteMaiorCompraIntervaloDTO.encontrarClienteComMaiorCompraNoIntervalo(dataInicial, dataFinal);
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
}
