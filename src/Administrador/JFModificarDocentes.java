/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrador;

import Clases.ConsultarDocente; // Importa la clase ConsultarDocentes
import Clases.TextPrompt; // Importa la clase TextPrompt para utilizar placeholders
import java.awt.Color; // Permite usar la clase Color para cambiar colores en componentes gráficos.
import java.awt.Image; // Permite manejar imágenes, por ejemplo, para íconos o imágenes en la interfaz.
import java.awt.Toolkit; // Proporciona acceso a recursos del sistema como imágenes, sonidos, etc.
import java.awt.event.KeyEvent; // Permite detectar y manejar eventos del teclado, como presionar, soltar o escribir una tecla.
import javax.swing.JFrame;
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).

/**
 *
 * @author canto
 */
public class JFModificarDocentes extends javax.swing.JFrame {

    /**
     * Creates new form JFModificarDocentes
     */
    public JFModificarDocentes() {
        initComponents();
  setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva la X de cierre
        TextPrompt nousuario = new TextPrompt("12345678",jTextNOUsuario); // Establece textos de sugerencia ("placeholders")
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTalleresGrupos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jLabelnformacion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextContacto = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextNombres = new javax.swing.JTextField();
        jTextApellidos = new javax.swing.JTextField();
        jTextEdad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextCampo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextNOUsuario = new javax.swing.JTextField();
        jTextContraseña = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTalleresGrupos1 = new javax.swing.JTable();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonRegresarInicio = new javax.swing.JButton();

        jTableTalleresGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTalleresGrupos);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actualizar datos de docentes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Actualiza datos de un docente");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Imagenes/Docente.png"))); // NOI18N

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

        jLabelnformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Informacion.png"))); // NOI18N
        jLabelnformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelnformacionMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Nombres");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Edad");

        jTextContacto.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jButtonActualizar.setBackground(java.awt.Color.lightGray);
        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Registrar.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseExited(evt);
            }
        });
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Contacto");

        jTextNombres.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombresKeyTyped(evt);
            }
        });

        jTextApellidos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidosKeyTyped(evt);
            }
        });

        jTextEdad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextEdadKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setText("Campo");

        jTextCampo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextCampo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCampoKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("No. Usuario");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel13.setText("Contraseña");

        jTextNOUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextNOUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNOUsuarioKeyPressed(evt);
            }
        });

        jTextContraseña.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jTableTalleresGrupos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableTalleresGrupos1);

        jButtonLimpiar.setBackground(java.awt.Color.lightGray);
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/limpiar.png"))); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonLimpiarMouseExited(evt);
            }
        });
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextNOUsuario))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextContraseña))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextNombres))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextCampo)))))
                    .addComponent(jButtonActualizar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonLimpiar)
                            .addComponent(jLabel8))
                        .addGap(7, 7, 7)
                        .addComponent(jTextContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextNOUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButtonActualizar)
                .addGap(54, 54, 54)
                .addComponent(jButtonLimpiar)
                .addGap(26, 26, 26))
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonRegresarInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelnformacion)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabelnformacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonRegresar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRegresarInicio)
                        .addGap(51, 51, 51))))
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
         // Para regresar al menu
        JFAdministrarDocentes JFAdministrarDocentes =new JFAdministrarDocentes();
        JFAdministrarDocentes.setVisible(true);
        JFAdministrarDocentes.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jLabelnformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelnformacionMouseClicked
        // TODO add your handling code here:
        // Este método se ejecuta cuando el usuario hace clic en el label de información.
        JOptionPane.showMessageDialog(null,"Utiliza esta ventana para modificar la información de un deocente existente.\n" +
                    "Selecciona el deocente que deseas actualizar, escribiendo su número de usuario y dando click en enter para cargar su información.\n" +
                    "Revisa y edita los campos necesarios. Verifica que los datos sean correctos.\n" +
                    "Haz clic en Actualizar para guardar los cambios.",
            "Información",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelnformacionMouseClicked

    private void jButtonActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonActualizar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonActualizarMouseEntered

    private void jButtonActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseExited
        // TODO add your handling code here:
         // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonActualizar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonActualizarMouseExited

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "Realmente desea actualizar la informacion de este docente?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.NO_OPTION) {
            // Si el usuario elige "No", simplemente no hace nada o muestra otro mensaje
            JOptionPane.showMessageDialog(null, "Operación cancelada.");
        }else {
            // Validación: Verifica si algún campo obligatorio está vacío
            if (jTextNOUsuario.getText().trim().isEmpty()||
                    jTextContraseña.getText().trim().isEmpty()||
                    jTextNombres.getText().trim().isEmpty()||
                    jTextApellidos.getText().trim().isEmpty()||
                    jTextEdad.getText().trim().isEmpty()||
                    jTextCampo.getText().trim().isEmpty()||
                    jTextContacto.getText().trim().isEmpty()){ 
            
            JOptionPane.showMessageDialog(null,"Por favor, completa todos los campos correctamente",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
            } else {
            ConsultarDocente cd = new ConsultarDocente();
            cd.Modificar(jTextNOUsuario, jTextContraseña, jTextNombres, jTextApellidos, jTextEdad, jTextContacto, jTextCampo);
            jTextNOUsuario.setText("");
            jTextContraseña.setText("");
            jTextNombres.setText("");
            jTextApellidos.setText("");
            jTextEdad.setText("");
            jTextCampo.setText("");
            jTextContacto.setText("");
            jTextNOUsuario.setEditable(true);
            jTextContraseña.setEditable(true);
            jTextNOUsuario.requestFocus();
            }
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

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
        // Para regresar al inicio
        JFMenuAdministrador JFMenuAdministrador =new JFMenuAdministrador();
        JFMenuAdministrador.setVisible(true);
        JFMenuAdministrador.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(false);
    }//GEN-LAST:event_jButtonRegresarInicioActionPerformed

    private void jTextNOUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNOUsuarioKeyPressed
        // TODO add your handling code here:
        // Para cargar información del alumno
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            // Validación: Verifica si algún campo obligatorio está vacío 
            if (jTextNOUsuario.getText().trim().isEmpty()){ 
            
            JOptionPane.showMessageDialog(null,"Por favor, escribe un número de usuario",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                ConsultarDocente cd = new ConsultarDocente();
                cd.Consultar(jTextNOUsuario, jTextContraseña, jTextNombres, jTextApellidos, jTextEdad, jTextContacto, jTextCampo, jTableTalleresGrupos);

                jTextNOUsuario.setEditable(false); // Desabilita la edición de este campo
                jTextContraseña.setEditable(false);
                }
            }
    }//GEN-LAST:event_jTextNOUsuarioKeyPressed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
            // TODO add your handling code here:
            // Limpiar los campos
            jTextNOUsuario.setText("");
            jTextContraseña.setText("");
            jTextNombres.setText("");
            jTextApellidos.setText("");
            jTextEdad.setText("");
            jTextCampo.setText("");
            jTextContacto.setText("");
            jTextNOUsuario.setEditable(true);
            jTextContraseña.setEditable(true);
            jTextNOUsuario.requestFocus();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLimpiarMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonLimpiar.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonLimpiarMouseEntered

    private void jButtonLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLimpiarMouseExited
        // TODO add your handling code here:
         // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonLimpiar.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonLimpiarMouseExited

    private void jTextEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextEdadKeyTyped
        // TODO add your handling code here:
        //Validamos que en el campo no se puedan ingresar letras.
        char c = evt.getKeyChar(); //llamamos al evento
            if (Character.isLetter(c)){ //comparamos si ingresamos una letra
                evt.consume(); //evitar que se capture la letra
                JOptionPane.showMessageDialog(null,"Solo puedes ingresar números en este campo",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTextEdadKeyTyped

    private void jTextNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombresKeyTyped
        // TODO add your handling code here:
            //Validamos que en el campo no se puedan ingresar números.
            char c = evt.getKeyChar(); //llamamos al evento
            if (Character.isDigit(c)){ //comparamos si ingresamos un digito
                evt.consume(); //evitar que se capture el digito
                JOptionPane.showMessageDialog(null,"No puedes ingresar números en este campo",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jTextNombresKeyTyped

    private void jTextApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidosKeyTyped
        // TODO add your handling code here:
            //Validamos que en el campo no se puedan ingresar números.
            char c = evt.getKeyChar(); //llamamos al evento
            if (Character.isDigit(c)){ //comparamos si ingresamos un digito
                evt.consume(); //evitar que se capture el digito
                JOptionPane.showMessageDialog(null,"No puedes ingresar números en este campo",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jTextApellidosKeyTyped

    private void jTextCampoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCampoKeyTyped
        // TODO add your handling code here:
            //Validamos que en el campo no se puedan ingresar números.
            char c = evt.getKeyChar(); //llamamos al evento
            if (Character.isDigit(c)){ //comparamos si ingresamos un digito
                evt.consume(); //evitar que se capture el digito
                JOptionPane.showMessageDialog(null,"No puedes ingresar números en este campo",
                        "ADVERTENCIA",
                        JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_jTextCampoKeyTyped

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
            java.util.logging.Logger.getLogger(JFModificarDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFModificarDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFModificarDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFModificarDocentes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFModificarDocentes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonRegresarInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelnformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTalleresGrupos;
    private javax.swing.JTable jTableTalleresGrupos1;
    private javax.swing.JTextField jTextApellidos;
    private javax.swing.JTextField jTextCampo;
    private javax.swing.JTextField jTextContacto;
    private javax.swing.JTextField jTextContraseña;
    private javax.swing.JTextField jTextEdad;
    private javax.swing.JTextField jTextNOUsuario;
    private javax.swing.JTextField jTextNombres;
    // End of variables declaration//GEN-END:variables
}
