package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendasRepository  extends JpaRepository<Vendas, Integer> {
}
