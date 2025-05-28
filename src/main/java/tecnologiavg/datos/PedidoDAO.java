/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologiavg.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import tecnologiavg.conexion.Conexion;
import tecnologiavg.dominio.Pedido;

/**
 *
 * @author delma
 */
public class PedidoDAO implements IPedidoDAO{
    
    @Override
    public boolean agregarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (nit_cliente, producto, cantidad, precio, total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, pedido.getNitCliente());
            stmt.setString(2, pedido.getProducto());
            stmt.setInt(3, pedido.getCantidad());
            stmt.setDouble(4, pedido.getPrecio());
            stmt.setDouble(5, pedido.getTotal());
            
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        
        } catch (SQLException e) {
            System.err.println("Error al agregar pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Pedido buscarPedidoPorNumero(int noPedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedido> listarPedidosPorCliente(String nitCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}