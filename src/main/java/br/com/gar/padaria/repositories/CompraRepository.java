package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
