package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.VendasItens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasItensRepository  extends JpaRepository<VendasItens, Integer> {
}
