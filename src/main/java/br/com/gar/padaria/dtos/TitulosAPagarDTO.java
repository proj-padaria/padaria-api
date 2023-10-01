package br.com.gar.padaria.dtos;

import java.util.Date;

public interface TitulosAPagarDTO {

    Integer getFornecedor_Id();

    Integer getCompra_id();

    String getNome();
    Date getData_vencimento();

    Double getValor_a_pagar();
}
