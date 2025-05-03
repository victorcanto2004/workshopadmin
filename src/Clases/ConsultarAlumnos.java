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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author canto
 */
public class ConsultarAlumnos {
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    public void Consultar(JTextField jTextMatricula,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextTutor,
            JTextField jTextContactoTutor,
            JTable jTableTalleresGrupos){
            try
            {
                Class.forName(driver); 
                cx=DriverManager.getConnection(url+bd,user, password); 
                PreparedStatement consulta;
                consulta=cx.prepareStatement("SELECT a.id_alumno, a.matricula, a.nombre, a.apellido, a.edad, a.tutor, a.contacto_tutor, "
                     + "g.nombre AS grupo, t.nombre AS taller "
                     + "FROM alumnos a "
                     + "JOIN grupos g ON a.id_grupo = g.id_grupo "
                     + "JOIN talleres t ON g.id_taller = t.id_taller "
                     + "WHERE a.matricula = ?");
                
                consulta.setString(1, jTextMatricula.getText());
                ResultSet rs = consulta.executeQuery();
                
                DefaultTableModel modeloTabla = new DefaultTableModel();
                modeloTabla.addColumn("Taller");
                modeloTabla.addColumn("Grupo");

                jTableTalleresGrupos.setModel(modeloTabla);
                boolean encontrado = false;

            while(rs.next())
            { if(!encontrado){
            jTextNombres.setText(rs.getString("nombre"));
            jTextApellidos.setText(rs.getString("apellido"));
            jTextEdad.setText(rs.getString("edad"));
            jTextTutor.setText(rs.getString("tutor"));
            jTextContactoTutor.setText(rs.getString("contacto_tutor"));
            encontrado=true;
            }           
            String taller = rs.getString("taller");
                String grupo = rs.getString("grupo");

                modeloTabla.addRow(new Object[]{taller, grupo});
            }
                if (!encontrado) {
        JOptionPane.showMessageDialog(null, "No se encontró un alumno con esa matrícula.");
    } 
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                System.out.println("No se conectó a la BD" + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void Modificar(JTextField jTextMatricula,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextTutor,
            JTextField jTextContactoTutor){
          try
            {
                if(jTextMatricula.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Primero debe buscar al estudiante para poder actualizar");
                    jTextMatricula.requestFocus();
                }
                else
                {         
                    Class.forName(driver); 
                    cx=DriverManager.getConnection(url+bd,user, password); 
                    PreparedStatement consulta;
                    consulta=cx.prepareStatement("UPDATE alumnos "
                                                + "SET nombre=?, "
                                                + "matricula=?, "
                                                + "apellido=?, "
                                                + "edad=?, "
                                                + "tutor=?, "
                                                + "contacto_tutor=? "
                                                + "WHERE matricula=?");
                    
                
                consulta.setString(1, jTextNombres.getText());
                consulta.setInt(2, Integer.parseInt(jTextMatricula.getText()));
                consulta.setString(3, jTextApellidos.getText());
                consulta.setInt(4, Integer.parseInt(jTextEdad.getText()));
                consulta.setString(5, jTextTutor.getText());
                consulta.setString(6, jTextContactoTutor.getText());
                consulta.setString(7, jTextMatricula.getText()); // Para el WHERE

                consulta.executeUpdate();
                consulta.close();
                cx.close();
                
                JOptionPane.showMessageDialog(null, "El estudiante se ha actualizado con éxito");
                jTextMatricula.requestFocus();
                }
                
       
            }
                catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }       
}