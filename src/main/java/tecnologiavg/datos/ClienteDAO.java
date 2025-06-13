
package tecnologiavg.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tecnologiavg.conexion.Conexion;
import tecnologiavg.dominio.Cliente;

//la clase que se encarga de todas las opciones para los clientes
public class ClienteDAO implements IClienteDAO {

    //agregar otro cliente a la base de datos
    @Override
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nit_cliente, nombre_apellido, direccion, correo_electronico, telefono, credito) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConexion(); //abre la conexion con la base de datos
                 PreparedStatement stmt = conexion.prepareStatement(sql)) {//preparar la opcion que se hara

            stmt.setString(1, cliente.getNit());
            stmt.setString(2, cliente.getNombreApellido());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreoElectronico());
            stmt.setString(5, cliente.getTelefono());
            stmt.setDouble(6, cliente.getCredito());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }
    
    //buscar cliente en la base de datos por su id
    @Override
    public Cliente buscarClientePorId(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, id); //enviamos el id
            ResultSet rs = stmt.executeQuery(); //comienza a buscar

            if (rs.next()) {
                return construirClienteDesdeResultSet(rs);//si encuentra cliente lo devuelve
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar cliente por ID: " + e.getMessage());
        }
        return null;
    }
    
    //buscae cliente por su nit
    @Override
    public Cliente buscarClientePorNit(String nit) {
        String sql = "SELECT * FROM cliente WHERE nit_cliente = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nit);//se envia el nit
            ResultSet rs = stmt.executeQuery();//comienza busqueda

            if (rs.next()) {
                return construirClienteDesdeResultSet(rs);
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar cliente por NIT: " + e.getMessage());
        }
        return null;
    }
    
    //actualizar datos de cliente
    @Override
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nit_cliente = ?, nombre_apellido = ?, direccion = ?, correo_electronico = ?, telefono = ?, credito = ? WHERE id = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            //ponemos los nuevos datos
            stmt.setString(1, cliente.getNit());
            stmt.setString(2, cliente.getNombreApellido());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreoElectronico());
            stmt.setString(5, cliente.getTelefono());
            stmt.setDouble(6, cliente.getCredito());
            stmt.setInt(7, cliente.getId());

            //se consulta y si se actualizo se devuelve true
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
    }
    
    //eliminar cliente por su id
    @Override
    public boolean eliminarClientePorId(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conexion = Conexion.getConexion(); PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, id);//mandamos el id del cliente para eliminar
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    
    //para obtener los datos de todos los clientes que hay en la base de datos
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conexion = Conexion.getConexion(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            //se buscan todos los resultados y se agregan a la lista
            while (rs.next()) {
                clientes.add(construirClienteDesdeResultSet(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        }
        return clientes;
    }
    
    //este metodo convierte la fila de resultados en el objeto cliente
    private Cliente construirClienteDesdeResultSet(ResultSet rs) throws SQLException {
        return new Cliente(
                rs.getInt("id"),
                rs.getString("nit_cliente"),
                rs.getString("nombre_apellido"),
                rs.getString("direccion"),
                rs.getString("correo_electronico"),
                rs.getString("telefono"),
                rs.getDouble("credito")
        );
    }
}