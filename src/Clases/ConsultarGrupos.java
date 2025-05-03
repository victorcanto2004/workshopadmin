/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author canto
 */
public class ConsultarGrupos {
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    public void Consultar(String idgrupo, JTextField jTextNoDocente,
            JTextField jTextNombre,
            JTextField jTextApellidos){
                        try
            {
                Class.forName(driver); 
                cx=DriverManager.getConnection(url+bd,user, password); 
                PreparedStatement consulta;
                consulta=cx.prepareStatement("SELECT d.no_usuario, d.nombre, d.apellido " +
                                                "FROM docentes d " +
                                                "WHERE id_grupo = ?");
                
                consulta.setString(1, idgrupo);
                ResultSet resultado = consulta.executeQuery();

                if (resultado.next()) {
                    // Si hay un docente, mostramos sus datos en los JTextField
                    jTextNoDocente.setText(resultado.getString("no_usuario"));
                    jTextNombre.setText(resultado.getString("nombre"));
                    jTextApellidos.setText(resultado.getString("apellido"));
                } else {
                    // Si no se encuentra ningún docente, mostramos un mensaje en los JTextField
                    jTextNoDocente.setText("No hay docente aún");
                    jTextNombre.setText("No hay docente aún");
                    jTextApellidos.setText("No hay docente aún");
                }
     
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println("No se conectó a la BD" + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }
}