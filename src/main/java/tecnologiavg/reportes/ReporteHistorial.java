
package tecnologiavg.reportes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import tecnologiavg.conexion.Conexion;

public class ReporteHistorial {

    public void mostrarHistorialCliente(Scanner scanner) {
        System.out.println("\n--- REPORTE DE HISTORIAL DEL CLIENTE ---");
        System.out.print("Ingrese el NIT del cliente: ");
        String nit = scanner.nextLine();

        Connection conexion = null;
        PreparedStatement psCliente = null;
        PreparedStatement psPedidos = null;
        ResultSet rsCliente = null;
        ResultSet rsPedidos = null;

        try {
            conexion = Conexion.getConexion();

            //Buscar datos del cliente
            String sqlCliente = "SELECT id, nombre_apellido, direccion, correo_electronico, telefono FROM cliente WHERE nit_cliente = ?";
            psCliente = conexion.prepareStatement(sqlCliente);
            psCliente.setString(1, nit);
            rsCliente = psCliente.executeQuery();

            if (rsCliente.next()) {
                //Imprimir datos
                System.out.println("\n--- Datos del Cliente ---");
                System.out.println("ID: " + rsCliente.getInt("id"));
                System.out.println("Nombre: " + rsCliente.getString("nombre_apellido"));
                System.out.println("Dirección: " + rsCliente.getString("direccion"));
                System.out.println("Correo: " + rsCliente.getString("correo_electronico"));
                System.out.println("Teléfono: " + rsCliente.getString("telefono"));

                //Buscar pedidos del cliente
                String sqlPedidos = "SELECT no_pedido, producto, cantidad, precio, total FROM pedido WHERE nit_cliente = ?";
                psPedidos = conexion.prepareStatement(sqlPedidos);
                psPedidos.setString(1, nit);
                rsPedidos = psPedidos.executeQuery();

                System.out.println("\n--- Historial de Pedidos ---");
                boolean hayPedidos = false;

                while (rsPedidos.next()) {
                    //Imprimir datos
                    hayPedidos = true;
                    System.out.println("No. Pedido: " + rsPedidos.getInt("no_pedido"));
                    System.out.println("Producto: " + rsPedidos.getString("producto"));
                    System.out.println("Cantidad: " + rsPedidos.getInt("cantidad"));
                    System.out.println("Precio: Q" + rsPedidos.getDouble("precio"));
                    System.out.println("Total: Q" + rsPedidos.getDouble("total"));
                    System.out.println("-------------------------------");
                }

                if (!hayPedidos) {
                    System.out.println("Este cliente no tiene pedidos registrados.");
                }

            } else {
                System.out.println("Cliente con NIT " + nit + " no encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar historial: " + e.getMessage());
        } finally {
            try {
                if (rsCliente != null) {
                    rsCliente.close();
                }
                if (rsPedidos != null) {
                    rsPedidos.close();
                }
                if (psCliente != null) {
                    psCliente.close();
                }
                if (psPedidos != null) {
                    psPedidos.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexiones: " + e.getMessage());
            }
        }
    }
}