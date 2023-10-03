package br.com.gar.padaria.controllers;

import br.com.gar.padaria.dtos.TitulosAPagarDTO;
import br.com.gar.padaria.models.Pagar;
import br.com.gar.padaria.repositories.PagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/pagar")

public class PagarController {

    @Autowired
    private PagarRepository pagarRepository;

    @GetMapping("list")
    public List<Pagar> findAll() {
        return pagarRepository.findAll();
    }

    @GetMapping("TitulosAPagar")
    public List<TitulosAPagarDTO> titulos_a_pagar_ate_hoje() {
        return pagarRepository.titulos_a_pagar_ate_hoje();
    }
}