package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.Uf;
import br.com.gar.padaria.repositories.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ufs")

public class UfController {
    @Autowired
    private UfRepository ufRepository;

    @GetMapping("list")
    public List<Uf> findAll() {
        return ufRepository.findAll();
    }

    @GetMapping("id/{id}")
    public Uf selectById(@PathVariable Integer id) {
        return ufRepository.findById(id).get();
    }

    @PostMapping("save")
    public Uf ufSave(@RequestBody Uf ufModel) {
        Uf uf = ufRepository.save(ufModel);
        return uf;
    }

    @GetMapping("sigla/{sigla}")
    public Uf selectBySigla(@PathVariable String sigla) {
        return ufRepository.findBySiglaIgnoreCase(sigla);
    }

    @DeleteMapping("delete/{id}")
    public void ufDeleteById(@PathVariable Integer id) {
        ufRepository.deleteById(id);

    }

}
