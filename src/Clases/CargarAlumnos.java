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
import javax.swing.JComboBox; // Importa la clase JComboBox que permite crear listas desplegables en la interfaz gráfica
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).

/**
 *
 * @author canto
 */
public class CargarAlumnos {
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas)
    
    private JComboBox<String> jComboBox1; // JComboBox de talleres
    private JComboBox<String> jComboBox2; // JComboBox de grupos
    private JComboBox<String> jComboBox3; // JComboBox de alumnos
    private String idguardado; // Id de los talleres
    private String idguardado2; // Id de los grupos
    
    // Constructor que inicializa los JComboBox y las IDs de taller y grupo.
    public CargarAlumnos(JComboBox<String> comboBox, JComboBox<String> comboBox2,JComboBox<String> comboBox3, String idregistrado, String idregistrado2) {
        this.jComboBox1 = comboBox;
        this.jComboBox2 = comboBox2;
        this.jComboBox3 = comboBox3;
        this.idguardado = idregistrado;
        this.idguardado2 = idregistrado2;
    }

    // Método para cargar los talleres en el JComboBox jComboBox1.
    public void cargarTalleres() {
        try {
            // Establecer la conexión
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los nombres de los talleres
            String query = "SELECT nombre FROM talleres WHERE activo = TRUE";  
            PreparedStatement stmt = cx.prepareStatement(query);
            var rs = stmt.executeQuery(); // Ejecuta la consulta

            // Limpiar el JComboBox antes de agregar los nuevos elementos
            jComboBox1.removeAllItems();

            // Agregar la opción "Taller"
            jComboBox1.addItem("Taller");

            // Agregar los nombres de los talleres al JComboBox
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("nombre"));  
            }

            // Cierra la consulta y la conexión
            rs.close();
            stmt.close();
            cx.close();

            jComboBox1.updateUI();  // Refrescar el JComboBox visualmente

            // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola 
            } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }
    
    // Método para cargar los grupos en el JComboBox jComboBox2, basado en el ID del taller.
    public void cargarGrupos(){
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los grupos asociados al ID del taller
            String query = "SELECT nombre FROM grupos WHERE id_taller = ? AND activo = TRUE";
            PreparedStatement stmt = cx.prepareStatement(query);
            stmt.setString(1, idguardado); // Asignar el ID del taller al parámetro         
            var rs = stmt.executeQuery(); // Ejecutar la consulta

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox2.removeAllItems();

            // Agregar la opción "Grupo"
            jComboBox2.addItem("Grupos");

            // Agregar los nombres de los grupos al JComboBox
            while (rs.next()) {
                jComboBox2.addItem(rs.getString("nombre"));
            }

            // Cierra la consulta y la conexión
            rs.close();
            stmt.close();
            cx.close();

             jComboBox2.updateUI(); // Refrescar el JComboBox visualmente
            
        // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
}

    // Método para cargar los alumnos en el JComboBox jComboBox3, basado en el ID del grupo.
    public void CargarAlumnos(){
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los grupos asociados a ese id_taller
            String query = "SELECT matricula FROM alumnos WHERE id_grupo = ? AND activo = TRUE";
            PreparedStatement stmt = cx.prepareStatement(query);
            stmt.setString(1, idguardado2);  // Asignar el ID del grupo al parámetro

            // Ejecutar la consulta
            var rs = stmt.executeQuery();

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox3.removeAllItems();

            // Agregar las matrículas de los alumnos al JComboBox
            jComboBox3.addItem("Matriculas");

            // Agregar los grupos al JComboBox
            while (rs.next()) {
                jComboBox3.addItem(rs.getString("matricula"));
            }

            // Cierra la consulta y la conexión
            rs.close();
            stmt.close();
            cx.close();

            jComboBox3.updateUI();  // Refrescar el JComboBox visualmente
               
        // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola
        } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }       
   }
    
    // Método para cargar los docentes en el JComboBox jComboBox3, basado en el ID del grupo.
    public void CargarDocentes(){
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver); // Cargar el driver JDBC para MySQL
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los usuarios de los docentes en un grupo específico
            String query = "SELECT no_usuario FROM docentes WHERE id_grupo = ? AND activo = TRUE";
            PreparedStatement stmt = cx.prepareStatement(query);
            stmt.setString(1, idguardado2);  // Establecer el parámetro id_taller

            // Ejecutar la consulta
            var rs = stmt.executeQuery();

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox3.removeAllItems();

            // Agregar la opción "No_Usuario"
            jComboBox3.addItem("No_Usuario");

            // Agregar los grupos al JComboBox
            while (rs.next()) {
                jComboBox3.addItem(rs.getString("no_usuario"));
            }

            // Agregar los números de usuario de los docentes al JComboBox
            rs.close();
            stmt.close();
            cx.close();

            jComboBox3.updateUI();  // Refrescar el JComboBox visualmente

            // Si ocurre un error al conectar o ejecutar la consulta, se imprime en consola    
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }       
    }
}
