
package universidadgrupo69.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo69.entidades.*;



public class inscripcionData {
   
    private AlumnoData aluData;
    private MateriaData matData;
    private Connection con = null;
    //Las devoluciones de SQL hasta aqui vistas son ResultSet si solo se le solicita inf a la BD
    //sin que se haya modificado la informacion en tablas.
    //Si se modifica la informacion en tablas de tambien devuelve un ResultSet, pero se le debe especi_
    //_ficar en el metodo que compila la consulta(modificacion) que devuelva las claves generadas.
    public inscripcionData(){
        con = Conexion.getConexion();//Este metodo se llama sin instanciar obj Conexion
    }                               //pues este ultimo tiene metodos estaticos.
    
        public void guardarInscricion(Inscripcion insc){//Necesita instanciar un 
                                                            //obj inscripcion.
        String sql = "INSERT INTO inscripcion VALUES (null, ?, ?, ?);";
        try {// ?, ?, ? >>> placeholders / "comodines"
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());//En la linea de arriba el Objeto de tipo Connection
            ps.setInt(2, insc.getAlumno().getIdAlumno());//usa su metodo prepStat.. y 
            ps.setInt(3, insc.getMateria().getIdMateria());//devuelve un objeto del tipo
            //preparedStatement, por eso ps representa la referencia a dicho objeto.
            ps.executeUpdate();
            
            ResultSet resultset = ps.getGeneratedKeys();
            
            if(resultset.next()){
                insc.setIdInscripcion(resultset.getInt(1));/*Obtenemos solo el primer dato*/
                System.out.println(">>>Inscripcion guardada<<<");//Necesita instanciar un 
            }                                                   //obj inscripcion.
            ps.close();
        } catch (SQLException ex) {
            System.out.println(">>>Error al acceder a la tabla<<<  ");
            ex.printStackTrace();
            }
        }
        
        public List<Inscripcion> listarInscripciones(){
        String sql = "SELECT idInscripto, nota, idAlumno, idMateria FROM inscripcion;";
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                
                inscripcion.setIdInscripcion(rs.getInt("idInscripto"));
                inscripcion.setNota(rs.getDouble("nota"));
                inscripcion.setAlumno(aluData.buscarAlumnoXid((rs.getInt("idAlumno"))));
                inscripcion.setMateria(matData.buscarMateriaXid((rs.getInt("idMateria"))));
                
                inscripciones.add(inscripcion);
            }
            ps.close();
            
        } catch (SQLException sqlE) {
            System.out.println(">>>Error al acceder a la tabla<<<  ");
            sqlE.getMessage();
        }
        return inscripciones;
    }
        
        public List<Inscripcion> listarInscripcionesPorAlumno(int idAlumno){
            ArrayList<Inscripcion> inscripciones = new ArrayList<>();
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?;";
            
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            aluData = new AlumnoData();
            matData = new MateriaData();
            while(rs.next()){
                //Aqui hay que instanciar (new) aluData y matData
                //Reveer si es necesario interar el paso de asignar el Alumno a Inscripcion.
                Inscripcion insc = new Inscripcion();
                
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(aluData.buscarAlumnoXid(idAlumno));
                insc.setMateria(matData.buscarMateriaXid((rs.getInt("idMateria"))));
                
                inscripciones.add(insc);
                
            }
            ps.close();
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal.<<<");
            sqlE.printStackTrace();
        }
            return inscripciones;
        }
        
        public List<Materia> listarMateriasCursadas(int idAlumno){
            ArrayList<Materia> inscriptas = null;//De esta forma si ocurre el catch no se instancia materias.
            String sql = "SELECT materia.idMateria, materia.nombre, materia.año, materia.estado "+
                    "FROM materia JOIN inscripcion ON(materia.idMateria=inscripcion.idMateria) "+
                    "WHERE idAlumno = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            inscriptas = new ArrayList<>();
            
            while(rs.next()){
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setActivo(rs.getBoolean("estado"));
                
                inscriptas.add(mat);
            }
            ps.close();
           
        } catch (SQLException sqlE) {
            System.out.println(">>>Algo no resulto bien durante el proceso<<<");
            System.out.println(sqlE.getMessage());
        }   
            return inscriptas;
        }
        
        public List<Materia> listarMateriasNoCursadas(int idAlumno){
            String sql = "SELECT * FROM materia WHERE (materia.estado = 1) AND materia.idMateria "+
                    "NOT IN (SELECT inscripcion.idMateria FROM inscripcion WHERE idAlumno = ?);";
            ArrayList<Materia> noInscriptas = null;
            
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            noInscriptas = new ArrayList<>();
            
            while(rs.next()){
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setActivo(rs.getBoolean("estado"));
                
                noInscriptas.add(mat);
            }
            ps.close();
        } catch (SQLException sqlE) {
            System.out.println(">>>Algo no resulto bien durante el proceso<<<");
            System.out.println(sqlE.getMessage());
        }
            return noInscriptas;
        }
        
        public void borrarInscripcionAMateriaDeAlumno(int idAlumno, int idMateria){
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, ">>>Inscripcion anulada<<<");
            }                                                   
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            }
        }

        public void actualizarNota(int idAlumno, int idMateria, double nota){
            String sql = "UPDATE inscripcion SET nota = ? WHERE inscripcion.idAlumno = ? AND inscripcion.idMateria = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            
            if(ps.executeUpdate() == 1){
                JOptionPane.showMessageDialog(null, ">>>Nota Actualizada!!!<<<");
            }                                                   
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");        
            }
        }
        
        public List<Alumno> listarAlumnosPorMateria(int idMateria){
            ArrayList<Alumno> alumnos = null;
            String sql = "SELECT alumno.idAlumno, alumno.dni, alumno.apellido, alumno.nombre,"+
                    " alumno.fechaNacimiento, alumno.estado\n"+
                    " FROM alumno JOIN inscripcion ON(alumno.idAlumno=inscripcion.idAlumno)\n" +
                    " WHERE inscripcion.idMateria = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs  = ps.executeQuery();
            
            alumnos = new ArrayList<>();
            while(rs.next()){
                Alumno alum = new Alumno();
                
                alum.setIdAlumno(rs.getInt("idAlumno"));
                alum.setDni(rs.getInt("dni"));
                alum.setApellido(rs.getString("apellido"));
                alum.setNombre(rs.getString("nombre"));
                alum.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alum.setEstado(rs.getBoolean("estado"));
                
                alumnos.add(alum);
            }
            ps.close();
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, ">>>Algo malio sal<<<");
            System.out.println(sqlE.getMessage());
        }        
            return alumnos;
        }

}
