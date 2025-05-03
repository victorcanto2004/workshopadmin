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
public class ConsultarDocente {
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    public void Consultar(JTextField jTextNOUsuario,
            JTextField jTextContraseña,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextContacto,
            JTextField jTextCampo,
            JTable jTableTalleresGrupos){
        
            try
            {
                Class.forName(driver); 
                cx=DriverManager.getConnection(url+bd,user, password); 
                PreparedStatement consulta;
                consulta=cx.prepareStatement("SELECT d.id_docente, d.no_usuario, d.contra_docente, d.nombre, d.apellido, d.edad, d.contacto_docente, d.especialidad, "
                     + "g.nombre AS grupo, t.nombre AS taller "
                     + "FROM docentes d "
                     + "JOIN grupos g ON d.id_grupo = g.id_grupo "
                     + "JOIN talleres t ON g.id_taller = t.id_taller "
                     + "WHERE d.no_usuario = ?");
                
                consulta.setString(1, jTextNOUsuario.getText());
                ResultSet rs = consulta.executeQuery();
                
                DefaultTableModel modeloTabla = new DefaultTableModel();
                modeloTabla.addColumn("Taller");
                modeloTabla.addColumn("Grupo");

                jTableTalleresGrupos.setModel(modeloTabla);
                boolean encontrado = false;

            while(rs.next())
            { if(!encontrado){
            jTextContraseña.setText(rs.getString("contra_docente"));
            jTextNombres.setText(rs.getString("nombre"));
            jTextApellidos.setText(rs.getString("apellido"));
            jTextEdad.setText(rs.getString("edad"));
            jTextContacto.setText(rs.getString("contacto_docente"));
            jTextCampo.setText(rs.getString("especialidad"));
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
    
public void Modificar(JTextField jTextNOUsuario,
            JTextField jTextContraseña,
            JTextField jTextNombres,
            JTextField jTextApellidos,
            JTextField jTextEdad,
            JTextField jTextContacto,
            JTextField jTextCampo){
          try
            {
                if(jTextNOUsuario.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Primero debe buscar al estudiante para poder actualizar");
                    jTextNOUsuario.requestFocus();
                }
                else
                {         
                    Class.forName(driver); 
                    cx=DriverManager.getConnection(url+bd,user, password); 
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
                    
                
                consulta.setInt(1, Integer.parseInt(jTextNOUsuario.getText()));
                consulta.setString(2, jTextContraseña.getText());
                consulta.setString(3, jTextNombres.getText());
                consulta.setString(4, jTextApellidos.getText());
                consulta.setInt(5, Integer.parseInt(jTextEdad.getText()));
                consulta.setString(6, jTextContacto.getText());
                consulta.setString(7, jTextCampo.getText());
                consulta.setString(8, jTextNOUsuario.getText()); // Para el WHERE

                consulta.executeUpdate();
                consulta.close();
                cx.close();
                
                JOptionPane.showMessageDialog(null, "El estudiante se ha actualizado con éxito");
                jTextNOUsuario.requestFocus();
                }
                
       
            }
                catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
    }   
}
