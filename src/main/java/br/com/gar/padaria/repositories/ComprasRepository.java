package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {
}
