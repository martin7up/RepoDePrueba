
package universidadgrupo69.accesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo69.entidades.Alumno;


public class AlumnoData {
    private Connection con = null;
    
    public AlumnoData(){
        con = Conexion.getConexion();
    }
    public void guardarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumno VALUES (null, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            
            ResultSet resultset = ps.getGeneratedKeys();
            
            if(resultset.next()){
                alumno.setIdAlumno(resultset.getInt(1));/*Obtenemos solo el primer dato*/
                JOptionPane.showMessageDialog(null, alumno.toString());
            }
            ps.close();
            resultset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal... =(( <<<");
        }
    }
    
    public void modificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? WHERE idAlumno = ?;";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNac()));/*Date y LocalDate no son una misma clase.*/
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());
            if(ps.executeUpdate() == 1){
                System.out.println(">>>Fila correspondiente al alumno modificada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal... =(( <<<");
        }
    }
    
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, "Alumno dado de baja.");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Algo malio sal... =(( ");
        }
        
    }
    
    public Alumno buscarAlumnoXid(int id){
        String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1;";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setEstado(true);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                
            }else{
                JOptionPane.showMessageDialog(null, ">>>No se encuentra al alumno<<<");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal... =(( <<<");
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoXdni(int dni){
        String sql = "SELECT idAlumno, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ? ;";
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                alumno = new Alumno();
                alumno.setDni(dni);
                alumno.setEstado(rs.getBoolean("estado"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                
            }else{
                JOptionPane.showMessageDialog(null, "No se encuentra en BD tal alumno");
            }
            ps.close();
        } catch (SQLException ex ) {
            JOptionPane.showMessageDialog(null, " Algo malio sal =(( ");
        }
        return alumno;
    }
    
    public List<Alumno> buscarAlumnos(){
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE estado = 1;";
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno = new Alumno();
                alumno.setDni(rs.getInt("dni"));
                alumno.setEstado(true);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                
                alumnos.add(alumno);
            }
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println(">>>Error al acceder a la tabla<<<  ");
            ex.printStackTrace();
        }
        return alumnos;
    }
    
    /*AGREGAR EL METODO PARA TRAER TODOS LOS ALUMNOS QUE TENGAN UNA DETERMINADA EDAD A LA FECHA DEL DIA*/
    /*Hacer serializacion y guardado de archivo */
}
