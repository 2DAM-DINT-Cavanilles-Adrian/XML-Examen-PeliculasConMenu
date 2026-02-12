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
        listaPeliculas.setModel(modeloLista);
        cargarDatosXML();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listaPeliculas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPeliculas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPeliculasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaPeliculas);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Género");

        lblGenero.setText(".");

        jLabel3.setText("Título");

        lblTitulo.setText(".");

        jLabel5.setText("Duración");

        lblDuracion.setText(".");

        btnTrailer.setText("Ver Tráiler");
        btnTrailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrailerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTrailer)
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
                .addComponent(btnTrailer)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            if (seleccionada != null) {
                lblTitulo.setText(seleccionada.getTitulo());
                lblGenero.setText(seleccionada.getGenero());
                lblDuracion.setText(seleccionada.getDuracion() + " min");
                this.urlActual = seleccionada.getUrlTrailer();
                }
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
