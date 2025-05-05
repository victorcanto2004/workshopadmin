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
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).
import javax.swing.JTable; // Importa la clase JTable, que permite mostrar datos en forma de tabla en una interfaz gráfica.
import javax.swing.JTextField; // Importa la clase JTextField que permite crear campos de texto en la interfaz gráfica
import javax.swing.table.DefaultTableModel; // Importa la clase DefaultTableModel, que facilita la gestión de datos en una JTable (agregar, eliminar filas, etc.).

/**
 *
 * @author canto
 */
public class ConsultarDocente {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
   // Método para consultar los datos de un docente y mostrarlos en campos de texto y tabla.  
    public void Consultar(JTextField jTextNOUsuario,
            JTextField jTextContraseña,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextContacto,
            JTextField jTextCampo,
            JTable jTableTalleresGrupos){
        
        try {
            Class.forName(driver); // Carga el driver JDBC de MySQL
            cx=DriverManager.getConnection(url+bd,user, password); // Establece conexión con la BD
            PreparedStatement consulta;
            consulta=cx.prepareStatement("SELECT d.id_docente, d.no_usuario, d.contra_docente, d.nombre, d.apellido, d.edad, d.contacto_docente, d.especialidad, "
                     + "g.nombre AS grupo, t.nombre AS taller "
                     + "FROM docentes d "
                     + "JOIN grupos g ON d.id_grupo = g.id_grupo "
                     + "JOIN talleres t ON g.id_taller = t.id_taller "
                     + "WHERE d.no_usuario = ? AND d.activo = TRUE");
                
            consulta.setString(1, jTextNOUsuario.getText()); // Asigna el valor del campo no_usuario
            ResultSet rs = consulta.executeQuery(); // Ejecuta la consulta
                
            DefaultTableModel modeloTabla = new DefaultTableModel(); // Modelo para mostrar los talleres y grupos en la tabla
            modeloTabla.addColumn("Taller");
            modeloTabla.addColumn("Grupo");

            jTableTalleresGrupos.setModel(modeloTabla); // Asigna modelo a la tabla
            boolean encontrado = false; // Bandera para saber si se encontró el docente

            while(rs.next()){ 
                if(!encontrado){
                    // Llena los campos de texto con los datos del docente
                    jTextContraseña.setText(rs.getString("contra_docente"));
                    jTextNombres.setText(rs.getString("nombre"));
                    jTextApellidos.setText(rs.getString("apellido"));
                    jTextEdad.setText(rs.getString("edad"));
                    jTextContacto.setText(rs.getString("contacto_docente"));
                    jTextCampo.setText(rs.getString("especialidad"));
                    encontrado=true;
                    }  
            // Llena la tabla con los talleres y grupos
            String taller = rs.getString("taller");
            String grupo = rs.getString("grupo");

            modeloTabla.addRow(new Object[]{taller, grupo});
            } if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró un docente con ese número de usuario.");
            } 
         // Manejo de errores de conexión o SQL
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD" + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   // Método para consultar los datos de un docente y mostrarlos en campos de texto y tabla.  
    public void ConsultarInactivo(JTextField jTextNOUsuario,
            JTextField jTextContraseña,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextContacto,
            JTextField jTextCampo,
            JTable jTableTalleresGrupos){
        
        try {
            Class.forName(driver); // Carga el driver JDBC de MySQL
            cx=DriverManager.getConnection(url+bd,user, password); // Establece conexión con la BD
            PreparedStatement consulta;
            consulta=cx.prepareStatement("SELECT d.id_docente, d.no_usuario, d.contra_docente, d.nombre, d.apellido, d.edad, d.contacto_docente, d.especialidad, "
                     + "g.nombre AS grupo, t.nombre AS taller "
                     + "FROM docentes d "
                     + "JOIN grupos g ON d.id_grupo = g.id_grupo "
                     + "JOIN talleres t ON g.id_taller = t.id_taller "
                     + "WHERE d.no_usuario = ? AND d.activo = FALSE");
                
            consulta.setString(1, jTextNOUsuario.getText()); // Asigna el valor del campo no_usuario
            ResultSet rs = consulta.executeQuery(); // Ejecuta la consulta
                
            DefaultTableModel modeloTabla = new DefaultTableModel(); // Modelo para mostrar los talleres y grupos en la tabla
            modeloTabla.addColumn("Taller");
            modeloTabla.addColumn("Grupo");

            jTableTalleresGrupos.setModel(modeloTabla); // Asigna modelo a la tabla
            boolean encontrado = false; // Bandera para saber si se encontró el docente

            while(rs.next()){ 
                if(!encontrado){
                    // Llena los campos de texto con los datos del docente
                    jTextContraseña.setText(rs.getString("contra_docente"));
                    jTextNombres.setText(rs.getString("nombre"));
                    jTextApellidos.setText(rs.getString("apellido"));
                    jTextEdad.setText(rs.getString("edad"));
                    jTextContacto.setText(rs.getString("contacto_docente"));
                    jTextCampo.setText(rs.getString("especialidad"));
                    encontrado=true;
                    }  
            // Llena la tabla con los talleres y grupos
            String taller = rs.getString("taller");
            String grupo = rs.getString("grupo");

            modeloTabla.addRow(new Object[]{taller, grupo});
            } if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró un docente con ese número de usuario.");
            } 
         // Manejo de errores de conexión o SQL
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD" + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
// Método para modificar los datos de un docente en la base de datos.
public void Modificar(JTextField jTextNOUsuario,
            JTextField jTextContraseña,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextContacto,
            JTextField jTextCampo){
    try { 
        // Si no hay número de usuario, muestra advertencia
        if(jTextNOUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Primero debe buscar al estudiante para poder actualizar");
            jTextNOUsuario.requestFocus();
        } else {
            Class.forName(driver); // Carga el driver JDBC
            cx=DriverManager.getConnection(url+bd,user, password); // Conecta a la BD 
            PreparedStatement consulta;
            consulta=cx.prepareStatement("UPDATE docentes "
                                                + "SET no_usuario=?, "
                                                + "contra_docente=?, "
                                                + "nombre=?, "
                                                + "apellido=?, "
                                                + "edad=?, "
                                                + "contacto_docente=?, "
                                                + "especialidad=? "
                                                + "WHERE no_usuario=?");
                    
            // Asigna los valores al PreparedStatement    
            consulta.setInt(1, Integer.parseInt(jTextNOUsuario.getText()));
            consulta.setString(2, jTextContraseña.getText());
            consulta.setString(3, jTextNombres.getText());
            consulta.setString(4, jTextApellidos.getText());
            consulta.setInt(5, Integer.parseInt(jTextEdad.getText()));
            consulta.setString(6, jTextContacto.getText());
            consulta.setString(7, jTextCampo.getText());
            consulta.setString(8, jTextNOUsuario.getText()); // Condición WHERE

            consulta.executeUpdate(); // Ejecuta la actualización
            consulta.close(); // Cierra la consulta
            cx.close(); // Cierra la conexión
                
            JOptionPane.showMessageDialog(null, "Los datos del docente se han actualizado con éxito");
            jTextNOUsuario.requestFocus();
            }
    // Manejo de errores de conexión o SQL
    } catch (ClassNotFoundException | SQLException ex) {
        System.out.println("No se conectó a la BD " + ex.getMessage());
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
