/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tecnologiavg.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author delma
 */
public class Conexion {
    
    public static Connection getConexion(){
        
     Connection conexion = null;
     var baseDatos = "tecnologiavg";
     var url = "jdbc:mysql://localhost:3306/"+baseDatos;
     var usuario = "root";
     var password = "admin";
     try{
         
         Class.forName("com.mysql.cj.jdbc.Driver");
         conexion = DriverManager.getConnection(url, usuario, password);
     }catch(Exception e){
        System.out.println("Error al conectarnos a la BD: "+e.getMessage());
    }
        
        return conexion;
    }   
    
    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if(conexion!= null ){
            System.out.println("Conexion exitosa: "+conexion);
        } 
        else
        {
            System.out.println("Error al conectarse");
        }
    }
    
    
    
}
