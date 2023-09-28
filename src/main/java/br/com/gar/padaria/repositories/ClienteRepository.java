package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {

    List<Cliente> findAll();

}
