

package tatosport;

import com.itextpdf.text.DocumentException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmVerPedido extends javax.swing.JFrame {

    private Pedidos pedido;
    private ArrayList ListaPedidos;
    private ArrayList ListaProducto;
    
    private DefaultTableModel TablaModelo = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio", "Total"
            });
    
    public FrmVerPedido() throws SQLException {
        try {
            this.pedido = new Pedidos();
            initComponents();
            this.Privilegios();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtbuscarpedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaproductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtregistro = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtfactura = new javax.swing.JLabel();
        txtorden = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtgiro = new javax.swing.JLabel();
        txtfiscal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtpedido = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtentrega = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtnit = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtpago = new javax.swing.JLabel();
        imagenpedido = new org.jdesktop.swingx.JXImageView();
        txtimgnombre = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmdeditar = new javax.swing.JButton();
        cmdeliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblanticipo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtanticipo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cmdenviar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblaprox = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtbuscarpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarpedidoActionPerformed(evt);
            }
        });
        txtbuscarpedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarpedidoKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar (N° de pedido , orden): ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("ORDEN DE PEDIDO ");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaproductos);

        jLabel3.setText("Cliente :");

        txtcliente.setText("________");

        jLabel5.setText("N° Registro :");

        txtregistro.setText("________");

        jLabel11.setText("Total Precios productos:");

        txttotal.setText("________");

        jLabel7.setText("N° Factura :");

        txtfactura.setText("________");

        txtorden.setText("________");

        jLabel10.setText("N° Orden :");

        jLabel13.setText("N° Giro :");

        txtgiro.setText("________");

        txtfiscal.setText("________");

        jLabel16.setText("Credito Fiscal :");

        txtpedido.setText("________");

        jLabel18.setText("Fecha Pedido :");

        txtentrega.setText("________");

        jLabel20.setText("Fecha Entrega :");

        jLabel21.setText("N° Nit :");

        txtnit.setText("________");

        jLabel23.setText("Tipo de pago :");

        txtpago.setText("________");

        javax.swing.GroupLayout imagenpedidoLayout = new javax.swing.GroupLayout(imagenpedido);
        imagenpedido.setLayout(imagenpedidoLayout);
        imagenpedidoLayout.setHorizontalGroup(
            imagenpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        imagenpedidoLayout.setVerticalGroup(
            imagenpedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtimgnombre.setText("________");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtorden, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtgiro, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpago, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtimgnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(imagenpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcliente)
                            .addComponent(jLabel13)
                            .addComponent(txtgiro))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtregistro)
                            .addComponent(jLabel16)
                            .addComponent(txtfiscal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtfactura)
                            .addComponent(jLabel18)
                            .addComponent(txtpedido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtentrega)
                            .addComponent(jLabel10)
                            .addComponent(txtorden))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtnit)
                            .addComponent(jLabel23)
                            .addComponent(txtpago))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagenpedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtimgnombre)
                        .addGap(8, 8, 8)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txttotal))
                .addContainerGap())
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/print_icon&16.png"))); // NOI18N
        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cmdeditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/wrench_icon&16.png"))); // NOI18N
        cmdeditar.setText("Editar");

        cmdeliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/delete_icon&16.png"))); // NOI18N
        cmdeliminar.setText("Eliminar");
        cmdeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdeliminarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setText("Total a pagar $");

        lbltotal.setText("____________");

        jLabel8.setText("Anticipo $");

        lblanticipo.setText("____________");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Anticipo Actual:");

        cmdenviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/round_arrow_right_icon&16.png"))); // NOI18N
        cmdenviar.setText("Enviar");
        cmdenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdenviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtanticipo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdenviar)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtanticipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdenviar))
                .addGap(16, 16, 16))
        );

        jLabel12.setText("Aproximado:");

        lblaprox.setText("____________");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblanticipo)
                    .addComponent(lbltotal)
                    .addComponent(lblaprox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lbltotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblanticipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(lblaprox))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdeditar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmdeliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarpedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(cmdeditar)
                    .addComponent(cmdeliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Anticipo()
    {
        ArrayList Lanticipo = new ArrayList();
        try {
           
            try {
                Lanticipo = new Pedidos().GetAnticipo(this.ListaPedidos.get(0).toString());
                if(Lanticipo.isEmpty())
                {
                    this.lblanticipo.setText("0.0");
                    double total = 0.0;
                    for(int i =0; i < this.tablaproductos.getRowCount() ; i++)
                    {
                        double valor = Double.parseDouble(this.tablaproductos.getValueAt(i, 3).toString());
                        total += valor;
                    }
                    this.lbltotal.setText(String.valueOf(total));
                    this.lblaprox.setText("0%");
                }
                else
                {
                    
                     this.lbltotal.setText(Lanticipo.get(0).toString());
                     this.lblanticipo.setText(Lanticipo.get(1).toString());
                     double pago = Double.parseDouble(Lanticipo.get(0).toString());
                     double anticipo = Double.parseDouble(Lanticipo.get(1).toString());
                     double t = pago - anticipo;
                     double porcentaje = (1 -(t/pago))*100 ;
                     this.lblaprox.setText(String.valueOf(Math.round(porcentaje)) + "%");
                }
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void txtbuscarpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarpedidoActionPerformed
        try {
            this.ObtenerDatosPedido();
        } catch (IOException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtbuscarpedidoActionPerformed

    private void txtbuscarpedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarpedidoKeyReleased
        try {
            this.ObtenerDatosPedido();
            this.Anticipo();
        } catch (IOException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtbuscarpedidoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) this.tablaproductos.getModel();
        int rows = model.getRowCount();
        int col = model.getColumnCount();
        String[][] data = new String[rows][col];
        for(int i=0; i < rows ; i++)
        {
            for(int j =0; j < col ; j++)
            {
                data[i][j] = model.getValueAt(i, j).toString();
            }
        }
        PdfCreador pdf = new PdfCreador();
        try {
            pdf.SetArregloDatosToPdf(data,  
                    new String [] { "Cantidad", "Descripcion", "Precio", "Total"});
            
            ArrayList lista_datos = new ArrayList();
            ArrayList lista_datosP = new ArrayList();
            
            lista_datos.add(" ");
            lista_datos.add(" ");
            lista_datosP.add(" ");
            lista_datos.add("N° factura : " 
                    + this.txtfactura.getText() 
                    + " N° de Orden : " + this.txtorden.getText() );
            lista_datos.add("Cliente : " + this.txtcliente.getText());
            lista_datos.add("Nit : " + this.txtnit.getText() 
                    + " Giro: " + this.txtgiro.getText());
            lista_datos.add("Credito Fiscal : " + this.txtfiscal.getText()  
                    + " N° registro: " + this.txtregistro.getText());
            lista_datos.add("Fecha pedido : " + this.txtpedido.getText()
             + " Fecha de entrega : "  + this.txtentrega.getText() );
            lista_datos.add(" ");
            lista_datos.add(" ");
            lista_datosP.add(" ");
            lista_datosP.add(" ");
            lista_datosP.add("Total :" + this.txttotal.getText());
            lista_datosP.add("Forma de pago :" + this.txtpago.getText());
            
            pdf.SetDatosEncabezado(lista_datos);
            pdf.SetDatosPiedePagina(lista_datosP);
            pdf.Crear_PDF("Pedidos", this.txtcliente.getText() 
                    , this.txtorden.getText()
                    , this.txtpedido.getText()
                    , "");
            pdf.Imprimir();
            
            
            
        } catch (DocumentException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmdeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdeliminarActionPerformed
        int diag = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este pedido?" , "Confirmar Salida" ,JOptionPane.YES_NO_OPTION);
        if(diag >=1) return;
        try {
            pedido = new Pedidos();
            boolean kill = pedido.EliminarPedido(this.ListaPedidos.get(0).toString());
            if(kill)
                JOptionPane.showMessageDialog(this, "Pedido eliminado con exito ...");
            else
                 JOptionPane.showMessageDialog(this, "No se ha podido eliminar este pedido ....");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
    }//GEN-LAST:event_cmdeliminarActionPerformed

    private void cmdenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdenviarActionPerformed

        if(this.txtanticipo.getText() == "")
         {
             JOptionPane.showMessageDialog(this, "Se necesita un valor de anticipo", 
                        "oops !", JOptionPane.INFORMATION_MESSAGE);
             return ;
         }
        try {
             try {
                 
               double anticipo = Double.parseDouble(this.lblanticipo.getText());
              if(anticipo <= 0){
                 boolean ok = new Pedidos().GuardarAnticipo(this.ListaPedidos.get(0).toString()
                         , this.lbltotal.getText() , this.txtanticipo.getText());
                 if(ok)
                      JOptionPane.showMessageDialog(this, "Anticipo añadido con exito", 
                       "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
                 else
                      JOptionPane.showMessageDialog(this, "Algo malo ocurrio", 
                        "oops !", JOptionPane.INFORMATION_MESSAGE);
              }
              else
              {
                    int diag = JOptionPane.showConfirmDialog(this, "¿Desea cambiar el anticipo ?" , "Confirmar Salida" ,JOptionPane.YES_NO_OPTION);
                    if(diag <=0)
                    {
                        boolean actualizado = new Pedidos().ActualizarAnticipo(this.ListaPedidos.get(0).toString()
                         , this.lbltotal.getText() , this.txtanticipo.getText());
                        if(actualizado)
                             JOptionPane.showMessageDialog(this, "Anticipo actualizado con exito", 
                               "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(this, "Algo malo ocurrio", 
                            "oops !", JOptionPane.INFORMATION_MESSAGE);
                    }
              }
                   this.Anticipo();
                 } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, "Algo malo ocurrio", 
                        "oops !", JOptionPane.INFORMATION_MESSAGE);
                 Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
             }
             
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, "Algo malo ocurrio", 
                        "oops !", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdenviarActionPerformed

    private void Privilegios()
    {
        int priv = Seguridad.Get_privilegios();
        switch(priv)
        {
            case 0:
                this.cmdeliminar.setEnabled(false);
                this.cmdeditar.setEnabled(false);
                break;
            case 1:
                 this.cmdeliminar.setEnabled(true);
                this.cmdeditar.setEnabled(true);
                break;
        }
    }
    
    private void ObtenerDatosPedido() throws IOException
    {
        try {
            String codigo =this.txtbuscarpedido.getText();
            this.pedido = new Pedidos();
            this.ListaPedidos = new ArrayList();
            this.ListaPedidos = this.pedido.Get_DatosCliente_byId(codigo);
            this.ListaProducto = new ArrayList();
            this.ListaProducto = this.pedido.Get_ProductosByPedidos(this.ListaPedidos.get(0).toString());
            if(this.ListaPedidos.size() >=1)
                this.GenerarDatosPedidos();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings({"BroadCatchBlock", "TooBroadCatch"})
    private void GenerarDatosPedidos() throws IOException
    {
        
        double total_prod = 0.0;
        
        //inicio de la configuracion para los productos en la tabla
        TablaModelo = new DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio", "Total"
            });
        for(int i =0; i < this.ListaProducto.size() ; i++)
        {
            Object[] obj = (Object[]) this.ListaProducto.get(i);
            this.TablaModelo.addRow(obj);
            total_prod += Double.valueOf(obj[obj.length - 1].toString());
        }
        this.tablaproductos.setModel(TablaModelo);
        //final de la configuracion de los productos.
        this.txttotal.setText(String.valueOf(total_prod));
        
        //mostrando los demas datos del pedido
        this.txtcliente.setText(this.ListaPedidos.get(1).toString());
        this.txtregistro.setText(this.ListaPedidos.get(2).toString());
        this.txtfactura.setText(this.ListaPedidos.get(3).toString());
        this.txtorden.setText(this.ListaPedidos.get(4).toString());
        this.txtnit.setText(this.ListaPedidos.get(5).toString());
        this.txtgiro.setText(this.ListaPedidos.get(6).toString());
        this.txtfiscal.setText(this.ListaPedidos.get(7).toString());
        this.txtpedido.setText(this.ListaPedidos.get(8).toString());
        this.txtentrega.setText(this.ListaPedidos.get(9).toString());
        //mostrando la imagen 
        try{
        byte[] Mbits = (byte[]) this.ListaPedidos.get(11);
        InputStream in = new ByteArrayInputStream(Mbits);
	BufferedImage bImageFromConvert = ImageIO.read(in);
        bImageFromConvert.getScaledInstance(this.imagenpedido.getWidth()
                , this.imagenpedido.getHeight(),Image.SCALE_FAST);
        this.imagenpedido.setImage(bImageFromConvert);
        }catch(IOException ex){
            Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
               ).getImage();
            this.imagenpedido.setImage(img);
        }
         //los demas datos
        this.txtimgnombre.setText(this.ListaPedidos.get(10).toString());
        int pago = Integer.parseInt(this.ListaPedidos.get(12).toString());
        if(pago ==0)
            this.txtpago.setText("Efectivo");
        else 
             this.txtpago.setText("Credito");
    }

    /*this.list.add(rs.getString("id"));
                this.list.add(rs.getString("cliente"));
                this.list.add(rs.getString("registro"));
                this.list.add(rs.getString("factura"));
                this.list.add(rs.getString("orden"));
                this.list.add(rs.getString("nit"));
                this.list.add(rs.getString("giro"));
                this.list.add(rs.getString("fiscal"));
                this.list.add(rs.getString("inicio"));
                this.list.add(rs.getString("entrega"));
                this.list.add(rs.getString("nombre"));
                this.list.add(rs.getObject("photo"));
                this.list.add(rs.getString("pago"));*/
    
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVerPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new FrmVerPedido().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FrmVerPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdeditar;
    private javax.swing.JButton cmdeliminar;
    private javax.swing.JButton cmdenviar;
    private org.jdesktop.swingx.JXImageView imagenpedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblanticipo;
    private javax.swing.JLabel lblaprox;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tablaproductos;
    private javax.swing.JTextField txtanticipo;
    private javax.swing.JTextField txtbuscarpedido;
    private javax.swing.JLabel txtcliente;
    private javax.swing.JLabel txtentrega;
    private javax.swing.JLabel txtfactura;
    private javax.swing.JLabel txtfiscal;
    private javax.swing.JLabel txtgiro;
    private javax.swing.JLabel txtimgnombre;
    private javax.swing.JLabel txtnit;
    private javax.swing.JLabel txtorden;
    private javax.swing.JLabel txtpago;
    private javax.swing.JLabel txtpedido;
    private javax.swing.JLabel txtregistro;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
