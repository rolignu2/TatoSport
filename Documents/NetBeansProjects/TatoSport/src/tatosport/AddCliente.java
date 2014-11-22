/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tatosport;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author rolandoantonio
 */
public class AddCliente extends javax.swing.JPanel {

    
    private static final String EMAIL_EXPRESION = 
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    private boolean FLAG_EMAIL = false;
  
    private final Pattern pattern;
    private Matcher matcher;
    
    
    public AddCliente() {
        initComponents();
        pattern = Pattern.compile(EMAIL_EXPRESION);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cmdregistrar = new javax.swing.JButton();
        cmdlimpiar = new javax.swing.JButton();
        txtoffices = new javax.swing.JFormattedTextField();
        txtmail = new javax.swing.JTextField();
        dateChooserCombo1 = new org.jdesktop.swingx.JXDatePicker();
        txtweb = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnit = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        txtfiscal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("Nombres:");

        jLabel2.setText("Apellidos:");

        txtnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresActionPerformed(evt);
            }
        });

        txtapellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidosActionPerformed(evt);
            }
        });

        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        jLabel3.setText("Direccion:");

        jLabel4.setText("Tel Oficina:");

        jLabel5.setText("Tel celular:");

        jLabel6.setText("E-mail:");

        try {
            txtcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Fecha ingreso:");

        cmdregistrar.setText("Registrar");
        cmdregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdregistrarActionPerformed(evt);
            }
        });

        cmdlimpiar.setText("Limpiar");
        cmdlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdlimpiarActionPerformed(evt);
            }
        });

        try {
            txtoffices.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtmail.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtmailInputMethodTextChanged(evt);
            }
        });
        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmailKeyPressed(evt);
            }
        });

        txtweb.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtwebInputMethodTextChanged(evt);
            }
        });
        txtweb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtwebKeyPressed(evt);
            }
        });

        jLabel8.setText("Pagina Web:");

        try {
            txtnit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("NIT:");

        txtfiscal.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtfiscalInputMethodTextChanged(evt);
            }
        });
        txtfiscal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfiscalKeyPressed(evt);
            }
        });

        jLabel10.setText("Credito Fiscal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdregistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtweb)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtfiscal)
                                    .addComponent(txtnit, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtdireccion))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtnombres))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtmail)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtoffices, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                                .addComponent(txtcelular))
                                            .addGap(44, 44, 44)))))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtoffices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtweb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtfiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdregistrar)
                    .addComponent(cmdlimpiar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresActionPerformed

    private void txtapellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidosActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionActionPerformed

    private void cmdregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdregistrarActionPerformed
       
        if(this.Seguridad())
        {
            try {
                Clientes client = new Clientes();
                Random rnd = new Random();
                String id_cliente = "CLIENT_" + String.valueOf(this.txtnombres.getText().charAt(0)).toUpperCase();
                id_cliente += String.valueOf(this.txtapellidos.getText().charAt(0)).toUpperCase();
                id_cliente += String.valueOf(rnd.nextInt(20));
                id_cliente += String.valueOf(rnd.nextInt(1000));
                id_cliente += String.valueOf(rnd.nextInt(200));
                String fecha_formato = Seguridad.Get_formato_fecha(this.dateChooserCombo1.getDate());
                
                boolean ok = client.Set_clientes(id_cliente,
                        this.txtnombres.getText(), 
                        this.txtapellidos.getText(), 
                        this.txtdireccion.getText(), 
                        this.txtoffices.getText(),
                        this.txtcelular.getText(), 
                        this.txtmail.getText(), 
                        fecha_formato,
                        this.txtweb.getText() ,
                        this.txtnit.getText(),
                        this.txtfiscal.getText());
                
                if(ok){
                   JOptionPane.showMessageDialog(this, "Cliente se a registrado con exito", 
                "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
                   Clear();
                }
                else
                    JOptionPane.showMessageDialog(this, "Creo que hubo un error en el sistema , intente mas tarde", 
                "Opps!", JOptionPane.ERROR_MESSAGE);

            } catch (    SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(AddCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdregistrarActionPerformed

    private void txtmailInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtmailInputMethodTextChanged
        
       
    }//GEN-LAST:event_txtmailInputMethodTextChanged

    private void txtmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyPressed
        matcher = pattern.matcher(this.txtmail.getText());
        if(!matcher.matches())
        {
            this.txtmail.setBackground(Color.LIGHT_GRAY);
            this.FLAG_EMAIL = true;
        }
        else
        {
            this.txtmail.setBackground(Color.white);
            this.FLAG_EMAIL = false;
        }
    }//GEN-LAST:event_txtmailKeyPressed

    private void cmdlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdlimpiarActionPerformed
        Clear();
    }//GEN-LAST:event_cmdlimpiarActionPerformed

    private void txtwebInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtwebInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtwebInputMethodTextChanged

    private void txtwebKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtwebKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtwebKeyPressed

    private void txtfiscalInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtfiscalInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiscalInputMethodTextChanged

    private void txtfiscalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiscalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiscalKeyPressed

    private boolean Seguridad()
    {
        if(this.FLAG_EMAIL == true)
        {
            JOptionPane.showMessageDialog(this, "el correo electronico o e-mail es invalido", 
                "Opps!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if("".equals(this.txtnombres.getText()) 
                || "".equals(this.txtapellidos.getText()))
        {
            JOptionPane.showMessageDialog(this, "el nombre o apellido estan vacios", 
                "Opps!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else if(this.txtmail.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "el correo electronico es encesario , favor agregar un correo valido", 
                "Opps!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void Clear()
    {
        this.txtapellidos.setText("");
         this.txtnombres.setText("");
          this.txtdireccion.setText("");
           this.txtcelular.setText("");
            this.txtoffices.setText("");
             this.txtmail.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdlimpiar;
    private javax.swing.JButton cmdregistrar;
    private org.jdesktop.swingx.JXDatePicker dateChooserCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JFormattedTextField txtcelular;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfiscal;
    private javax.swing.JTextField txtmail;
    private javax.swing.JFormattedTextField txtnit;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JFormattedTextField txtoffices;
    private javax.swing.JTextField txtweb;
    // End of variables declaration//GEN-END:variables
}
