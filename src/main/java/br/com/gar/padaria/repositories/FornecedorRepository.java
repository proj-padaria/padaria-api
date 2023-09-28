package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Fornecedor;
import br.com.gar.padaria.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {


}
