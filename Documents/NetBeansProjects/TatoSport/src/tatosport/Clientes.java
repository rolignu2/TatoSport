

package tatosport;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Clientes extends Conexion {
    
    private final List lista_clientes;
    private Map cliente_ciccionario;
    private String sql;

    public Clientes() throws SQLException, 
            ClassNotFoundException, 
            InstantiationException, 
            IllegalAccessException
    {
        this.cliente_ciccionario = new HashMap();
        this.lista_clientes = new List();
    }
    
    public Map Get_clientes()
    {
        try {
            sql = "SELECT id_cliente as id , CONCAT(apellido,' , ' , nombre  ) as nombre FROM clientes";
            ResultSet rs = Get_Consulta(sql);
            this.cliente_ciccionario = new HashMap();
            
            while(rs.next())
               this.cliente_ciccionario.put(rs.getString("id"), rs.getString("nombre"));

            return this.cliente_ciccionario;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean Set_clientes( 
            String id ,
            String nombre , 
            String apellido,
            String direccion,
            String oficina, 
            String celular,
            String email, 
            String ingreso,
            String web,
            String nit,
            String fiscal)
    {
        try {
            sql = "INSERT INTO clientes (id_cliente ,  nombre , apellido , direccion , oficina , celular , email , ingreso , web , nit , fiscal) "
                    + "VALUES ('" + id + "','" + nombre + "','" + apellido + "','" + direccion + "','"
                    + oficina + "','" 
                    + celular + "','" + email 
                    + "','" + ingreso 
                    + "','" + web + "','" + nit + "','" + fiscal + "')";
            
            boolean ok = super.Get_Consulta_update(sql);
            return ok;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List Get_clientes_byId(String id)
    {
        try {
            if(this.lista_clientes.getItemCount() >=1)
                this.lista_clientes.removeAll();
            
            this.sql = "SELECT nombre as nombre , apellido as apellido, direccion as direccion , oficina as oficina , celular as celular , email as email"
                    + ", nit as nit , fiscal as fiscal  FROM clientes WHERE id_cliente LIKE '" + id + "'";
            ResultSet rs = super.Get_Consulta(sql);
            if(rs.next())
            {
                this.lista_clientes.add(rs.getString("nombre"));
                this.lista_clientes.add(rs.getString("apellido"));
                this.lista_clientes.add(rs.getString("direccion"));
                this.lista_clientes.add(rs.getString("oficina"));
                this.lista_clientes.add(rs.getString("celular"));
                this.lista_clientes.add(rs.getString("email"));
                this.lista_clientes.add(rs.getString("nit"));
                this.lista_clientes.add(rs.getString("fiscal"));
            }
            return lista_clientes;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList GetClientes_Fill(String Parametro)
    {
        try {
            if(this.lista_clientes.getItemCount() >=1)
                this.lista_clientes.removeAll();
            
            String[] Tablas = new String[] 
            {
                "nombre",
                "apellido",
                "direccion",
                "oficina",
                "celular",
                "email",
                "nit",
                "oficina"
            };
            
            ResultSet rs;
            ArrayList arr = new ArrayList();
            for(int i =0; i < Tablas.length ;i++){
                
                this.sql = "SELECT CONCAT(nombre  , ' ', apellido) as nombre , direccion as direccion , oficina as oficina , celular as celular , email as email"
                    + ", nit as nit , fiscal as fiscal  FROM clientes WHERE " 
                        + Tablas[i] +  " LIKE '%" + Parametro + "%'";
                 
                 rs = super.Get_Consulta(sql);
                 while(rs.next())
                 {
                        String[] C = new String[]{
                        rs.getString("nombre"),
                        rs.getString("direccion"),
                        rs.getString("oficina"),
                        rs.getString("celular"),
                        rs.getString("email"),
                        rs.getString("nit"),
                        rs.getString("fiscal")};
                        arr.add(C);
                }
                 
            }
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList Get_clientes_List()
    {
        try {
            if(this.lista_clientes.getItemCount() >=1)
                this.lista_clientes.removeAll();
            
            this.sql = "SELECT CONCAT(nombre  , ' ', apellido) as nombre, direccion as direccion , oficina as oficina , celular as celular , email as email"
                    + ", nit as nit , fiscal as fiscal  FROM clientes ";
            ResultSet rs = super.Get_Consulta(sql);
            ArrayList arr = new ArrayList();
            while(rs.next())
            {
                String[] C = new String[]{
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("oficina"),
                    rs.getString("celular"),
                    rs.getString("email"),
                    rs.getString("nit"),
                    rs.getString("fiscal")
                };
                arr.add(C);
            }
            
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
