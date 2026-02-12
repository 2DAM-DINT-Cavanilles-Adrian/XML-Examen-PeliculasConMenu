// Adrian Gimenez Muñoz - EXAMEN 11/02/2026

package xmlpeliculasconmenu_adrian;

public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());

    public MenuPrincipal() {
        initComponents();
        this.setTitle("Gestor de Películas - " + this.getClass().getSimpleName());
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("foto.png")).getImage());
        
        // Para que aparezca en el medio
        
        this.setLocationRelativeTo(null);
        
        // He añadido teclas para mejorar el funcionamiento de la app
        
        jMenu1.setMnemonic('F');    // Alt + F abre "Funcionalidades"
        menuCrear.setMnemonic('C'); // Una vez abierto el menú, 'C' abre Crear
        menuLeer.setMnemonic('L');  // 'L' abre Leer
        menuCrear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCrear = new javax.swing.JMenuItem();
        menuLeer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Noto Serif", 1, 18)); // NOI18N
        jLabel1.setText("Gestor de Peliculas XML");

        jLabel2.setFont(new java.awt.Font("Noto Serif", 0, 24)); // NOI18N
        jLabel2.setText("Bienvenido al:");

        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jMenu1.setText("Funcionalidades");

        menuCrear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuCrear.setText("Crear XML de Peliculas");
        menuCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCrearActionPerformed(evt);
            }
        });
        jMenu1.add(menuCrear);

        menuLeer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuLeer.setText("Leer XML y Mostrar Tráiler");
        menuLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLeerActionPerformed(evt);
            }
        });
        jMenu1.add(menuLeer);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCrearActionPerformed
        // Instanciamos la ventana de creación
        // Crearemos la clase VentanaCrear en el siguiente paso
        VentanaCrear vCrear = new VentanaCrear();
        vCrear.setVisible(true);
        // No cerramos el menú principal por si lo queremos utilizar para otra cosa
    }//GEN-LAST:event_menuCrearActionPerformed

    private void menuLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLeerActionPerformed
        // Esto lo hago para ver si el archivo existe o no
        java.io.File archivo = new java.io.File("peliculas.xml");
        
        if (archivo.exists()) {
            // Si existe, se abre la ventana
            VentanaLeer vLeer = new VentanaLeer(); // Crearemos la clase VentanaLeer
            vLeer.setVisible(true);
        } else {
            // Si no existe, sale un error y no se abre la ventana
            javax.swing.JOptionPane.showMessageDialog(this, 
                "El archivo .xml no existe. Tienes que generarlo primero.", 
                "Error de Archivo", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuLeerActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCrear;
    private javax.swing.JMenuItem menuLeer;
    // End of variables declaration//GEN-END:variables
}
