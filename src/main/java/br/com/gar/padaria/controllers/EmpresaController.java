package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.Cidade;
import br.com.gar.padaria.models.Empresa;
import br.com.gar.padaria.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/empresa")

public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("list")
    public List<Empresa> findAll() {
       return empresaRepository.findAll();
    }

    @DeleteMapping("delete/{razaoSocial}")
    public void empresaDeleteByRazaoSocial (@PathVariable String razaoSocial){
       empresaRepository.deleteByRazaoSocial(razaoSocial);
    }

    @PostMapping("save")
    public Empresa empresaSave (@RequestBody Empresa empresaModel){
        Empresa empresa = empresaRepository.save(empresaModel);
        return empresa;
    }


}
