package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.CompraItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraItemRepository extends JpaRepository<CompraItem, Integer> {

}
