package br.com.gar.padaria.controllers;
import br.com.gar.padaria.repositories.ComprasItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "compras_itens")
public class ComprasItensController {
    @Autowired
    private ComprasItensRepository comprasItensRepository;


}
