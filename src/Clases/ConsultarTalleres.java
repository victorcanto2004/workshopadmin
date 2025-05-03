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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author canto
 */
public class ConsultarTalleres {
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    public void Consultar(String nombreTaller, JTable jTableTalleresGrupos) {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            PreparedStatement consulta;
            consulta = cx.prepareStatement(
                "SELECT d.nombre AS docente_nombre, d.no_usuario, g.nombre AS grupo " +
                "FROM docentes d " +
                "JOIN grupos g ON d.id_grupo = g.id_grupo " +
                "JOIN talleres t ON g.id_taller = t.id_taller " +
                "WHERE t.nombre = ?"
            );

            consulta.setString(1, nombreTaller);
            ResultSet rs = consulta.executeQuery();

            // Creamos el modelo de la tabla
            DefaultTableModel modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Nombre Docente");
            modeloTabla.addColumn("No. Usuario");
            modeloTabla.addColumn("Grupo");

            // Establecemos el modelo a la tabla
            jTableTalleresGrupos.setModel(modeloTabla);
            boolean encontrado = false;
            // Si se encuentran resultados, los agregamos a la tabla
            while (rs.next()) {
                String docenteNombre = rs.getString("docente_nombre");
                String noUsuario = rs.getString("no_usuario");
                String grupo = rs.getString("grupo");
                modeloTabla.addRow(new Object[]{docenteNombre, noUsuario, grupo});
                encontrado = true;
            }

            // Si no hay resultados
            if (!encontrado) {
            modeloTabla.addRow(new Object[]{"No se encontraron", "docentes ", "para este taller"});
        }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conectó a la BD: " + ex.getMessage());
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
