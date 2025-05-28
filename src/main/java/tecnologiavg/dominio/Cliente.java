/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologiavg.dominio;

import java.util.Objects;

/**
 *
 * @author delma
 */
public class Cliente {

    private String nit;
    private String nombreApellido;
    private String direccion;
    private String correoElectronico;
    private String telefono;
    private double credito;

    // Constructor
    public Cliente(String nit, String nombreApellido, String direccion,
                   String correoElectronico, String telefono, double credito) {
        this.nit = nit;
        this.nombreApellido = nombreApellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.credito = credito;
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

    @Override
    public String toString() {
        return "Cliente{" + "nit=" + nit + ", nombreApellido=" + nombreApellido + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + ", credito=" + credito + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
}