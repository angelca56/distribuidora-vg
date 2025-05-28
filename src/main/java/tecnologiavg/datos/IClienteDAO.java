/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tecnologiavg.datos;

import java.util.List;
import tecnologiavg.dominio.Cliente;

/**
 *
 * @author delma
 */
public interface IClienteDAO {
    // Agrega un nuevo cliente
    boolean agregarCliente(Cliente cliente);

    // Busca cliente por NIT
    Cliente buscarCliente(String nit);

    // Actualiza datos del cliente
    boolean actualizarCliente(Cliente cliente);

    // Elimina un cliente por NIT
    boolean eliminarCliente(String nit);

    // Lista todos los clientes
    List<Cliente> obtenerTodosLosClientes();
}