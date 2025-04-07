/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author canto
 */
public class CargarAlumnos {
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    private JComboBox<String> jComboBox1; // JComboBox de talleres
    private JComboBox<String> jComboBox2; // JComboBox de grupos
    private JComboBox<String> jComboBox3; // JComboBox de alumnos
    private String idguardado; 
    private String idguardado2; 
    
    // Constructor para inicializar el JComboBox
    public CargarAlumnos(JComboBox<String> comboBox, JComboBox<String> comboBox2,JComboBox<String> comboBox3, String idregistrado, String idregistrado2) {
        this.jComboBox1 = comboBox;
        this.jComboBox2 = comboBox2;
        this.jComboBox3 = comboBox3;
        this.idguardado = idregistrado;
        this.idguardado2 = idregistrado2;
    }

    public void cargarTalleres() {
    try {
        // Establecer la conexión
        Class.forName(driver);
        cx = DriverManager.getConnection(url + bd, user, password);

        // Consulta SQL
        String query = "SELECT nombre FROM talleres";  // Cambia esto según tu tabla
        PreparedStatement stmt = cx.prepareStatement(query);
        var rs = stmt.executeQuery();

        // Limpiar el JComboBox antes de agregar nuevos elementos
        jComboBox1.removeAllItems();
        
        // Agregar la opción "Taller"
        jComboBox1.addItem("Taller");

        // Agregar los datos al JComboBox
        while (rs.next()) {
            jComboBox1.addItem(rs.getString("nombre"));  // Asegúrate de que el campo exista en la tabla
        }

        rs.close();
        stmt.close();
        cx.close();
        
        jComboBox1.updateUI();  // Refrescar visualmente
        } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
        }
    }
    
    public void cargarGrupos(){
try {
        // Verificar que el TextField no esté vacío
        if (idguardado != null && !idguardado.trim().isEmpty()) {
            // Establecer la conexión a la base de datos
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los grupos asociados a ese id_taller
            String query = "SELECT nombre FROM grupos WHERE id_taller = ?";
            PreparedStatement stmt = cx.prepareStatement(query);
            stmt.setString(1, idguardado);  // Establecer el parámetro id_taller

            // Ejecutar la consulta
            var rs = stmt.executeQuery();

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox2.removeAllItems();
            
            // Agregar la opción "Grupo"
            jComboBox2.addItem("Grupos");

            // Agregar los grupos al JComboBox
            while (rs.next()) {
                jComboBox2.addItem(rs.getString("nombre"));
            }

            // Cerrar los recursos
            rs.close();
            stmt.close();
            cx.close();

            jComboBox2.updateUI();  // Refrescar el JComboBox visualmente
        } else {
            // Si el TextField está vacío, mostrar un mensaje
        }
    } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
    }
}

    public void CargarAlumnos(){
try {
        // Verificar que el TextField no esté vacío
        if (idguardado2 != null && !idguardado2.trim().isEmpty()) {
            // Establecer la conexión a la base de datos
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);

            // Consulta SQL para obtener los grupos asociados a ese id_taller
            String query = "SELECT matricula FROM alumnos WHERE id_grupo = ?";
            PreparedStatement stmt = cx.prepareStatement(query);
            stmt.setString(1, idguardado2);  // Establecer el parámetro id_taller

            // Ejecutar la consulta
            var rs = stmt.executeQuery();

            // Limpiar el JComboBox antes de agregar nuevos elementos
            jComboBox3.removeAllItems();
            
            // Agregar la opción "Grupo"
            jComboBox3.addItem("Matriculas");

            // Agregar los grupos al JComboBox
            while (rs.next()) {
                jComboBox3.addItem(rs.getString("matricula"));
            }

            // Cerrar los recursos
            rs.close();
            stmt.close();
            cx.close();

            jComboBox3.updateUI();  // Refrescar el JComboBox visualmente
        } else {
            // Si el TextField está vacío, mostrar un mensaje
        }
    } catch (ClassNotFoundException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage());
            }       
        }
    }
