
package tecnologiavg.dominio;

import java.util.Objects;

public class Pedido {
    
    //Definimos variables que usaremos para los pedidos
    private int noPedido;
    private String nitCliente;
    private String producto;
    private int cantidad;
    private double precio;
    private double total;

    // Constructor para las funciones de pedido
    public Pedido (int noPedido, String nitCliente, String producto, int cantidad, double precio) {
        this.noPedido = noPedido;
        this.nitCliente = nitCliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = cantidad * precio;
    }
    
    //Get para leer y Set para modificar
    public int getNoPedido() {
        return noPedido;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getTotal() {
        return total;
    }

    public void setNoPedido(int noPedido) {
        this.noPedido = noPedido;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    //Imprimir datos con toString
    @Override
    public String toString() {
        return "Pedido{" + "noPedido=" + noPedido + ", nitCliente=" + nitCliente + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + ", total=" + total + '}';
    }
     
    //Evaluar datos
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.noPedido;
        hash = 29 * hash + Objects.hashCode(this.nitCliente);
        hash = 29 * hash + Objects.hashCode(this.producto);
        hash = 29 * hash + this.cantidad;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.noPedido != other.noPedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return Objects.equals(this.nitCliente, other.nitCliente);
    }   
}