package br.com.gar.padaria.controllers;
import br.com.gar.padaria.models.Departamento;
import br.com.gar.padaria.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;

   @GetMapping("list")
    public List<Departamento> findall(){
       return departamentoRepository.findAll();
   }

    @GetMapping("id/{id}")
    public Departamento selectById(@PathVariable Integer id) {
        return departamentoRepository.findById(id).get();
    }

    @PostMapping("save")
    public Departamento departamento(@RequestBody Departamento departamentoModel) {
        Departamento departamento = departamentoRepository.save(departamentoModel);
        return departamento;
    }

    @DeleteMapping("delete/{id}")
    public void departamentoDeleteById(@PathVariable Integer id) {
        departamentoRepository.deleteById(id);

    }
}
