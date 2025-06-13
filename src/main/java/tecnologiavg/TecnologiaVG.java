
package tecnologiavg;

import java.util.List;
import java.util.Scanner;
import tecnologiavg.datos.ClienteDAO;
import tecnologiavg.datos.IClienteDAO;
import tecnologiavg.datos.IPedidoDAO;
import tecnologiavg.datos.PedidoDAO;
import tecnologiavg.dominio.Cliente;
import tecnologiavg.dominio.Pedido;
import tecnologiavg.reportes.ReporteHistorial;

public class TecnologiaVG {

    public static void main(String[] args) {
   
        Scanner scanner = new Scanner(System.in);
        IClienteDAO clienteDAO = new ClienteDAO();
        IPedidoDAO pedidoDAO = new PedidoDAO();

    int opcion;
    do {
        System.out.println("\n*** MENÚ PRINCIPAL ***");
        System.out.println("----- Clientes -----");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Buscar Cliente por ID");
        System.out.println("3. Buscar Cliente por NIT");
        System.out.println("4. Actualizar Cliente");
        System.out.println("5. Eliminar Cliente");
        System.out.println("6. Listar Todos los Clientes");
        System.out.println("\n----- Pedidos -----");
        System.out.println("7. Agregar Pedido");
        System.out.println("8. Buscar Pedido por Número");
        System.out.println("9. Listar Pedidos por Cliente (NIT)");
        System.out.println("10. Listar Todos los Pedidos");
        System.out.println("11. Historial de Pedidos");
        System.out.println("12. Salir");
        System.out.print("Seleccione una opción: ");
        String Scanner = scanner.nextLine().trim();

        if (Scanner.isEmpty() || !Scanner.matches("\\d+")) {
        System.out.println("Entrada inválida. Ingrese un número válido.");
        opcion = -1; // valor que no esté en el menú
        } else {
        opcion = Integer.parseInt(Scanner);
        }

        switch (opcion) {
            //Agregar Cliente
            case 1 -> {
                //Se piden los datos
                System.out.print("\nIngrese el NIT: ");
                String nit = scanner.nextLine();
                System.out.print("Nombre y Apellido: ");
                String nombre = scanner.nextLine();
                System.out.print("Dirección: ");
                String direccion = scanner.nextLine();
                System.out.print("Correo electrónico: ");
                String correo = scanner.nextLine();
                System.out.print("Teléfono: ");
                String telefono = scanner.nextLine();
                System.out.print("Crédito: ");
                double credito = Double.parseDouble(scanner.nextLine());

                //Se llama a la funcion de AgregarCliente
                Cliente nuevoCliente = new Cliente(nit, nombre, direccion, correo, telefono, credito);
                if (clienteDAO.agregarCliente(nuevoCliente)) {
                    System.out.println("Cliente agregado correctamente.");
                } else {
                    System.out.println("Error al agregar cliente.");
                }
                System.out.println(); //Salto de linea
            }

            //Buscar Cliente por ID
            case 2 -> {
                System.out.print("\nIngrese ID del cliente a buscar: ");
                int id = Integer.parseInt(scanner.nextLine());
                
                //Se manda a llamar la funcion de buscar cliente por ID
                Cliente cliente = clienteDAO.buscarClientePorId(id);
                if (cliente != null) {
                    System.out.println("Cliente Encontrado: "+cliente);
                } else {
                    System.out.println("Cliente con ID " + id + " no encontrado.");
                }
                System.out.println(); //salto de linea
            }

            //Buscar Cliente por NIT
            case 3 -> {
                System.out.print("\nIngrese NIT del cliente a buscar: ");
                String nit = scanner.nextLine();
                
                //Se manda a llmar la funcion de buscar cliente por NIT
                Cliente cliente = clienteDAO.buscarClientePorNit(nit);
                if (cliente != null) {
                    System.out.println(cliente);
                } else {
                    System.out.println("Cliente con NIT " + nit + " no encontrado.");
                }
                System.out.println(); //salto de linea
            }

            //Actualizar Cliente por ID
            case 4 -> {
                System.out.print("\nID del cliente a actualizar: ");
                int id = Integer.parseInt(scanner.nextLine());
                //Se manda a llmar la funciion de buscar cliente para encontrar el cliente que deseamos actualizar
                Cliente cliente = clienteDAO.buscarClientePorId(id);
                if (cliente != null) {
                    //Si se encuentra se piden los datos
                    System.out.println("Cliente actual: " + cliente);
                    System.out.print("Nuevo NIT: ");
                    cliente.setNit(scanner.nextLine());
                    System.out.print("Nuevo nombre: ");
                    cliente.setNombreApellido(scanner.nextLine());
                    System.out.print("Nueva dirección: ");
                    cliente.setDireccion(scanner.nextLine());
                    System.out.print("Nuevo correo: ");
                    cliente.setCorreoElectronico(scanner.nextLine());
                    System.out.print("Nuevo teléfono: ");
                    cliente.setTelefono(scanner.nextLine());
                    System.out.print("Nuevo crédito: ");
                    cliente.setCredito(Double.parseDouble(scanner.nextLine()));

                    //Se manda a llamar la funcion para actualizar los datos
                    if (clienteDAO.actualizarCliente(cliente)) {
                        System.out.println("Cliente actualizado.");
                    } else {
                        System.out.println("Error al actualizar.");
                    }
                } else {
                    System.out.println("Cliente con ID " + id + " no encontrado.");
                }
                System.out.println(); //salto de linea
            }

            //Eliminar Cliente
            case 5 -> {
                System.out.print("\nIngrese ID del cliente a eliminar: ");
                int id = Integer.parseInt(scanner.nextLine());
                
                //Se manda a llamar la funcion de eliminar cliente
                if (clienteDAO.eliminarClientePorId(id)) {
                    System.out.println("Cliente eliminado.");
                } else {
                     System.out.println("Cliente con ID " + id + " no encontrado.");
                }
                System.out.println(); //salto de linea
            }

            
            //Listar todos los clientes disponibles
            case 6 -> {
                System.out.println("\n--- Listado de Todos los Clientes ---");
                //se manda a llmar la funcien de la lista
                List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
                clientes.forEach(System.out::println);
                
            }
            

            //Agregar un Producto
            case 7 -> {
                System.out.print("\nIngrese NIT del cliente: ");
                String nitCliente = scanner.nextLine();

                //Se busca que el cliente este agregado
                Cliente cliente = clienteDAO.buscarClientePorNit(nitCliente);
                    if (cliente == null) {
                        System.out.println("No se puede registrar el pedido: el NIT ingresado no pertenece a ningún cliente registrado.");
            
                    } else {
                        //Si esta agreagdo se piden los datos
                        System.out.print("Producto: ");
                        String producto = scanner.nextLine();
                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());
                        System.out.print("Precio unitario: ");
                        double precio = Double.parseDouble(scanner.nextLine());

                        //Se agrega el nuevo pedido y se manda a llmar la funcion de agregar pedido
                        Pedido nuevoPedido = new Pedido(0, nitCliente, producto, cantidad, precio);
                        if (pedidoDAO.agregarPedido(nuevoPedido)) {
                            System.out.println("Pedido registrado correctamente para el cliente: " + cliente.getNombreApellido());
                        } else {
                            System.out.println("Error al registrar el pedido.");
                        }
                    }
                    System.out.println(); // salto de línea
            }

            //Buscar pedido por numero
            case 8 -> {
                System.out.print("\nIngrese número del pedido: ");
                int numero = Integer.parseInt(scanner.nextLine());
                //Se llama la funcion de buscar pedido
                Pedido pedido = pedidoDAO.buscarPedidoPorNumero(numero);
                if (pedido != null) {
                    System.out.println(pedido);
                } else {
                    System.out.println("El Pedido número "+numero+" no encontrando.");
                }
                System.out.println(); //salto de linea
            }

            //Listar pedidos por cliente
            case 9 -> {
                
                System.out.println("\n--- Listado de Pedidos por Cliente ---");
                System.out.print("Ingrese NIT del cliente: ");
                String nitCliente = scanner.nextLine();
                //Se manda a llamar la funcion de buscar cliente por NIT
                Cliente cliente = clienteDAO.buscarClientePorNit(nitCliente);
                    if (cliente == null) {
                        System.out.println("El NIT ingresado no pertenece a ningún cliente registrado.");
                    } else {
                        //Se manda a llamar la funcion de pedidos por cliente
                        List<Pedido> pedidos = pedidoDAO.listarPedidosPorCliente(nitCliente);
                        if (pedidos.isEmpty()) {
                            System.out.println("El cliente no tiene pedidos registrados.");
                        } else {
                            System.out.println("Pedidos del cliente " + cliente.getNombreApellido() + ":");
                            pedidos.forEach(System.out::println);
                        }
                    }
                    System.out.println(); // salto de línea
                }

            //Listar todos los pedidos disponibles
            case 10 -> {
                System.out.println("\n--- Listado de Todos los Pedidos ---");
                List<Pedido> pedidos = pedidoDAO.obtenerTodosLosPedidos();
                pedidos.forEach(System.out::println);
                System.out.println(); //salto de linea
            }
            
            //Historial de Pedidos
            case 11 -> {
            //Se manda a llamar a la funcion de Historial de pedidos
                ReporteHistorial reporte = new ReporteHistorial();
                reporte.mostrarHistorialCliente(scanner);
                System.out.println(); //salto de linea
            }
 
            case 12 -> System.out.println("Saliendo del sistema...");
            default -> System.out.println("Opción inválida.");
        }

    } while (opcion != 12);
        
    }
}