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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author canto
 */
public class Grupos {
    //Atributos
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private String nombreguardado;
    private String idguardado;
    
    //Este es el método constructor
    public Grupos(JComboBox<String> comboBox, String nombreRecibido, String idrecibido, JComboBox<String> comboBox1)
    {
        this.jComboBox1 = comboBox;
        this.jComboBox2 = comboBox1;
        //Se asignan los parámetros a los atributos
        this.nombreguardado = nombreRecibido;
        this.idguardado = idrecibido;
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
        
        //jComboBox1.updateUI();  // Refrescar visualmente
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
    
    public void AltaGrupos(){
    try
    {   
    Class.forName(driver); 
    cx=DriverManager.getConnection(url+bd,user, password); 
    PreparedStatement consulta;
    consulta=cx.prepareStatement("INSERT INTO grupos(nombre, id_taller)"
                                                 + " VALUES(?, ?)");
    consulta.setString(1, nombreguardado);
    consulta.setString(2, idguardado);
    consulta.executeUpdate();
    consulta.close();
    cx.close();
    JOptionPane.showMessageDialog(null, "Taller registrado exitosamente.");
    cargarTalleres();  // Recargar el JComboBox inmediatamente
    }
    catch(ClassNotFoundException | SQLException ex)
    {
    System.out.println("No se conectó a la BD " + ex.getMessage());
    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    
    public void BajaGrupos(){
    try
    {
    Class.forName(driver);
    cx=DriverManager.getConnection(url+bd,user, password);
    PreparedStatement consulta;
    consulta=cx.prepareStatement("DELETE FROM grupos WHERE nombre=?");

    consulta.setString(1, nombreguardado);
    consulta.executeUpdate();
    consulta.close();
    cx.close();

    JOptionPane.showMessageDialog(null, "El producto se ha eliminado con éxito");
    cargarGrupos();  // Recargar el JComboBox inmediatamente
    cargarTalleres();
    }
    catch(ClassNotFoundException | SQLException ex)
    {
    System.out.println("No se conectó a la BD " + ex.getMessage());
     Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }    
}
