/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection; // Importa la clase conexion para gestionar la conexion con la base de datos
import java.sql.DriverManager; // Importa DriverManager, que se usa para establecer conexiones con la base de datos.
import java.sql.PreparedStatement; // Importa PreparedStatement, que permite ejecutar consultas SQL seguras con parámetros.
import java.sql.SQLException; // Importa SQLException, que captura errores relacionados con la base de datos.
// Importa Logger y Level, herramientas para registrar mensajes en la consola o en archivos de log.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox; // Importa la clase JComboBox que permite crear listas desplegables en la interfaz gráfica
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).

/**
 *
 * @author canto
 */
public class Talleres {
    
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
    //Atributos   
    private JComboBox<String> jComboBox1;
    private String nombreguardado;
    
    //Este es el método constructor
    public Talleres(JComboBox<String> comboBox, String nombreRecibido)
    {
        //Se asignan los parámetros a los atributos
        this.jComboBox1 = comboBox;
        this.nombreguardado = nombreRecibido;
    }

    public void cargarTalleres() {
        try {
            // Establecer la conexión
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los nombres de los talleres
            String query = "SELECT nombre FROM talleres WHERE activo = TRUE";  
            PreparedStatement stmt = cx.prepareStatement(query);
            var rs = stmt.executeQuery();

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox1.removeAllItems();

            // Agregar la opción "Taller"
            jComboBox1.addItem("Taller");

            // Agregar los datos al JComboBox
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("nombre"));  
            }

            // Cierra la consulta y la conexión
            rs.close();
            stmt.close();
            cx.close();

            jComboBox1.updateUI();  // Refrescar visualmente
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    } 
    
    // Método para dar de alta un taller en la base de datos
    public void AltaTaller(){
        try {   
            Class.forName(driver); // Cargar el driver JDBC
            cx=DriverManager.getConnection(url+bd,user, password); // Conexión a la BD
            // Verificar si ya existe el taller
            PreparedStatement verificar = cx.prepareStatement("SELECT * FROM talleres WHERE nombre = ? AND activo = TRUE");
            verificar.setString(1, nombreguardado);
            var rs = verificar.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "El taller ya existe.");
            } else {
                // Insertar un nuevo taller con el nombre guardado
                PreparedStatement consulta;
                consulta=cx.prepareStatement("INSERT INTO talleres(nombre)"
                                                             + " VALUES(?)");
                consulta.setString(1, nombreguardado);
                consulta.executeUpdate();
                // Cierra la consulta y la conexión
                consulta.close();
                cx.close();
                JOptionPane.showMessageDialog(null, "Taller registrado exitosamente.");
                cargarTalleres();  // Recargar el ComboBox de talleres
            }} catch(ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
   // Método para dar de baja (eliminar) un taller de la base de datos
    public void BajaTaller(){
        try {
            Class.forName(driver); // Cargar el driver JDBC
            cx=DriverManager.getConnection(url+bd,user, password); // Conexión a la BD
            // Eliminar taller por nombre
            PreparedStatement consulta;
            consulta=cx.prepareStatement("UPDATE talleres SET activo = FALSE WHERE nombre=?");

            consulta.setString(1, nombreguardado);
            consulta.executeUpdate();
            // Cierra la consulta y la conexión
            consulta.close();
            cx.close();

            JOptionPane.showMessageDialog(null, "El taller se ha eliminado con éxito");
            cargarTalleres();  // Recargar el ComboBox de talleres
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("No se conectó a la BD " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
}