package br.com.gar.padaria.controllers;

import br.com.gar.padaria.models.CompraItem;
import br.com.gar.padaria.repositories.CompraItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "compras_itens")
public class CompraItemController {
    @Autowired
    private CompraItemRepository compraItemRepository;

    @GetMapping("list")
    public List<CompraItem> findAll() {

        return compraItemRepository.findAll();
    }

    @GetMapping("id/{id}")
    public CompraItem selectedById(@PathVariable Integer id) {

        return compraItemRepository.findById(id).get();
    }

    @PostMapping("save")
    public CompraItem compraItemSave(@RequestBody CompraItem compraItemModel) {
        CompraItem compraItem = compraItemRepository.save(compraItemModel);
        return compraItem;
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {

        compraItemRepository.deleteById(id);
    }
}
