package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoasRepository extends JpaRepository<Pessoa, Integer> {

    Pessoa findByNomeIgnoreCase(String nome);

    List<Pessoa> findByOrderByNomeAsc();

    List<Pessoa> findByOrderByNomeDesc();
}
