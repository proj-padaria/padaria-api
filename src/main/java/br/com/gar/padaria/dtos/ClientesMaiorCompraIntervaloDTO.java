package br.com.gar.padaria.dtos;

import org.springframework.stereotype.Service;

@Service
public interface ClientesMaiorCompraIntervaloDTO {

    Integer getCliente_id();

    String getNome();

    Double getValor_total_gasto();
    }
