/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrador;

import Clases.CargarAlumnos; // Importa la clase CargarAlumnos
import Clases.Conexion; // Importa la clase conexion para gestionar la conexion con la base de datos
import Clases.TextPrompt; // Importa la clase TextPrompt para utilizar placeholders
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color; // Permite usar la clase Color para cambiar colores en componentes gráficos.
import java.awt.Image; // Permite manejar imágenes, por ejemplo, para íconos o imágenes en la interfaz.
import java.awt.Toolkit; // Proporciona acceso a recursos del sistema como imágenes, sonidos, etc.
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection; // Importa Connection, que representa la conexión activa con la base de datos.
import java.sql.DriverManager; // Importa DriverManager, que se usa para establecer conexiones con la base de datos.
import java.sql.PreparedStatement; // Importa PreparedStatement, que permite ejecutar consultas SQL seguras con parámetros.
import java.sql.SQLException;  // Importa SQLException, que captura errores relacionados con la base de datos.
import java.text.DateFormat; // Clase base para formateo de fechas genérico
import java.text.SimpleDateFormat; // Clase concreta que permite definir el formato de la fecha (por ejemplo: dd/MM/yyyy)
import java.util.Date; // Clase que representa una fecha y hora
import java.util.Locale;
// Importa Logger y Level, herramientas para registrar mensajes en la consola o en archivos de log.
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).
import java.sql.*;
/**
 *
 * @author canto
 */
public class JFPagosCursosLibros extends javax.swing.JFrame {

    /**
     * Creates new form JFPagosCursosLibros
     */
    
    // Datos de configuración para la conexión con la base de datos
    String bd="workshopadmin"; // Nombre de la base de datos a la que se desea conectar.
    String url="jdbc:mysql://localhost:3306/"; // URL de conexión para MySQL. Incluye el host (localhost) y el puerto (3306), pero no la base de datos todavía.
    String user="root"; // Usuario de la base de datos. En muchos entornos locales, "root" es el usuario por defecto.
    String password="sqloracle"; // Contraseña del usuario "root". Aquí se ha puesto "sqloracle", pero debe coincidir con la contraseña real en tu servidor MySQL.
    String driver="com.mysql.cj.jdbc.Driver"; // Nombre del driver JDBC que se utiliza para conectar a MySQL. Este driver debe estar incluido en el classpath del proyecto.
    Connection cx=null; // Objeto de conexión. Se utilizará para establecer la conexión con la base de datos.
    PreparedStatement ps=null; // Objeto que permite ejecutar sentencias SQL con parámetros (consultas preparadas) 
    
    public JFPagosCursosLibros() {
        initComponents();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva la X de cierre
        // Llamar a CargarAlumnos
        CargarAlumnos al = new CargarAlumnos(jComboBoxTalleres, jComboBoxGrupos,jComboBoxAlumnos, jTextField1.getText(),jTextField2.getText());
        al.cargarTalleres();
        // Oculta inicialmente el jTextField
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        TextPrompt motivo = new TextPrompt("Pago curso o libro",jTextMotivo); // Establece textos de sugerencia ("placeholders")
        TextPrompt costo = new TextPrompt("$520.00",jTextMonto); 
        
        setIconImage(getIconImage()); // Establece un ícono personalizado para la ventana.
    }
    //Icono del JFrame
    @Override // Indica que este método sobrescribe el método getIconImage() de la clase JFrame
    // Usa Toolkit (una clase de utilidades gráficas de AWT) para obtener una imagen ubicada en la ruta interna del proyecto
    // ClassLoader.getSystemResource() localiza el archivo dentro del classpath (dentro de src o el .jar).
    public Image getIconImage(){ 
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("workshopadmin/Imagenes/LogoIcono.png"));
        return retValue; // Devuelve la imagen para que sea usada como ícono del JFrame
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextMotivo = new javax.swing.JTextField();
        jTextMonto = new javax.swing.JTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonHistorial = new javax.swing.JButton();
        jComboBoxTalleres = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jComboBoxGrupos = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextApellido = new javax.swing.JTextField();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelnformacion = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jButtonRegresarInicio = new javax.swing.JButton();
        jButtonRecibo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registrar pagos de cursos");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Motivo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Costo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Fecha");

        jTextMotivo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTextMonto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMontoKeyTyped(evt);
            }
        });

        jButtonRegistrar.setBackground(java.awt.Color.lightGray);
        jButtonRegistrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Registrar.png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegistrarMouseExited(evt);
            }
        });
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonHistorial.setBackground(java.awt.Color.lightGray);
        jButtonHistorial.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Historial.png"))); // NOI18N
        jButtonHistorial.setText("Historial");
        jButtonHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonHistorialMouseExited(evt);
            }
        });
        jButtonHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistorialActionPerformed(evt);
            }
        });

        jComboBoxTalleres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxTalleres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTalleresActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jComboBoxGrupos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxGruposActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");

        jComboBoxAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAlumnosActionPerformed(evt);
            }
        });

        jTextField3.setText("jTextField3");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Nombre");

        jTextNombre.setEditable(false);
        jTextNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Apellido");

        jTextApellido.setEditable(false);
        jTextApellido.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jDateChooserFecha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButtonHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addComponent(jComboBoxTalleres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMotivo, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                            .addComponent(jTextMonto)
                            .addComponent(jTextNombre)
                            .addComponent(jTextApellido)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTalleres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonHistorial))
                .addGap(33, 33, 33))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Imagenes/Pagos.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setText("Registra el pago de los cursos o libros");

        jLabelnformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Informacion.png"))); // NOI18N
        jLabelnformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelnformacionMouseClicked(evt);
            }
        });

        jButtonRegresar.setBackground(java.awt.Color.lightGray);
        jButtonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Atras.png"))); // NOI18N
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegresarMouseExited(evt);
            }
        });
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jButtonRegresarInicio.setBackground(java.awt.Color.lightGray);
        jButtonRegresarInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonRegresarInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Atras.png"))); // NOI18N
        jButtonRegresarInicio.setText("Regresar al inicio");
        jButtonRegresarInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRegresarInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonRegresarInicioMouseExited(evt);
            }
        });
        jButtonRegresarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarInicioActionPerformed(evt);
            }
        });

        jButtonRecibo.setBackground(java.awt.Color.lightGray);
        jButtonRecibo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/imprimir.png"))); // NOI18N
        jButtonRecibo.setText("<html>Recibo</html>");
        jButtonRecibo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonReciboMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonReciboMouseExited(evt);
            }
        });
        jButtonRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonRegresar)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonRegresarInicio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelnformacion)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabelnformacion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegresarInicio)
                    .addComponent(jButtonRegresar))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonRegistrar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonRegistrarMouseEntered

    private void jButtonRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonRegistrar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonRegistrarMouseExited

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "Realmente desea registrar este pago?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.NO_OPTION) {
            // Si el usuario elige "No", simplemente no hace nada o muestra otro mensaje
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
            } else {
                // Validación: Verifica si algún campo obligatorio está vacío
                if (jComboBoxTalleres.getSelectedItem().toString().equals("Taller") ||
                    jComboBoxGrupos.getSelectedItem().toString().equals("Grupos")||
                    jComboBoxAlumnos.getSelectedItem().toString().equals("Matriculas")||
                    jTextMotivo.getText().trim().isEmpty()||
                    jTextMonto.getText().trim().isEmpty()||
                    jDateChooserFecha.getDate() == null){ 

                JOptionPane.showMessageDialog(null,"Por favor, selecciona el taller, el grupo y el alumno"
                        + "\ntambien escribe el motivo, el monto y la fecha",
                            "ADVERTENCIA",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try
                      {    
                          Date  fecha=(Date) jDateChooserFecha.getDate();
                          DateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
                          String fechapago=f1.format(fecha);

                              Class.forName(driver); 
                              cx=DriverManager.getConnection(url+bd,user, password); 
                              PreparedStatement consulta;
                              consulta=cx.prepareStatement("INSERT INTO pagos (motivo, monto, fecha_pago, id_alumno) "
                                                         + "VALUES (?, ?, ?, ?)");

                              consulta.setString(1, jTextMotivo.getText()); // motivo
                              consulta.setDouble(2, Double.parseDouble(jTextMonto.getText())); // monto
                              consulta.setDate(3, java.sql.Date.valueOf(fechapago)); // fecha_pago
                              consulta.setInt(4, Integer.parseInt(jTextField3.getText())); // id_alumno
                              consulta.executeUpdate();
                              consulta.close();
                              cx.close();     
                              
                            CargarAlumnos al = new CargarAlumnos(jComboBoxTalleres, jComboBoxGrupos,jComboBoxAlumnos, jTextField1.getText(),jTextField2.getText());
                            al.cargarTalleres();
                              
                              jTextMotivo.setText("");
                              jTextMonto.setText("");
                              jTextNombre.setText("");
                              jTextApellido.setText("");
                              jDateChooserFecha.setDate(null);
                              
                              JOptionPane.showMessageDialog(null, "Pago registrado con éxito");
            } catch(ClassNotFoundException | SQLException ex){
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }      
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHistorialMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonHistorial.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonHistorialMouseEntered

    private void jButtonHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonHistorialMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonHistorial.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonHistorialMouseExited

    private void jLabelnformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelnformacionMouseClicked
        // TODO add your handling code here:
        // Este método se ejecuta cuando el usuario hace clic en el label de información.
        JOptionPane.showMessageDialog(null,"Usa esta ventana para registrar un pago, ya sea por un curso o por un libro.\n" +
                            "*Selecciona el taller y el grupo correspondientes.\n" +
                            "*Elige al alumno que realizó el pago.\n" +
                            "*Indica el tipo de pago: curso o libro.\n" +
                            "*Ingresa el monto pagado y la fecha del pago.\n" +
                            "*Haz clic en Registrar para guardar la información.\n" +
                            "*Asegúrate de que todos los datos sean correctos antes de confirmar.",
            "Información",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelnformacionMouseClicked

    private void jButtonRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonRegresar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonRegresarMouseEntered

    private void jButtonRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonRegresar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonRegresarMouseExited

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        JFAdministrarPagos JFAdministrarPagos =new JFAdministrarPagos();
        JFAdministrarPagos.setVisible(true);
        JFAdministrarPagos.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonRegresarInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarInicioMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonRegresarInicio.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonRegresarInicioMouseEntered

    private void jButtonRegresarInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegresarInicioMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonRegresarInicio.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonRegresarInicioMouseExited

    private void jButtonRegresarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarInicioActionPerformed
        // TODO add your handling code here:
        JFMenuAdministrador JFMenuAdministrador =new JFMenuAdministrador();
        JFMenuAdministrador.setVisible(true);
        JFMenuAdministrador.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarInicioActionPerformed

    private void jComboBoxTalleresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTalleresActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) jComboBoxTalleres.getSelectedItem();

        // Verificar si el valor seleccionado no es "Taller"
        if (seleccionado != null && !seleccionado.equals("Taller")) {
            // Establecer el nombre del taller en el JTextField
            jTextField1.setText(seleccionado);

            try {
                // Establecer la conexión a la base de datos
                Class.forName(driver);
                cx = DriverManager.getConnection(url + bd, user, password);

                // Preparar la consulta para obtener el id_taller
                PreparedStatement consulta = cx.prepareStatement("SELECT id_taller, nombre FROM talleres WHERE nombre=? AND activo = TRUE");

                // Establecer el parámetro de la consulta
                consulta.setString(1, seleccionado);  // Usamos directamente el nombre seleccionado

                // Ejecutar la consulta
                var rs = consulta.executeQuery();

                // Verificar si el ResultSet tiene resultados
                if (rs.next()) {
                    // Obtener el id_taller desde el ResultSet
                    int idTaller = rs.getInt("id_taller");
                    String nombre = rs.getString("nombre");

                    // Establecer el id_taller en otro JTextField
                    jTextField1.setText(String.valueOf(idTaller));
                    jTextField4.setText(String.valueOf(nombre));

                    // Llamar a cargarGrupos() pasando el id del taller y el JComboBox2 para cargar los grupos
                    CargarAlumnos al = new CargarAlumnos(jComboBoxTalleres, jComboBoxGrupos,jComboBoxAlumnos, jTextField1.getText(),jTextField2.getText());
                    al.cargarGrupos(); // Pasar el id del taller

                } else {
                    // Si no se encuentra el taller, mostrar un mensaje
                    JOptionPane.showMessageDialog(null, "Taller no encontrado.");
                }

                // Cerrar los recursos
                rs.close();
                consulta.close();
                cx.close();

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si se selecciona "Taller" o si el valor es null, limpiar el JTextField
            jTextField1.setText("");
            // Limpiar el JComboBox de grupos y agregar solo "Grupos"
            jComboBoxGrupos.removeAllItems();
            jComboBoxGrupos.addItem("Grupos");
            jComboBoxAlumnos.removeAllItems();
            jComboBoxAlumnos.addItem("Matriculas");
            jTextNombre.setText("");
            jTextApellido.setText("");
        }
    }//GEN-LAST:event_jComboBoxTalleresActionPerformed

    private void jComboBoxGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxGruposActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) jComboBoxGrupos.getSelectedItem();

        // Verificar si el valor seleccionado no es "Taller"
        if (seleccionado != null && !seleccionado.equals("Grupos")) {
            // Establecer el nombre del taller en el JTextField
            jTextField2.setText(seleccionado);

            try {
                // Establecer la conexión a la base de datos
                Class.forName(driver);
                cx = DriverManager.getConnection(url + bd, user, password);

                // Preparar la consulta para obtener el id_taller
                PreparedStatement consulta = cx.prepareStatement("SELECT id_grupo, nombre FROM grupos WHERE nombre=? AND activo = TRUE");

                // Establecer el parámetro de la consulta
                consulta.setString(1, seleccionado);  // Usamos directamente el nombre seleccionado

                // Ejecutar la consulta
                var rs = consulta.executeQuery();

                // Verificar si el ResultSet tiene resultados
                if (rs.next()) {
                    // Obtener el id_taller desde el ResultSet
                    int idGrupo = rs.getInt("id_grupo");
                    String nombre = rs.getString("nombre");

                    // Establecer el id_taller en otro JTextField
                    // Si quieres mostrar el id_taller en otro JTextField
                    jTextField2.setText(String.valueOf(idGrupo));
                    jTextField5.setText(String.valueOf(nombre));
                    
                    // Llamar a cargarGrupos() pasando el id del taller y el JComboBox2 para cargar los grupos
                    CargarAlumnos al = new CargarAlumnos(jComboBoxTalleres, jComboBoxGrupos,jComboBoxAlumnos, jTextField1.getText(),jTextField2.getText());
                    al.CargarAlumnos(); // Pasar el id del taller

                } else {
                    // Si no se encuentra el taller, mostrar un mensaje
                    JOptionPane.showMessageDialog(null, "Taller no encontrado.");
                }

                // Cerrar los recursos
                rs.close();
                consulta.close();
                cx.close();

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si se selecciona "Taller" o si el valor es null, limpiar el JTextField
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jComboBoxGruposActionPerformed

    private void jComboBoxAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosActionPerformed
        // TODO add your handling code here:
        String seleccionado = (String) jComboBoxAlumnos.getSelectedItem();

        // Verificar si el valor seleccionado no es "Taller"
        if (seleccionado != null && !seleccionado.equals("Matriculas")) {
            // Establecer el nombre del taller en el JTextField
            jTextField3.setText(seleccionado);

            try {
                // Establecer la conexión a la base de datos
                Class.forName(driver);
                cx = DriverManager.getConnection(url + bd, user, password);

                // Preparar la consulta para obtener el id_taller
                PreparedStatement consulta = cx.prepareStatement("SELECT id_alumno, "
                        + "nombre, "
                        + "apellido, "
                        + "edad, tutor, "
                        + "contacto_tutor "
                        + "FROM alumnos WHERE matricula=? AND id_grupo=? AND activo = TRUE");

                // Establecer el parámetro de la consulta
                consulta.setString(1, seleccionado);  // Usamos directamente el nombre seleccionado
                consulta.setString(2, jTextField2.getText());
                
                // Ejecutar la consulta
                var rs = consulta.executeQuery();

                // Verificar si el ResultSet tiene resultados
                if (rs.next()) {
                    // Obtener el id_taller desde el ResultSet
                    int idAlumno = rs.getInt("id_alumno");
                    // Establecer el id_taller en otro JTextField
                    jTextField3.setText(String.valueOf(idAlumno));  
                    jTextNombre.setText(rs.getString("nombre"));
                    jTextApellido.setText(rs.getString("apellido"));
 
                } else {
                    // Si no se encuentra el taller, mostrar un mensaje
                    JOptionPane.showMessageDialog(null, "Taller no encontrado.");
                }

                // Cerrar los recursos
                rs.close();
                consulta.close();
                cx.close();

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println("No se conectó a la BD " + ex.getMessage());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // Si se selecciona "Taller" o si el valor es null, limpiar el JTextField
            jTextField3.setText("");
            jTextNombre.setText("");
            jTextApellido.setText("");
        }
    }//GEN-LAST:event_jComboBoxAlumnosActionPerformed

    private void jTextMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoKeyTyped
        // TODO add your handling code here:
        //Validamos que en el campo no se puedan ingresar letras.
        char c = evt.getKeyChar(); //llamamos al evento
            if (Character.isLetter(c)){ //comparamos si ingresamos una letra
                evt.consume(); //evitar que se capture la letra
                JOptionPane.showMessageDialog(null,"Solo puedes ingresar números en este campo",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextMontoKeyTyped

    private void jButtonReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReciboActionPerformed
        // TODO add your handling code here:
        // Validar que todos los campos estén completos antes de generar el PDF
        if (jTextMotivo.getText().isEmpty()||
            jTextMonto.getText().isEmpty()||
            jTextMonto.getText().isEmpty()||
            jTextMonto.getText().isEmpty()||
            jTextNombre.getText().isEmpty()||
            jTextApellido.getText().isEmpty()||
            jDateChooserFecha.getDate() == null||
            jComboBoxTalleres.getSelectedItem().toString().equals("Taller") ||
            jComboBoxGrupos.getSelectedItem().toString().equals("Grupos") ||
            jComboBoxAlumnos.getSelectedItem().toString().equals("Matriculas")) {
                     // Mostrar mensaje de advertencia si falta algún campo
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa todos los datos correspondientes"
                            + "\ny elige un taller, un grupo y la matrícula del alumno.");
                    jTextNombre.requestFocus();
                    return;
                } else{
        try {
             // Obtener el nombre de la persona que pagó y el motivo
            String nombrePersona = jTextNombre.getText();
            String motivo = jTextMotivo.getText();

            // Formatear el nombre del archivo con el formato requerido
            String nombreArchivo = "ReciboPago("+nombrePersona+ "_" +motivo+").pdf";
            
            // Definir la ruta de la carpeta de descargas (esto puede variar dependiendo del sistema operativo)
            String userHome = System.getProperty("user.home");
            String downloadPath = userHome + File.separator + "Downloads" + File.separator + nombreArchivo;
            
            // Crear documento PDF
            Document document = new Document();
            FileOutputStream fos = new FileOutputStream(downloadPath); // Ruta del archivo
            PdfWriter writer = PdfWriter.getInstance(document, fos); // Asociar PDFWriter

            document.open();  // Abrir el documento para escribir

            // Estilos
            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font etiquetaFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            Font valorFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            // Título
            Paragraph titulo = new Paragraph("Centro Cultural Green Nekk'", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(new Paragraph(" "));

            // Subtítulo
            Paragraph subtitulo = new Paragraph("RECIBO DE PAGO", subFont);
            subtitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(subtitulo);
            document.add(new Paragraph(" "));

            // Motivos
            Paragraph motivo2 = new Paragraph();
            motivo2.add(new Chunk("Motivo: ", etiquetaFont));
            motivo2.add(new Chunk(jTextMotivo.getText(), valorFont));
            document.add(motivo2);

            // Monto
            Paragraph monto = new Paragraph();
            monto.add(new Chunk("Monto: ", etiquetaFont));
            monto.add(new Chunk("$" + jTextMonto.getText(), valorFont));
            document.add(monto);

            // Fecha
            Paragraph fecha = new Paragraph();
            fecha.add(new Chunk("Fecha: ", etiquetaFont));
            fecha.add(new Chunk(new SimpleDateFormat("dd/MM/yyyy").format(jDateChooserFecha.getDate()), valorFont));
            document.add(fecha);

            document.add(new Paragraph(" ")); // Espacio

            // Datos del alumno
            Paragraph datos = new Paragraph("Datos del Alumno", subFont);
            datos.setAlignment(Element.ALIGN_LEFT);
            document.add(datos);

            Paragraph nombre = new Paragraph();
            nombre.add(new Chunk("Nombres: ", etiquetaFont));
            nombre.add(new Chunk(jTextNombre.getText(), valorFont));
            document.add(nombre);

            Paragraph apellido = new Paragraph();
            apellido.add(new Chunk("Apellidos: ", etiquetaFont));
            apellido.add(new Chunk(jTextApellido.getText(), valorFont));
            document.add(apellido);

            Paragraph taller = new Paragraph();
            taller.add(new Chunk("Taller: ", etiquetaFont));
            taller.add(new Chunk(jTextField4.getText(), valorFont));
            document.add(taller);

            Paragraph grupo = new Paragraph();
            grupo.add(new Chunk("Grupo: ", etiquetaFont));
            grupo.add(new Chunk(jTextField5.getText(), valorFont));
            document.add(grupo);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Gracias por su pago.", valorFont));

            document.close();

            JOptionPane.showMessageDialog(null, "PDF generado exitosamente en la carpeta de descargas.");

        // Verificar si el archivo existe antes de intentar abrirlo
        File archivoPDF = new File(downloadPath);
        if (archivoPDF.exists()) {
            // Abrir el archivo PDF generado
            java.awt.Desktop.getDesktop().open(archivoPDF);
        } else {
            JOptionPane.showMessageDialog(null, "El archivo no se ha generado correctamente.");
        }
        
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar o abrir el PDF: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonReciboActionPerformed

    private void jButtonReciboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReciboMouseEntered
        // TODO add your handling code here:
        jButtonRecibo.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonReciboMouseEntered

    private void jButtonReciboMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonReciboMouseExited
        // TODO add your handling code here:
        jButtonRecibo.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonReciboMouseExited

    private void jButtonHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistorialActionPerformed
        // TODO add your handling code here:
    // Atributos de conexión
    String bd = "workshopadmin";  // Nombre de la base de datos
    String url = "jdbc:mysql://localhost:3306/" + bd; // URL de conexión a MySQL
    String user = "root"; // Usuario de la base de datos
    String password = "sqloracle"; // Contraseña del usuario
    String driver = "com.mysql.cj.jdbc.Driver"; // Driver JDBC para MySQL

    // Objetos para conexión, consulta y resultados
    java.sql.Connection cx = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName(driver); // Cargar el driver JDBC
        cx = DriverManager.getConnection(url, user, password); // Establecer conexión a la base de datos

        // Consulta para obtener historial de pagos con nombres de grupo y taller
        String sql = "SELECT p.id_pago, " +
             "a.nombre AS nombre_alumno, a.apellido AS apellido_alumno, " +
             "p.monto, p.fecha_pago, p.motivo, " +
             "g.nombre AS nombre_grupo, t.nombre AS nombre_taller " +
             "FROM pagos p " +
             "JOIN alumnos a ON p.id_alumno = a.id_alumno " +
             "JOIN grupos g ON a.id_grupo = g.id_grupo " +
             "JOIN talleres t ON g.id_taller = t.id_taller " +
             "ORDER BY p.fecha_pago DESC";

        // Preparar la consulta con desplazamiento sin sensibilidad y solo lectura
        ps = cx.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = ps.executeQuery(); // Ejecutar la consulta

        // Ruta para guardar el PDF en la carpeta de descargas del usuario
        String userHome = System.getProperty("user.home");
        String downloadPath = userHome + "/Downloads/";
        String filePath = downloadPath + "HistorialPagos.pdf";

        // Crear documento PDF
        Document document = new Document(); 
        PdfWriter.getInstance(document, new FileOutputStream(filePath));  // Vincular PDF con archivo físico
        document.open(); // Abrir el documento para escribir
        
        // Formato de fecha y hora en español para la fecha de "Generado" con formato de 24 horas
        SimpleDateFormat sdfGenerado = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", new Locale("es", "ES"));
        String fechaGenerado = sdfGenerado.format(new java.util.Date());
        
        // Centrar el título
        Paragraph title = new Paragraph("Historial de Pagos", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(" ")); // Espacio en blanco
        document.add(new Paragraph("Generado: " + fechaGenerado)); // Fecha y hora de generación
        document.add(new Paragraph(" ")); // Espacio en blanco

        // Crear tabla con 6 columnas: Pagador, Monto, Fecha, Motivo, Grupo, Taller
        PdfPTable table = new PdfPTable(6); // 6 columnas: Pagador, Monto, Fecha, Motivo, Grupo, Taller
        table.setWidthPercentage(100);

        // Agregar encabezados de la tabla
        table.addCell("Pagador");
        table.addCell("Monto");
        table.addCell("Fecha");
        table.addCell("Motivo");
        table.addCell("Grupo");
        table.addCell("Taller");

        boolean hayResultados = false;

        // Formato de fecha en español para la fecha en la tabla
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("es", "ES"));

        // Recorrer los resultados de la consulta
        while (rs.next()) {
            hayResultados = true;

            // Obtener los datos de cada columna
            String pagador = rs.getString("nombre_alumno") + " " + rs.getString("apellido_alumno");
            String monto = "$" + String.format("%.2f", rs.getDouble("monto"));
            String fecha = sdf.format(rs.getDate("fecha_pago"));
            String motivo = rs.getString("motivo");
            String grupo = rs.getString("nombre_grupo");
            String taller = rs.getString("nombre_taller");

            // Agregar fila con los datos obtenidos
            table.addCell(pagador);
            table.addCell(monto);
            table.addCell(fecha);
            table.addCell(motivo);
            table.addCell(grupo);
            table.addCell(taller);
        }

         // Si no hay resultados, mostrar mensaje y salir
        if (!hayResultados) {
            JOptionPane.showMessageDialog(null, "No hay registros de pagos.");
            document.close(); // Cerrar el documento sin guardar tabla vacía
            return;
        }

        document.add(table); // Agregar la tabla al PDF
        document.close();  // Cerrar y guardar el documento
        JOptionPane.showMessageDialog(null, "PDF generado exitosamente en la carpeta de descargas.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al generar PDF: " + e.getMessage()); // Mostrar mensaje de error
    } finally {
        try {
            // Cerrar recursos si fueron abiertos
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (cx != null) cx.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_jButtonHistorialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPagosCursosLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPagosCursosLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPagosCursosLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPagosCursosLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPagosCursosLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonHistorial;
    private javax.swing.JButton jButtonRecibo;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonRegresarInicio;
    private javax.swing.JComboBox<String> jComboBoxAlumnos;
    private javax.swing.JComboBox<String> jComboBoxGrupos;
    private javax.swing.JComboBox<String> jComboBoxTalleres;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelnformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextMonto;
    private javax.swing.JTextField jTextMotivo;
    private javax.swing.JTextField jTextNombre;
    // End of variables declaration//GEN-END:variables
}
