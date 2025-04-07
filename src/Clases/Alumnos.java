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

/**
 *
 * @author canto
 */
public class Alumnos {
    //Atributos
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;

    private String matriculaguardada;
    private String nombreguardado;
    private String apellidoguardado;
    private int edadguardada;
    private String tutorguardado;
    private String contactoguardado;
    private int idgrupo;
    
    
    //Este es el método constructor
    public Alumnos( String matricularecibida, String nombrerecibido, String apellidorecibido, int edadrecibida, String tutorrecibido,
            String contactorecibido, int idgrupo)
    {
        this.matriculaguardada = matricularecibida;
        this.nombreguardado = nombrerecibido;
        this.apellidoguardado = apellidorecibido;
        this.edadguardada = edadrecibida;
        this.tutorguardado = tutorrecibido;
        this.contactoguardado = contactorecibido;
        this.idgrupo = idgrupo;
    }

    public void AltaAlumno(){
    // Obtener el nombre del grupo seleccionado del JComboBox
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
                "INSERT INTO alumnos(matricula, nombre, apellido, edad, tutor, contacto_tutor, id_grupo) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)"
            );
            consulta.setString(1, matriculaguardada);
            consulta.setString(2, nombreguardado);
            consulta.setString(3, apellidoguardado);
            consulta.setInt(4, edadguardada);
            consulta.setString(5, tutorguardado);
            consulta.setString(6, contactoguardado);
            consulta.setInt(7, idgrupo);  // Usar el id_grupo que se pasó al constructor
            consulta.executeUpdate();
            consulta.close();
            cx.close();
            JOptionPane.showMessageDialog(null, "Alumno registrado exitosamente.");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BajaAlumnos(){
              try
            {    
                    Class.forName(driver); 
                    cx=DriverManager.getConnection(url+bd,user, password); 
                    PreparedStatement consulta;
                    consulta=cx.prepareStatement("DELETE FROM alumnos "
                                               + "WHERE id_alumno=?");
                    consulta.setInt(1, Integer.parseInt(matriculaguardada));
                    consulta.executeUpdate();
                    consulta.close();
                    cx.close();     
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }          
    }
}
