package br.com.gar.padaria.dtos;

import java.util.Date;

public interface ClientesSemComprarDTO {

    Integer getCliente_Id();

    Date getData_ultima_compra();
    String getNome();
}
