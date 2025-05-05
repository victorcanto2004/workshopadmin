/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

// Paquetes utilizados
import java.sql.*; // Importa todas las clases de java.sql, como Connection, DriverManager, SQLException, ResultSet, etc.
import java.sql.PreparedStatement; // Importa específicamente la clase PreparedStatement, usada para consultas SQL con parámetros.
import java.util.logging.Level; // Importa la clase Level del sistema de logging, que define niveles de severidad (INFO, SEVERE, etc.).
import java.util.logging.Logger; // Importa la clase Logger, que permite registrar eventos o errores en el sistema.

/**
 *
 * @author canto 
 */
public class Conexion {  
    // Atributos para la conexión a la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos
    String url="jdbc:mysql://localhost:3306/"; // URL del servidor MySQL
    String user="root"; // Usuario de la base de datos
    String password="sqloracle"; // Contraseña del usuario
    String driver="com.mysql.cj.jdbc.Driver"; // Driver JDBC para MySQL
    Connection cx=null; // Objeto de conexión
    PreparedStatement ps=null; // Objeto para consultas preparadas

    //Método constructor vacío
    public Conexion(){}
    
    // Método para conectar con la base de datos
    public Connection conectar() {
        try {
            // Cargar el driver JDBC
            Class.forName(driver); 
            
            // Establecer la conexión a la base de datos con URL, base de datos, usuario y contraseña
            cx=DriverManager.getConnection(url+bd,user, password);
            System.out.println("Se conectó a la BD"); // Mensaje de éxito
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD"); // Mensaje de error en caso de fallo al conectar
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx; // Retorna la conexión (null si falló)     
    }
    
    // Método para cerrar la conexión
    public void desconectar() {
        try {
            cx.close(); // Intenta cerrar la conexión
        // En caso de error al cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
}
