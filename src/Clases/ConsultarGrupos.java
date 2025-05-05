/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

// Paquetes a utilizar
import java.sql.Connection; // Importa la clase conexion para gestionar la conexion con la base de datos
import java.sql.DriverManager; // Importa DriverManager, que se usa para establecer conexiones con la base de datos.
import java.sql.PreparedStatement; // Importa PreparedStatement, que permite ejecutar consultas SQL seguras con parámetros.
import java.sql.ResultSet; // Importa la clase ResultSet, que se utiliza para almacenar los resultados de una consulta SQL.
import java.sql.SQLException; // Importa SQLException, que captura errores relacionados con la base de datos.
// Importa Logger y Level, herramientas para registrar mensajes en la consola o en archivos de log.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField; // Importa la clase JTextField que permite crear campos de texto en la interfaz gráfica

/**
 *
 * @author canto
 */
public class ConsultarGrupos {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
    // Método para consultar los datos del docente asignado a un grupo específico
    public void Consultar(String idgrupo, JTextField jTextNoDocente,
            JTextField jTextNombre,
            JTextField jTextApellidos){
        try {
            Class.forName(driver);  // Carga el driver JDBC
            cx=DriverManager.getConnection(url+bd,user, password);  // Conexión a la BD
            // Prepara la consulta para obtener al docente asignado al grupo
            PreparedStatement consulta;
            consulta=cx.prepareStatement("SELECT d.no_usuario, d.nombre, d.apellido " +
                                                "FROM docentes d " +
                                                "WHERE id_grupo = ? AND activo = TRUE");
                
            consulta.setString(1, idgrupo); // Asigna el ID del grupo
            ResultSet resultado = consulta.executeQuery(); // Ejecuta la consulta

            if (resultado.next()) {
                // Si hay docente asignado, muestra sus datos en los campos
                jTextNoDocente.setText(resultado.getString("no_usuario"));
                jTextNombre.setText(resultado.getString("nombre"));
                jTextApellidos.setText(resultado.getString("apellido"));
            } else {
                // Si no hay docente, muestra mensaje en los campos
                jTextNoDocente.setText("No hay docente aún");
                jTextNombre.setText("No hay docente aún");
                jTextApellidos.setText("No hay docente aún");
                }
     
        // Maneja excepciones como no concectar a la BD
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD" + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}