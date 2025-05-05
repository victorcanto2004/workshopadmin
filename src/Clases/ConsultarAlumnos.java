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
public class ConsultarAlumnos {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
    // Método para consultar datos de un alumno y mostrarlos en campos de texto y tabla.
    public void Consultar(JTextField jTextMatricula,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextTutor,
            JTextField jTextContactoTutor,
            JTable jTableTalleresGrupos){
        try {
            Class.forName(driver); // Carga el driver de conexión JDBC para MySQL
            cx=DriverManager.getConnection(url+bd,user, password); // Establece la conexión con la base de datos
            PreparedStatement consulta;
            // Consulta SQL para obtener los datos del alumno, su grupo y taller
            consulta=cx.prepareStatement("SELECT a.id_alumno, a.matricula, a.nombre, a.apellido, a.edad, a.tutor, a.contacto_tutor, "
                    + "g.nombre AS grupo, t.nombre AS taller "
                    + "FROM alumnos a "
                    + "JOIN grupos g ON a.id_grupo = g.id_grupo "
                    + "JOIN talleres t ON g.id_taller = t.id_taller "
                    + "WHERE a.matricula = ? AND a.activo = TRUE");
                
            consulta.setString(1, jTextMatricula.getText()); // Asigna la matrícula al parámetro de la consulta
            ResultSet rs = consulta.executeQuery(); // Ejecuta la consulta y guarda el resultado
                
            DefaultTableModel modeloTabla = new DefaultTableModel(); // Modelo para la tabla
            modeloTabla.addColumn("Taller"); // Agrega columna "Taller"
            modeloTabla.addColumn("Grupo"); // Agrega columna "Grupo"

            jTableTalleresGrupos.setModel(modeloTabla); // Aplica el modelo a la JTable
            boolean encontrado = false; // Bandera para saber si se encontró el alumno

            while(rs.next()){ 
                if(!encontrado){ // Si es la primera coincidencia, llenar los campos de texto
                jTextNombres.setText(rs.getString("nombre"));
                jTextApellidos.setText(rs.getString("apellido"));
                jTextEdad.setText(rs.getString("edad"));
                jTextTutor.setText(rs.getString("tutor"));
                jTextContactoTutor.setText(rs.getString("contacto_tutor"));
                encontrado=true;
                }  
            // Agrega cada taller y grupo relacionado con el alumno
            String taller = rs.getString("taller");
            String grupo = rs.getString("grupo");

            modeloTabla.addRow(new Object[]{taller, grupo});
            }
                if (!encontrado) { // Si no hay resultados
                    JOptionPane.showMessageDialog(null, "No se encontró un alumno con esa matrícula.");
                } 
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD" + ex.getMessage()); // Error de conexión o ejecución
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para consultar datos de un alumno y mostrarlos en campos de texto y tabla.
    public void ConsultarInactivo(JTextField jTextMatricula,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextTutor,
            JTextField jTextContactoTutor,
            JTable jTableTalleresGrupos){
        try {
            Class.forName(driver); // Carga el driver de conexión JDBC para MySQL
            cx=DriverManager.getConnection(url+bd,user, password); // Establece la conexión con la base de datos
            PreparedStatement consulta;
            // Consulta SQL para obtener los datos del alumno, su grupo y taller
            consulta=cx.prepareStatement("SELECT a.id_alumno, a.matricula, a.nombre, a.apellido, a.edad, a.tutor, a.contacto_tutor, "
                    + "g.nombre AS grupo, t.nombre AS taller "
                    + "FROM alumnos a "
                    + "JOIN grupos g ON a.id_grupo = g.id_grupo "
                    + "JOIN talleres t ON g.id_taller = t.id_taller "
                    + "WHERE a.matricula = ? AND a.activo = FALSE");
                
            consulta.setString(1, jTextMatricula.getText()); // Asigna la matrícula al parámetro de la consulta
            ResultSet rs = consulta.executeQuery(); // Ejecuta la consulta y guarda el resultado
                
            DefaultTableModel modeloTabla = new DefaultTableModel(); // Modelo para la tabla
            modeloTabla.addColumn("Taller"); // Agrega columna "Taller"
            modeloTabla.addColumn("Grupo"); // Agrega columna "Grupo"

            jTableTalleresGrupos.setModel(modeloTabla); // Aplica el modelo a la JTable
            boolean encontrado = false; // Bandera para saber si se encontró el alumno

            while(rs.next()){ 
                if(!encontrado){ // Si es la primera coincidencia, llenar los campos de texto
                jTextNombres.setText(rs.getString("nombre"));
                jTextApellidos.setText(rs.getString("apellido"));
                jTextEdad.setText(rs.getString("edad"));
                jTextTutor.setText(rs.getString("tutor"));
                jTextContactoTutor.setText(rs.getString("contacto_tutor"));
                encontrado=true;
                }  
            // Agrega cada taller y grupo relacionado con el alumno
            String taller = rs.getString("taller");
            String grupo = rs.getString("grupo");

            modeloTabla.addRow(new Object[]{taller, grupo});
            }
                if (!encontrado) { // Si no hay resultados
                    JOptionPane.showMessageDialog(null, "No se encontró un alumno con esa matrícula.");
                } 
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD" + ex.getMessage()); // Error de conexión o ejecución
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Método para modificar los datos de un alumno en la base de datos.
    public void Modificar(JTextField jTextMatricula,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextTutor,
            JTextField jTextContactoTutor){
        try {
            // Verifica que el campo de matrícula no esté vacío
            if(jTextMatricula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,"Primero debe buscar al estudiante para poder actualizar");
                jTextMatricula.requestFocus(); // Enfoca el campo
            } else {
                Class.forName(driver); // Carga el driver JDBC
                cx=DriverManager.getConnection(url+bd,user, password); // Establece la conexión a la base de datos 
                PreparedStatement consulta;
                // Sentencia SQL para actualizar los datos del alumno
                consulta=cx.prepareStatement("UPDATE alumnos "+ "SET nombre=?, "
                                            + "matricula=?, "
                                            + "apellido=?, "
                                            + "edad=?, "
                                            + "tutor=?, "
                                            + "contacto_tutor=? "
                                            + "WHERE matricula=?");
                    
                // Establece los valores de los parámetros para la consulta// Establece los valores de los parámetros para la consulta
                consulta.setString(1, jTextNombres.getText());
                consulta.setInt(2, Integer.parseInt(jTextMatricula.getText()));
                consulta.setString(3, jTextApellidos.getText());
                consulta.setInt(4, Integer.parseInt(jTextEdad.getText()));
                consulta.setString(5, jTextTutor.getText());
                consulta.setString(6, jTextContactoTutor.getText());
                consulta.setString(7, jTextMatricula.getText()); // WHERE: identificar al alumno por su matrícula
 
                consulta.executeUpdate(); // Ejecuta la actualización
                consulta.close(); // Cierra el statement
                cx.close(); // Cierra la conexión
                
                JOptionPane.showMessageDialog(null, "Los datos del alumno se han actualizado con éxito"); // Mensaje de éxito
                jTextMatricula.requestFocus(); // Enfoca el campo de matrícula
                }
                
       
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD " + ex.getMessage()); // Error de conexión o SQL
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}