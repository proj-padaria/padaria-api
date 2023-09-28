package br.com.gar.padaria.dtos;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.Query;

public interface VerificaPontoPedidoDTO {

       int getId();
       int getDepartamento_id();
       String getNome();
       Double  getQuantidade_em_estoque();
       int getPonto_pedido();
       Double getPercentual();


          //quando fizer interface do DTO tem que colocar o get
}
