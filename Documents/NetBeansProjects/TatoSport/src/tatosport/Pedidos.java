

package tatosport;


import java.awt.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Pedidos extends Conexion {
    
    
    private final Map mapeo;
    private final List listado;
    private final List CodigosPedidos;
    private ArrayList list;
    
    public Pedidos() throws SQLException, 
            ClassNotFoundException, 
            InstantiationException, 
            IllegalAccessException
    {
        this.list = new ArrayList();
        mapeo = new HashMap();
        listado = new List();
        CodigosPedidos = new List();
        this.CodigosPedidos.add("registro");
        this.CodigosPedidos.add("orden");
    }
    
    public ArrayList Get_DatosCliente_byId(String codigo) throws SQLException
    {
        list = new ArrayList();
        //super.AbrirConexion();
        for(int i =0; 
                i < this.CodigosPedidos.getItemCount() 
                ; i++)
        {
            
            String sql = "SELECT CONCAT(clientes.nombre, ' ' , clientes.apellido) as 'cliente' "
                    + ", pedidos.id_pedido as id , pedidos.registro , pedidos.factura , "
                    + " pedidos.orden , pedidos.nit , pedidos.giro , pedidos.fiscal ,"
                    + " pedidos.fecha_pedido as inicio , pedidos.fecha_entrega as entrega , "
                    + " imagenes.nombre , imagenes.photo , pedidos.pago "
                    + " FROM pedidos INNER JOIN clientes ON pedidos.id_cliente=clientes.id_cliente "
                    + " INNER JOIN imagenes ON pedidos.id_imagen=imagenes.id_imagen "
                    + " WHERE pedidos." + CodigosPedidos.getItem(i) + " LIKE '" + codigo + "'" ;
            ResultSet rs = super.Get_Consulta(sql);
            int k =0;
            while(rs.next())
            {
                this.list.add(rs.getString("id"));
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
                this.list.add(rs.getString("pago"));
                k++;
            }
            if(k>=1)break;
            
        }
        //super.CerrarConexion();
        return this.list;
    }
    
    public ArrayList Get_ProductosByPedidos(String id_pedido)
    {
        try {        
            
            //super.AbrirConexion();
            list = new ArrayList();
            String sql = "SELECT productos.cantidad , productos.descripcion , productos.precio , productos.total"
                    + " FROM productos WHERE productos.id_pedido LIKE '" + id_pedido + "'";
            ResultSet rs = super.Get_Consulta(sql);
            while(rs.next())
            {
                Object[] obj = new Object[] {
                    rs.getString("cantidad"),
                    rs.getString("descripcion"),
                    rs.getString("precio"),
                    rs.getString("total")
                };
                this.list.add(obj);
            }
            //super.CerrarConexion();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean EliminarPedido(String id_pedido) throws SQLException
    {
        
        String sql = "DELETE a1 , a2 FROM pedidos as a1 INNER JOIN productos as a2 "
                + " WHERE a1.id_pedido=a2.id_pedido AND a1.id_pedido LIKE '" + id_pedido + "'";
        boolean Eliminado = super.Get_Consulta_update(sql);
        return Eliminado;
    }
    
   
    public boolean GuardarCorte(ArrayList LCorte , ArrayList LTalla) throws SQLException
    {
        
       if(LCorte.isEmpty()) return false;
       String Data=null;
       String id_pedido = LCorte.get(1).toString();
       for(int i =0;i < LCorte.size() ; i++)
       {
           switch(i)
           {
               case 0:
                   Data = "";
                   Data += LCorte.get(i).toString() +  ",";
                   break;
               default:
                   if(i == (LCorte.size() - 1))
                       Data += "'" +  LCorte.get(i).toString() + "')";
                   else
                       Data += "'" + LCorte.get(i).toString() + "',";
                   break;
           }
       }
       String sql ="INSERT INTO corte (id_tela, id_pedido, color, Mcuello, Mescote, Mpuno, Mfranjas, Mvenas, Melastico) VALUES ("  + Data;
       if(super.Get_Consulta_update(sql))
       {
           sql ="";
           for(int j=0; j < LTalla.size() ; j++)
           {
               String[] IDTalla = LTalla.get(j).toString().split("-");
               sql = "UPDATE  productos SET talla='" + IDTalla[1] 
                       + "' WHERE id_producto LIKE " + IDTalla[0] ;
                       
               super.Get_Consulta_update(sql);
           }
           return true;
       }
       
       return false;
      
    }
    
    
    
     public boolean ActualizaCorte(ArrayList LCorte , ArrayList LTalla , String id_corte) throws SQLException
    {
        
       if(LCorte.isEmpty()) return false;
       
       String Data=null;
       Stack pila = new Stack();

        pila.push("Melastico");
        pila.push("Mvenas");
        pila.push("Mfranjas");
        pila.push("Mpuno");
        pila.push("Mescote");
        pila.push("Mcuello");
        pila.push("color");
        pila.push("id_pedido");
        pila.push("id_tela");
        
       for(int i =0;i < LCorte.size() ; i++)
       {
           switch(i)
           {
               case 0:
                   Data = "" + pila.pop().toString() + "=";
                   Data += LCorte.get(i).toString() +  ", ";
                   break;
               default:
                   if(i== LCorte.size() - 1)
                        Data += pila.pop().toString() + "='" +  LCorte.get(i).toString() + "'";
                   else
                        Data += pila.pop().toString() + "='" +  LCorte.get(i).toString() + "', ";
                   break;
           }
       }
        
       //id_tela, id_pedido, color, Mcuello, Mescote, Mpuno, Mfranjas, Mvenas, Melastico
       String sql ="UPDATE corte SET "  + Data + " WHERE corte.id_corte LIKE " + id_corte ;
       if(super.Get_Consulta_update(sql))
       {
           sql ="";
           for(int j=0; j < LTalla.size() ; j++)
           {
               String[] IDTalla = LTalla.get(j).toString().split("-");
               sql = "UPDATE  productos SET talla='" + IDTalla[1] 
                       + "' WHERE id_producto LIKE " + IDTalla[0] ;
                       
               super.Get_Consulta_update(sql);
           }
           return true;
       }
       
       return false;
      
    }
    
  
    public boolean CorteRealizado(String id_pedido) throws SQLException
    {
         String sql ="SELECT COUNT(*) as contador FROM corte WHERE id_pedido LIKE '" + id_pedido + "'";
         ResultSet rs = super.Get_Consulta(sql);
         if(rs.next())
         {
             return rs.getInt("contador") >= 1;
         }
         return false;
    }
    
    public ArrayList Get_ProductosCorteByPedidos(String id_pedido)
    {
        try {        
            
            //super.AbrirConexion();
            list = new ArrayList();
            String sql = " SELECT productos.id_producto as id , productos.descripcion , productos.cantidad , productos.talla"
                    + " FROM productos WHERE productos.id_pedido LIKE '" + id_pedido + "'";
            ResultSet rs = super.Get_Consulta(sql);
            while(rs.next())
            {
                Object[] obj = new Object[] {
                    rs.getString("id"),
                    rs.getString("descripcion"),
                    rs.getString("cantidad"),
                    rs.getString("talla")
                };
                this.list.add(obj);
            }
            //super.CerrarConexion();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
     public boolean GuardarEnsamble( String... Datos ) throws SQLException
    {
       String Data="";
       for(int i=0 ; i < Datos.length ; i++)
       {
           if(i== Datos.length - 1)
               Data += "'" + Datos[i].toString() + "')";
           else
               Data += "'" + Datos[i].toString() + "',";
       }
       
       String sql ="INSERT INTO ensamble ( id_tela, id_pedido, color, procedimiento,decorado) VALUES ("  
               + Data;
       
       return super.Get_Consulta_update(sql);
      
    }
     
     public boolean EnsambleRealizado(String id_pedido) throws SQLException
    {
         String sql ="SELECT COUNT(*) as contador FROM ensamble WHERE id_pedido LIKE '" + id_pedido + "'";
         ResultSet rs = super.Get_Consulta(sql);
         if(rs.next())
             return rs.getInt("contador") >= 1;

         return false;
    }
     
     
    public ArrayList GetAnticipo(String id_pedido) throws SQLException
    {
        list = new ArrayList();
        String sql = "SELECT anticipo.pago as pago  , anticipo.anticipo as anticipo " +
                 " FROM pedidos INNER JOIN anticipo ON pedidos.id_pedido=anticipo.id_pedido "
                + " WHERE pedidos.id_pedido LIKE '" + id_pedido + "'";
        ResultSet rs = super.Get_Consulta(sql);
        if(rs.next())
        {
            list.add(rs.getString("pago"));
            list.add(rs.getString("anticipo"));
        }
        return list;
    }
    
    public boolean GuardarAnticipo(String id_pedido , String total , String anticipo) throws SQLException
    {
        String sql ="INSERT INTO anticipo (id_pedido , pago , anticipo) VALUES('"
                 + id_pedido + "','" + total +  "','" + anticipo + "')";
        return super.Get_Consulta_update(sql);
    }
    
    public boolean ActualizarAnticipo(String id_pedido , String total, String anticipo) throws SQLException
    {
         String sql ="UPDATE anticipo SET pago='" + total
                 +  "',anticipo='" + anticipo + "' WHERE id_pedido LIKE '" + id_pedido + "'";
        return super.Get_Consulta_update(sql);
    }
    
    
    public ArrayList GetPedidosEntrega() throws SQLException
    {
        this.list = new ArrayList();
        
        String sql ="SELECT pedidos.orden as orden , pedidos.fecha_pedido as inicio , "
                + " pedidos.fecha_entrega as entrega , anticipo.pago as pago , "
                + " anticipo.anticipo as anticipo FROM pedidos INNER JOIN anticipo "
                + " ON pedidos.id_pedido=anticipo.id_pedido ";
        
        ResultSet rs = super.Get_Consulta(sql);
        while(rs.next())
        {
            //obtener fecha despues del plazo del anticipo
            Date Finicio = rs.getDate("inicio");
            Date Fentrega = rs.getDate("entrega");
           
            GregorianCalendar t1= new GregorianCalendar(Finicio.getYear(), Finicio.getMonth() , 
                    Finicio.getDay()
                  );
            GregorianCalendar t2= new GregorianCalendar(Fentrega.getYear(), Fentrega.getMonth() , 
                    Fentrega.getDay()
                  );
             int diff = t2.get(Calendar.DAY_OF_YEAR | Calendar.SUNDAY | Calendar.SATURDAY ) - t1.get(Calendar.DAY_OF_YEAR | Calendar.SUNDAY | Calendar.SATURDAY);
             String dias = "";
             if(diff <= -1) dias = "Retraso ";
             else dias = String.valueOf(diff);
                  
            
             double pago = Double.valueOf(rs.getString("pago"));
             double anticipo = Double.valueOf(rs.getString("anticipo"));
             double deuda = pago - anticipo ;
             double total =(deuda / pago );
             double porcentaje = (1-total)*100;
             
             if(Math.round(porcentaje) >= 50 ){ 
                 String[] obj = new String[]
                {
                  rs.getString("orden"),
                  String.valueOf(dias),
                  String.valueOf(Math.round(porcentaje))
                };
                list.add(obj);
            }
        }
        return list;
    }
    
    public boolean GuardarEmpaque(String id_pedido , String incluye , String responsable) throws SQLException
    {
        String sql ="INSERT INTO empaque (id_pedido , incluye , responsable) VALUES('"
                 + id_pedido + "','" + incluye +  "','" + responsable + "')";
        return super.Get_Consulta_update(sql);
    }
}
