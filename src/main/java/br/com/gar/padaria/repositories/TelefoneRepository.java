package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Telefones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefones, Integer> {

    List<Telefones> findAllByDdd(String ddd);
}
