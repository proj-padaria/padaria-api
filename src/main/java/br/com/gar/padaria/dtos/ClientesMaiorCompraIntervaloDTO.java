package br.com.gar.padaria.dtos;

import org.springframework.stereotype.Service;

@Service
public interface ClientesMaiorCompraIntervaloDTO {

    Integer getId();

    String getNome();

    Double getValor_total();
    }
