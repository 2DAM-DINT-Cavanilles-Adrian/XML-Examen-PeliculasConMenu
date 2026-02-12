// Adrian Gimenez Muñoz - EXAMEN 11/02/2026

package xmlpeliculasconmenu_adrian;

import java.io.File;    
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;

public class VentanaCrear extends javax.swing.JFrame {
    
    // Aqui separo las listas para controlar que el limite sea de 3 por genero
    
    private java.util.List<Pelicula> listaMisterio = new java.util.ArrayList<>();
    private java.util.List<Pelicula> listaAventura = new java.util.ArrayList<>();
    private java.util.List<Pelicula> listaComedia = new java.util.ArrayList<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrear.class.getName());

    // A continuacion voy a crear 2 metodos para ayudarme con la gestion del ejercicio
    
    // Método para añadir el nodo de género y las 3 películas hijas.
    
    private void appendGenero(Document doc, Element root, String nombreGenero, java.util.List<Pelicula> lista) {
        Element nodoGenero = doc.createElement(nombreGenero);
        root.appendChild(nodoGenero);
        
        for (Pelicula p : lista) {
            Element nodoPelicula = doc.createElement("pelicula");
            
            // Título
            
            Element nodoTitulo = doc.createElement("titulo");
            nodoTitulo.setTextContent(p.getTitulo());
            nodoPelicula.appendChild(nodoTitulo);
            
            // Duración
            
            Element nodoDuracion = doc.createElement("duracion");
            nodoDuracion.setTextContent(String.valueOf(p.getDuracion()));
            nodoPelicula.appendChild(nodoDuracion);
            
            // Trailer
            
            Element nodoTrailer = doc.createElement("trailer");
            nodoTrailer.setTextContent(p.getUrlTrailer());
            nodoPelicula.appendChild(nodoTrailer);
            
            // Genero
            
            nodoGenero.appendChild(nodoPelicula);
        }
    }
    
    // Creo este metodo para mostrar el estado en todo momento de las listas.
    
    private void actualizarResumen() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- ESTADO DE LA COLECCIÓN DE PELICULAS ---\n");
        sb.append("Misterio: ").append(listaMisterio.size()).append("/3\n");
        for(Pelicula p : listaMisterio) sb.append(" - ").append(p.getTitulo()).append("\n");
        
        sb.append("\nAventura: ").append(listaAventura.size()).append("/3\n");
        for(Pelicula p : listaAventura) sb.append(" - ").append(p.getTitulo()).append("\n");
        
        sb.append("\nComedia: ").append(listaComedia.size()).append("/3\n");
        for(Pelicula p : listaComedia) sb.append(" - ").append(p.getTitulo()).append("\n");
        
        txtResumen.setText(sb.toString());
    }
    
    
    
    public VentanaCrear() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Gestor de Películas - " + this.getClass().getSimpleName());
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("foto.png")).getImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        comboGenero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtUrl = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResumen = new javax.swing.JTextArea();
        btnGenerar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel1.setText("Titulo");

        jLabel2.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel2.setText("Duración (min):");

        jLabel3.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel3.setText("Género:");

        txtTitulo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDuracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Misterio", "Aventura", "Comedia" }));
        comboGenero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jLabel4.setText("URL Tráiler");

        txtUrl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregar.setBackground(new java.awt.Color(215, 248, 215));
        btnAgregar.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar Película");
        btnAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(147, 182, 147), 2));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtResumen.setColumns(20);
        txtResumen.setRows(5);
        txtResumen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txtResumen);

        btnGenerar.setBackground(new java.awt.Color(204, 204, 255));
        btnGenerar.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        btnGenerar.setText("Generar XML");
        btnGenerar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(91, 91, 132), 2));
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Noto Serif", 1, 12)); // NOI18N
        jButton1.setText("Atras");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(62, 62, 62)
                                        .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(72, 72, 72)
                                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        // 1. Conseguir todos los datos que necesitamos
        
        String titulo = txtTitulo.getText().trim();
        String duracionStr = txtDuracion.getText().trim();
        String url = txtUrl.getText().trim();
        String genero = (String) comboGenero.getSelectedItem();

        // 2. Validaciones

        // Validar que el Titulo no este vacio
        
        if (titulo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El título no puede estar vacío.");
            return;
        }
        
        if (titulo.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "El título es obligatorio.", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            txtTitulo.requestFocus(); // Esto hace que el cursor vuelva al campo del error
            return;
        }

        // Validar Duración que sea un entero y que no este en negativo
        
        int duracion = 0;
        try {
            duracion = Integer.parseInt(duracionStr);
            if (duracion <= 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "La duración tiene que ser positiva.");
                return;
            }
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "La duración debe ser un número válido.");
            return;
        }

        // Validar la URL que empiece por http:// o https://)
        
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            javax.swing.JOptionPane.showMessageDialog(this, "La URL tiene que empezar por http:// o https://");
            return;
        }

        // 3. Controar limite por genero (en mi caso el maximo 3)
        
        java.util.List<Pelicula> listaActual = null;

        // Aqui se selecciona la lista correcta
        
        if (genero.equals("Misterio")) listaActual = listaMisterio;
        else if (genero.equals("Aventura")) listaActual = listaAventura;
        else if (genero.equals("Comedia")) listaActual = listaComedia;

        // Aqui se comprueba si esta llena
        
        if (listaActual.size() >= 3) {
            javax.swing.JOptionPane.showMessageDialog(this, "Ya has introducido 3 películas de " + genero + ".");
            return;
        }

        // 4. Agregar pelicula
        
        Pelicula p = new Pelicula(titulo, duracion, genero, url);
        listaActual.add(p);

        // Aqui se actualiza el area para que se pueda ver el registro añadido
        
        actualizarResumen();

        // Limpio todos los campos para la siguiente entrada
        
        txtTitulo.setText("");
        txtDuracion.setText("");
        txtUrl.setText("");
        txtTitulo.requestFocus();

        // 5. Verificar si se puede activar el boton que genera el XML
        
        // Solo si hay 3 en cada lista, en total 9
        
        if (listaMisterio.size() == 3 && listaAventura.size() == 3 && listaComedia.size() == 3) {
            btnGenerar.setEnabled(true);
            javax.swing.JOptionPane.showMessageDialog(this, "Lista completa. Ya puedes generar el archivo XML.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            
            // 1. Configuración del DOM
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Elemento raíz
            
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("peliculas");
            doc.appendChild(rootElement);

            // 2. Metodo para procesar las categorias
            
            // Llamo a una funcion para no tener que repetir el codigo 3 veces
            appendGenero(doc, rootElement, "misterio", listaMisterio); // [cite: 58]
            appendGenero(doc, rootElement, "aventura", listaAventura); // [cite: 66]
            appendGenero(doc, rootElement, "comedia", listaComedia);   // [cite: 69]

            // 3. Aqi transformo y guardo el archivo
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Esto es para que se vea bonito
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            File archivo = new File("peliculas.xml");
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(archivo);

            transformer.transform(source, result);

            javax.swing.JOptionPane.showMessageDialog(this, "XML generado correctamente en: " + archivo.getAbsolutePath());

            //Si hay algun error devuelve un Dialog avisado del error.
            
        } catch (Exception ex) {
            ex.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al generar XML: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            
        // Hago una validacion para asegurar que el usuario a guardado los cambios.
        
        if (!txtTitulo.getText().isEmpty()) {
            int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, 
                "Tienes datos sin guardar, ¿seguro que quieres salir?", 
                "Confirmar salida", 
                javax.swing.JOptionPane.YES_NO_OPTION);

            if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaCrear().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextArea txtResumen;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
