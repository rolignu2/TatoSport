
package tatosport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rolandoantonio
 */
public class Orden extends Conexion{
    
    private ResultSet rs;

    
    public Orden() throws SQLException, 
            ClassNotFoundException, 
            InstantiationException, 
            IllegalAccessException
    {
        
    }
    
    public ArrayList Get_ClienteOrden(String orden) throws SQLException
    {
        String sql = "SELECT pedidos.id_pedido as id , pedidos.orden as orden , CONCAT(clientes.nombre , ' ' , clientes.apellido) as nombre , "
                + " pedidos.fecha_pedido as fecha , imagenes.nombre as foto_n , imagenes.photo as photo "
                + " FROM pedidos INNER JOIN clientes ON pedidos.id_cliente=clientes.id_cliente "
                + " INNER JOIN imagenes ON pedidos.id_imagen=imagenes.id_imagen WHERE pedidos.orden LIKE '" + orden + "'";
        this.rs = super.Get_Consulta(sql);
        ArrayList listado = new ArrayList();
        if(rs.next())
        {
            listado.add(rs.getString("id"));
            listado.add(rs.getString("orden"));
            listado.add(rs.getString("nombre"));
            listado.add(rs.getString("fecha"));
            listado.add(rs.getString("foto_n"));
            listado.add(rs.getObject("photo"));
        }
        return listado;
    }
    
    public ArrayList GetListaTela() throws SQLException
    {
        ArrayList list = new ArrayList();
        String sql =" SELECT CONCAT(id_tela , '-' , nombre) as tela From telas ";
        ResultSet rs = super.Get_Consulta(sql);
        while(rs.next())
            list.add(rs.getString("tela"));
        return list;
    }
    
    public ArrayList GetProductosbyPedido(String id_pedido)
    {
           try {        
            
            ArrayList list = new ArrayList();
            String sql = "SELECT productos.id_producto as id , productos.descripcion , productos.cantidad"
                    + " FROM productos WHERE productos.id_pedido LIKE '" + id_pedido + "'";
            this.rs = super.Get_Consulta(sql);
            while(rs.next())
            {
                Object[] obj = new Object[] {
                    rs.getString("id"),
                    rs.getString("descripcion"),
                    rs.getString("cantidad"),
                };
                list.add(obj);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    //`id_corte`, `id_tela`, `id_pedido`, `color`, `Mcuello`, `Mescote`, `Mpuno`, `Mfranjas`, `Mvenas`, `Melastico`
    public ArrayList GetCorteByPedido(String id_pedido)
    {
           try {        
            
            ArrayList list = new ArrayList();
            String sql = "SELECT corte.id_corte as id , CONCAT(telas.id_tela , '-' , telas.nombre) as tela "
                    + " , corte.id_pedido , corte.color , corte.Mcuello , corte.Mescote , corte.Mpuno , corte.Mfranjas , "
                    + " corte.Mvenas , corte.Melastico"
                    + " FROM corte INNER JOIN telas ON corte.id_tela=telas.id_tela"
                    + " WHERE corte.id_pedido LIKE '" + id_pedido + "'";
            this.rs = super.Get_Consulta(sql);
            if(rs.next())
            {
                
                     list.add(rs.getString("id"));
                     list.add(rs.getString("tela"));
                     list.add(rs.getString("id_pedido"));
                     list.add(rs.getString("color"));
                     list.add(rs.getString("Mcuello"));
                     list.add(rs.getString("Mescote"));
                     list.add(rs.getString("Mpuno"));
                     list.add(rs.getString("Mfranjas"));
                     list.add(rs.getString("Mvenas"));
                     list.add(rs.getString("Melastico"));

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList GetEnsambleByPedido(String id_pedido)
    {
           try {        
            
            ArrayList list = new ArrayList();
            String sql = "SELECT ensamble.id_ensamble as id , CONCAT(telas.id_tela , '-' , telas.nombre) as tela "
                    + " , ensamble.id_pedido , ensamble.color , ensamble.procedimiento , ensamble.decorado  "
                    + " FROM ensamble INNER JOIN telas ON ensamble.id_tela=telas.id_tela"
                    + " WHERE ensamble.id_pedido LIKE '" + id_pedido + "'";
            this.rs = super.Get_Consulta(sql);
            if(rs.next())
            {
                
                     list.add(rs.getString("id"));
                     list.add(rs.getString("tela"));
                     list.add(rs.getString("id_pedido"));
                     list.add(rs.getString("color"));
                     list.add(rs.getString("procedimiento"));
                     list.add(rs.getString("decorado"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
