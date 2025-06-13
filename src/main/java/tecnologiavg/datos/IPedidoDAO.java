
package tecnologiavg.datos;

import java.util.List;
import tecnologiavg.dominio.Pedido;

public interface IPedidoDAO {

    // Agrega un nuevo pedido
    boolean agregarPedido(Pedido pedido);

    // Busca un pedido por número
    Pedido buscarPedidoPorNumero(int noPedido);

    // Lista todos los pedidos de un cliente por el NIT
    List<Pedido> listarPedidosPorCliente(String nitCliente);

    // Lista todos los pedidos
    List<Pedido> obtenerTodosLosPedidos();
}