package br.com.gar.padaria.dtos;

public interface VendasMediaPorBairro {


    int getProduto_id();
    String getProduto_nome();

    String getPessoa_bairro();

    Double  getQuantidade_media_por_bairro();
}
