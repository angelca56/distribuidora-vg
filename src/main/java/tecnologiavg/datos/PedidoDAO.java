
package tecnologiavg.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tecnologiavg.conexion.Conexion;
import tecnologiavg.dominio.Pedido;

public class PedidoDAO implements IPedidoDAO {

    @Override
    //para agregar un nuevo pedido a la base 
    public boolean agregarPedido(Pedido pedido) {
        //instruccion sql con lo que hay que llenar
        String sql = "INSERT INTO pedido (nit_cliente, producto, cantidad, precio, total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = Conexion.getConexion();// se abre la conexion con la base de datos
                 PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, pedido.getNitCliente());
            stmt.setString(2, pedido.getProducto());
            stmt.setInt(3, pedido.getCantidad());
            stmt.setDouble(4, pedido.getPrecio());
            stmt.setDouble(5, pedido.getTotal());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar pedido: " + e.getMessage());
            return false;
        }
    }

    @Override
    //buscar pedido especifico por numero
    public Pedido buscarPedidoPorNumero(int noPedido) {
        String sql = "SELECT * FROM pedido WHERE no_pedido = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, noPedido);//enviamos numero de pedido
            ResultSet rs = stmt.executeQuery();

            //se construye el objeto pedido y lo devolvemos si hay resultados
            if (rs.next()) {
                return construirPedidoDesdeResultSet(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar pedido: " + e.getMessage());
        }
        return null;
    }

    //mostrar todos los pedidos de un cliente por su nit
    @Override
    public List<Pedido> listarPedidosPorCliente(String nitCliente) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE nit_cliente = ?";

        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nitCliente);//agregamos el nit para consultar
            ResultSet rs = stmt.executeQuery();

            //si hay pedidos se agregan a la lista
            while (rs.next()) {
                pedidos.add(construirPedidoDesdeResultSet(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al listar pedidos por cliente: " + e.getMessage());
        }
        return pedidos;
    }

    //crear una lista con todos los pedidos en la base de datos
    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";

        //se abre la conexion, y se consultan todos los resultados
        try (Connection conexion = Conexion.getConexion(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                pedidos.add(construirPedidoDesdeResultSet(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    // se convierte los resultados de la base de datos en un objeto pedido
    private Pedido construirPedidoDesdeResultSet(ResultSet rs) throws SQLException {
        return new Pedido(
                rs.getInt("no_pedido"),
                rs.getString("nit_cliente"),
                rs.getString("producto"),
                rs.getInt("cantidad"),
                rs.getDouble("precio")
        );
    }
}