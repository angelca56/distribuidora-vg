/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tecnologiavg.datos;

import java.util.List;
import tecnologiavg.dominio.Pedido;

/**
 *
 * @author delma
 */
public interface IPedidoDAO {
     // Agrega un nuevo pedido
    boolean agregarPedido(Pedido pedido);

    // Busca un pedido por número
    Pedido buscarPedidoPorNumero(int noPedido);

    // Lista todos los pedidos de un cliente por NIT
    List<Pedido> listarPedidosPorCliente(String nitCliente);

    // Lista todos los pedidos
    List<Pedido> obtenerTodosLosPedidos();
}