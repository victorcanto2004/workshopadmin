/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author canto
 */
public class Docentes {
    //Atributos
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;

    private String nousuarioguardado;
    private String contraguardado;
    private String nombreguardado;
    private String apellidoguardado;
    private int edadguardada;
    private String contactoguardado;
    private String especialiadadguardado;
    private int idgrupo;
    
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
    
    public void AltaDocentes(){
        try {
            // Establecer la conexión a la base de datos
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);

            // Paso 1: Verificar si el idgrupo existe en la tabla grupos
            PreparedStatement verificarGrupo = cx.prepareStatement("SELECT COUNT(*) FROM grupos WHERE id_grupo = ?");
            verificarGrupo.setInt(1, idgrupo);
            var rsVerificacion = verificarGrupo.executeQuery();

            if (rsVerificacion.next()) {
                int count = rsVerificacion.getInt(1);  // Obtener el número de registros que coinciden

                if (count == 0) {
                    // Si no se encuentra el grupo, mostrar un mensaje y salir del método
                    JOptionPane.showMessageDialog(null, "El grupo con ID " + idgrupo + " no existe.");
                    return;
                }
            }

            // Paso 2: Insertar el alumno con el id_grupo recibido
            PreparedStatement consulta = cx.prepareStatement(
                "INSERT INTO docentes(no_usuario, contra_docente, nombre, apellido, edad, contacto_docente, especialidad, id_grupo) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)"
            );
            consulta.setString(1, nousuarioguardado);
            consulta.setString(2, contraguardado);
            consulta.setString(3, nombreguardado);
            consulta.setString(4, apellidoguardado);
            consulta.setInt(5, edadguardada);
            consulta.setString(6, contactoguardado);
            consulta.setString(7, especialiadadguardado);
            consulta.setInt(8, idgrupo);  // Usar el id_grupo que se pasó al constructor
            consulta.executeUpdate();
            consulta.close();
            cx.close();
            JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}