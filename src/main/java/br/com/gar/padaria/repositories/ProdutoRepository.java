package br.com.gar.padaria.repositories;
import br.com.gar.padaria.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
