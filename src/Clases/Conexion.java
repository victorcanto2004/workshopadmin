/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author canto 
 */
public class Conexion
{
   
    //Atributos
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    
    //Método constructor
    public Conexion(){}
    
    public Connection conectar()
    {
        try
        {
            // Cargar el driver JDBC
            Class.forName(driver); 
            
            // Establecer la conexión a la base de datos
            cx=DriverManager.getConnection(url+bd,user, password);
            System.out.println("Se conectó a la BD");
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            System.out.println("No se conectó a la BD");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;       
    }
    
    public void desconectar() 
    {
        try 
        {
            cx.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
