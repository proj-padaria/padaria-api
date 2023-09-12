package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.ComprasItens;

import java.util.List;

public interface ComprasItensRepository {
    void deleteById(Integer id);

    ThreadLocal<Object> findById(Integer id);

    List<ComprasItens> findAll();

    ComprasItens save(ComprasItens comprasItensModel);
}
