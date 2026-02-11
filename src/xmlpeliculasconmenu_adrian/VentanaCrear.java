// Adrian Gimenez Muñoz - EXAMEN 11/02/2026

package xmlpeliculasconmenu_adrian;

public class VentanaCrear extends javax.swing.JFrame {
    
    // Aqui separo las listas para controlar que el limite sea de 3 por genero
    
    private java.util.List<Pelicula> listaMisterio = new java.util.ArrayList<>();
    private java.util.List<Pelicula> listaAventura = new java.util.ArrayList<>();
    private java.util.List<Pelicula> listaComedia = new java.util.ArrayList<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCrear.class.getName());

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titulo");

        jLabel2.setText("Duración (min):");

        jLabel3.setText("Género:");

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Misterio", "Aventura", "Comedia" }));

        jLabel4.setText("URL Tráiler");

        btnAgregar.setText("Agregar Película");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtResumen.setColumns(20);
        txtResumen.setRows(5);
        jScrollPane1.setViewportView(txtResumen);

        btnGenerar.setText("Generar XML");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(60, 60, 60)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49)
                                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(32, 32, 32)
                                .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(btnAgregar)))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(490, 490, 490)
                        .addComponent(btnGenerar)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(btnAgregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnGenerar)
                .addContainerGap(21, Short.MAX_VALUE))
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
