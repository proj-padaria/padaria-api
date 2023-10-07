package br.com.gar.padaria.dtos;

import java.util.Date;

public interface ClientesInadimplentesDTO {

    String getNome();

    Integer getDia_vencimento_fiado();

    Double getValor();

    Date getData_vencimento();

    Date getData_maior_atraso();
}
