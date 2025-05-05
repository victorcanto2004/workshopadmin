/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

// Paquetes a utilizar
import java.sql.Connection; // Importa la clase conexion para gestionar la conexion con la base de datos
import java.sql.DriverManager; // Importa DriverManager, que se usa para establecer conexiones con la base de datos.
import java.sql.PreparedStatement; // Importa PreparedStatement, que permite ejecutar consultas SQL seguras con parámetros.
import java.sql.SQLException; // Importa SQLException, que captura errores relacionados con la base de datos.
// Importa Logger y Level, herramientas para registrar mensajes en la consola o en archivos de log.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).

/**
 *
 * @author canto
 */
public class Docentes {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)

    //Atributos
    private String nousuarioguardado;
    private String contraguardado;
    private String nombreguardado;
    private String apellidoguardado;
    private int edadguardada;
    private String contactoguardado;
    private String especialiadadguardado;
    private int idgrupo;
    
    // Constructor
    public Docentes(String nousuariorecibido, String contrarecibido, String nombrerecibido, String apellidorecibido, int edadrecibida, String contactorecibido,
            String especialiadadrecibido, int idgrupo){
     
        this.nousuarioguardado = nousuariorecibido;
        this.contraguardado = contrarecibido;
        this.nombreguardado = nombrerecibido;
        this.apellidoguardado = apellidorecibido;
        this.edadguardada = edadrecibida;
        this.contactoguardado = contactorecibido;
        this.especialiadadguardado = especialiadadrecibido;
        this.idgrupo = idgrupo;
    }
    
    // Método para registrar (dar de alta) un docente en la base de datos.
    public void AltaDocentes(){
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Verificar si el idgrupo existe en la tabla grupos
            PreparedStatement verificarGrupo = cx.prepareStatement("SELECT COUNT(*) FROM grupos WHERE id_grupo = ?");
            verificarGrupo.setInt(1, idgrupo); // Asigna el ID del grupo al parámetro
            var rsVerificacion = verificarGrupo.executeQuery(); // Ejecuta la consulta

            if (rsVerificacion.next()) {
                int count = rsVerificacion.getInt(1);  // Obtiene el número de registros encontrados

                if (count == 0) {
                    // Si el grupo no existe, mostrar mensaje y cancelar el registro
                    JOptionPane.showMessageDialog(null, "El grupo con ID " + idgrupo + " no existe.");
                    return;
                }
            }
            
            // Verificar si existe un docente activo con la misma matrícula
            PreparedStatement verificarDocente = cx.prepareStatement(
                "SELECT * FROM docentes WHERE no_usuario = ?"
            );
            verificarDocente.setString(1, nousuarioguardado);
            var rs = verificarDocente.executeQuery();

            if (rs.next()) {
                // Comparar todos los campos relevantes
                boolean mismoDocente = rs.getString("nombre").equals(nombreguardado)
                    && rs.getString("apellido").equals(apellidoguardado)
                    && rs.getInt("edad") == edadguardada
                    && rs.getString("contacto_docente").equals(contactoguardado)
                    && rs.getString("especialidad").equals(especialiadadguardado);

                if (!mismoDocente) {
                    JOptionPane.showMessageDialog(null, "La matrícula ya está en uso por otro docente. Por favor, elige otra.");
                    return;
                }
            }

            // Verificar si la contraseña ya está en uso
            PreparedStatement verificarContrasena = cx.prepareStatement(
                "SELECT COUNT(*) FROM docentes WHERE contra_docente = ? AND no_usuario != ?"
            );
            verificarContrasena.setString(1, contraguardado); // Contraseña que se quiere usar
            verificarContrasena.setString(2, nousuarioguardado); // Asegurarse que no sea el mismo docente
            var rsContra = verificarContrasena.executeQuery();

            if (rsContra.next() && rsContra.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "La contraseña ya está en uso por otro docente. Por favor, elige otra.");
                return;
            }
            
            // Verificar si ya existe un docente con la misma matrícula en el mismo grupo
            PreparedStatement verificarGrupoDocente = cx.prepareStatement(
                "SELECT COUNT(*) FROM docentes WHERE no_usuario = ? AND id_grupo = ?"
            );
            verificarGrupoDocente.setString(1, nousuarioguardado);  // Matricula del docente
            verificarGrupoDocente.setInt(2, idgrupo);  // ID del grupo al que se quiere agregar
            var rsGrupo = verificarGrupoDocente.executeQuery();

            if (rsGrupo.next() && rsGrupo.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "El docente ya está asignado a este grupo.");
                return;
            }
            // Insertar el alumno con el id_grupo recibido
            PreparedStatement consulta = cx.prepareStatement(
                "INSERT INTO docentes(no_usuario, contra_docente, nombre, apellido, edad, contacto_docente, especialidad, id_grupo) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
            );
            // Asignación de valores a los parámetros de la consulta
            consulta.setString(1, nousuarioguardado);
            consulta.setString(2, contraguardado);
            consulta.setString(3, nombreguardado);
            consulta.setString(4, apellidoguardado);
            consulta.setInt(5, edadguardada);
            consulta.setString(6, contactoguardado);
            consulta.setString(7, especialiadadguardado);
            consulta.setInt(8, idgrupo);  // ID del grupo recibido por constructor
            consulta.executeUpdate(); // Ejecuta la inserción en la base de datos
            // Cierra la consulta y la conexión
            consulta.close();
            cx.close();
            
            JOptionPane.showMessageDialog(null, "Docente registrado exitosamente."); // Muestra mensaje de éxito
            
        // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola y log
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}