/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tecnologiavg;
import java.util.Scanner;
import tecnologiavg.dominio.Pedido;
import tecnologiavg.datos.PedidoDAO;

/**
 *
 * @author delma
 */
public class TecnologiaVG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PedidoDAO pedidoDAO = new PedidoDAO();

        System.out.println("==== REGISTRO DE PEDIDOS ====");

        System.out.print("Ingrese el NIT del cliente: ");
        String nitCliente = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String producto = scanner.nextLine();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese el precio unitario: ");
        double precio = Double.parseDouble(scanner.nextLine());

        // Crea el pedido con el constructor que ya calcula el total
        Pedido pedido = new Pedido(0, nitCliente, producto, cantidad, precio);

        boolean insertado = pedidoDAO.agregarPedido(pedido);

        if (insertado) {
            System.out.println("Pedido agregado exitosamente.");
            System.out.println("Resumen del pedido:");
            System.out.println(pedido);
        } else {
            System.out.println("Error al agregar el pedido.");
        }
    }
}