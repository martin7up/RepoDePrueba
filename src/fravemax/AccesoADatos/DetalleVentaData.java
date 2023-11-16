
package fravemax.AccesoADatos;

import fravemax.Entidades.Cliente;
import fravemax.Entidades.DetalleVenta;
import fravemax.Entidades.Producto;
import fravemax.Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVentaData {
  
    private Connection con = null;   
  
    public DetalleVentaData(){
        con = Conexion.getConexion();
    }
  
    public void cargarDetalleVenta(DetalleVenta detVent){
        
        String sql0 = "SELECT producto.stock, producto.estado FROM producto WHERE idProducto = ?;";
        try {
            
            PreparedStatement ps=con.prepareStatement(sql0);
            ps.setInt(1, detVent.getProducto().getIdProducto());
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            JOptionPane.showMessageDialog(null,"Cantidad : "+rs.getInt("stock")+" disponible : "+rs.getBoolean("estado"));
            
            if(!rs.getBoolean("estado")){
                JOptionPane.showMessageDialog(null,"El producto no se encuentra disponible para la venta.\n Su estado es : "+rs.getBoolean("estado"));
                ps.close();
                rs = null;
                return;//Si el producto tiene estado false, se informa y no se asienta en BD.
            }
            
            if(rs.getInt("stock")<detVent.getCantidad()){
                JOptionPane.showMessageDialog(null,"Solo se dipone de : "+rs.getInt("stock")+" en stock.");
                ps.close();
                rs = null;
                return;//Si la cantidad requerida(a comprar) es mayor que la disponible, se informa y no se asienta en BD.
            }
            
            ps.close();
        
        }catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
            sqlE.printStackTrace();//Permite ver el error por consola.
        }
        
        //Esta modificacion solo se intenta si no se ejecuto el cuerpo de alguno de los if.
        String sql1 = "INSERT INTO detalleventa(cantidad, idVenta, precioVenta, idProducto) VALUES (?,?,?,?);";
        String sql2 = "UPDATE producto SET producto.stock = (producto.stock - ?) WHERE idProducto = ?;\n"+
                      "UPDATE venta SET venta.concretada = true WHERE idVenta = ?;";
        try {

            PreparedStatement ps=con.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,detVent.getCantidad());
            ps.setInt(2,detVent.getVenta().getIdVenta());
            ps.setDouble(3,detVent.getPrecioVenta());
            ps.setInt(4,detVent.getProducto().getIdProducto());

            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();

            if(rs.next()){
               detVent.setIdDetalleVenta(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"DETALLE VENTA AGREGADO");
            }

            ps.close();
            
            //Aqui se intenta modificar el stock reduciendolo en la cantidad comprada.
            ps=con.prepareStatement(sql2);
            ps.setInt(1,detVent.getCantidad());
            ps.setInt(2,detVent.getProducto().getIdProducto());
            ps.setBoolean(3, true);
            
            int exito=ps.executeUpdate();
            if(exito>1){
                JOptionPane.showMessageDialog(null,"Venta concretada;\nStock Modificado.");
            }
            
            ps.close(); 

        }catch(SQLException sqlE){
                JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
                sqlE.printStackTrace();//Permite ver el error por consola.
        }
        
    }
     
    public List<Producto>listarProductoXfecha(LocalDate fechaVenta){
        String sql="SELECT * FROM producto WHERE producto.idProducto IN "+
                    "(SELECT detalleventa.iDProducto FROM Venta JOIN DetalleVenta "+
                        "ON venta.iDVenta = detalleventa.iDVenta WHERE venta.fechaVenta = ?);";
        ArrayList<Producto>productos = null;
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs=ps.executeQuery();
            
            productos = new ArrayList();
            while(rs.next()){
                
                Producto prod=new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                prod.setPrecioActual(rs.getDouble("precioActual"));
                prod.setEstado(rs.getBoolean("estado"));
                
                productos.add(prod);
                
            }
            
            ps.close();
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
            sqlE.printStackTrace();//Permite ver el error por consola.
        }    
      return productos;  
    }
    
    public void eliminarDetalleVenta(int idDetalleVenta){
        
        String sql = "DELETE FROM detalleventa WHERE detalleventa.idDetalleVenta = ?;";
 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Va a eliminar el DetalleVenta" + idDetalleVenta);
            ps.setInt(1, idDetalleVenta);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "DetalleVenta Eliminado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalleventa");
            ex.printStackTrace();//Permite ver el error por consola.
        }
    }
    
    public void modificarVenta(DetalleVenta detalleventa){
        
        String sql = "UPDATE detalleventa SET cantidad = ?,idVenta= ?,precioVenta=?,idProducto=? "+
                        "WHERE idDetalleVenta=?;";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,detalleventa.getCantidad());
            ps.setInt(2,detalleventa.getVenta().getIdVenta());
            ps.setDouble(3,detalleventa.getPrecioVenta());
            ps.setInt(4,detalleventa.getProducto().getIdProducto());
            ps.setInt(5,detalleventa.getIdDetalleVenta());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Detalleventa Modificada");
            }
            ps.close();    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla DetalleVenta");
            ex.printStackTrace();//Permite ver el error por consola.
        }     
    }
    
    public List<Venta>listarVentasXFecha(LocalDate fechaVenta){
    String sql="SELECT * FROM venta WHERE venta.fechaventa ON venta.idVenta = detalleventa.idVenta"
                + " WHERE venta.fechaVenta = ?)";
        ArrayList<Venta>ventas=new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fechaVenta));
            ResultSet rs=ps.executeQuery();
            ClienteData clData = new ClienteData();
            while(rs.next()){
                Venta vta=new Venta();
                
                vta.setIdVenta(rs.getInt("idVenta"));
                Cliente cl = clData.buscarCliente(rs.getInt("idCliente"));
                vta.setFechaVenta(rs.getDate("fechaventa").toLocalDate());
                vta.setCliente(cl);//Agregado porque faltaba.

                ventas.add(vta);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        return ventas;
    }
    
    public List<Cliente>listarClientesXProducto(int idProducto){
    String sql="SELECT * FROM cliente WHERE cliente.IdCliente IN (SELECT detalleventa.idCliente"
                + " FROM Producto JOIN DetalleVenta ON producto.idProducto = detalleventa.idProducto"
                + " WHERE idProducto = ?)";
            
    
        ArrayList<Cliente>clientes=new ArrayList();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl=new Cliente();
                
                cl.setIdCliente(rs.getInt("idCliente"));
                cl.setDni(rs.getInt("DNI"));
                cl.setApellido(rs.getString("apellido"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDomicilio(rs.getString("domicilio"));

                clientes.add(cl);
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla");
        }
        return clientes;
    }
}