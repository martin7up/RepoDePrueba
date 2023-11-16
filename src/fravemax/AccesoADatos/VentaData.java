
package fravemax.AccesoADatos;

import fravemax.Entidades.Cliente;
import fravemax.Entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class VentaData {
    
    private Connection con = null; 
    //private EnumCamposBD enumCamposBD;
    
    public VentaData(){
        con = Conexion.getConexion();
    }

    public void registraVenta(Venta venta){
        
        String sql = "INSERT INTO venta(idVenta,idCliente,fechaVenta) VALUES (null,?,?);";
        
        try {
            
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,venta.getCliente().getIdCliente());
            ps.setDate(2,Date.valueOf(venta.getFechaVenta()));
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                venta.setIdVenta(rs.getInt(1));
                 JOptionPane.showMessageDialog(null,"Venta Registrada!\nId : "+venta.getIdVenta());
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al Acceder a la tabla");
        }
    }
    
    public void eliminarVenta(int idVenta){
        String sql = "DELETE FROM venta WHERE venta.idVenta = ?;";
 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            JOptionPane.showMessageDialog(null, "Va a eliminar la venta " + idVenta);
            ps.setInt(1, idVenta);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta Eliminada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Venta");
        }
    }
    
    public void modificarVenta(Venta venta){
        String sql="UPDATE venta SET idCliente=? ,fechaVenta= ? WHERE idVenta=? ;";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1,venta.getCliente().getIdCliente());
            ps.setDate(2,Date.valueOf(venta.getFechaVenta()));
            ps.setInt(3,venta.getIdVenta());
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Venta Modificada");
            }
            ps.close();    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Venta");
        }     
    }
    
    public List listarVentasDeUnCliente(long idCliente){
        
        List ventas = null;
        
            String sql = "SELECT idVenta, fechaVenta FROM venta WHERE venta.idCliente = ? ORDER BY venta.fechaVenta DESC;";
                try{
                    //Preparacion de consulta p/BD
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setLong(1, idCliente);
                    //Ejecucion de consulta y almacenamiento de respuesta desde BD
                    ResultSet rs = ps.executeQuery();
                    //Preparacion de retorno.
                    ventas = new ArrayList<Venta>();
                    //En este metodo todas las ventas tienen el mismo cliente, no es necesario que esta linea este dentro del while().
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(idCliente);
                   
                    while(rs.next()){
                        Venta venta = new Venta();//Si se deja fuera del while esta linea,
                                                    //produce un resultado indeseado en la
                        venta.setCliente(cliente);  //tabla de la vista VentaFormulario.
                        venta.setIdVenta(Integer.parseInt(rs.getString("idVenta")));
                        venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());
                        
                        ventas.add(venta);
                    }
                    //Cierre de conexion.
                    ps.close();
                    
                }catch(SQLException sqlE){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta.");
                }
        return ventas;
    }
    
    public List listarTodasLasVentas(String campo, String orden){
        
        List ventas = null;
        
            String sql = "SELECT venta.idVenta, venta.idCliente, venta.fechaVenta ,"+
                    "cliente.dni, cliente.apellido, cliente.nombre FROM venta JOIN "+
                    "cliente ON(venta.idCliente=cliente.idCliente) "+
                    "ORDER BY "+campo+" "+orden+" ;";
            
                try{
                    //Preparacion de consulta p/BD
                    PreparedStatement ps = con.prepareStatement(sql);
                
                    //Ejecucion de consulta y almacenamiento de respuesta desde BD
                    ResultSet rs = ps.executeQuery();
                    //Preparacion de retorno.
                    ventas = new ArrayList<Venta>();

                    while(rs.next()){
                        //En este metodo cada venta tiene un cliente diferente.
                        Cliente cliente = new Cliente();
                        cliente.setIdCliente(Long.parseLong(rs.getString("idCliente")+""));
                        cliente.setDni(Long.parseLong(rs.getString("dni")+""));
                        cliente.setApellido(rs.getString("apellido"));
                        cliente.setNombre(rs.getString("nombre"));
                        //Instanciacion de cada venta traida desde BD.
                        Venta venta = new Venta();
                        venta.setCliente(cliente);
                        venta.setIdVenta(Integer.parseInt(rs.getString("idVenta")+""));
                        venta.setFechaVenta(rs.getDate("fechaVenta").toLocalDate());

                        ventas.add(venta);
                    }
                    //Cierre de conexion.
                    ps.close();

                }catch(SQLException sqlE){
                    JOptionPane.showMessageDialog(null, "Error al acceder a la tabla venta.");
                    sqlE.printStackTrace();
                }
        return ventas;
    }
}