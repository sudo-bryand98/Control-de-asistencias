
package registrodeasistenciav1;

import javax.swing.ImageIcon;


public class MenuPrincipal extends javax.swing.JFrame {

    
    public MenuPrincipal() {
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        barra = new javax.swing.JMenuBar();
        menua = new javax.swing.JMenu();
        itemreg = new javax.swing.JMenuItem();
        itemrep = new javax.swing.JMenuItem();
        menuu = new javax.swing.JMenu();
        itemnu = new javax.swing.JMenuItem();
        itemge = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA DE GESTIÓN DE ASISTENCIA-Panel Administrativo");
        setIconImage( new ImageIcon(getClass().getResource("/Img/employees.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(240, 239, 239));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEMA DE CONTROL DE ASISTENCIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(905, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton2.setText("SALIR");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo_original.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(100, 100, 100)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        barra.setBackground(new java.awt.Color(51, 51, 255));
        barra.setBorder(null);
        barra.setForeground(new java.awt.Color(255, 153, 153));
        barra.setPreferredSize(new java.awt.Dimension(56, 26));

        menua.setBackground(new java.awt.Color(51, 51, 255));
        menua.setForeground(new java.awt.Color(255, 255, 255));
        menua.setText("Control de asistencias");
        menua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemreg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemreg.setBackground(new java.awt.Color(51, 51, 255));
        itemreg.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        itemreg.setForeground(new java.awt.Color(255, 255, 255));
        itemreg.setText("Registrar asistencia");
        itemreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemregActionPerformed(evt);
            }
        });
        menua.add(itemreg);

        itemrep.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itemrep.setBackground(new java.awt.Color(51, 51, 255));
        itemrep.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        itemrep.setForeground(new java.awt.Color(255, 255, 255));
        itemrep.setText("Reportes de asistencias");
        itemrep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemrepActionPerformed(evt);
            }
        });
        menua.add(itemrep);

        barra.add(menua);

        menuu.setBackground(new java.awt.Color(51, 51, 255));
        menuu.setForeground(new java.awt.Color(255, 255, 255));
        menuu.setText("Gestion de usuarios");
        menuu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemnu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        itemnu.setBackground(new java.awt.Color(51, 51, 255));
        itemnu.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        itemnu.setForeground(new java.awt.Color(255, 255, 255));
        itemnu.setText("Nuevo Usuario");
        itemnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemnuActionPerformed(evt);
            }
        });
        menuu.add(itemnu);

        itemge.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        itemge.setBackground(new java.awt.Color(51, 51, 255));
        itemge.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        itemge.setForeground(new java.awt.Color(255, 255, 255));
        itemge.setText("Actualizar, Eliminar y Editar Usuarios");
        itemge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemgeActionPerformed(evt);
            }
        });
        menuu.add(itemge);

        barra.add(menuu);

        jMenu1.setBackground(new java.awt.Color(51, 51, 255));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Ayuda");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem1.setBackground(new java.awt.Color(51, 51, 255));
        jMenuItem1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Acerca de");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        barra.add(jMenu1);

        setJMenuBar(barra);

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

    private void itemregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemregActionPerformed
        RegistrarAsistencia cambio = new RegistrarAsistencia();
        cambio.setVisible(true);
        
    }//GEN-LAST:event_itemregActionPerformed

    private void itemrepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemrepActionPerformed
        ReportedeAsistencias cambio = new ReportedeAsistencias();
        cambio.setVisible(true);
       
    }//GEN-LAST:event_itemrepActionPerformed

    private void itemnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemnuActionPerformed
        RegistrarUsuario cambio = new RegistrarUsuario();
        cambio.setVisible(true);
    }//GEN-LAST:event_itemnuActionPerformed

    private void itemgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemgeActionPerformed
        GestiondeUsuarios cambio = new GestiondeUsuarios();
        cambio.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_itemgeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LogIn ver = new LogIn();
        ver.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        AcercaDe ad = new AcercaDe();
        ad.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuBar barra;
    public static javax.swing.JMenuItem itemge;
    public static javax.swing.JMenuItem itemnu;
    public static javax.swing.JMenuItem itemreg;
    public static javax.swing.JMenuItem itemrep;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JMenu menua;
    public static javax.swing.JMenu menuu;
    // End of variables declaration//GEN-END:variables
}