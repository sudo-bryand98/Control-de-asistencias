package registrodeasistenciav1;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public final class LogIn extends javax.swing.JFrame {

    public LogIn() {
        initComponents();
        this.setLocationRelativeTo(null);
        AUTO();
        AutoCompleteDecorator.decorate(cbx_auto);
    }

    void limpiar_campos() {
        pass_contraseña.setText("");
        cbx_auto.setSelectedIndex(0);
    }

    void acceso() {
        String usu = (cbx_auto.getSelectedItem().toString());
        String pas = new String(pass_contraseña.getPassword());
        try {
            String cap = "";
            String sta = "";
            preparedStatement = reg.prepareStatement("SELECT * FROM usuarios WHERE usuario=? &&  contrasenia=?");
            preparedStatement.setString(1, usu);
            preparedStatement.setString(2, pas);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cap = resultSet.getString("acceso");
            }

            if (cap.equals("DIRECTOR")) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "BIENVENIDO: "+usu+
                        "\n HAZ INICIADO SESION COMO : " + cap);
                MenuPrincipal ingreso = new MenuPrincipal();
                ingreso.setVisible(true);
            }

            if (cap.equals("COORDINADOR")) {
                this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "BIENVENIDO: "+usu+
                        "\n Haz iniciado sesion como" + cap);
                        MenuPrincipal ingreso = new MenuPrincipal();
                        ingreso.setVisible(true);
                            MenuPrincipal.menuu.setEnabled(false);
                            MenuPrincipal.itemreg.setEnabled(true);
                            MenuPrincipal.itemrep.setEnabled(true);
            }

            if (cap.equals("USUARIO_COMUN")) {
                this.setVisible(false);
                        JOptionPane.showMessageDialog(null, "BIENVENIDO: "+usu+
                        "\n Haz iniciado sesion como" + cap);
                        MenuPrincipal ingreso = new MenuPrincipal();
                        ingreso.setVisible(true);
                            MenuPrincipal.menuu.setEnabled(false);
                            MenuPrincipal.itemreg.setEnabled(true);
                            MenuPrincipal.itemrep.setEnabled(false);
            }

            if ((!cap.equals("DIRECTOR")) && (!cap.equals("COORDINADOR")) && (!cap.equals("USUARIO_COMUN"))) {
                JOptionPane.showMessageDialog(null, "Los datos ingresados son incorrectos intente nuevamente.", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                LogIn ver = new LogIn();
                ver.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }
    void AUTO(){
     String sql;
        sql = "SELECT usuario FROM usuarios";
                try {
                preparedStatement = reg.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {                     
                      cbx_auto.addItem(resultSet.getString("usuario"));                    
                }

            } catch (SQLException | HeadlessException ex) {
                System.out.println(ex);
            }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pass_contraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_aceptar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        cbx_auto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SISTEMA DE GESTIÓN DE ASISTENCIA-LogIn");
        setIconImage( new ImageIcon(getClass().getResource("/Img/employees.png")).getImage());
        setResizable(false);

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
                .addContainerGap(49, Short.MAX_VALUE))
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

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel4.setText("USUARIO:");

        pass_contraseña.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        pass_contraseña.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        pass_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pass_contraseñaActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel5.setText("CONTRASEÑA");

        btn_aceptar.setBackground(new java.awt.Color(153, 255, 153));
        btn_aceptar.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btn_aceptar.setText("INGRESAR");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        btn_aceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_aceptarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btn_aceptarKeyTyped(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 153, 153));
        btn_eliminar.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btn_eliminar.setText("CANCELAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btn_aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_eliminar))
                .addContainerGap())
        );

        cbx_auto.setBackground(new java.awt.Color(102, 153, 255));
        cbx_auto.setEditable(true);
        cbx_auto.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        cbx_auto.setForeground(new java.awt.Color(255, 255, 255));
        cbx_auto.setMaximumRowCount(100);
        cbx_auto.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pass_contraseña)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_auto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_auto, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(pass_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed

        if (pass_contraseña.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "¡LA SEGURIDAD ES PRIMERO!"
                    + "\nINGRESA TU CONTRASEÑA PARA ACCEDER AL SISTEMA.");
            pass_contraseña.requestFocus();
            return;
        }
        acceso();
    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void pass_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pass_contraseñaActionPerformed
       pass_contraseña.transferFocus();
    }//GEN-LAST:event_pass_contraseñaActionPerformed

    private void btn_aceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_aceptarKeyPressed
       
    }//GEN-LAST:event_btn_aceptarKeyPressed

    private void btn_aceptarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_aceptarKeyTyped
        char enter=evt.getKeyChar();
        if(enter==KeyEvent.VK_ENTER){
        btn_aceptar.doClick();
        }
    }//GEN-LAST:event_btn_aceptarKeyTyped

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JComboBox<String> cbx_auto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pass_contraseña;
    // End of variables declaration//GEN-END:variables
    
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    conexion con = new conexion();
    Connection reg = con.conexion();
}
