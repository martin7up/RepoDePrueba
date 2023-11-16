
package fravemax.AccesoADatos;

import fravemax.Entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteData {
    private Connection con=null;
    
    public ClienteData(){
        con=Conexion.getConexion();
    }
    
    public void agregarCliente(Cliente cliente){
        
        String sql="INSERT INTO cliente(dni,apellido,nombre,domicilio,telefono) "+
                    "VALUES(?,?,?,?,?);";
        try {
            
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1,cliente.getDni());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getNombre());
            ps.setString(4,cliente.getDomicilio());
            ps.setString(5,cliente.getTelefono());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if(rs.next()){
                cliente.setIdCliente(rs.getLong(1));
                JOptionPane.showMessageDialog(null,"Cliente agregado. "+"iD asignado : "+cliente.getIdCliente());
            }
            
            ps.close();
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla cliente;\n"+
                            "Despliegue la tabla clientes y verifique,\n"+
                    "que el cliente no haya sido registrado anteriormente.");
            sqlE.printStackTrace();
        }
    }
    
    public void modificarCliente(Cliente cliente){
        
        String sql="UPDATE cliente SET dni=?,apellido=?,nombre=?,domicilio=?,telefono=? "+
                    "WHERE idCliente=? ;";
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setLong(1, cliente.getDni());
            ps.setString(2,cliente.getApellido());
            ps.setString(3,cliente.getNombre());
            ps.setString(4,cliente.getDomicilio());
            ps.setString(5,cliente.getTelefono());
            ps.setLong(6,cliente.getIdCliente());
            
            int exito=ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Cliente Modificado");
            }
            
            ps.close(); 
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla Cliente");
            sqlE.printStackTrace();
        }
        
    }
    
    public Cliente buscarCliente(long dniCliente){
        Cliente cl = null;
        
        String sql = "SELECT * FROM cliente WHERE dni = ?;";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, dniCliente);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
               cl = new Cliente();
               cl.setIdCliente(rs.getLong("idCliente"));
               cl.setApellido(rs.getString("apellido"));
               cl.setNombre(rs.getString("nombre"));
               cl.setDni(rs.getLong("dni"));
               cl.setDomicilio(rs.getString("domicilio"));
               cl.setTelefono(rs.getString("telefono"));
            }
            
            ps.close();
            
        } catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlE.printStackTrace();
        }
        
        return cl;
    }
    
    public List<Cliente> buscarClienteXApellido(String apellido){

        List <Cliente> clientes = new ArrayList <>();
        
        String sql = "SELECT * FROM cliente WHERE apellido LIKE ?;";
       
        try {
           
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + apellido + "%");

            ResultSet rs = ps.executeQuery();
           
            if(rs.next()){
              Cliente cl = new Cliente();
               cl.setIdCliente(rs.getInt("idCliente"));
               cl.setApellido(rs.getString("apellido"));
               cl.setNombre(rs.getString("nombre"));
               cl.setDni(rs.getInt("dni"));
               cl.setDomicilio(rs.getString("domicilio"));
               cl.setTelefono(rs.getString("telefono"));
               
               clientes.add(cl);
            }
           
            ps.close();
           
        } catch(SQLException sqlE){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlE.printStackTrace();
        }
       
        return clientes;
    }
    
    public void eliminarCliente(int idCliente) {
        
        String sql = "DELETE FROM detalleventa WHERE detalleventa.idVenta \n" +
                     "IN (SELECT venta.idVenta FROM venta JOIN cliente ON (venta.idCliente = cliente.idCliente) \n" +
                     "WHERE cliente.idCliente = ?);";
        String sql1 ="DELETE FROM venta WHERE venta.idCliente = ?;";
        String sql2 ="DELETE FROM cliente WHERE cliente.idCliente = ?;";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement qs = con.prepareStatement(sql1);
            PreparedStatement rs = con.prepareStatement(sql2);
            
            ps.setLong(1, idCliente);
            qs.setLong(1, idCliente);
            rs.setLong(1, idCliente);
            
            int tablaLejana = ps.executeUpdate();
            int tablaIntermedia = qs.executeUpdate();
            int tablaInicial = rs.executeUpdate();
            
            /*if () {
                JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            }*/
            
            ps.close();
            
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cliente");
            sqlE.printStackTrace();
        }
    }
    
    public List<Cliente> listarClientes(){
        
            ArrayList<Cliente> clientes = new ArrayList<>();
            String sql = "SELECT * FROM cliente ORDER BY dni DESC;";
            
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Cliente cliente = new Cliente();
                
                cliente.setIdCliente(Long.parseLong(rs.getString("idCliente")));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setDni(Long.parseLong(rs.getString("dni")));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setTelefono(rs.getString("telefono"));
                
                clientes.add(cliente);
                
            }
            ps.close();
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "mmm... algo salio mal al acceder a la base de datos.");
            sqlE.printStackTrace();
        }
            return clientes;
    }
}




/*codigo SQL alternativo para el borrado
DELETE FROM detalleventa WHERE detalleventa.idVenta 
IN (SELECT venta.idVenta FROM venta JOIN cliente ON (venta.idCliente = cliente.idCliente) 
WHERE cliente.idCliente = ?);

*/