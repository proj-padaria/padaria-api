package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    List<Fornecedor> findAll();

}
