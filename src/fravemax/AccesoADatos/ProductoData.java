
package fravemax.AccesoADatos;

import fravemax.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {

    private Connection con = null;   
        
    public ProductoData(){
        con = Conexion.getConexion();
    }
    
    public void registrarProducto(Producto producto){
        
        String sql = "INSERT INTO producto(idProducto,nombreProducto,descripcion,precioActual,stock,estado)"
             + "VALUES (null,?,?,?,?,?);";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,producto.getNombreProducto());
            ps.setString(2,producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5,producto.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
               producto.setIdProducto(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Producto agregado!" + producto.toString());
            }
            
            ps.close();
                     
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
            sqlE.printStackTrace();  
        }
    }
    /*
    public ArrayList<Producto> listarProductoXFecha(LocalDate fecha){
        ArrayList<Producto> listProd = null;
        
        return listProd;
    }
    */ 
    public void eliminarProducto(int idProducto){
        
        String sql = "UPDATE producto SET Estado = 0 WHERE producto.idProducto = ?;";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            int exito = ps.executeUpdate();
            
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Producto Eliminado.");
            }
            
            ps.close();
            
            } catch (SQLException sqlE) {
                   JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
                   sqlE.printStackTrace();
               }
    }
    
    public void modificarProducto(Producto producto){
        
        String sql="UPDATE producto SET nombreProducto=?, descripcion=?, precioActual=?, stock=?, estado=? "
                + "WHERE idProducto=? ";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,producto.getNombreProducto());
            ps.setString(2,producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5,producto.isEstado());
            ps.setInt(6,producto.getIdProducto());
            
            int exito=ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Producto Modificado");
            }
            
            ps.close();    
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }   
    }
    
    public Producto buscarProductoXId(int idProd){
        
        Producto prod = null;
        
        String sql = "SELECT * FROM producto WHERE producto.idProducto = ?;";
        /*Hay que ver como detectar cuando devuelve un objeto sin columnas desde BD*/
        try{
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProd);
            ResultSet rs = ps.executeQuery();
            prod = new Producto();
            while(rs.next()){
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setEstado(rs.getBoolean("estado"));
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
            }
            
            ps.close();
            
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
        
        return prod;
    }
    
    public List<Producto> buscarProductoXNombre(String nombreProducto){
       

       List <Producto> productos = new ArrayList <>();
        String sql = "SELECT * FROM producto WHERE producto.nombreProducto LIKE ?; ";
        
        try{
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nombreProducto + "%");
            ResultSet rs = ps.executeQuery();

                
            while(rs.next()){
                Producto prod = new Producto();
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setEstado(rs.getBoolean("estado"));
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setStock(rs.getInt("stock"));
                
                productos.add(prod);
            }
           
            ps.close();
           
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla.");
            sqlE.printStackTrace();
        }
       
        return productos;
    }
}