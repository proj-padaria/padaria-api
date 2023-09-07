package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoasRepository extends JpaRepository<Pessoas, Integer> {

    Pessoas findByNomeIgnoreCase(String nome);

    List<Pessoas> findByOrderByNomeAsc();

    List<Pessoas> findByOrderByNomeDesc();
}
