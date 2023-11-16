
package modelo1exparcial2lab2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class Modelo1ExParcial2Lab2 {
    

    public static void main(String[] args) {
//        Doctor doctor1 = new Doctor("Cardiologia", 1, "Doctor1", 40);
//        Doctor doctor2 = new Doctor("Pediatria", 2, "Doctor2", 35);
//        
//        Paciente paciente1 = new Paciente("Muy sano", LocalDate.parse("1991-11-20"), 
//            doctor1, 0, "Julian", 35);
//        Paciente paciente2 = new Paciente("Algo resfriado.", LocalDate.parse("2001-12-31"), 
//            doctor2, 0, "Mario", 22);
//        
//        Hospital hospital = new Hospital("Perrando");
//        hospital.agregarPaciente(paciente1);
//        hospital.agregarPaciente(paciente2);
//        hospital.eliminarPaciente("Paciente2");
//        hospital.mostrarListaPacientes();
//        hospital.asignarDoctorCabecera("Doctor1", "Manuel");
//        hospital.mostrarPacientesEntreFechas("1990-01-01", "2023-02-02");
        
    }
}

//Inicio clase Hospital---------------------------------------------------------
class Hospital{
    
    private String nombreHospital;
    
    public Hospital(){};
    public Hospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }
    public void setNombreHospital(String nombreHospital) {
        this.nombreHospital = nombreHospital;
    }
    
    public void agregarPaciente(Paciente paciente){
        
        String query = "INSERT INTO pacientes(nombre, edad, historial_medico, doctor, fecha_ingreso)"+
                        " VALUES("+"'"+paciente.getNombre()+
                        "', "+"'"+paciente.getEdad()+
                        "', "+"'"+paciente.getHistorial()+
                        "', "+"'"+paciente.getDoctorCabecera().getId()+
                        "', "+"'"+Date.valueOf(paciente.getFechaIngreso())+"');";
        
        if(DBHelper.ejecutarConsulta(query)>0)
            System.out.println("Paciente agregado");
        else
            System.out.println("No se pudo agregar el paciente.");
        
    }
    public void mostrarListaPacientes(){
        
        String query = "SELECT * FROM pacientes;";
        ResultSet rs = DBHelper.ejecutarConsultaConResultado(query);
        
        if (rs!=null){
            
            System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n",
                                "ID", "Nombre", "Edad", "Historial Médico",
                                    "Fecha Ingreso", "Doctor");
            
            try {
                while(rs.next()){
                    
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    String historial =  rs.getString("historial_medico");
                    LocalDate fechaIng = rs.getDate("fecha_ingreso").toLocalDate();
                    int idDoc = rs.getInt("doctor");
                    
                    System.out.printf("%-10d %-15s %-5d %-20s %-13s %-10d\n",
                            id, nombre, edad, historial, fechaIng, idDoc);
                }
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            } 
        }else{
                System.out.println("No se pudo descargar la lista de clientes.");
        }       
    }
    public void asignarDoctorCabecera(String nombreDoctor, String nombrePaciente) {
        
        String query = "UPDATE pacientes SET doctor = (SELECT id FROM doctores "+
                "WHERE nombre = '"+nombreDoctor+"') WHERE nombre = "+"'"+nombrePaciente+"';";
        
        if(DBHelper.ejecutarConsulta(query)>0)
            System.out.println("Doctor asignado.");
        else
            System.out.println("No se pudo asignar el doctor.");
        
    }
    public void mostrarPacientesEntreFechas(String fechaInicio, String fechaFin) {
        
        String query = "SELECT * FROM pacientes WHERE fecha_ingreso BETWEEN '"+
                Date.valueOf(fechaInicio)+"' AND '"+
                Date.valueOf(fechaFin)+"';";
        
        ResultSet rs = DBHelper.ejecutarConsultaConResultado(query);
        
        if (rs!=null){
            
            System.out.printf("%-10s %-15s %-5s %-20s %-12s %-10s\n",
                                "ID", "Nombre", "Edad", "Historial Médico",
                                    "Fecha Ingreso", "Doctor");
            
            try {
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    String historial =  rs.getString("historial_medico");
                    LocalDate fechaIng = rs.getDate("fecha_ingreso").toLocalDate();
                    int idDoc = rs.getInt("doctor");
                    
                    System.out.printf("%-10d %-15s %-5d %-20s %-13s %-10d\n",
                            id, nombre, edad, historial, fechaIng, idDoc);
                }
            } catch (SQLException sqlE) {
                sqlE.printStackTrace();
            } 
        }else{
                System.out.println("No se pudo descargar la lista de pacientes.");
        }
        
    }
    public void eliminarPaciente(String nombrePaciente) {
        
        String query = "DELETE FROM pacientes WHERE nombre LIKE '"+nombrePaciente+"';";
        
        if(DBHelper.ejecutarConsulta(query)>0)
            System.out.println("Paciente eliminado");
        else
            System.out.println("No se pudo eliminar el paciente.");
        
    }
      
}
//Fin clase Hospital------------------------------------------------------------

//Inicio clase Persona----------------------------------------------------------
abstract class Persona{
    private int id;
    private String nombre;
    private int edad;
   
    public Persona(){}
    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }   
   
}
//Fin clase Persona-------------------------------------------------------------

//Inicio clase Doctor-----------------------------------------------------------
class Doctor extends Persona{
    
    private String especialidad;
   
    public Doctor(){
        super();
    }
    public Doctor(String especialidad, int id, String nombre, int edad) {
        super(id, nombre, edad);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctor{"+"Nombre : "+super.getNombre()+
                " Edad : "+super.getEdad()+" Especialidad=" +
                especialidad + '}';
    }/*Se emplea getter de la superclase, 
    pues se requiere que la misma tenga atributos privados.*/
          
}
//Fin clase Doctor--------------------------------------------------------------

//Inicio clase Paciente---------------------------------------------------------
class Paciente extends Persona{
    
    private String historial;
    private LocalDate fechaIngreso;
    private Doctor doctorCabecera;

    public Paciente(){
        super();
    }
    public Paciente(String historial, LocalDate fechaIngreso, 
            Doctor doctorCabecera, int id, String nombre, int edad) {
        super(id, nombre, edad);
        this.historial = historial;
        this.fechaIngreso = fechaIngreso;
        this.doctorCabecera = doctorCabecera;
    }

    public String getHistorial() {
        return historial;
    }
    public void setHistorial(String historial) {
        this.historial = historial;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public Doctor getDoctorCabecera() {
        return doctorCabecera;
    }
    public void setDoctorCabecera(Doctor doctorCabecera) {
        this.doctorCabecera = doctorCabecera;
    }

    @Override
    public String toString() {
        return "Paciente{"+"Nombre : "+super.getNombre() + "historial=" +
                historial + ", fechaIngreso=" + fechaIngreso + 
                ", doctorCabecera=" + doctorCabecera.getNombre()+
                " "+doctorCabecera.getId()+ '}';
    }
       
}
//Fin clase Paciente------------------------------------------------------------

//Inicio clase DB---------------------------------------------------------------
class DBHelper {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB="hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para ejecutar una consulta devolviendo cantidad de filas afectadas
    public static int ejecutarConsulta(String consulta) {
        int filas = 0;
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement ps = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                filas = ps.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
            return filas;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filas;
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        ResultSet rs;
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL+DB, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement ps = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            rs = ps.executeQuery();
            connection.close();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
//Fin clase DB------------------------------------------------------------------
