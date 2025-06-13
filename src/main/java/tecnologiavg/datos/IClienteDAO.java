
package tecnologiavg.datos;

import java.util.List;
import tecnologiavg.dominio.Cliente;

public interface IClienteDAO {

    // Agrega un nuevo cliente
    boolean agregarCliente(Cliente cliente);

    // Buscar Cliente por el ID
    Cliente buscarClientePorId(int id);

    // Buscar Cliente porel Nit
    Cliente buscarClientePorNit(String nit);

    // Actualizar datos de los clientes
    boolean actualizarCliente(Cliente cliente);

    // Eliminar Clientes por el ID
    boolean eliminarClientePorId(int id);

    //Imprimir el listado de todos los Clientes
    List<Cliente> obtenerTodosLosClientes();
}