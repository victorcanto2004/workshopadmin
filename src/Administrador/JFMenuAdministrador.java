/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Administrador;

import Inicios.JFInicioAdministrador; // Importa la interfaz del inicio del administrador desde el paquete 'Inicios'.
import java.awt.Color; // Permite usar la clase Color para cambiar colores en componentes gráficos.
import java.awt.Image; // Permite manejar imágenes, por ejemplo, para íconos o imágenes en la interfaz.
import java.awt.Toolkit; // Proporciona acceso a recursos del sistema como imágenes, sonidos, etc.
import javax.swing.JFrame;
import javax.swing.JOptionPane; // Permite mostrar cuadros de diálogo (mensajes, confirmaciones, entradas de texto, etc.).

/**
 *
 * @author canto
 */
public class JFMenuAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form JFAdministrador
     */
    public JFMenuAdministrador() {
        initComponents(); // Método que configura y organiza todos los componentes gráficos en la ventana.
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Desactiva la X de cierre
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
        jButtonAlumnos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonTalleres = new javax.swing.JButton();
        jButtonPagos = new javax.swing.JButton();
        jButtonDonaciones = new javax.swing.JButton();
        jButtonDocentes = new javax.swing.JButton();
        jButtonGrupos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelnformacion = new javax.swing.JLabel();
        jButtonCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú del administrador");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAlumnos.setBackground(java.awt.Color.lightGray);
        jButtonAlumnos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Alumnos.png"))); // NOI18N
        jButtonAlumnos.setText("Alumnos");
        jButtonAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonAlumnosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonAlumnosMouseExited(evt);
            }
        });
        jButtonAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlumnosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Elige que quieres administrar");

        jButtonTalleres.setBackground(java.awt.Color.lightGray);
        jButtonTalleres.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonTalleres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Talleres.png"))); // NOI18N
        jButtonTalleres.setText("Talleres");
        jButtonTalleres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTalleresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonTalleresMouseExited(evt);
            }
        });
        jButtonTalleres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTalleresActionPerformed(evt);
            }
        });

        jButtonPagos.setBackground(java.awt.Color.lightGray);
        jButtonPagos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Pagos.png"))); // NOI18N
        jButtonPagos.setText("Pagos");
        jButtonPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonPagosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonPagosMouseExited(evt);
            }
        });
        jButtonPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagosActionPerformed(evt);
            }
        });

        jButtonDonaciones.setBackground(java.awt.Color.lightGray);
        jButtonDonaciones.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonDonaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Donaciones.png"))); // NOI18N
        jButtonDonaciones.setText("Donaciones");
        jButtonDonaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDonacionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDonacionesMouseExited(evt);
            }
        });
        jButtonDonaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDonacionesActionPerformed(evt);
            }
        });

        jButtonDocentes.setBackground(java.awt.Color.lightGray);
        jButtonDocentes.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonDocentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Docente2.png"))); // NOI18N
        jButtonDocentes.setText("Docentes");
        jButtonDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonDocentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonDocentesMouseExited(evt);
            }
        });
        jButtonDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDocentesActionPerformed(evt);
            }
        });

        jButtonGrupos.setBackground(java.awt.Color.lightGray);
        jButtonGrupos.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jButtonGrupos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Grupos.png"))); // NOI18N
        jButtonGrupos.setText("Grupos");
        jButtonGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonGruposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonGruposMouseExited(evt);
            }
        });
        jButtonGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGruposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonTalleres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPagos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDonaciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonGrupos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(117, 117, 117))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jButtonAlumnos)
                .addGap(18, 18, 18)
                .addComponent(jButtonDocentes)
                .addGap(18, 18, 18)
                .addComponent(jButtonTalleres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGrupos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPagos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDonaciones)
                .addGap(14, 14, 14))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("¡Menú del Administrador!");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Imagenes/Administrador.png"))); // NOI18N

        jLabelnformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/Informacion.png"))); // NOI18N
        jLabelnformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelnformacionMouseClicked(evt);
            }
        });

        jButtonCerrarSesion.setBackground(java.awt.Color.lightGray);
        jButtonCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workshopadmin/Iconos/CerrarSesion.png"))); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesión");
        jButtonCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonCerrarSesionMouseExited(evt);
            }
        });
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jButtonCerrarSesion)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelnformacion)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabelnformacion)))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCerrarSesion)
                        .addGap(31, 31, 31))))
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
    
    private void jButtonAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlumnosActionPerformed
        // TODO add your handling code here:
        JFAdministrarAlumnos JFAdministrarAlumnos =new JFAdministrarAlumnos(); // Crea una nueva instancia de la ventana  
                JFAdministrarAlumnos.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarAlumnos.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false);  // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonAlumnosActionPerformed

    private void jLabelnformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelnformacionMouseClicked
        // TODO add your handling code here:
        // Este método se ejecuta cuando el usuario hace clic en el label de información.
        JOptionPane.showMessageDialog(null,"Has click en lo que deseas administrar",
            "Información",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jLabelnformacionMouseClicked

    private void jButtonAlumnosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlumnosMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonAlumnos.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonAlumnosMouseEntered

    private void jButtonAlumnosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAlumnosMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonAlumnos.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonAlumnosMouseExited

    private void jButtonGruposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGruposMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonGrupos.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonGruposMouseEntered

    private void jButtonGruposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGruposMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonGrupos.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonGruposMouseExited

    private void jButtonDocentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDocentesMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonDocentes.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonDocentesMouseEntered

    private void jButtonDocentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDocentesMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonDocentes.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonDocentesMouseExited

    private void jButtonTalleresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTalleresMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonTalleres.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonTalleresMouseEntered

    private void jButtonTalleresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTalleresMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonTalleres.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonTalleresMouseExited

    private void jButtonPagosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPagosMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonPagos.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonPagosMouseEntered

    private void jButtonPagosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPagosMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonPagos.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonPagosMouseExited

    private void jButtonDonacionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDonacionesMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a verde cuando el mouse pasa por encima.
        jButtonDonaciones.setBackground(Color.GREEN);
    }//GEN-LAST:event_jButtonDonacionesMouseEntered

    private void jButtonDonacionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDonacionesMouseExited
        // TODO add your handling code here:
        // Restaura el fondo del botón a gris claro cuando el mouse sale.
        jButtonDonaciones.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonDonacionesMouseExited

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        // TODO add your handling code here:
        // Muestra un cuadro de diálogo de confirmación al usuario.
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere cerrar sesión??", 
                "Confirmar salida", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
        if (respuesta == JOptionPane.YES_OPTION) {
        // Aquí colocas la lógica para dar de alta al alumno
        JFInicioAdministrador JFInicioAdministrador =new JFInicioAdministrador();  // Crea una nueva instancia de la ventana
                JFInicioAdministrador.setVisible(true); // Muestra la ventana de inicio.
                JFInicioAdministrador.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false);  // Oculta la ventana actual.
        JOptionPane.showMessageDialog(null, "Sesión cerrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Operación cancelada");
        }
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void jButtonCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionMouseEntered
        // TODO add your handling code here:
        // Cambia el fondo del botón a rojo cuando el mouse pasa por encima.
        jButtonCerrarSesion.setBackground(Color.RED);
    }//GEN-LAST:event_jButtonCerrarSesionMouseEntered

    private void jButtonCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionMouseExited
        // TODO add your handling code here:
        jButtonCerrarSesion.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jButtonCerrarSesionMouseExited

    private void jButtonDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDocentesActionPerformed
        // TODO add your handling code here:
        JFAdministrarDocentes JFAdministrarDocentes =new JFAdministrarDocentes();  // Crea una nueva instancia de la ventana 
                JFAdministrarDocentes.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarDocentes.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false);  // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonDocentesActionPerformed

    private void jButtonTalleresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTalleresActionPerformed
        // TODO add your handling code here:
        JFAdministrarTalleres JFAdministrarTalleres =new JFAdministrarTalleres(); // Crea una nueva instancia de la ventana  
                JFAdministrarTalleres.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarTalleres.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false);  // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonTalleresActionPerformed

    private void jButtonGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGruposActionPerformed
        // TODO add your handling code here:
        JFAdministrarGrupos JFAdministrarGrupos =new JFAdministrarGrupos();   // Crea una nueva instancia de la ventana
                JFAdministrarGrupos.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarGrupos.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false); // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonGruposActionPerformed

    private void jButtonPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagosActionPerformed
        // TODO add your handling code here:
        JFAdministrarPagos JFAdministrarPagos =new JFAdministrarPagos();   // Crea una nueva instancia de la ventana
                JFAdministrarPagos.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarPagos.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false); // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonPagosActionPerformed

    private void jButtonDonacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDonacionesActionPerformed
        // TODO add your handling code here:
        JFAdministrarDonaciones JFAdministrarDonaciones =new JFAdministrarDonaciones();   // Crea una nueva instancia de la ventana
                JFAdministrarDonaciones.setVisible(true); // Muestra la ventana de inicio.
                JFAdministrarDonaciones.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                this.setVisible(false);  // Oculta la ventana actual.
    }//GEN-LAST:event_jButtonDonacionesActionPerformed

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
            java.util.logging.Logger.getLogger(JFMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMenuAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlumnos;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonDocentes;
    private javax.swing.JButton jButtonDonaciones;
    private javax.swing.JButton jButtonGrupos;
    private javax.swing.JButton jButtonPagos;
    private javax.swing.JButton jButtonTalleres;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelnformacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
