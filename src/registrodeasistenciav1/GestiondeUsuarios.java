
package registrodeasistenciav1;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class GestiondeUsuarios extends javax.swing.JFrame {

   
    public GestiondeUsuarios() {
        initComponents();
        llenartabla("");
        this.setExtendedState(MAXIMIZED_BOTH);
        listarcombo();
        AutoCompleteDecorator.decorate(cbx_acceso);
        id.setVisible(false);
    }
  
   void llenartabla(String valor){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("EDAD");
        modelo.addColumn("SEXO");
        modelo.addColumn("CARGO");
        modelo.addColumn("AREA");
        modelo.addColumn("USUARIO");
        modelo.addColumn("CONTRASEÑA");
        modelo.addColumn("SUELDO X HORA");
        modelo.addColumn("ACCESO");
        

       tabla_usuarios.setModel(modelo);
        String sql = "";       
        if (valor.equals("")) {
            sql = "SELECT * FROM  usuarios where id_usuario !=1";
        } else {
            
            sql = "SELECT * FROM usuarios WHERE nombre LIKE '%"+valor+"%'";
        }

        String[] datos = new String[10];
        try {
            Statement st = reg.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                modelo.addRow(datos);
            }
            tabla_usuarios.setModel(modelo);

        } catch (SQLException ex) {
            Logger.getLogger(GestiondeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void limpiarcampos(){
    txt_area.setText("");
    txt_cargo.setText("");
    txt_contrasenia.setText("");
    txt_edad1.setText("");
    txt_sueldo.setText("");
    txt_usuario.setText("");
    cbx_sexo.setSelectedIndex(0);
    txt_nombre.setText("");
    txt_sueldo.setText("");
    cbx_acceso.setSelectedIndex(0);
    }
    void listarcombo(){
         cbx_acceso.addItem("SELECCIONE UNO");
         cbx_acceso.addItem("DIRECTOR");
         cbx_acceso.addItem("COORDINADOR");
         cbx_acceso.addItem("USUARIO_COMUN");
    }
    void gestionar(){
    try {
             String ssql = "UPDATE usuarios SET nombre=?,edad=?,sexo=?,cargo=?,area=?,usuario=?,contrasenia=?,sueldo=?,acceso=? WHERE id_usuario=?"; 
            preparedStatement = reg.prepareStatement(ssql);
            preparedStatement.setString(1, txt_nombre.getText());
            preparedStatement.setString(2, txt_edad1.getText());
            preparedStatement.setString(3, cbx_sexo.getSelectedItem().toString());
            preparedStatement.setString(4, txt_cargo.getText());
            preparedStatement.setString(5, txt_area.getText());
            preparedStatement.setString(6, txt_usuario.getText());
            preparedStatement.setString(7, txt_contrasenia.getText());
            preparedStatement.setString(8, txt_sueldo.getText());
            preparedStatement.setString(9, cbx_acceso.getSelectedItem().toString());
            preparedStatement.setInt(10, Integer.parseInt(id.getText()));
            int res = preparedStatement.executeUpdate();
            llenartabla("");
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
                btn_actualizar.setEnabled(false);
                btn_eliminar.setEnabled(false);
                btn_actualizar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar al usuario");

            }

        } catch (SQLException | NumberFormatException | HeadlessException ex) {
            System.out.println(ex);
        }
        limpiarcampos();
    }
    void eliminar(){
    try {
         
            preparedStatement = reg.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?");
            preparedStatement.setInt(1, Integer.parseInt(id.getText()));
            int res = preparedStatement.executeUpdate();
            llenartabla("");
            limpiarcampos();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Eliminado");
                btn_actualizar.setEnabled(true);
                btn_actualizar.setEnabled(false);
                btn_eliminar.setEnabled(false);                
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
            connection.close();
        } catch (SQLException | NumberFormatException | HeadlessException ex) {
            System.out.println(ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbx_sexo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_sueldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_area = new javax.swing.JTextField();
        txt_usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_contrasenia = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        cbx_acceso = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_edad1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage( new ImageIcon(getClass().getResource("/Img/employees.png")).getImage());

        jPanel1.setBackground(new java.awt.Color(240, 239, 239));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("GESTION DE USUARIOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)), "EN ESTA ZONA SE MUESTRAN LOS DATOS DE LA BUSQUEDA"));

        txt_nombre.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_nombre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel7.setText("NOMBRE:");

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel5.setText("EDAD:");

        cbx_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE UNO", "HOMBRE", "MUJER" }));

        jLabel10.setBackground(new java.awt.Color(0, 153, 153));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel10.setText("SEXO:");

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel8.setText("CARGO:");

        txt_sueldo.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_sueldo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_sueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sueldoKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel4.setText("AREA:");

        txt_area.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_area.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txt_usuario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_usuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel6.setText("USUARIO:");

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel9.setText("CONTRASEÑA:");

        txt_contrasenia.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_contrasenia.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        btn_actualizar.setBackground(new java.awt.Color(153, 255, 153));
        btn_actualizar.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btn_actualizar.setText("ACTUALIZAR");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(255, 153, 153));
        btn_eliminar.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_limpiar.setBackground(new java.awt.Color(204, 255, 255));
        btn_limpiar.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        btn_limpiar.setText("LIMPIAR CAMPOS");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        cbx_acceso.setEditable(true);

        jLabel12.setBackground(new java.awt.Color(0, 153, 153));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel12.setText("NIVEL DE ACCESO:");

        txt_cargo.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_cargo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        id.setEditable(false);
        id.setFocusable(false);

        jLabel13.setBackground(new java.awt.Color(0, 153, 153));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel13.setText("SUELDO X HORA:");

        txt_edad1.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_edad1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_edad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_edad1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_edad1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombre))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_area))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_usuario))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cargo)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(btn_actualizar))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbx_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_contrasenia))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10)
                        .addComponent(txt_edad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_sexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_cargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_sueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbx_acceso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)), "PARA PODER ELIMINAR O ACTUALIZAR ALGUN REGISTRO DE LOS USUARIOS ES NECESARIO  RELLENAR EL CAMPO CON EL NOMBRE Y PRESIONAR EL BOTON DE \"BUSCAR\""));

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        jLabel11.setText("BUSCAR A:");

        txt_busqueda.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        txt_busqueda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        txt_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busquedaActionPerformed(evt);
            }
        });
        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 255, 255));
        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        jButton4.setText("BUSCAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(565, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jLabel11)
                    .addComponent(txt_busqueda))
                .addGap(23, 23, 23))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)), "SELECCIONE EN LA TABLA  EL REGISTRO QUE QUIERA ELIMINAR O ACTUALIZAR"));

        tabla_usuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_usuarios.setBackground(new java.awt.Color(204, 255, 255));
        tabla_usuarios.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_usuarios.setRowHeight(30);
        tabla_usuarios.setSelectionBackground(new java.awt.Color(102, 153, 255));
        tabla_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_usuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_usuarios);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if (txt_nombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_nombre.requestFocus();
            return;
        } 
     if (txt_edad1.getText().length() == 0 || txt_edad1.getText().length() > 2) {
            JOptionPane.showMessageDialog(null, "LLENE CORRECTAMRENTE EL CAMPO DE EDAD");                    
            txt_edad1.requestFocus();
            return;
        }
     
     if (cbx_sexo.getSelectedItem().toString().equals("SELECCIONE UNO")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION\n PARA CONTINUAR CON EL REGISTRO");                   
            cbx_sexo.requestFocus();
            return;
        }
     
     if (txt_cargo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_cargo.requestFocus();
            return;
        }
      if (txt_area.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_area.requestFocus();
            return;
        }
      
     if (txt_usuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_usuario.requestFocus();
            return;
        }
    
     
     if (txt_contrasenia.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_contrasenia.requestFocus();
            return;
        }
     
     if (txt_sueldo.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS PARA CONTINUAR CON EL REGISTRO");                    
            txt_sueldo.requestFocus();
            return;
        }
     
     
     if (cbx_acceso.getSelectedItem().toString().equals("SELECCIONE UNO")) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA OPCION\n PARA CONTINUAR CON EL REGISTRO");                    
            cbx_acceso.requestFocus();
            return;
        }
        gestionar();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarcampos();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busquedaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        llenartabla(txt_busqueda.getText());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void tabla_usuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_usuariosMouseClicked
        int rec = this.tabla_usuarios.getSelectedRow();
        this.id.setText(tabla_usuarios.getValueAt(rec, 0).toString());
        this.txt_nombre.setText(tabla_usuarios.getValueAt(rec, 1).toString());
        this.txt_edad1.setText(tabla_usuarios.getValueAt(rec, 2).toString());
        this.cbx_sexo.setSelectedItem(tabla_usuarios.getValueAt(rec, 3).toString());
        this.txt_cargo.setText(tabla_usuarios.getValueAt(rec, 4).toString());
        this.txt_area.setText(tabla_usuarios.getValueAt(rec, 5).toString());
        this.txt_usuario.setText(tabla_usuarios.getValueAt(rec, 6).toString());
        this.txt_contrasenia.setText(tabla_usuarios.getValueAt(rec, 7).toString());
        this.txt_sueldo.setText(tabla_usuarios.getValueAt(rec, 8).toString());
        this.cbx_acceso.setSelectedItem(tabla_usuarios.getValueAt(rec, 9).toString());
        
    }//GEN-LAST:event_tabla_usuariosMouseClicked

    private void txt_sueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sueldoKeyTyped
        char validar=evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "ESTE CAMPO SOLO ACEPTA NUMEROS DEL 1 AL 99");
            txt_sueldo.setText("");
        }
    }//GEN-LAST:event_txt_sueldoKeyTyped

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        
        eliminar();
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
        llenartabla(txt_busqueda.getText());
    }//GEN-LAST:event_txt_busquedaKeyReleased

    private void txt_edad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edad1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_edad1KeyTyped

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
            java.util.logging.Logger.getLogger(GestiondeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestiondeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestiondeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestiondeUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestiondeUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JComboBox<String> cbx_acceso;
    private javax.swing.JComboBox<String> cbx_sexo;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JTextField txt_area;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_cargo;
    private javax.swing.JTextField txt_contrasenia;
    private javax.swing.JTextField txt_edad1;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_sueldo;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    conexion con=new conexion();
    Connection reg=con.conexion();
}
