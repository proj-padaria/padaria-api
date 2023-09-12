package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.ComprasItens;
import br.com.gar.padaria.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComprasItensRepository extends JpaRepository<ComprasItens,String> {



}
