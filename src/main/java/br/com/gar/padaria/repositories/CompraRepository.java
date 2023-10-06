package br.com.gar.padaria.repositories;

import br.com.gar.padaria.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Integer> {

    //List<Compra> findByDataCompraBetween(LocalDate dataInicial, LocalDate dataFinal);
}
