package br.com.gar.padaria.dtos;

import br.com.gar.padaria.models.Produto;
import org.hibernate.mapping.List;

public interface VerificaPontoPedidoDTO {

  <Produto> List quantidadePontoPedido();
}
