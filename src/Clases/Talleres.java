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
public class Talleres {
    //Atributos
    String bd="workshopadmin";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="sqloracle";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx=null;
    PreparedStatement ps=null;
    
    private JComboBox<String> jComboBox1;
    private String nombreguardado;
    
        //Este es el método constructor
    public Talleres(JComboBox<String> comboBox, String nombreRecibido)
    {
        this.jComboBox1 = comboBox;
        //Se asignan los parámetros a los atributos
        this.nombreguardado = nombreRecibido;
    }

    public void cargarTalleres() {
    try {
        // Establecer la conexión
        Class.forName(driver);
        cx = DriverManager.getConnection(url + bd, user, password);

        // Consulta SQL
        String query = "SELECT nombre FROM talleres";  
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
    
    public void AltaTaller(){
    try
    {   
    Class.forName(driver); 
    cx=DriverManager.getConnection(url+bd,user, password); 
    PreparedStatement consulta;
    consulta=cx.prepareStatement("INSERT INTO talleres(nombre)"
                                                 + " VALUES(?)");
    consulta.setString(1, nombreguardado);
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
    
    public void BajaTaller(){
    try
    {
    Class.forName(driver);
    cx=DriverManager.getConnection(url+bd,user, password);
    PreparedStatement consulta;
    consulta=cx.prepareStatement("DELETE FROM talleres WHERE nombre=?");

    consulta.setString(1, nombreguardado);
    consulta.executeUpdate();
    consulta.close();
    cx.close();

    JOptionPane.showMessageDialog(null, "El producto se ha eliminado con éxito");
    cargarTalleres();  // Recargar el JComboBox inmediatamente
    }
    catch(ClassNotFoundException | SQLException ex)
    {
    System.out.println("No se conectó a la BD " + ex.getMessage());
     Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}