/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection; // Importa la clase conexion para gestionar la conexion con la base de datos
import java.sql.DriverManager; // Importa DriverManager, que se usa para establecer conexiones con la base de datos.
import java.sql.PreparedStatement; // Importa PreparedStatement, que permite ejecutar consultas SQL seguras con parámetros.
import java.sql.ResultSet; // Importa la clase ResultSet, que se utiliza para almacenar los resultados de una consulta SQL.
import java.sql.SQLException; // Importa SQLException, que captura errores relacionados con la base de datos.
// Importa Logger y Level, herramientas para registrar mensajes en la consola o en archivos de log.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable; // Importa la clase JTable, que permite mostrar datos en forma de tabla en una interfaz gráfica.
import javax.swing.table.DefaultTableModel; // Importa la clase DefaultTableModel, que facilita la gestión de datos en una JTable (agregar, eliminar filas, etc.).

/**
 *
 * @author canto
 */
public class ConsultarTalleres {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
    // Método para consultar los docentes asignados a un taller específico y mostrarlos en una tabla
    public void Consultar(String nombreTaller, JTable jTableTalleresGrupos) {
        try {
            Class.forName(driver); // Carga el driver JDBC
            cx = DriverManager.getConnection(url + bd, user, password); // Conexión a la base de datos
            // Verificar si el taller existe
            PreparedStatement verificarTaller = cx.prepareStatement("SELECT id_taller FROM talleres WHERE nombre = ? AND activo = TRUE");
            verificarTaller.setString(1, nombreTaller);
            ResultSet rsTaller = verificarTaller.executeQuery();

            if (!rsTaller.next()) {
                JOptionPane.showMessageDialog(null, "Este taller no existe");
                return;
            }
            // Consulta para obtener docentes y grupos asociados al taller indicado
            PreparedStatement consulta;
            consulta = cx.prepareStatement(
                "SELECT d.nombre AS docente_nombre, d.no_usuario, g.nombre AS grupo " +
                "FROM docentes d " +
                "JOIN grupos g ON d.id_grupo = g.id_grupo " +
                "JOIN talleres t ON g.id_taller = t.id_taller " +
                "WHERE t.nombre = ? AND t.activo = TRUE"
            );

            consulta.setString(1, nombreTaller); // Asigna el nombre del taller a buscar
            ResultSet rs = consulta.executeQuery(); // Ejecuta la consulta

             // Crea el modelo de la tabla y define las columnas
            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Nombre Docente");
            modeloTabla.addColumn("No. Usuario");
            modeloTabla.addColumn("Grupo");

            // Aplica el modelo a la tabla
            jTableTalleresGrupos.setModel(modeloTabla);
            boolean encontrado = false;
            
            // Llena la tabla con los resultados
            while (rs.next()) {
                String docenteNombre = rs.getString("docente_nombre");
                String noUsuario = rs.getString("no_usuario");
                String grupo = rs.getString("grupo");
                modeloTabla.addRow(new Object[]{docenteNombre, noUsuario, grupo});
                encontrado = true;
            }

            // Si no se encontró ningún docente
            if (!encontrado) {
            modeloTabla.addRow(new Object[]{"No se encontraron", "docentes ", "para este taller"});
        }

        // Maneja las excepciones
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
