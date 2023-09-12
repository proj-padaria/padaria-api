package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

    List<Telefone> findAllByDdd(String ddd);
}
