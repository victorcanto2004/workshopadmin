/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

// Paquetes que se utilizan
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
public class Alumnos {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)

    // Atributos que almacenan los datos del alumno a registrar
    private String matriculaguardada;
    private String nombreguardado;
    private String apellidoguardado;
    private int edadguardada;
    private String tutorguardado;
    private String contactoguardado;
    private int idgrupo; // Identificador del grupo al que pertenece el alumno
    
    
    // Constructor: recibe y guarda todos los datos necesarios para registrar un alumno.
    public Alumnos( String matricularecibida, String nombrerecibido, String apellidorecibido, int edadrecibida, String tutorrecibido,
            String contactorecibido, int idgrupo){
        this.matriculaguardada = matricularecibida;
        this.nombreguardado = nombrerecibido;
        this.apellidoguardado = apellidorecibido;
        this.edadguardada = edadrecibida;
        this.tutorguardado = tutorrecibido;
        this.contactoguardado = contactorecibido;
        this.idgrupo = idgrupo;
    }

    // Método para registrar (dar de alta) un alumno en la base de datos.
    public void AltaAlumno(){
    // Obtener el nombre del grupo seleccionado del JComboBox
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Primero verifica que el grupo exista antes de insertar los datos del alumno.
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
            
            // Verificar si existe un alumno con la misma matrícula
            PreparedStatement verificarAlumno = cx.prepareStatement(
                "SELECT * FROM alumnos WHERE matricula = ?"
            );
            verificarAlumno.setString(1, matriculaguardada);
            var rs = verificarAlumno.executeQuery();

            if (rs.next()) {
                // Comparar todos los campos relevantes
                boolean mismoalumno = rs.getString("nombre").equals(nombreguardado)
                    && rs.getString("apellido").equals(apellidoguardado)
                    && rs.getInt("edad") == edadguardada
                    && rs.getString("tutor").equals(tutorguardado)
                    && rs.getString("contacto_tutor").equals(contactoguardado);
                
                if (!mismoalumno) {
                    JOptionPane.showMessageDialog(null, "La matrícula ya está en uso por otro alumno. Por favor, elige otra.");
                    return;
                }
            }
            
            // Verificar si ya existe un alumno con la misma matrícula en el mismo grupo
            PreparedStatement verificarGrupoAlumno = cx.prepareStatement(
                "SELECT COUNT(*) FROM alumnos WHERE matricula = ? AND id_grupo = ?"
            );
            verificarGrupoAlumno.setString(1, matriculaguardada);  // Matricula del docente
            verificarGrupoAlumno.setInt(2, idgrupo);  // ID del grupo al que se quiere agregar
            var rsGrupo = verificarGrupoAlumno.executeQuery();

            if (rsGrupo.next() && rsGrupo.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "El alumno ya está asignado a este grupo.");
                return;
            }

            // Insertar los datos del alumno en la tabla "alumnos"
            PreparedStatement consulta = cx.prepareStatement(
                "INSERT INTO alumnos(matricula, nombre, apellido, edad, tutor, contacto_tutor, id_grupo) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)"
            );
            // Asignación de valores a los parámetros de la consulta
            consulta.setString(1, matriculaguardada);
            consulta.setString(2, nombreguardado);
            consulta.setString(3, apellidoguardado);
            consulta.setInt(4, edadguardada);
            consulta.setString(5, tutorguardado);
            consulta.setString(6, contactoguardado);
            consulta.setInt(7, idgrupo);  // ID del grupo recibido por constructor
            
            consulta.executeUpdate(); // Ejecuta la inserción en la base de datos
            // Cierra la consulta y la conexión
            consulta.close();
            cx.close();
            
            // Muestra mensaje de éxito
            JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente.");
        } catch (ClassNotFoundException | SQLException ex) {
            // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola y log
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
