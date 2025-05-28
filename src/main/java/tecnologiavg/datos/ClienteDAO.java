/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologiavg.datos;

import java.util.List;
import tecnologiavg.dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author delma
 */
import tecnologiavg.conexion.Conexion;
public class ClienteDAO implements IClienteDAO{
    
    @Override
    public boolean agregarCliente(Cliente cliente) {
        
        String sql = "INSERT INTO cliente (nit_cliente, nombre_apellido, direccion, correo_electronico, telefono, credito) " + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNit());
            stmt.setString(2, cliente.getNombreApellido());
            stmt.setString(3, cliente.getDireccion());
            stmt.setString(4, cliente.getCorreoElectronico());
            stmt.setString(5, cliente.getTelefono());
            stmt.setDouble(6, cliente.getCredito());
            
            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        
        } catch (SQLException e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Cliente buscarCliente(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarCliente(String nit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}