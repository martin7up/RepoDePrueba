
package universidadgrupo69.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo69.entidades.Materia;


public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConexion();
    }
        
    public void guardarMateria(Materia materia){
        String sql = "INSERT INTO materia VALUES (null, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnioMateria());
            ps.setBoolean(3, materia.isActivo());
            
            ps.executeUpdate();
            
            ResultSet resultset = ps.getGeneratedKeys();
            
            if(resultset.next()){
                materia.setIdMateria(resultset.getInt(1));/*Obtenemos solo el primer dato*/
                JOptionPane.showMessageDialog(null, ">>>Materia guardad correctamente<<<");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            ex.printStackTrace();
        }
    }
    
    public Materia buscarMateriaXid(int id){
        String sql = "SELECT nombre, año, estado FROM materia WHERE idMateria = ?;";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                materia = new Materia();
                
                materia.setIdMateria(id);
                materia.setActivo(rs.getBoolean("estado"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));                
                
            }else{
                System.out.println(">>>No existe tal materia<<< ");
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println(">>>Error al acceder a la tabla<<<  ");
            ex.printStackTrace();
        }
        return materia;
    }
    
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET  nombre= ?, año= ?, estado = ?"
                +" WHERE idMateria = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(4, materia.getIdMateria());
            ps.setString(1, materia.getNombre());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(2, materia.getAnioMateria());
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, ">>>Materia modificada correctamente<<<");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            ex.printStackTrace();
        }
    }
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null,">>>Materia dada de baja.");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            ex.printStackTrace();
        }  
    }
    
    public List<Materia> listarMaterias(){
        String sql = "SELECT idMateria, nombre, año FROM materia WHERE estado = 1;";
        ArrayList<Materia> materias = new ArrayList<Materia>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia = new Materia();
                
                materia.setAnioMateria(rs.getInt("año"));
                materia.setActivo(true);
                materia.setNombre(rs.getString("nombre"));
                materia.setIdMateria(rs.getInt("idMateria"));
                
                materias.add(materia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            ex.printStackTrace();
        }
        return materias;
    }
}
