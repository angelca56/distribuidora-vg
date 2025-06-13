
package tecnologiavg.dominio;

import java.util.Objects;

public class Cliente {
    
    //Definir variables que usaremos para los Clientes
    private int id;
    private String nit;
    private String nombreApellido;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private double credito;

    //Constructor con ID: este constructor nos sirve para guardar el ID
    public Cliente(int id, String nit, String nombreApellido, String direccion,
               String correoElectronico, String telefono, double credito) {
    this.id = id;
    this.nit = nit;
    this.nombreApellido = nombreApellido;
    this.direccion = direccion;
    this.correoElectronico = correoElectronico;
    this.telefono = telefono;
    this.credito = credito;
}
    
    // Constructor // este constructor sirve para cuando vamos a llamar la funcion agregar un cliente
    public Cliente(String nit, String nombreApellido, String direccion,
                   String correoElectronico, String telefono, double credito) {
        this.nit = nit;
        this.nombreApellido = nombreApellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.credito = credito;
    }
    
    //Get = Leer
    //Set = Modificar
    public int getId() {
    return id;
    }
    
     public void setId(int id) {
        this.id = id;
    }
   
    
    public String getNit() {
        return nit;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getCredito() {
        return credito;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    //Evaluar nuestros datos con hashCOde y equals    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nit);
        hash = 59 * hash + Objects.hashCode(this.nombreApellido);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.correoElectronico);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.credito) ^ (Double.doubleToLongBits(this.credito) >>> 32));
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.credito) != Double.doubleToLongBits(other.credito)) {
            return false;
        }
        if (!Objects.equals(this.nit, other.nit)) {
            return false;
        }
        if (!Objects.equals(this.nombreApellido, other.nombreApellido)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.correoElectronico, other.correoElectronico)) {
            return false;
        }
        return Objects.equals(this.telefono, other.telefono);
    }

    //El toString = funcionar para mandar a imprimir
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nit=" + nit + ", NombreApellido=" + nombreApellido + ", Direccion=" + direccion + ", CorreoElectronico=" + correoElectronico + ", telefono=" + telefono + ", credito=" + credito + '}';
    }   
}