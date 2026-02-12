// Adrian Gimenez Muñoz - EXAMEN 11/02/2026

package xmlpeliculasconmenu_adrian;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Este archivo se encargara de parsear el archivo XML y de mostrar la informacion de la pelicula

public class VentanaLeer extends javax.swing.JFrame {
    
    private javax.swing.DefaultListModel modeloLista = new javax.swing.DefaultListModel(); 
    private String urlActual = "";
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaLeer.class.getName());

    // Aqui con DOM extreaemos los datos del archivo peliculas.xml
    
    private void cargarDatosXML() {
        try {
            File archivo = new File("peliculas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);
            doc.getDocumentElement().normalize();

            // Por aqui pasan los 3 generos que hemos creado
            
            String[] generos = {"misterio", "aventura", "comedia"};
            
            // Utilizamos un doble bucle para tener el genero y luego la pelicula en si
            
            for (String generoTag : generos) {
                NodeList nList = doc.getElementsByTagName(generoTag);
                
                // Aqui se entra al tipo de genero
                
                if (nList.getLength() > 0) {
                    Element elementoGenero = (Element) nList.item(0);
                    NodeList listaPelis = elementoGenero.getElementsByTagName("pelicula");
                    
                    for (int i = 0; i < listaPelis.getLength(); i++) {
                        Element elementoPeli = (Element) listaPelis.item(i);
                        
                        String titulo = elementoPeli.getElementsByTagName("titulo").item(0).getTextContent();
                        String duracionStr = elementoPeli.getElementsByTagName("duracion").item(0).getTextContent();
                        String url = elementoPeli.getElementsByTagName("trailer").item(0).getTextContent();
                        
                        // Guardamos la clase Pelicula en la lista visual
                        // Y reutilizamos la clase Pelicula que habiamos creado al principio
                        Pelicula p = new Pelicula(titulo, Integer.parseInt(duracionStr), generoTag, url);
                        modeloLista.addElement(p);
                    }
                }
            }
        } catch (Exception e) {
            
            // Aqui se checkea si el archivo no esta corrupto o si no existe
            
            System.err.println("Error al cargar XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public VentanaLeer() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Gestor de Películas - " + this.getClass().getSimpleName());
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("foto.png")).getImage());
        listaPeliculas.setModel(modeloLista);
        cargarDatosXML();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPeliculas = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblGenero = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDuracion = new javax.swing.JLabel();
        btnTrailer = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jButton1.setText("Atras");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaPeliculas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listaPeliculas.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        listaPeliculas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPeliculasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPeliculas);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel1.setText("Género:");

        lblGenero.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        lblGenero.setText(".");

        jLabel3.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel3.setText("Título:");

        lblTitulo.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        lblTitulo.setText(".");

        jLabel5.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel5.setText("Duración:");

        lblDuracion.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        lblDuracion.setText(".");

        btnTrailer.setBackground(new java.awt.Color(204, 255, 204));
        btnTrailer.setFont(new java.awt.Font("Noto Serif", 1, 10)); // NOI18N
        btnTrailer.setText("Ver Tráiler");
        btnTrailer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 151, 102), 2));
        btnTrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrailerActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(255, 204, 204));
        btnVolver.setFont(new java.awt.Font("Noto Serif", 1, 10)); // NOI18N
        btnVolver.setText("Atras");
        btnVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(lblDuracion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 44, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblGenero))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblDuracion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrailer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Evento que sirve para actualizar los JLabels de la Lista
    
    private void listaPeliculasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPeliculasValueChanged
        if (!evt.getValueIsAdjusting()) {
            Object temporal = listaPeliculas.getSelectedValue();
            if (temporal instanceof Pelicula) {
                Pelicula seleccionada = (Pelicula) temporal;
                lblTitulo.setText(seleccionada.getTitulo());
                lblGenero.setText(seleccionada.getGenero().toUpperCase());
                lblDuracion.setText(seleccionada.getDuracion() + " minutos");
                this.urlActual = seleccionada.getUrlTrailer();
            }
        }
    }//GEN-LAST:event_listaPeliculasValueChanged

    // Boton que al pulsarlo con lleva al navegador 
    
    private void btnTrailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrailerActionPerformed
        // TODO add your handling code here:
            if (urlActual == null || urlActual.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una película primero.");
            return;
        }

        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(urlActual)); // 
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo abrir el navegador: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnTrailerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // No se por que se ha creado este boton, no lo puedo eliminar
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed


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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaLeer().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTrailer;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<String> listaPeliculas;
    // End of variables declaration//GEN-END:variables
}
