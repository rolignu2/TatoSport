

package tatosport;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmUsuario extends javax.swing.JFrame {

    private Conexion conn;
    
    private DefaultTableModel modelo_tabla;
    private Map mapeo;
    private String codigo_usuario = null;
    private String password_usuario=null;
    private String nombre_usuario=null;
    
    public FrmUsuario() {
        this.mapeo = new HashMap();
        this.modelo_tabla = new javax.swing.table.DefaultTableModel(null,
                new String [] {
                    "Codigo", "Usuario", "Nombres", "Dui"
                });
        
        initComponents();
        this.CargandoUsuarios();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        opactivo = new javax.swing.JRadioButton();
        optnoactivo = new javax.swing.JRadioButton();
        comboprivilegios = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtpassword2 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        cmdeliminar = new javax.swing.JButton();
        cmdguardar = new javax.swing.JButton();
        cmdperfil = new javax.swing.JButton();
        lblperfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Administracion de Usuarios ");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablausuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablausuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablausuarios);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        opactivo.setText("Usuario Activo");
        opactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opactivoActionPerformed(evt);
            }
        });

        optnoactivo.setText("Usuario No Activo");
        optnoactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optnoactivoActionPerformed(evt);
            }
        });

        comboprivilegios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario Normal", "Usuario Administrativo" }));

        jLabel2.setText("Privilegios administrativos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(optnoactivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(opactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(comboprivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboprivilegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(opactivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(optnoactivo)
                .addGap(16, 16, 16))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtpassword.setText("jPasswordField1");

        jLabel3.setText("Cambiar Contraseña");

        txtpassword2.setText("jPasswordField1");

        jLabel4.setText("Repetir Contraseña");

        cmdeliminar.setText("Eliminar Usuario");
        cmdeliminar.setActionCommand("Eliminar ");
        cmdeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdeliminarActionPerformed(evt);
            }
        });

        cmdguardar.setText("Guardar Cambios");
        cmdguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdguardarActionPerformed(evt);
            }
        });

        cmdperfil.setText("Anidar Perfil Empleado");
        cmdperfil.setActionCommand("Eliminar ");
        cmdperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdperfilActionPerformed(evt);
            }
        });

        lblperfil.setText("...");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmdguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(cmdeliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdperfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblperfil)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblperfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmdperfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdeliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdguardar)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opactivoActionPerformed
       CambioOpcioneActivo(0);
    }//GEN-LAST:event_opactivoActionPerformed

    private void optnoactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optnoactivoActionPerformed
       CambioOpcioneActivo(1);
    }//GEN-LAST:event_optnoactivoActionPerformed

    private void tablausuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablausuariosMouseClicked
       int R = this.tablausuarios.getSelectedRow();
       CargarInformacionUsuario(R);
    }//GEN-LAST:event_tablausuariosMouseClicked

    private void cmdguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdguardarActionPerformed
       this.GuardarDatosAlterados();
    }//GEN-LAST:event_cmdguardarActionPerformed

    private void cmdperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdperfilActionPerformed
        FrmAnidarEmpleado emp = new FrmAnidarEmpleado();
        emp.setVisible(true);
        FrmAnidarEmpleado.Id_anidado = this.codigo_usuario;
        FrmAnidarEmpleado.nombre_anidado = this.nombre_usuario;
    }//GEN-LAST:event_cmdperfilActionPerformed

    private void cmdeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdeliminarActionPerformed
        try {
            
            int diag = JOptionPane.showConfirmDialog(this, "¿Desea eliminar al usuario " 
                    + this.nombre_usuario  + "?" , "Confirmar Salida" ,JOptionPane.YES_NO_OPTION);
            if(diag >=1) return;
           
            conn = new Conexion();
            String Sql = "DELETE FROM login WHERE id_login LIKE " + this.codigo_usuario + "";
            boolean ok = conn.Get_Consulta_update(Sql);
            if(ok)
            {
                JOptionPane.showMessageDialog(this, "El usuario ha sido eliminado con exito",
                            "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
                CargandoUsuarios();
            }
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmdeliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmUsuario().setVisible(true);
            }
        });
    }
    
    private void GuardarDatosAlterados()
    {
        try {
            //verificamos si se altero password
            String PassTxt = this.txtpassword.getText();
            boolean PassOk = false;
            if(!this.password_usuario.equals(PassTxt))
            {
                String PassTxt2 = this.txtpassword2.getText();
                if(PassTxt != PassTxt2)
                {
                    JOptionPane.showMessageDialog(this, "Parece que las contraseñas no son iguales",
                            "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                else
                    PassOk = true;
            }
            if(PassOk == false)
                PassTxt = this.password_usuario.toString();
            
            int priv = this.comboprivilegios.getSelectedIndex();
            int estado = 0;
            
            if(this.opactivo.isSelected())
                estado =1;
            else
                estado =0;
            
            Conexion conn = new Conexion();
            
            String sql = "UPDATE login "
                    + "SET login.password='" + PassTxt 
                    + "', login.privilegios=" + priv + ", login.activo=" 
                    + estado + " WHERE login.id_login LIKE " + this.codigo_usuario + "";
            
            boolean isok = conn.Get_Consulta_update(sql);
            if(isok)
            {
                 JOptionPane.showMessageDialog(this, "Usuario se ha logrado alterar con exito.",
                            "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "Existe un error al momento de hacer la peticion",
                            "Ops!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void CargarInformacionUsuario(int row)
    {
        try{
            String codigo = this.tablausuarios.getValueAt(row, 0).toString();
            String Nombres = null;
           
            try{
                this.nombre_usuario = this.tablausuarios.getValueAt(row, 1).toString();
                Nombres = this.tablausuarios.getValueAt(row, 2).toString();
            }catch(Exception ex){}
            
            if(Nombres == "" || Nombres == null)
            {
                this.lblperfil.setText("Este usuario no tiene perfil de empleado, favor anidar  o crear perfil ");
                this.cmdperfil.setEnabled(true);
            }
            else
            {
                this.lblperfil.setText("Usuario anidado con el empleado " + Nombres);
                this.cmdperfil.setEnabled(false);
            }
            
            this.codigo_usuario = codigo;
            
//mapeando datos
            for(Object datos : this.mapeo.keySet())
            {
                if(datos.equals(codigo))
                {
                    List lista = (List) this.mapeo.get(datos);
                    
                    this.txtpassword.setText(lista.getItem(0).toString());
                    this.password_usuario = lista.getItem(0).toString();
                    
                    int priv = Integer.parseInt(lista.getItem(1).toString());
                    int activo = Integer.parseInt(lista.getItem(2).toString());
                    
                    if(priv==0)
                        this.comboprivilegios.setSelectedIndex(0);
                    else
                        this.comboprivilegios.setSelectedIndex(1);
                    
                    if(activo==0)
                        CambioOpcioneActivo(1);
                    else 
                        CambioOpcioneActivo(0);
                    
                    break;
                }
            }
            
        }
        finally{
           
        }
    }
    
    private void CambioOpcioneActivo(int bool)
    {
        switch(bool)
        {
            case 0:
                this.opactivo.setSelected(true);
                this.optnoactivo.setSelected(false);
                break;
            case 1:
                this.opactivo.setSelected(false);
                this.optnoactivo.setSelected(true);
                break;
        }
    }
    
    private void CargandoUsuarios()
    {
        try {
            conn = new Conexion();
            String sql = "SELECT DISTINCT login.id_login as 'Codigo' , login.usuario as 'Usuario' , CONCAT(empleado.nombre , ' ' , empleado.apellido) as 'Nombres' "
                    + " , empleado.dui as 'Dui' , login.password as 'Contraseña' , login.privilegios as 'privilegios'"
                    + " , login.activo as activo FROM login LEFT JOIN empleado ON login.id_empleado=empleado.id_empleado ";
           
           ResultSet rs = conn.Get_Consulta(sql);
           this.modelo_tabla = new javax.swing.table.DefaultTableModel(null,
                new String [] {
                    "Codigo", "Usuario", "Nombres", "Dui"
                });
           mapeo = new HashMap();
           while(rs.next())
           {
               List lista_data = new List();
               this.modelo_tabla.addRow(new Object[] {
                   rs.getString("Codigo") ,
                   rs.getString("Usuario") ,
                   rs.getString("Nombres") ,
                   rs.getString("Dui") ,
               });
               lista_data.add(rs.getString("Contraseña"));
               lista_data.add(rs.getString("privilegios"));
               lista_data.add(rs.getString("activo"));
               mapeo.put(rs.getString("Codigo"), lista_data);
           }
           this.tablausuarios.setModel(modelo_tabla);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdeliminar;
    private javax.swing.JButton cmdguardar;
    private javax.swing.JButton cmdperfil;
    private javax.swing.JComboBox comboprivilegios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblperfil;
    private javax.swing.JRadioButton opactivo;
    private javax.swing.JRadioButton optnoactivo;
    private javax.swing.JTable tablausuarios;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpassword2;
    // End of variables declaration//GEN-END:variables
}
