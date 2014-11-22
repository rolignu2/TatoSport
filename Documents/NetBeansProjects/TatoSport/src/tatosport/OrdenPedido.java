
package tatosport;


import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class OrdenPedido extends javax.swing.JFrame {

    
    /*ORDEN DE PEDIDO VARIABLES A UTILIZAR*/
    private Map DiccionarioClientes;
    private String Id_Cliente = null;
    private List lista_cliente_id;
    private String nit_cliente_seleccionado;
    private String fiscal_cliente_seleccionado;
    private String direccion_cliente_seleccionado;
    private String nombre_clientes_seleccionado;
    private File archivo_design_seleccionado;
    
    /*INDEXADO TABLA PEDIDO ... PASO 3 */
    private int RowIndex = -1;
    
    private final DefaultTableModel modelo_tabla_pedido = new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
    },
    new String [] {
        "Cantidad", "Descripcion", "Precio Unitario", "Total"
    });
    
    /*FIN DE VARIABLES ORDEN DE PEDIDO*/
    
    /*PRODUCCION DE CORTE VARIABLES A UTILIZAR*/
    private ArrayList ListaClientePedido = new ArrayList();
    private ArrayList ListaTelas = new ArrayList();
    private ArrayList ListaCortePedido = new ArrayList();
    private ArrayList ListaEnsamblePedido = new ArrayList();
    /*FIN PRODUCCION DE CORTE*/
    
    public OrdenPedido() {
        this.archivo_design_seleccionado = null;
        this.direccion_cliente_seleccionado = "";
        this.fiscal_cliente_seleccionado = "";
        this.nit_cliente_seleccionado = "";
        this.nombre_clientes_seleccionado = "";
        
        initComponents();
        //carga de datos iniciales
        Cargando_datos();
        //verifica los privilegios administrativos
        Privilegios();
        //temporizadores
        TemporizadorTablaPedido();
        //
        this.TopClientes();
        this.Notificaciones();
    }

     
    /*Privilegios 
       ADMINISTRADOR = 1
       USUARIO = 0*/
    private void Privilegios()
    {
        int priv_ = Seguridad.Get_privilegios();
        switch(priv_)
        {
            case 0:
                this.jadministracion.setEnabled(false);
                this.cmdcorte_editar.setEnabled(false);
               // this.cmdeditar_asm.setEnabled(false);
                break;
            case 1:
                this.jadministracion.setEnabled(true);
                this.cmdcorte_editar.setEnabled(true);
                //this.cmdeditar_asm.setEnabled(true);
                break;
        }
    }
    
    
    private void Notificaciones()
    {
        try {
            ArrayList notificar = new Pedidos().GetPedidosEntrega();
            if(notificar.isEmpty())
            {
                this.menu_notificaciones.setText("Sin notificaciones ...");
            }
            else
            {
                for(int i=0; i < notificar.size() ; i++)
                {
                    String[] obj = (String[]) notificar.get(i);
                    JMenuItem item = new JMenuItem();
                    String dato = "Orden n°: " + obj[0] 
                            + " || Expira: " + obj[1] + " Dias || Anticipo: " + obj[2] + "%" ;
                    item.setText(dato);
                    this.menu_notificaciones.add(item);
                }
                this.menu_notificaciones.setForeground(Color.red);
                this.menu_notificaciones.setText("Tienes " + notificar.size() + " Notificacion(es)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        try {
            frmVerPedido1 = new tatosport.FrmVerPedido();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }
        jXFrame1 = new org.jdesktop.swingx.JXFrame();
        jMenuItem3 = new javax.swing.JMenuItem();
        panell1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel4 = new javax.swing.JPanel();
        combocliente = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JLabel();
        txtoficina = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmdreflesh = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaclientes = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        addCliente2 = new tatosport.AddCliente();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblcliente_pedido = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtn_orden_pedido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtgiro_pedido = new javax.swing.JTextField();
        txt_fiscal_pedido = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtn_factura_pedido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtn_registro_pedido = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_nit_pedido = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        opt_pago_credito_pedido = new javax.swing.JRadioButton();
        opt_pago_contado_pedido = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        txt_fecha_pedido = new org.jdesktop.swingx.JXDatePicker();
        txtfecha_entrega = new org.jdesktop.swingx.JXDatePicker();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        vistaimagen = new org.jdesktop.swingx.JXImageView();
        cmdimagene_seleccionada_pedido = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_pedidos = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        cmd_add_jtabla_pedido = new javax.swing.JButton();
        cmd_eliminar_pedido = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblfila_pedido = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbldescripcion_pedido = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblcantidad_pedido = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        cmd_finalizar_pedido = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txtnumero_orden = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        imagenproduccion_corte = new org.jdesktop.swingx.JXImageView();
        jLabel19 = new javax.swing.JLabel();
        txtorden_corte = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtcliente_corte = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtfecha_corte = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtimagen_corte = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabla_corte = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        combotela_corte = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        combocolor_corte = new javax.swing.JComboBox();
        jPanel21 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtcorte_cuello = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtcorte_ecotecuello = new javax.swing.JTextField();
        txtcorte_puno = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtcorte_franjas = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtcorte_venas = new javax.swing.JTextField();
        txtcorte_elastico = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cmdguardar_corte = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        txtnumero_orden1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        imagenproduccion_corte1 = new org.jdesktop.swingx.JXImageView();
        jLabel34 = new javax.swing.JLabel();
        txtorden_corte1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtcliente_corte1 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtfecha_corte1 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtimagen_corte1 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_corte1 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        combotela_corte1 = new javax.swing.JComboBox();
        jLabel39 = new javax.swing.JLabel();
        combocolor_corte1 = new javax.swing.JComboBox();
        jPanel26 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtcorte_cuello1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtcorte_ecotecuello1 = new javax.swing.JTextField();
        txtcorte_puno1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtcorte_franjas1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtcorte_venas1 = new javax.swing.JTextField();
        txtcorte_elastico1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        cmdcorte_editar = new javax.swing.JButton();
        cmdcorte_imprimir = new javax.swing.JButton();
        txtcorte_id = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        txtnumero_orden2 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        imagenproduccion_corte2 = new org.jdesktop.swingx.JXImageView();
        jLabel46 = new javax.swing.JLabel();
        txtorden_corte2 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtcliente_corte2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtfecha_corte2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtimagen_corte2 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_corte2 = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        combotela_corte2 = new javax.swing.JComboBox();
        jLabel51 = new javax.swing.JLabel();
        combocolor_corte2 = new javax.swing.JComboBox();
        jPanel33 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        asm1 = new javax.swing.JComboBox();
        asm2 = new javax.swing.JComboBox();
        asm3 = new javax.swing.JComboBox();
        asm4 = new javax.swing.JComboBox();
        asm5 = new javax.swing.JComboBox();
        asm6 = new javax.swing.JComboBox();
        cmdguardar_asm = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        txtasm_decorado = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        txtnumero_orden3 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        imagenproduccion_corte3 = new org.jdesktop.swingx.JXImageView();
        jLabel60 = new javax.swing.JLabel();
        txtorden_corte3 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtcliente_corte3 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtfecha_corte3 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        txtimagen_corte3 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabla_corte3 = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        combotela_corte3 = new javax.swing.JComboBox();
        jLabel65 = new javax.swing.JLabel();
        combocolor_corte3 = new javax.swing.JComboBox();
        jPanel38 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        asm7 = new javax.swing.JComboBox();
        asm8 = new javax.swing.JComboBox();
        asm9 = new javax.swing.JComboBox();
        asm10 = new javax.swing.JComboBox();
        asm11 = new javax.swing.JComboBox();
        asm12 = new javax.swing.JComboBox();
        jLabel72 = new javax.swing.JLabel();
        txtasm_decorado1 = new javax.swing.JTextField();
        cmdasm_imprimir = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel39 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        txtnumero_orden4 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        imagenproduccion_corte4 = new org.jdesktop.swingx.JXImageView();
        jLabel74 = new javax.swing.JLabel();
        txtorden_corte4 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtcliente_corte4 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtfecha_corte4 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        txtimagen_corte4 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tabla_corte4 = new javax.swing.JTable();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        cmdguardar_empaque = new javax.swing.JButton();
        txtincluye_paquete = new javax.swing.JTextField();
        txtresponsable_paquete = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        cmd_sesion = new javax.swing.JMenu();
        cmdsesion = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cmd_Salir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        cmdpedido = new javax.swing.JMenuItem();
        menutelas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cmd_add_cliente = new javax.swing.JMenuItem();
        cmd_verclientes = new javax.swing.JMenuItem();
        jadministracion = new javax.swing.JMenu();
        juser_contra = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        cmdadduser = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_notificaciones = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        javax.swing.GroupLayout jXFrame1Layout = new javax.swing.GroupLayout(jXFrame1.getContentPane());
        jXFrame1.getContentPane().setLayout(jXFrame1Layout);
        jXFrame1Layout.setHorizontalGroup(
            jXFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jXFrame1Layout.setVerticalGroup(
            jXFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Orden de pedido");
        setBackground(new java.awt.Color(204, 204, 204));
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        panell1.setBackground(new java.awt.Color(204, 255, 255));
        panell1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panell1.setToolTipText("orden pedido");
        panell1.setDoubleBuffered(true);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        combocliente.setEditable(true);
        combocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboclienteActionPerformed(evt);
            }
        });
        combocliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboclienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                comboclienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                comboclienteKeyTyped(evt);
            }
        });

        jLabel1.setText("Selecciona un Cliente Registrado");

        txtnombre.setText("_______");

        txtdireccion.setText("_______");

        txtoficina.setText("_______");

        jLabel2.setText("Nombres:");

        jLabel3.setText("Direccion:");

        jLabel4.setText("Telefono:");

        cmdreflesh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/refresh_icon&16.png"))); // NOI18N
        cmdreflesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdrefleshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtoficina, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(combocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdreflesh, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combocliente)
                    .addComponent(cmdreflesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtoficina))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setText("Top Clientes Recientes");

        listaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaclientes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );

        panell1.addTab("Paso 1: Seleccion de cliente", jPanel1);

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Pedido"));

        jLabel5.setText("Cliente: ");

        lblcliente_pedido.setText("_________");

        jLabel7.setText("N° de Orden :");

        jLabel9.setText("NIT:");

        jLabel10.setText("Giro:");

        jLabel11.setText("Credito Fiscal:");

        jLabel12.setText("N° de Factura :");

        jLabel14.setText("N° de Registro :");

        try {
            txt_nit_pedido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-######-###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtn_orden_pedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                            .addComponent(txtn_factura_pedido)
                            .addComponent(txt_nit_pedido, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcliente_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtn_registro_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(txtgiro_pedido))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(18, 18, 18)
                            .addComponent(txt_fiscal_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel13)
                    .addContainerGap(342, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblcliente_pedido))
                .addGap(26, 26, 26)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtn_registro_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtn_factura_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtn_orden_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_nit_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtgiro_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_fiscal_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addComponent(jLabel13)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Forma de pago"));

        opt_pago_credito_pedido.setText("Pago por medio de credito");
        opt_pago_credito_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_pago_credito_pedidoActionPerformed(evt);
            }
        });

        opt_pago_contado_pedido.setText("Pago de contado");
        opt_pago_contado_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt_pago_contado_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt_pago_credito_pedido)
                    .addComponent(opt_pago_contado_pedido))
                .addGap(102, 102, 102))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(opt_pago_credito_pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opt_pago_contado_pedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("Fecha de pedido :");

        jLabel16.setText("Fecha de entrega :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_fecha_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txtfecha_entrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_fecha_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfecha_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Diseño Solicitado"));

        vistaimagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        vistaimagen.setInheritAlpha(false);
        vistaimagen.setMaximumSize(new java.awt.Dimension(110, 110));
        vistaimagen.setName(""); // NOI18N

        javax.swing.GroupLayout vistaimagenLayout = new javax.swing.GroupLayout(vistaimagen);
        vistaimagen.setLayout(vistaimagenLayout);
        vistaimagenLayout.setHorizontalGroup(
            vistaimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        vistaimagenLayout.setVerticalGroup(
            vistaimagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        cmdimagene_seleccionada_pedido.setText("Seleccionar Imagen (2mb max)");
        cmdimagene_seleccionada_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdimagene_seleccionada_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(vistaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(cmdimagene_seleccionada_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(vistaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdimagene_seleccionada_pedido)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Paso 2: Ingreso de datos", jPanel2);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Insertar productos"));

        tabla_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio Unitario", "Total"
            }));
            tabla_pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabla_pedidosMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(tabla_pedidos);

            javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
            jPanel12.setLayout(jPanel12Layout);
            jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Controles"));

            cmd_add_jtabla_pedido.setText("Agregar Fila");
            cmd_add_jtabla_pedido.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_add_jtabla_pedidoActionPerformed(evt);
                }
            });

            cmd_eliminar_pedido.setText("Eliminar Fila");
            cmd_eliminar_pedido.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_eliminar_pedidoActionPerformed(evt);
                }
            });

            jLabel6.setText("N° Fila:");

            lblfila_pedido.setText("__________");

            jLabel18.setText("Descripcion:");

            lbldescripcion_pedido.setText("__________");

            jLabel20.setText("Cantidad:");

            lblcantidad_pedido.setText("__________");

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jTextArea1.setText("para agregar productos \nen la tabla debera\ndarle doble click \na la columna a agregar.");
            jScrollPane2.setViewportView(jTextArea1);

            javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
            jPanel13.setLayout(jPanel13Layout);
            jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbldescripcion_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmd_add_jtabla_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmd_eliminar_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblfila_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblcantidad_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(cmd_add_jtabla_pedido)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(cmd_eliminar_pedido)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblfila_pedido))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(lbldescripcion_pedido))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(lblcantidad_pedido))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE))
            );

            jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Finalizar"));

            cmd_finalizar_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/save_icon&16.png"))); // NOI18N
            cmd_finalizar_pedido.setText("  Finalizar Pedido");
            cmd_finalizar_pedido.setActionCommand("Finalizar");
            cmd_finalizar_pedido.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_finalizar_pedidoActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
            jPanel14.setLayout(jPanel14Layout);
            jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cmd_finalizar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(cmd_finalizar_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(84, Short.MAX_VALUE))
            );

            jTabbedPane2.addTab("Paso 3: Introduccion de pedido", jPanel6);

            panell1.addTab("Orden de Pedido", jTabbedPane2);

            jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtnumero_orden.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtnumero_ordenActionPerformed(evt);
                }
            });
            txtnumero_orden.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtnumero_ordenKeyReleased(evt);
                }
            });

            jLabel17.setText("Seleccione N° de Orden:");

            jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

            javax.swing.GroupLayout imagenproduccion_corteLayout = new javax.swing.GroupLayout(imagenproduccion_corte);
            imagenproduccion_corte.setLayout(imagenproduccion_corteLayout);
            imagenproduccion_corteLayout.setHorizontalGroup(
                imagenproduccion_corteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 247, Short.MAX_VALUE)
            );
            imagenproduccion_corteLayout.setVerticalGroup(
                imagenproduccion_corteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
            jPanel18.setLayout(jPanel18Layout);
            jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel18Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel19.setText("N° orden:");

            txtorden_corte.setText("_____________");

            jLabel22.setText("Nombre Cliente:");

            txtcliente_corte.setText("_____________");

            jLabel24.setText("Fecha pedido:");

            txtfecha_corte.setText("_____________");

            jLabel26.setText("Nombre Imagen:");

            txtimagen_corte.setText("_____________");

            javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
            jPanel17.setLayout(jPanel17Layout);
            jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnumero_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha_corte, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente_corte, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtorden_corte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel17Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtimagen_corte, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18))
            );
            jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtnumero_orden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(txtorden_corte))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtcliente_corte))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtfecha_corte))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtimagen_corte))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel17Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            tabla_corte.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane5.setViewportView(tabla_corte);

            jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            jLabel21.setText("Tipo de tela :");

            jLabel23.setText("Color de tela:");

            combocolor_corte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ROJO ", "VERDE ", "AZUL", "BLANCO ", "CYAN ", "MAGENTA ", "AMARILLO ", "NEGRO", "GRIS  ", "ROSA  ", "VIOLETA  ", "CELESTE  ", "MARRON  ", "NARANJA  ", "LAVANDA ", "TURQUESA ", "ORO VIEJO" }));

            jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas de corte"));

            jLabel25.setText("Cuello:");

            jLabel27.setText("Escote cuello:");

            jLabel28.setText("Puño:");

            jLabel29.setText("Franjas:");

            jLabel30.setText("Venas:");

            jLabel31.setText("Elastico:");

            javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
            jPanel21.setLayout(jPanel21Layout);
            jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel27)
                        .addComponent(jLabel25)
                        .addComponent(jLabel28))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtcorte_puno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcorte_cuello, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcorte_ecotecuello, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(51, 51, 51)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcorte_franjas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addGap(18, 18, 18)
                            .addComponent(txtcorte_venas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcorte_elastico, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(txtcorte_franjas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30)
                                .addComponent(txtcorte_venas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel31)
                                .addComponent(txtcorte_elastico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel21Layout.createSequentialGroup()
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25)
                                .addComponent(txtcorte_cuello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(txtcorte_ecotecuello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(txtcorte_puno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(23, Short.MAX_VALUE))
            );

            cmdguardar_corte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/save_icon&16.png"))); // NOI18N
            cmdguardar_corte.setText("Guardar ");
            cmdguardar_corte.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdguardar_corteActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
            jPanel20.setLayout(jPanel20Layout);
            jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combocolor_corte, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combotela_corte, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(115, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdguardar_corte, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))))
            );
            jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                            .addGap(0, 43, Short.MAX_VALUE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(combotela_corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(combocolor_corte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addComponent(cmdguardar_corte))
                        .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
            jPanel19.setLayout(jPanel19Layout);
            jPanel19Layout.setHorizontalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel19Layout.setVerticalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel19Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
            jPanel15.setLayout(jPanel15Layout);
            jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(89, 89, 89))
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel15Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(64, 64, 64))
            );

            jTabbedPane4.addTab("Agregar Corte", jPanel15);

            jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtnumero_orden1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtnumero_orden1ActionPerformed(evt);
                }
            });
            txtnumero_orden1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtnumero_orden1KeyReleased(evt);
                }
            });

            jLabel33.setText("Seleccione N° de Orden:");

            jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

            javax.swing.GroupLayout imagenproduccion_corte1Layout = new javax.swing.GroupLayout(imagenproduccion_corte1);
            imagenproduccion_corte1.setLayout(imagenproduccion_corte1Layout);
            imagenproduccion_corte1Layout.setHorizontalGroup(
                imagenproduccion_corte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 247, Short.MAX_VALUE)
            );
            imagenproduccion_corte1Layout.setVerticalGroup(
                imagenproduccion_corte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
            jPanel23.setLayout(jPanel23Layout);
            jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel23Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel34.setText("N° orden:");

            txtorden_corte1.setText("_____________");

            jLabel35.setText("Nombre Cliente:");

            txtcliente_corte1.setText("_____________");

            jLabel36.setText("Fecha pedido:");

            txtfecha_corte1.setText("_____________");

            jLabel37.setText("Nombre Imagen:");

            txtimagen_corte1.setText("_____________");

            javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
            jPanel22.setLayout(jPanel22Layout);
            jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jLabel33)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnumero_orden1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha_corte1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente_corte1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtorden_corte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel22Layout.createSequentialGroup()
                            .addComponent(jLabel37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtimagen_corte1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18))
            );
            jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(txtnumero_orden1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(txtorden_corte1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(txtcliente_corte1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txtfecha_corte1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtimagen_corte1))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            tabla_corte1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane6.setViewportView(tabla_corte1);

            jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            jLabel38.setText("Tipo de tela :");

            jLabel39.setText("Color de tela:");

            combocolor_corte1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ROJO ", "VERDE ", "AZUL", "BLANCO ", "CYAN ", "MAGENTA ", "AMARILLO ", "NEGRO", "GRIS  ", "ROSA  ", "VIOLETA  ", "CELESTE  ", "MARRON  ", "NARANJA  ", "LAVANDA ", "TURQUESA ", "ORO VIEJO" }));

            jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas de corte"));

            jLabel40.setText("Cuello:");

            jLabel41.setText("Escote cuello:");

            jLabel42.setText("Puño:");

            jLabel43.setText("Franjas:");

            jLabel44.setText("Venas:");

            jLabel45.setText("Elastico:");

            javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
            jPanel26.setLayout(jPanel26Layout);
            jPanel26Layout.setHorizontalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel41)
                        .addComponent(jLabel40)
                        .addComponent(jLabel42))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtcorte_puno1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcorte_cuello1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcorte_ecotecuello1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(51, 51, 51)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(jLabel43)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcorte_franjas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(jLabel44)
                            .addGap(18, 18, 18)
                            .addComponent(txtcorte_venas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addComponent(jLabel45)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcorte_elastico1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel26Layout.setVerticalGroup(
                jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel43)
                                .addComponent(txtcorte_franjas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(txtcorte_venas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel45)
                                .addComponent(txtcorte_elastico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel26Layout.createSequentialGroup()
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(txtcorte_cuello1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel41)
                                .addComponent(txtcorte_ecotecuello1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel42)
                                .addComponent(txtcorte_puno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(23, Short.MAX_VALUE))
            );

            cmdcorte_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/save_icon&16.png"))); // NOI18N
            cmdcorte_editar.setText("Guardar Cambios");
            cmdcorte_editar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdcorte_editarActionPerformed(evt);
                }
            });

            cmdcorte_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/print_icon&16.png"))); // NOI18N
            cmdcorte_imprimir.setText("Imprimir Corte");
            cmdcorte_imprimir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdcorte_imprimirActionPerformed(evt);
                }
            });

            txtcorte_id.setText("________");

            javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
            jPanel25.setLayout(jPanel25Layout);
            jPanel25Layout.setHorizontalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel25Layout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combocolor_corte1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel25Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcorte_id)
                                        .addComponent(combotela_corte1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdcorte_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmdcorte_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34))))
            );
            jPanel25Layout.setVerticalGroup(
                jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel25Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(txtcorte_id)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(combotela_corte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel39)
                                .addComponent(combocolor_corte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmdcorte_editar)
                                .addComponent(cmdcorte_imprimir)))
                        .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
            jPanel24.setLayout(jPanel24Layout);
            jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel24Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
            jPanel16.setLayout(jPanel16Layout);
            jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(77, Short.MAX_VALUE))
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(69, Short.MAX_VALUE))
            );

            jTabbedPane4.addTab("Ver Corte ", jPanel16);

            panell1.addTab("Produccion de Corte", jTabbedPane4);

            jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtnumero_orden2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtnumero_orden2ActionPerformed(evt);
                }
            });
            txtnumero_orden2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtnumero_orden2KeyReleased(evt);
                }
            });

            jLabel32.setText("Seleccione N° de Orden:");

            jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

            javax.swing.GroupLayout imagenproduccion_corte2Layout = new javax.swing.GroupLayout(imagenproduccion_corte2);
            imagenproduccion_corte2.setLayout(imagenproduccion_corte2Layout);
            imagenproduccion_corte2Layout.setHorizontalGroup(
                imagenproduccion_corte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 247, Short.MAX_VALUE)
            );
            imagenproduccion_corte2Layout.setVerticalGroup(
                imagenproduccion_corte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
            jPanel30.setLayout(jPanel30Layout);
            jPanel30Layout.setHorizontalGroup(
                jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel30Layout.setVerticalGroup(
                jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel30Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel46.setText("N° orden:");

            txtorden_corte2.setText("_____________");

            jLabel47.setText("Nombre Cliente:");

            txtcliente_corte2.setText("_____________");

            jLabel48.setText("Fecha pedido:");

            txtfecha_corte2.setText("_____________");

            jLabel49.setText("Nombre Imagen:");

            txtimagen_corte2.setText("_____________");

            javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
            jPanel29.setLayout(jPanel29Layout);
            jPanel29Layout.setHorizontalGroup(
                jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnumero_orden2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel29Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha_corte2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel46))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente_corte2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtorden_corte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel29Layout.createSequentialGroup()
                            .addComponent(jLabel49)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtimagen_corte2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18))
            );
            jPanel29Layout.setVerticalGroup(
                jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(txtnumero_orden2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(txtorden_corte2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(txtcliente_corte2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48)
                        .addComponent(txtfecha_corte2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel49)
                        .addComponent(txtimagen_corte2))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel29Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            tabla_corte2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane7.setViewportView(tabla_corte2);

            jPanel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            jLabel50.setText("Tipo de tela :");

            jLabel51.setText("Color de tela:");

            combocolor_corte2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ROJO ", "VERDE ", "AZUL", "BLANCO ", "CYAN ", "MAGENTA ", "AMARILLO ", "NEGRO", "GRIS  ", "ROSA  ", "VIOLETA  ", "CELESTE  ", "MARRON  ", "NARANJA  ", "LAVANDA ", "TURQUESA ", "ORO VIEJO" }));

            jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas de corte"));

            jLabel52.setText("Armado en plana:");

            jLabel53.setText("Decorado en plana: ");

            jLabel54.setText("Ruedo en colaretera:");

            jLabel55.setText("Sellado:");

            jLabel56.setText("Pegado cuello:");

            jLabel57.setText("Ojal y boton:");

            asm1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
            jPanel33.setLayout(jPanel33Layout);
            jPanel33Layout.setHorizontalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel33Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addGap(22, 22, 22)))
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(asm1, 0, 68, Short.MAX_VALUE)
                                .addComponent(asm2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel54)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(asm3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(14, 14, 14)
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel55)
                            .addGap(41, 41, 41)
                            .addComponent(asm4, 0, 68, Short.MAX_VALUE)
                            .addGap(25, 25, 25))
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel56)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(asm5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(24, 24, 24))
                        .addGroup(jPanel33Layout.createSequentialGroup()
                            .addComponent(jLabel57)
                            .addGap(18, 18, 18)
                            .addComponent(asm6, 0, 68, Short.MAX_VALUE)
                            .addGap(23, 23, 23))))
            );
            jPanel33Layout.setVerticalGroup(
                jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel33Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel55)
                                .addComponent(asm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel52))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel56)
                                .addComponent(asm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel57)
                                .addComponent(asm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel54)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel33Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel53)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            cmdguardar_asm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/save_icon&16.png"))); // NOI18N
            cmdguardar_asm.setText("Guardar ");
            cmdguardar_asm.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdguardar_asmActionPerformed(evt);
                }
            });

            jLabel58.setText("Decorado:");

            javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
            jPanel32.setLayout(jPanel32Layout);
            jPanel32Layout.setHorizontalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel32Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmdguardar_asm, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(combocolor_corte2, 0, 152, Short.MAX_VALUE))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel58)
                                        .addComponent(jLabel50))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(combotela_corte2, 0, 154, Short.MAX_VALUE)
                                        .addComponent(txtasm_decorado))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(30, 30, 30))
            );
            jPanel32Layout.setVerticalGroup(
                jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addGap(0, 16, Short.MAX_VALUE)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel58)
                                .addComponent(txtasm_decorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel50)
                                .addComponent(combotela_corte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel51)
                                .addComponent(combocolor_corte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(cmdguardar_asm))
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
            jPanel31.setLayout(jPanel31Layout);
            jPanel31Layout.setHorizontalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
            );
            jPanel31Layout.setVerticalGroup(
                jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel31Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
            jPanel27.setLayout(jPanel27Layout);
            jPanel27Layout.setHorizontalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel27Layout.setVerticalGroup(
                jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Agregar Ensamble", jPanel27);

            jPanel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtnumero_orden3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtnumero_orden3ActionPerformed(evt);
                }
            });
            txtnumero_orden3.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtnumero_orden3KeyReleased(evt);
                }
            });

            jLabel59.setText("Seleccione N° de Orden:");

            jPanel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

            javax.swing.GroupLayout imagenproduccion_corte3Layout = new javax.swing.GroupLayout(imagenproduccion_corte3);
            imagenproduccion_corte3.setLayout(imagenproduccion_corte3Layout);
            imagenproduccion_corte3Layout.setHorizontalGroup(
                imagenproduccion_corte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 247, Short.MAX_VALUE)
            );
            imagenproduccion_corte3Layout.setVerticalGroup(
                imagenproduccion_corte3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
            jPanel35.setLayout(jPanel35Layout);
            jPanel35Layout.setHorizontalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel35Layout.setVerticalGroup(
                jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel35Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel60.setText("N° orden:");

            txtorden_corte3.setText("_____________");

            jLabel61.setText("Nombre Cliente:");

            txtcliente_corte3.setText("_____________");

            jLabel62.setText("Fecha pedido:");

            txtfecha_corte3.setText("_____________");

            jLabel63.setText("Nombre Imagen:");

            txtimagen_corte3.setText("_____________");

            javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
            jPanel34.setLayout(jPanel34Layout);
            jPanel34Layout.setHorizontalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(jLabel59)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnumero_orden3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha_corte3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel34Layout.createSequentialGroup()
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel60))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente_corte3, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtorden_corte3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel34Layout.createSequentialGroup()
                            .addComponent(jLabel63)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtimagen_corte3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18))
            );
            jPanel34Layout.setVerticalGroup(
                jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel59)
                        .addComponent(txtnumero_orden3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(txtorden_corte3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(txtcliente_corte3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel62)
                        .addComponent(txtfecha_corte3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(txtimagen_corte3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel34Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            tabla_corte3.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane8.setViewportView(tabla_corte3);

            jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            jLabel64.setText("Tipo de tela :");

            jLabel65.setText("Color de tela:");

            combocolor_corte3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ROJO ", "VERDE ", "AZUL", "BLANCO ", "CYAN ", "MAGENTA ", "AMARILLO ", "NEGRO", "GRIS  ", "ROSA  ", "VIOLETA  ", "CELESTE  ", "MARRON  ", "NARANJA  ", "LAVANDA ", "TURQUESA ", "ORO VIEJO" }));

            jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas de corte"));

            jLabel66.setText("Armado en plana:");

            jLabel67.setText("Decorado en plana: ");

            jLabel68.setText("Ruedo en colaretera:");

            jLabel69.setText("Sellado:");

            jLabel70.setText("Pegado cuello:");

            jLabel71.setText("Ojal y boton:");

            asm7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            asm12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

            javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
            jPanel38.setLayout(jPanel38Layout);
            jPanel38Layout.setHorizontalGroup(
                jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                    .addComponent(jLabel67)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(jPanel38Layout.createSequentialGroup()
                                    .addComponent(jLabel66)
                                    .addGap(22, 22, 22)))
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(asm7, 0, 68, Short.MAX_VALUE)
                                .addComponent(asm8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel68)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(asm9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(14, 14, 14)
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel69)
                            .addGap(41, 41, 41)
                            .addComponent(asm10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(25, 25, 25))
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel70)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(asm11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24))
                        .addGroup(jPanel38Layout.createSequentialGroup()
                            .addComponent(jLabel71)
                            .addGap(18, 18, 18)
                            .addComponent(asm12, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(23, 23, 23))))
            );
            jPanel38Layout.setVerticalGroup(
                jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel38Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel38Layout.createSequentialGroup()
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel69)
                                .addComponent(asm7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel66))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel70)
                                .addComponent(asm11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel71)
                                .addComponent(asm12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(asm9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel68)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel38Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel67)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jLabel72.setText("Decorado:");

            cmdasm_imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/print_icon&16.png"))); // NOI18N
            cmdasm_imprimir.setText("Imprimir Ensamble");
            cmdasm_imprimir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdasm_imprimirActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
            jPanel37.setLayout(jPanel37Layout);
            jPanel37Layout.setHorizontalGroup(
                jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(55, 55, 55)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combocolor_corte3, 0, 152, Short.MAX_VALUE))
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel64))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combotela_corte3, 0, 154, Short.MAX_VALUE)
                                    .addComponent(txtasm_decorado1))))
                        .addGroup(jPanel37Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(cmdasm_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE))
            );
            jPanel37Layout.setVerticalGroup(
                jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel37Layout.createSequentialGroup()
                            .addGap(0, 16, Short.MAX_VALUE)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel72)
                                .addComponent(txtasm_decorado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel64)
                                .addComponent(combotela_corte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel65)
                                .addComponent(combocolor_corte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(cmdasm_imprimir))
                        .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
            jPanel36.setLayout(jPanel36Layout);
            jPanel36Layout.setHorizontalGroup(
                jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE))
            );
            jPanel36Layout.setVerticalGroup(
                jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel36Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
            jPanel7.setLayout(jPanel7Layout);
            jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jPanel36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
            jPanel28.setLayout(jPanel28Layout);
            jPanel28Layout.setHorizontalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            jPanel28Layout.setVerticalGroup(
                jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            jTabbedPane1.addTab("Ver Ensamble", jPanel28);

            panell1.addTab("Ensamble", jTabbedPane1);
            panell1.addTab("Serigrafia", jTabbedPane3);

            jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            txtnumero_orden4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtnumero_orden4ActionPerformed(evt);
                }
            });
            txtnumero_orden4.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    txtnumero_orden4KeyReleased(evt);
                }
            });

            jLabel73.setText("Seleccione N° de Orden:");

            jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));

            javax.swing.GroupLayout imagenproduccion_corte4Layout = new javax.swing.GroupLayout(imagenproduccion_corte4);
            imagenproduccion_corte4.setLayout(imagenproduccion_corte4Layout);
            imagenproduccion_corte4Layout.setHorizontalGroup(
                imagenproduccion_corte4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 247, Short.MAX_VALUE)
            );
            imagenproduccion_corte4Layout.setVerticalGroup(
                imagenproduccion_corte4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 0, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
            jPanel41.setLayout(jPanel41Layout);
            jPanel41Layout.setHorizontalGroup(
                jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel41Layout.setVerticalGroup(
                jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel41Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(imagenproduccion_corte4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel74.setText("N° orden:");

            txtorden_corte4.setText("_____________");

            jLabel75.setText("Nombre Cliente:");

            txtcliente_corte4.setText("_____________");

            jLabel76.setText("Fecha pedido:");

            txtfecha_corte4.setText("_____________");

            jLabel77.setText("Nombre Imagen:");

            txtimagen_corte4.setText("_____________");

            javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
            jPanel40.setLayout(jPanel40Layout);
            jPanel40Layout.setHorizontalGroup(
                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel40Layout.createSequentialGroup()
                            .addComponent(jLabel73)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnumero_orden4, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addGap(18, 18, 18)
                                .addComponent(txtfecha_corte4, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel40Layout.createSequentialGroup()
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel74))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcliente_corte4, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(txtorden_corte4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel40Layout.createSequentialGroup()
                            .addComponent(jLabel77)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtimagen_corte4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(34, 34, 34)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18))
            );
            jPanel40Layout.setVerticalGroup(
                jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel73)
                        .addComponent(txtnumero_orden4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel74)
                        .addComponent(txtorden_corte4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel75)
                        .addComponent(txtcliente_corte4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel76)
                        .addComponent(txtfecha_corte4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel77)
                        .addComponent(txtimagen_corte4))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel40Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

            tabla_corte4.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            jScrollPane9.setViewportView(tabla_corte4);

            jPanel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

            jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidas de corte"));

            jLabel80.setText("Incluye :");

            jLabel81.setText("Responsable:");

            cmdguardar_empaque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/save_icon&16.png"))); // NOI18N
            cmdguardar_empaque.setText("Guardar ");
            cmdguardar_empaque.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdguardar_empaqueActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
            jPanel44.setLayout(jPanel44Layout);
            jPanel44Layout.setHorizontalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addGap(161, 161, 161)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel44Layout.createSequentialGroup()
                            .addComponent(jLabel81)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtresponsable_paquete, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                    .addComponent(jLabel80)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtincluye_paquete, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(228, 228, 228))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                    .addComponent(cmdguardar_empaque, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26))))))
            );
            jPanel44Layout.setVerticalGroup(
                jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel44Layout.createSequentialGroup()
                    .addContainerGap(16, Short.MAX_VALUE)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel80)
                                .addComponent(txtincluye_paquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel81)
                                .addComponent(txtresponsable_paquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(48, 48, 48))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                            .addComponent(cmdguardar_empaque)
                            .addContainerGap())))
            );

            javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
            jPanel43.setLayout(jPanel43Layout);
            jPanel43Layout.setHorizontalGroup(
                jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel43Layout.setVerticalGroup(
                jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel43Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
            jPanel42.setLayout(jPanel42Layout);
            jPanel42Layout.setHorizontalGroup(
                jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
            );
            jPanel42Layout.setVerticalGroup(
                jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel42Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
            jPanel39.setLayout(jPanel39Layout);
            jPanel39Layout.setHorizontalGroup(
                jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46))
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            jPanel39Layout.setVerticalGroup(
                jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel39Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(38, Short.MAX_VALUE))
            );

            jTabbedPane5.addTab("Empaque", jPanel39);

            panell1.addTab("Empaque", jTabbedPane5);

            cmd_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/app_window&16.png"))); // NOI18N
            cmd_sesion.setText("Inicio");
            cmd_sesion.setInheritsPopupMenu(true);

            cmdsesion.setText("Cerrar Sesion");
            cmdsesion.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdsesionActionPerformed(evt);
                }
            });
            cmd_sesion.add(cmdsesion);
            cmd_sesion.add(jSeparator1);

            cmd_Salir.setText("Salir");
            cmd_Salir.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_SalirActionPerformed(evt);
                }
            });
            cmd_sesion.add(cmd_Salir);

            jMenuBar1.add(cmd_sesion);

            jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/pencil_icon&16.png"))); // NOI18N
            jMenu4.setText("Propiedades");

            cmdpedido.setText("Ver Orden de pedido");
            cmdpedido.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdpedidoActionPerformed(evt);
                }
            });
            jMenu4.add(cmdpedido);

            menutelas.setText("Agregar Telas");
            menutelas.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menutelasActionPerformed(evt);
                }
            });
            jMenu4.add(menutelas);

            jMenuBar1.add(jMenu4);

            jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/user_icon&16.png"))); // NOI18N
            jMenu2.setText("Clientes");

            cmd_add_cliente.setText("Agregar clientes");
            cmd_add_cliente.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_add_clienteActionPerformed(evt);
                }
            });
            jMenu2.add(cmd_add_cliente);

            cmd_verclientes.setText("Ver clientes");
            cmd_verclientes.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmd_verclientesActionPerformed(evt);
                }
            });
            jMenu2.add(cmd_verclientes);

            jMenuBar1.add(jMenu2);

            jadministracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tatosport/imgs/wrench_icon&16.png"))); // NOI18N
            jadministracion.setText("Administracion");

            juser_contra.setText("Usuarios y contraseñas");
            juser_contra.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    juser_contraActionPerformed(evt);
                }
            });
            jadministracion.add(juser_contra);

            jMenuItem1.setText("Empleados");
            jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jMenuItem1ActionPerformed(evt);
                }
            });
            jadministracion.add(jMenuItem1);

            cmdadduser.setText("Agregar Usuario");
            cmdadduser.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cmdadduserActionPerformed(evt);
                }
            });
            jadministracion.add(cmdadduser);

            jMenuBar1.add(jadministracion);

            jMenu3.setText(" || ");
            jMenuBar1.add(jMenu3);

            menu_notificaciones.setText("Notificaciones");
            jMenuBar1.add(menu_notificaciones);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(panell1))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(panell1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            panell1.getAccessibleContext().setAccessibleName("Orden De Pedido");

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void cmdrefleshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdrefleshActionPerformed
       Cargando_datos();
    }//GEN-LAST:event_cmdrefleshActionPerformed

    private void comboclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboclienteActionPerformed
       
       String cliente_d = this.combocliente.getSelectedItem().toString();
        for(Object data : DiccionarioClientes.keySet() ){
            if(cliente_d.equals(this.DiccionarioClientes.get(data).toString())){
                this.Id_Cliente = data.toString();
                break;
            }
        }
       Data_Cliente();
    }//GEN-LAST:event_comboclienteActionPerformed

    private void comboclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboclienteKeyPressed
     
    }//GEN-LAST:event_comboclienteKeyPressed

    private void comboclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboclienteKeyReleased

    }//GEN-LAST:event_comboclienteKeyReleased

    private void comboclienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboclienteKeyTyped
      
    }//GEN-LAST:event_comboclienteKeyTyped

    private void cmd_add_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_add_clienteActionPerformed
        Frmclientes cl = new Frmclientes();
        cl.setVisible(true);
    }//GEN-LAST:event_cmd_add_clienteActionPerformed

    private void juser_contraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juser_contraActionPerformed
       FrmUsuario user = new FrmUsuario();
       user.setVisible(true);
    }//GEN-LAST:event_juser_contraActionPerformed

    private void cmdadduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdadduserActionPerformed
       frmAddUsuario add = new frmAddUsuario();
       add.setVisible(true);
    }//GEN-LAST:event_cmdadduserActionPerformed

    private void listaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaclientesMouseClicked
        String cliente_d = this.listaclientes.getSelectedValue().toString();
        for(Object data : DiccionarioClientes.keySet() ){
            if(cliente_d.equals(this.DiccionarioClientes.get(data).toString())){
                this.Id_Cliente = data.toString();
                break;
            }
        }
       Data_Cliente();
    }//GEN-LAST:event_listaclientesMouseClicked

    private void cmdpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdpedidoActionPerformed
        try {
            FrmVerPedido pedido__ = new FrmVerPedido();
            pedido__.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdpedidoActionPerformed

    private void cmd_verclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_verclientesActionPerformed
        VerClientes clientes = new VerClientes();
        clientes.setVisible(true);
    }//GEN-LAST:event_cmd_verclientesActionPerformed

    private void menutelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menutelasActionPerformed
       FrmTelas Telas = new FrmTelas();
       Telas.setVisible(true);
    }//GEN-LAST:event_menutelasActionPerformed

    private void cmd_finalizar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_finalizar_pedidoActionPerformed
        try {

            if(this.Id_Cliente == null)
            {
                JOptionPane.showMessageDialog(this, "No existe un cliente a cual anidar este pedido",
                    "Opps!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String Tpedido = Seguridad.Get_formato_fecha(this.txt_fecha_pedido.getDate());
            String Tentrega = Seguridad.Get_formato_fecha(this.txtfecha_entrega.getDate());
            if(Tpedido == null)
            {
                JOptionPane.showMessageDialog(this, "No existe fecha de pedido",
                    "Opps!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(Tentrega == null)
            {
                JOptionPane.showMessageDialog(this, "No existe fecha de entrega",
                    "Opps!", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Conexion conn = new Conexion();

            String id_pedido = "Ped" + this.lblcliente_pedido.getText().substring(0, 2);
            Random rnd = new Random();
            id_pedido +=String.valueOf(rnd.nextInt(100));
            id_pedido +=String.valueOf(rnd.nextInt(1000));
            id_pedido +=String.valueOf(rnd.nextInt(10));

            /*preparando la imagen para guardar (primer paso proceso de guardado) */
            String id_imagen = "";
            String nombre_img = "No imagen";
            if(this.archivo_design_seleccionado != null){
                nombre_img = this.archivo_design_seleccionado.getName();
                id_imagen = nombre_img
                + String.valueOf(this.archivo_design_seleccionado.length())
                + String.valueOf(rnd.nextInt(2000));
            }
            else
            {
                id_imagen = id_pedido + String.valueOf(rnd.nextInt(5000));
            }

            boolean ok_img = conn.Get_consulta_imagen(id_imagen, nombre_img, archivo_design_seleccionado);

            /*Fin de guardado imagen en su respectiva tabla*/

            /*Inicio del guardado pedido ... (segundo paso proceso guardado)*/
            conn = new Conexion();
            String registro = this.txtn_registro_pedido.getText();
            String factura = this.txtn_factura_pedido.getText();
            String nit = this.txt_nit_pedido.getText();
            String orden = this.txtn_orden_pedido.getText();
            String giro = this.txtgiro_pedido.getText();
            String fiscal = this.txt_fiscal_pedido.getText();
            int pago =0;
            if(this.opt_pago_contado_pedido.isSelected())
            pago = 0;
            else
            pago =1;

            String sql = "INSERT INTO pedidos (id_pedido , id_cliente , registro , factura , orden "
            + ", nit , giro , fiscal , fecha_pedido , fecha_entrega , id_imagen , pago)"
            + " VALUES('" + id_pedido + "','"
            + this.Id_Cliente + "','"
            + registro + "','"
            + factura + "','"
            + orden + "','"
            + nit + "','"
            + giro + "','"
            + fiscal + "','"
            + Tpedido +  "','"
            + Tentrega + "','"
            + id_imagen + "',"
            + pago + ")";
            boolean ok_pedido = conn.Get_Consulta_update(sql);
            /*finalizanco el segundo proceso
            hoy se hara el ultimo proceso que seria agregar los productos seleccionados por el cliente*/
            if(ok_pedido)
            {

                DefaultTableModel model;
                model = (DefaultTableModel) this.tabla_pedidos.getModel();
                String cantidad = "";
                String descripcion = "";
                String precio = "";
                String total = "";
                Vector vect = model.getDataVector();
                int errores =0;
                for(int i=0; i < vect.size() ; i++)
                {
                    try{
                        conn = new Conexion();
                        Object obj =vect.get(i);
                        Vector a = (Vector) obj;
                        Object[] arreglo = a.toArray();
                        if(arreglo[arreglo.length - 1] != null){

                            cantidad = arreglo[0].toString();
                            descripcion = arreglo[1].toString();
                            precio  = arreglo[2].toString();
                            total = arreglo[3].toString();

                            sql = "INSERT INTO productos (id_pedido , cantidad , descripcion , precio , total) "
                            + "VALUES ('" + id_pedido + "',"
                            + cantidad + ",'" + descripcion + "',"
                            + precio  +"," + total + ")";

                            boolean ok = conn.Get_Consulta_update(sql);
                            if(!ok)errores++;
                        }
                    }
                    catch(Exception ex){}
                }

                if(errores >= 1)
                {
                    JOptionPane.showMessageDialog(this, "Pedido registrado pero con advertencias de que algunos productos no han sido registrados",
                        "Puede que algo salio mal !", JOptionPane.WARNING_MESSAGE);
                }
                else if(!ok_img)
                {
                    JOptionPane.showMessageDialog(this, "Pedido registrado pero con advertencia de que el diseño o imagen no se ha registrado con exito",
                        "Puede que algo salio mal !", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Pedido registrado con exito y sin problemas ...",
                        "IS OK!", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | FileNotFoundException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmd_finalizar_pedidoActionPerformed

    private void cmd_eliminar_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_eliminar_pedidoActionPerformed
        try
        {
            if(this.RowIndex != -1)
            {
                DefaultTableModel model;
                model = (DefaultTableModel) this.tabla_pedidos.getModel();
                model.removeRow(this.RowIndex);
            }
        }catch(Exception ex){}
    }//GEN-LAST:event_cmd_eliminar_pedidoActionPerformed

    private void cmd_add_jtabla_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_add_jtabla_pedidoActionPerformed
        DefaultTableModel model;
        model = (DefaultTableModel) this.tabla_pedidos.getModel();
        model.addRow(new Object[]{ null, null , null, null } );
    }//GEN-LAST:event_cmd_add_jtabla_pedidoActionPerformed

    private void tabla_pedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_pedidosMouseClicked

        this.RowIndex = this.tabla_pedidos.getSelectedRow();
        try{
            this.lblfila_pedido.setText(String.valueOf(this.RowIndex));
            this.lblcantidad_pedido.setText(this.tabla_pedidos.getValueAt(this.RowIndex, 0).toString());
            this.lbldescripcion_pedido.setText(this.tabla_pedidos.getValueAt(this.RowIndex, 1).toString());
        }catch(Exception ex)
        {

        }
    }//GEN-LAST:event_tabla_pedidosMouseClicked

    private void cmdimagene_seleccionada_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdimagene_seleccionada_pedidoActionPerformed
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        selector.setFileFilter(filtro);
        int resultado = selector.showOpenDialog(this);
        if(resultado == JFileChooser.APPROVE_OPTION )
        {
            archivo_design_seleccionado = selector.getSelectedFile();
            try {
                long peso = this.archivo_design_seleccionado.length();
                if(peso > 2097152)
                {
                    JOptionPane.showMessageDialog(this, "Solo se aceptan archivos menores o iguales a 2mb",
                        "Opps!", JOptionPane.ERROR_MESSAGE);
                }
                else
                this.vistaimagen.setImage(archivo_design_seleccionado );

            } catch (IOException ex) {
                Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cmdimagene_seleccionada_pedidoActionPerformed

    private void opt_pago_contado_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_pago_contado_pedidoActionPerformed
        Opt_pedido_activacion(0);
    }//GEN-LAST:event_opt_pago_contado_pedidoActionPerformed

    private void opt_pago_credito_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt_pago_credito_pedidoActionPerformed
        Opt_pedido_activacion(1);
    }//GEN-LAST:event_opt_pago_credito_pedidoActionPerformed

    private void txtnumero_ordenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_ordenKeyReleased
        Orden orden;
        Seguridad seguridad = new Seguridad();
        try {
            int i;
            orden = new Orden();
            this.ListaClientePedido = orden.Get_ClienteOrden(this.txtnumero_orden.getText());
            if(this.ListaClientePedido.size() <= 0)
            {
                this.txtorden_corte.setText("__________");
                this.txtcliente_corte.setText("__________");
                this.txtfecha_corte.setText("__________");
                this.txtimagen_corte.setText("__________");
                   Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
                this.imagenproduccion_corte.setImage(img);
            }else{
                this.txtorden_corte.setText(this.ListaClientePedido.get(1).toString());
                this.txtcliente_corte.setText(this.ListaClientePedido.get(2).toString());
                this.txtfecha_corte.setText(this.ListaClientePedido.get(3).toString());
                this.txtimagen_corte.setText(this.ListaClientePedido.get(4).toString());
                byte[] Mbit = (byte[]) this.ListaClientePedido.get(5);
                this.imagenproduccion_corte.setImage(seguridad.ConvertidorByteImg(Mbit));
            }
            
            this.Get_DescripcionProductos(this.tabla_corte);
            this.ListaTelas = orden.GetListaTela();
            if(this.combotela_corte.getItemCount() >= 1) this.combotela_corte.removeAllItems();
            for(i=0 ; i < this.ListaTelas.size() ; i++)
                this.combotela_corte.addItem(this.ListaTelas.get(i));
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
            this.imagenproduccion_corte.setImage(img);
        }
         
    }//GEN-LAST:event_txtnumero_ordenKeyReleased

    private void txtnumero_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_ordenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_ordenActionPerformed

       /*`id_corte`, `id_tela`, `id_pedido`, `color`, `Mcuello`, `Mescote`, `Mpuno`, `Mfranjas`, `Mvenas`, `Melastico`*/
    private void cmdguardar_corteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdguardar_corteActionPerformed
        try {
            
            
            int dialog = JOptionPane.showConfirmDialog(this 
                    , "¿desea continuar con el corte de pedido? "
                    , "Corte pedido" , JOptionPane.YES_NO_OPTION);
            if(dialog >=1) return;
            
            Pedidos pedido = new Pedidos();
            
            if(pedido.CorteRealizado(this.ListaClientePedido.get(0).toString()))
            {
                JOptionPane.showMessageDialog(this, "Este pedido ya tiene una produccion de corte", 
                "Ya existe este corte !", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String tela = this.combotela_corte.getSelectedItem().toString();
            String[] data_tela = tela.split("-");
            tela = data_tela[0];
            
            ArrayList ListaCorte = new ArrayList();
            ArrayList ListaTalla = new ArrayList();
           
            ListaCorte.add(tela);
            ListaCorte.add(this.ListaClientePedido.get(0));
            ListaCorte.add(this.combocolor_corte.getSelectedItem().toString());
            ListaCorte.add(this.txtcorte_cuello.getText());
            ListaCorte.add(this.txtcorte_ecotecuello.getText());
            ListaCorte.add(this.txtcorte_puno.getText());
            ListaCorte.add(this.txtcorte_franjas.getText());
            ListaCorte.add(this.txtcorte_venas.getText());
            ListaCorte.add(this.txtcorte_elastico.getText());
            
            DefaultTableModel dt = (DefaultTableModel) this.tabla_corte.getModel();
            for(int i =0; i < dt.getRowCount() ; i++)
                ListaTalla.add(dt.getValueAt(i, 0).toString() + "-" +dt.getValueAt(i, 3).toString());
           
            boolean ok = pedido.GuardarCorte(ListaCorte, ListaTalla);
            if(ok)
                JOptionPane.showMessageDialog(this, "Los datos de produccion de corte se guardaron con exito", 
                "Corte creado!", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Algo malo paso , no se guardaron los datos", 
                "Opps!", JOptionPane.ERROR_MESSAGE);
            
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdguardar_corteActionPerformed

    private void txtnumero_orden1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_orden1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_orden1ActionPerformed

    private void txtnumero_orden1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_orden1KeyReleased
        
        Orden orden;
        Seguridad seguridad = new Seguridad();
        try {
            int i;
            orden = new Orden();
            this.ListaClientePedido = orden.Get_ClienteOrden(this.txtnumero_orden1.getText());
           
            if(this.ListaClientePedido.size() <= 0)
            {
                this.txtorden_corte1.setText("__________");
                this.txtcliente_corte1.setText("__________");
                this.txtfecha_corte1.setText("__________");
                this.txtimagen_corte1.setText("__________");
                   Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
                this.imagenproduccion_corte1.setImage(img);
                this.txtcorte_cuello1.setText("");
                this.txtcorte_ecotecuello1.setText("");
                this.txtcorte_puno1.setText("");
                this.txtcorte_franjas1.setText("");
                this.txtcorte_venas1.setText("");
                this.txtcorte_elastico1.setText("");
            }else{
                this.txtorden_corte1.setText(this.ListaClientePedido.get(1).toString());
                this.txtcliente_corte1.setText(this.ListaClientePedido.get(2).toString());
                this.txtfecha_corte1.setText(this.ListaClientePedido.get(3).toString());
                this.txtimagen_corte1.setText(this.ListaClientePedido.get(4).toString());
                byte[] Mbit = (byte[]) this.ListaClientePedido.get(5);
                this.imagenproduccion_corte1.setImage(seguridad.ConvertidorByteImg(Mbit));
            }
            
            this.Get_DescripcionProductos(this.tabla_corte1 , 0);
            this.ListaTelas = orden.GetListaTela();
            
            if(this.combotela_corte1.getItemCount() >= 1) this.combotela_corte1.removeAllItems();
            for(i=0 ; i < this.ListaTelas.size() ; i++)
                this.combotela_corte1.addItem(this.ListaTelas.get(i));
            
            this.ListaCortePedido = orden.GetCorteByPedido(this.ListaClientePedido.get(0).toString());
            
            if(this.ListaCortePedido.isEmpty()) return;
            
            this.txtcorte_id.setVisible(false);
            this.txtcorte_id.setText(this.ListaCortePedido.get(0).toString());

            this.combotela_corte1.setSelectedItem(this.ListaCortePedido.get(1));
            this.combocolor_corte1.setSelectedItem(this.ListaCortePedido.get(3));
            this.txtcorte_cuello1.setText(this.ListaCortePedido.get(4).toString());
            this.txtcorte_ecotecuello1.setText(this.ListaCortePedido.get(5).toString());
            this.txtcorte_puno1.setText(this.ListaCortePedido.get(6).toString());
            this.txtcorte_franjas1.setText(this.ListaCortePedido.get(7).toString());
            this.txtcorte_venas1.setText(this.ListaCortePedido.get(8).toString());
            this.txtcorte_elastico1.setText(this.ListaCortePedido.get(9).toString());
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
            this.imagenproduccion_corte1.setImage(img);
        }
    }//GEN-LAST:event_txtnumero_orden1KeyReleased

    private void cmdcorte_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcorte_editarActionPerformed
       
         try {
            
            
            int dialog = JOptionPane.showConfirmDialog(this 
                    , "¿desea continuar con la edicion corte de pedido? "
                    , "Corte pedido" , JOptionPane.YES_NO_OPTION);
            if(dialog >=1) return;
            
            Pedidos pedido = new Pedidos();
            
            String tela = this.combotela_corte1.getSelectedItem().toString();
            String[] data_tela = tela.split("-");
            String id_corte = this.txtcorte_id.getText();
            tela = data_tela[0];
            
            ArrayList ListaCorte = new ArrayList();
            ArrayList ListaTalla = new ArrayList();
           
            ListaCorte.add(tela);
            ListaCorte.add(this.ListaClientePedido.get(0));
            ListaCorte.add(this.combocolor_corte1.getSelectedItem().toString());
            ListaCorte.add(this.txtcorte_cuello1.getText());
            ListaCorte.add(this.txtcorte_ecotecuello1.getText());
            ListaCorte.add(this.txtcorte_puno1.getText());
            ListaCorte.add(this.txtcorte_franjas1.getText());
            ListaCorte.add(this.txtcorte_venas1.getText());
            ListaCorte.add(this.txtcorte_elastico1.getText());
            
            DefaultTableModel dt = (DefaultTableModel) this.tabla_corte1.getModel();
            for(int i =0; i < dt.getRowCount() ; i++)
                ListaTalla.add(dt.getValueAt(i, 0).toString() + "-" +dt.getValueAt(i, 3).toString());
           
            boolean ok = pedido.ActualizaCorte(ListaCorte, ListaTalla , id_corte);
            if(ok)
                JOptionPane.showMessageDialog(this, "Los datos de produccion de corte se actualizaron con exito", 
                "Corte creado!", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Algo malo paso , no se guardaron los datos", 
                "Opps!", JOptionPane.ERROR_MESSAGE);
            
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdcorte_editarActionPerformed

    private void cmdcorte_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcorte_imprimirActionPerformed
       
        
        PdfCreador pdf = new PdfCreador();
        DefaultTableModel model = (DefaultTableModel) this.tabla_corte1.getModel();
        int rows = model.getRowCount();
        int col = model.getColumnCount();
        String[][] DatosEnviar = new String[rows][col];
        
        for(int i=0; i < rows ; i++)
            for(int j =0; j < col ; j++)
                 DatosEnviar[i][j] = model.getValueAt(i, j).toString();
        try {
            pdf.SetArregloDatosToPdf(DatosEnviar ,  
                    new String [] { "Cantidad", "Descripcion", "Precio", "Total", "Talla"});
            
            ArrayList ListaAntesDe = new ArrayList();
            ArrayList ListaDespuesDe = new ArrayList();
            
            ListaAntesDe.add("Ficha Produccion de corte ");
            ListaAntesDe.add(" ");
            ListaAntesDe.add(" ");
            ListaAntesDe.add("N° Orden : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add("Cliente : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add("Fecha Pedido : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add(" ");
            ListaAntesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add("Tallas  ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add("Cuello : " 
                    + this.txtcorte_cuello1.getText() + " Franjas :" + this.txtcorte_franjas1.getText() );
           ListaDespuesDe.add("Escote Cuello : " 
                    + this.txtcorte_ecotecuello1.getText() + " Venas :" + this.txtcorte_venas1.getText());
           ListaDespuesDe.add("Puño : " 
                    + this.txtcorte_elastico1.getText() + " Elastico :" + this.txtcorte_elastico1.getText() );
            
           
            pdf.SetDatosEncabezado(ListaAntesDe);
            pdf.SetDatosPiedePagina(ListaDespuesDe);
            pdf.Crear_PDF("Produccion de corte", ""
            , ""
            , ""
            , "");
            pdf.Imprimir();
         
        } catch (DocumentException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdcorte_imprimirActionPerformed

    private void txtnumero_orden2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_orden2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_orden2ActionPerformed

    
    
    private void txtnumero_orden2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_orden2KeyReleased
         Orden orden;
        Seguridad seguridad = new Seguridad();
        try {
            int i;
            orden = new Orden();
            this.ListaClientePedido = orden.Get_ClienteOrden(this.txtnumero_orden2.getText());
           
            if(this.ListaClientePedido.size() <= 0)
            {
                this.txtorden_corte2.setText("__________");
                this.txtcliente_corte2.setText("__________");
                this.txtfecha_corte2.setText("__________");
                this.txtimagen_corte2.setText("__________");
                   Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
                this.imagenproduccion_corte2.setImage(img);
            }else{
                this.txtorden_corte2.setText(this.ListaClientePedido.get(1).toString());
                this.txtcliente_corte2.setText(this.ListaClientePedido.get(2).toString());
                this.txtfecha_corte2.setText(this.ListaClientePedido.get(3).toString());
                this.txtimagen_corte2.setText(this.ListaClientePedido.get(4).toString());
                byte[] Mbit = (byte[]) this.ListaClientePedido.get(5);
                this.imagenproduccion_corte2.setImage(seguridad.ConvertidorByteImg(Mbit));
            }
            
            this.Get_DescripcionProductos(this.tabla_corte2 , 0);
            this.ListaTelas = orden.GetListaTela();
            
            if(this.combotela_corte2.getItemCount() >= 1) this.combotela_corte2.removeAllItems();
            for(i=0 ; i < this.ListaTelas.size() ; i++)
                this.combotela_corte2.addItem(this.ListaTelas.get(i));
            
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
            this.imagenproduccion_corte1.setImage(img);
        }
    }//GEN-LAST:event_txtnumero_orden2KeyReleased

    private void cmdguardar_asmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdguardar_asmActionPerformed
        try { 
            int dialog = JOptionPane.showConfirmDialog(this
                    , "¿desea continuar con produccion de area ensamble ? "
                    , "Ensamble pedido" , JOptionPane.YES_NO_OPTION);
            if(dialog >=1) return;
            
            if(new Pedidos().EnsambleRealizado(ListaClientePedido.get(0).toString())){
                JOptionPane.showMessageDialog(this, "Ya se hizo un ensamble a este pedido", 
                "Ensamble creado!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String id_tela = ((String[]) this.combotela_corte2.getSelectedItem().toString().split("-"))[0].toString();
            String id_pedido = ListaClientePedido.get(0).toString();
            String ensamble ="";
            ensamble += this.asm1.getSelectedItem().toString() + "-";
            ensamble += this.asm2.getSelectedItem().toString() + "-";
            ensamble += this.asm3.getSelectedItem().toString() + "-";
            ensamble += this.asm4.getSelectedItem().toString() + "-";
            ensamble += this.asm5.getSelectedItem().toString() + "-";
            ensamble += this.asm6.getSelectedItem().toString() + "";
            String decorado = this.txtasm_decorado.getText();
            String color = this.combocolor_corte2.getSelectedItem().toString();
            try {
                // id_tela, id_pedido, color, procedimiento,decorado
                boolean ASM_OK = new Pedidos().GuardarEnsamble(id_tela , id_pedido , color, ensamble , decorado );
                if(ASM_OK)
                JOptionPane.showMessageDialog(this, "Los datos de produccion de ensamble se actualizaron con exito", 
                "Ensamble creado!", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Algo malo paso , no se guardaron los datos", 
                "Opps!", JOptionPane.ERROR_MESSAGE);
                
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_cmdguardar_asmActionPerformed

    private void txtnumero_orden3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_orden3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_orden3ActionPerformed

    private void txtnumero_orden3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_orden3KeyReleased
        Orden orden;
        Seguridad seguridad = new Seguridad();
        try {
            int i;
            orden = new Orden();
            this.ListaClientePedido = orden.Get_ClienteOrden(this.txtnumero_orden3.getText());
            if(this.ListaClientePedido.size() <= 0)
            {
                this.txtorden_corte3.setText("__________");
                this.txtcliente_corte3.setText("__________");
                this.txtfecha_corte3.setText("__________");
                this.txtimagen_corte3.setText("__________");
                   Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
                this.imagenproduccion_corte3.setImage(img);
            }else{
                this.txtorden_corte3.setText(this.ListaClientePedido.get(1).toString());
                this.txtcliente_corte3.setText(this.ListaClientePedido.get(2).toString());
                this.txtfecha_corte3.setText(this.ListaClientePedido.get(3).toString());
                this.txtimagen_corte3.setText(this.ListaClientePedido.get(4).toString());
                byte[] Mbit = (byte[]) this.ListaClientePedido.get(5);
                this.imagenproduccion_corte3.setImage(seguridad.ConvertidorByteImg(Mbit));
            }
            
            this.ListaEnsamblePedido = orden.GetEnsambleByPedido(this.ListaClientePedido.get(0).toString());
            String[] procedimiento = this.ListaEnsamblePedido.get(4).toString().split("-");
            try{
                this.asm7.setSelectedItem(procedimiento[0].toString());
                 this.asm8.setSelectedItem(procedimiento[1].toString());
                  this.asm9.setSelectedItem(procedimiento[2].toString());
                   this.asm10.setSelectedItem(procedimiento[3].toString());
                    this.asm11.setSelectedItem(procedimiento[4].toString());
                     this.asm12.setSelectedItem(procedimiento[5].toString());
            }catch(Exception ex){}
            
            this.combocolor_corte3.setSelectedItem(this.ListaEnsamblePedido.get(3).toString());
            this.Get_DescripcionProductos(this.tabla_corte3 , 0);
            this.ListaTelas = orden.GetListaTela();
            
            if(this.combotela_corte3.getItemCount() >= 1) this.combotela_corte.removeAllItems();
            for(i=0 ; i < this.ListaTelas.size() ; i++)
                this.combotela_corte3.addItem(this.ListaTelas.get(i));
            
            this.combotela_corte3.setSelectedItem(this.ListaEnsamblePedido.get(1).toString());
            this.txtasm_decorado1.setText(this.ListaEnsamblePedido.get(5).toString());
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
            this.imagenproduccion_corte3.setImage(img);
        }
    }//GEN-LAST:event_txtnumero_orden3KeyReleased

    private void cmdasm_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdasm_imprimirActionPerformed
        PdfCreador pdf = new PdfCreador();
        DefaultTableModel model = (DefaultTableModel) this.tabla_corte1.getModel();
        int rows = model.getRowCount();
        int col = model.getColumnCount();
        String[][] DatosEnviar = new String[rows][col];
        
        for(int i=0; i < rows ; i++)
            for(int j =0; j < col ; j++)
                 DatosEnviar[i][j] = model.getValueAt(i, j).toString();

            try {
                pdf.SetArregloDatosToPdf(DatosEnviar ,
                        new String [] { "Cantidad", "Descripcion", "Precio", "Total", "Talla"});
            } catch (DocumentException ex) {
                Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ArrayList ListaAntesDe = new ArrayList();
            ArrayList ListaDespuesDe = new ArrayList();
            
            ListaAntesDe.add("Ficha Produccion Ensable ");
            ListaAntesDe.add(" ");
            ListaAntesDe.add(" ");
            ListaAntesDe.add("N° Orden : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add("Cliente : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add("Fecha Pedido : " + this.txtorden_corte1.getText() + "");
            ListaAntesDe.add(" ");
            ListaAntesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add("Medidas  ");
            ListaDespuesDe.add(" ");
            ListaDespuesDe.add("Armado en planas : " 
                    + this.asm7.getSelectedItem().toString() + "        Sellado: " 
                    + this.asm10.getSelectedItem().toString() );
            ListaDespuesDe.add("Decorado en planas : " 
                    + this.asm8.getSelectedItem().toString() + "        Pegado en cuello: " 
                    + this.asm11.getSelectedItem().toString() );
            ListaDespuesDe.add("Ruedo en colaretera : " 
                    + this.asm9.getSelectedItem().toString() + "        Ojal y Boton: " 
                    + this.asm12.getSelectedItem().toString() );
            
            ListaDespuesDe.add("Decorado: " + this.txtasm_decorado1.getText() );
            ListaDespuesDe.add("Tipo de tela: " + this.combotela_corte3.getSelectedItem().toString() );
            ListaDespuesDe.add("Color: " + this.combocolor_corte3.getSelectedItem().toString() );
            
            pdf.SetDatosEncabezado(ListaAntesDe);
            pdf.SetDatosPiedePagina(ListaDespuesDe);
            pdf.Crear_PDF("Produccion de corte", ""
            , ""
            , ""
            , "");
            pdf.Imprimir();
    }//GEN-LAST:event_cmdasm_imprimirActionPerformed

    private void cmd_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmd_SalirActionPerformed

    private void cmdsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsesionActionPerformed
        Seguridad.Set_privilegios(0);
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cmdsesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmEmpleado empleado = new FrmEmpleado();
        empleado.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void txtnumero_orden4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumero_orden4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumero_orden4ActionPerformed

    private void txtnumero_orden4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumero_orden4KeyReleased
        Orden orden;
        Seguridad seguridad = new Seguridad();
        try {
            int i;
            orden = new Orden();
            this.ListaClientePedido = orden.Get_ClienteOrden(this.txtnumero_orden4.getText());
           
            if(this.ListaClientePedido.size() <= 0)
            {
                this.txtorden_corte4.setText("__________");
                this.txtcliente_corte4.setText("__________");
                this.txtfecha_corte4.setText("__________");
                this.txtimagen_corte4.setText("__________");
                   Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
                this.imagenproduccion_corte4.setImage(img);
            }else{
                this.txtorden_corte4.setText(this.ListaClientePedido.get(1).toString());
                this.txtcliente_corte4.setText(this.ListaClientePedido.get(2).toString());
                this.txtfecha_corte4.setText(this.ListaClientePedido.get(3).toString());
                this.txtimagen_corte4.setText(this.ListaClientePedido.get(4).toString());
                byte[] Mbit = (byte[]) this.ListaClientePedido.get(5);
                this.imagenproduccion_corte4.setImage(seguridad.ConvertidorByteImg(Mbit));
            }
            
            this.Get_DescripcionProductos(this.tabla_corte4 , 0);
         

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Image img =  new ImageIcon( 
                       getClass().getResource("img_no.jpg")
              ).getImage();
            this.imagenproduccion_corte1.setImage(img);
        }
    }//GEN-LAST:event_txtnumero_orden4KeyReleased

    private void cmdguardar_empaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdguardar_empaqueActionPerformed
        try { 
            int dialog = JOptionPane.showConfirmDialog(this
                    , "¿desea continuar con el Empaquetado del pedido? "
                    , "Empaque pedido" , JOptionPane.YES_NO_OPTION);
            if(dialog >=1) return;
            
            boolean ok = false;
            try {
                ok = new Pedidos().GuardarEmpaque(this.ListaClientePedido.get(0).toString()
                        , this.txtincluye_paquete.getText() , this.txtresponsable_paquete.getText());
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(ok)
                JOptionPane.showMessageDialog(this, "Paquete realizado con exito   ",
                        "Muy bien !", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Algo malo ocurrio", 
                        "oops !", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdguardar_empaqueActionPerformed

    
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
            java.util.logging.Logger.getLogger(OrdenPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OrdenPedido().setVisible(true);
                
            }
        });
    }
    
    
    private void Opt_pedido_activacion(int seleccion)
    {
        switch(seleccion)
        {
            case 0:
                this.opt_pago_contado_pedido.setSelected(true);
                this.opt_pago_credito_pedido.setSelected(false);
                break;
            case 1:
                this.opt_pago_contado_pedido.setSelected(false);
                this.opt_pago_credito_pedido.setSelected(true);
                break;
        }
        
    }
    
    /*Da inicio a los datos */
    private void Cargando_datos()
    {
        try {
            
           DefaultComboBoxModel model = new DefaultComboBoxModel();

            if(this.DiccionarioClientes != null)
                if(this.DiccionarioClientes.size() >=1)
                    this.DiccionarioClientes.clear();
                        
            this.DiccionarioClientes = new Clientes().Get_clientes();
            
            for(Object data : DiccionarioClientes.keySet() ){
                if(this.Id_Cliente == null)
                    this.Id_Cliente = data.toString();
               // this.combocliente.addItem(this.DiccionarioClientes.get(data).toString());
                model.addElement(this.DiccionarioClientes.get(data).toString());
            }
            
            try{
               Image img = new ImageIcon( 
                       getClass().getResource("img_no.jpg")
               ).getImage();
               
               this.vistaimagen.setImage(img);
            }
            catch(Exception ex)
            {}
            
            this.combocliente.setModel(model);
            AutoCompleteDecorator.decorate(combocliente);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Obtiene los datos principales de los clientes por medio de la clase clientes*/
    private void Data_Cliente()
    {
        try {
            lista_cliente_id = new Clientes().Get_clientes_byId(Id_Cliente);
            
            this.txtnombre.setText(lista_cliente_id.getItem(1).toString() + "," + lista_cliente_id.getItem(0).toString());
            this.txtdireccion.setText(lista_cliente_id.getItem(2).toString());
            this.txtoficina.setText(lista_cliente_id.getItem(3));
            this.nit_cliente_seleccionado = this.lista_cliente_id.getItem(6);
            this.fiscal_cliente_seleccionado = this.lista_cliente_id.getItem(7);
            this.direccion_cliente_seleccionado = this.txtdireccion.getText();
            this.nombre_clientes_seleccionado = lista_cliente_id.getItem(1).toString() 
                    + " , " 
                    + lista_cliente_id.getItem(0).toString();
            this.txt_nit_pedido.setText(this.nit_cliente_seleccionado);
            this.txt_fiscal_pedido.setText(this.fiscal_cliente_seleccionado);
            this.lblcliente_pedido.setText(this.nombre_clientes_seleccionado);
            this.opt_pago_contado_pedido.setSelected(true);
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*Verifica quienes son los clientes que mas compran*/
    private void TopClientes()
    {
        try {
            Conexion conn = new Conexion();
            String sql = "SELECT CONCAT(clientes.apellido , ',' , clientes.nombre) as Clientes , count(pedidos.id_cliente) as 'Total' " +
            "FROM pedidos RIGHT JOIN clientes ON pedidos.id_cliente=clientes.id_cliente GROUP BY pedidos.id_cliente";
            ResultSet rs = conn.Get_Consulta(sql);
            
            DefaultListModel modelo = new DefaultListModel();
            this.listaclientes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            this.listaclientes.setLayoutOrientation(JList.VERTICAL_WRAP);
           
            int CantMayor=0;
            int CantMenor=0;
            
            while(rs.next())
            {
                 if(CantMayor <= rs.getInt(2))
                     CantMayor = rs.getInt(2);
                 else if(CantMayor >= rs.getInt(2))
                     CantMenor = rs.getInt(2);
            }
            rs.first();
            
            int ValorAprox =0;
            try{
               ValorAprox = Math.round((CantMayor/CantMenor));
            }
            catch(Exception ex)
            {
                ValorAprox = 1;
            }
            
            while(rs.next())
            {
                int C = rs.getInt(2);
                String data = rs.getString(1);
                if(C>=ValorAprox)
                    modelo.addElement(data);
            }
            this.listaclientes.setModel(modelo);
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
    /*Temporiza la tabla de orden de pedido , cuando se obtenga la cantidad y 
         el valor unitario se obtendra el valor total*/
    private void TemporizadorTablaPedido()
    {
       Timer timer = new Timer (500, new ActionListener () 
       { 
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
              try{
                    if(RowIndex != -1)
                    {
                        if(tabla_pedidos.getValueAt(RowIndex, 0) != null && tabla_pedidos.getValueAt(RowIndex, 2) != null)
                        {
                            int cant = Integer.parseInt(tabla_pedidos.getValueAt(RowIndex,0).toString());
                            double precio = Double.valueOf(tabla_pedidos.getValueAt(RowIndex, 2).toString());
                            double total = cant * precio;
                            tabla_pedidos.setValueAt(total, RowIndex, 3);
                        }
                    }
                }
                catch(NumberFormatException ex)
                {
                    
                }
            } 
       });
       timer.start();
    }
    
    
    /*Funcion muy importante en cuestion de que por medio de la tabla seleccionada
      generara los datos necesarios apra luego asi hacer la funcion completar por medio 
      del usuario los demas datos en este caso el dato no complementado es la talla*/
    private void Get_DescripcionProductos(JTable Tabla , int... Prod) 
    {
        try {
        if(Prod.length == 0){
            DefaultTableModel ModeloGenerico = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "Codigo",
                        "Producto",
                        "Cantidad",
                        "Talla"
                    }
            );
            if(this.ListaClientePedido.size() <=0)return;
            String id_pedido = this.ListaClientePedido.get(0).toString();
            ArrayList AListProd = new Orden().GetProductosbyPedido(id_pedido);
            for(int i =0; i < AListProd.size() ; i++)
            {
                Object[] obj = (Object[]) AListProd.get(i);
                Object[] ObjProd = new Object[]
                {
                     obj[0],
                     obj[1],
                     obj[2],
                     " "
                };
                ModeloGenerico.addRow(ObjProd);
            }
            Tabla.setModel(ModeloGenerico);
          }
          else
         {
                   DefaultTableModel ModeloGenerico = new DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "Codigo",
                        "Producto",
                        "Cantidad",
                        "Talla"
                    }
            );
            if(this.ListaClientePedido.size() <=0)return;
            String id_pedido = this.ListaClientePedido.get(0).toString();
            ArrayList AListProd = new Pedidos().Get_ProductosCorteByPedidos(id_pedido);
            for(int i =0; i < AListProd.size() ; i++)
            {
                Object[] obj = (Object[]) AListProd.get(i);
                Object[] ObjProd = new Object[]
                {
                     obj[0],
                     obj[1],
                     obj[2],
                     obj[3],
                };
                ModeloGenerico.addRow(ObjProd);
            }
            Tabla.setModel(ModeloGenerico);
         }
            
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrdenPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private tatosport.AddCliente addCliente2;
    private javax.swing.JComboBox asm1;
    private javax.swing.JComboBox asm10;
    private javax.swing.JComboBox asm11;
    private javax.swing.JComboBox asm12;
    private javax.swing.JComboBox asm2;
    private javax.swing.JComboBox asm3;
    private javax.swing.JComboBox asm4;
    private javax.swing.JComboBox asm5;
    private javax.swing.JComboBox asm6;
    private javax.swing.JComboBox asm7;
    private javax.swing.JComboBox asm8;
    private javax.swing.JComboBox asm9;
    private javax.swing.JMenuItem cmd_Salir;
    private javax.swing.JMenuItem cmd_add_cliente;
    private javax.swing.JButton cmd_add_jtabla_pedido;
    private javax.swing.JButton cmd_eliminar_pedido;
    private javax.swing.JButton cmd_finalizar_pedido;
    private javax.swing.JMenu cmd_sesion;
    private javax.swing.JMenuItem cmd_verclientes;
    private javax.swing.JMenuItem cmdadduser;
    private javax.swing.JButton cmdasm_imprimir;
    private javax.swing.JButton cmdcorte_editar;
    private javax.swing.JButton cmdcorte_imprimir;
    private javax.swing.JButton cmdguardar_asm;
    private javax.swing.JButton cmdguardar_corte;
    private javax.swing.JButton cmdguardar_empaque;
    private javax.swing.JButton cmdimagene_seleccionada_pedido;
    private javax.swing.JMenuItem cmdpedido;
    private javax.swing.JButton cmdreflesh;
    private javax.swing.JMenuItem cmdsesion;
    private javax.swing.JComboBox combocliente;
    private javax.swing.JComboBox combocolor_corte;
    private javax.swing.JComboBox combocolor_corte1;
    private javax.swing.JComboBox combocolor_corte2;
    private javax.swing.JComboBox combocolor_corte3;
    private javax.swing.JComboBox combotela_corte;
    private javax.swing.JComboBox combotela_corte1;
    private javax.swing.JComboBox combotela_corte2;
    private javax.swing.JComboBox combotela_corte3;
    private tatosport.FrmVerPedido frmVerPedido1;
    private org.jdesktop.swingx.JXImageView imagenproduccion_corte;
    private org.jdesktop.swingx.JXImageView imagenproduccion_corte1;
    private org.jdesktop.swingx.JXImageView imagenproduccion_corte2;
    private org.jdesktop.swingx.JXImageView imagenproduccion_corte3;
    private org.jdesktop.swingx.JXImageView imagenproduccion_corte4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextArea jTextArea1;
    private org.jdesktop.swingx.JXFrame jXFrame1;
    private javax.swing.JMenu jadministracion;
    private javax.swing.JMenuItem juser_contra;
    private javax.swing.JLabel lblcantidad_pedido;
    private javax.swing.JLabel lblcliente_pedido;
    private javax.swing.JLabel lbldescripcion_pedido;
    private javax.swing.JLabel lblfila_pedido;
    private javax.swing.JList listaclientes;
    private javax.swing.JMenu menu_notificaciones;
    private javax.swing.JMenuItem menutelas;
    private javax.swing.JRadioButton opt_pago_contado_pedido;
    private javax.swing.JRadioButton opt_pago_credito_pedido;
    private javax.swing.JTabbedPane panell1;
    private javax.swing.JTable tabla_corte;
    private javax.swing.JTable tabla_corte1;
    private javax.swing.JTable tabla_corte2;
    private javax.swing.JTable tabla_corte3;
    private javax.swing.JTable tabla_corte4;
    private javax.swing.JTable tabla_pedidos;
    private org.jdesktop.swingx.JXDatePicker txt_fecha_pedido;
    private javax.swing.JTextField txt_fiscal_pedido;
    private javax.swing.JFormattedTextField txt_nit_pedido;
    private javax.swing.JTextField txtasm_decorado;
    private javax.swing.JTextField txtasm_decorado1;
    private javax.swing.JLabel txtcliente_corte;
    private javax.swing.JLabel txtcliente_corte1;
    private javax.swing.JLabel txtcliente_corte2;
    private javax.swing.JLabel txtcliente_corte3;
    private javax.swing.JLabel txtcliente_corte4;
    private javax.swing.JTextField txtcorte_cuello;
    private javax.swing.JTextField txtcorte_cuello1;
    private javax.swing.JTextField txtcorte_ecotecuello;
    private javax.swing.JTextField txtcorte_ecotecuello1;
    private javax.swing.JTextField txtcorte_elastico;
    private javax.swing.JTextField txtcorte_elastico1;
    private javax.swing.JTextField txtcorte_franjas;
    private javax.swing.JTextField txtcorte_franjas1;
    private javax.swing.JLabel txtcorte_id;
    private javax.swing.JTextField txtcorte_puno;
    private javax.swing.JTextField txtcorte_puno1;
    private javax.swing.JTextField txtcorte_venas;
    private javax.swing.JTextField txtcorte_venas1;
    private javax.swing.JLabel txtdireccion;
    private javax.swing.JLabel txtfecha_corte;
    private javax.swing.JLabel txtfecha_corte1;
    private javax.swing.JLabel txtfecha_corte2;
    private javax.swing.JLabel txtfecha_corte3;
    private javax.swing.JLabel txtfecha_corte4;
    private org.jdesktop.swingx.JXDatePicker txtfecha_entrega;
    private javax.swing.JTextField txtgiro_pedido;
    private javax.swing.JLabel txtimagen_corte;
    private javax.swing.JLabel txtimagen_corte1;
    private javax.swing.JLabel txtimagen_corte2;
    private javax.swing.JLabel txtimagen_corte3;
    private javax.swing.JLabel txtimagen_corte4;
    private javax.swing.JTextField txtincluye_paquete;
    private javax.swing.JTextField txtn_factura_pedido;
    private javax.swing.JTextField txtn_orden_pedido;
    private javax.swing.JTextField txtn_registro_pedido;
    private javax.swing.JLabel txtnombre;
    private javax.swing.JTextField txtnumero_orden;
    private javax.swing.JTextField txtnumero_orden1;
    private javax.swing.JTextField txtnumero_orden2;
    private javax.swing.JTextField txtnumero_orden3;
    private javax.swing.JTextField txtnumero_orden4;
    private javax.swing.JLabel txtoficina;
    private javax.swing.JLabel txtorden_corte;
    private javax.swing.JLabel txtorden_corte1;
    private javax.swing.JLabel txtorden_corte2;
    private javax.swing.JLabel txtorden_corte3;
    private javax.swing.JLabel txtorden_corte4;
    private javax.swing.JTextField txtresponsable_paquete;
    private org.jdesktop.swingx.JXImageView vistaimagen;
    // End of variables declaration//GEN-END:variables
}
