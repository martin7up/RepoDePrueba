package examenParcial1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//Inicio Clase Hospital---------------------------------------------------------
public class Hospital implements Serializable{
    //Declaracion de Objetos y vbles necesarias, estas vbles estan disponible solo para los metodos_
    private static Scanner sc = new Scanner(System.in); // _de la clase Hospital.
    private static ArrayList<Paciente> pacientes = new ArrayList();
    private static ArrayList<Doctor> doctores = new ArrayList();
    private static int opcion = 0;
    //Fin declaraciones.
    
    //Inicio metodo principal a ejecutar en este archivo .java
    public static void main(String[] args) {
        sc.useDelimiter("\n");
    //Creacion y asignacion de datos de partida.  
    //Se crea un par de doctores para poder mostrarlos.
        Doctor doctor1 = new Doctor("Juan","06/09/1980",445213,"Neumonologo");
        Doctor doctor2 = new Doctor("Pedro","02/09/1981",433213,"Clinico");
        Doctor doctor3 = new Doctor("Daio","02/06/1999",421213,"Cardiologo");
        doctores.add(doctor1);
        doctores.add(doctor2);
        doctores.add(doctor3);
    /*    
    //Se crea un par de pacientes, la lista puede crecer luego. En realidad con la serializacion no
    // es necesario hacer todo esto
        Paciente paciente1 = new Paciente("Juan", "15/09/2022", 656541, 1564892, 0);
        Paciente paciente2 = new Paciente("Pedro", "09/06/209", 556981, 15622812, 1);
        Paciente paciente3 = new Paciente("Matias", "15/02/2004", 452981, 1364832, 0);
        Paciente paciente4 = new Paciente("Daniel", "12/05/1972", 156981, 1464842, 1);
        Paciente paciente5 = new Paciente("Mara", "11/12/1990", 356981, 1565692, 0);
        pacientes.add(paciente5);
        pacientes.add(paciente4);
        pacientes.add(paciente3);
        pacientes.add(paciente2);
        pacientes.add(paciente1);
    //Se crean unos cuantos historiales.
        Evento ev1 = new Evento("15/07/2000", "Chequeo Normal.");
        Evento ev2 = new Evento("12/08/2000", "Radiografias normales.");
        Evento ev3 = new Evento("13/07/2001", "Puilas dilatadas, se recomienda aflojar con los juegos.");
        Evento ev4 = new Evento("03/04/2005", "Pulso normal.");
        Evento ev5 = new Evento("02/06/2009", "Resultados analisis de sangre normales.");
        ArrayList<Evento> historial = new ArrayList();
        historial.add(ev1);
        historial.add(ev2);
        historial.add(ev3);
        paciente3.setHistorial(historial);
        historial = new ArrayList();
        historial.add(ev4);
        historial.add(ev5);
        paciente5.setHistorial(historial); 
    */
    //--------------------------------------------------------------------------
        
        //Bloque de interfaz para con el usuario.-------------------------------
        pacientes = Hospital.deserializarPacientesYSusHistoriales();//Se carga la lista de pacientes_
        while(opcion!=8){                               //_desde el archivo de manera automatica.
            Hospital.mostrarMenu();
            System.out.print(">>> Seleccionar opcion : ");
            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println("\n\n");
            switch(opcion){
                case 1: 
                        Hospital.mostrarDoctores(doctores);
                        System.out.println("\n\n\n");
                        break;
                case 2: Hospital.registrarNuevoPaciente();
                        System.out.println("\n\n\n");
                        break;
                case 3: Hospital.actualizarInfoDePaciente();
                        System.out.println("\n\n\n");
                        break;
                case 4: Hospital.consultarHistorialDeUnPaciente();
                        System.out.println("\n\n\n");
                        break;
                case 5: Hospital.agregarEventoAHistorial();
                        System.out.println("\n\n\n");
                        break;
                case 6: Hospital.serializarPacientesySusHistoriales();
                        System.out.println("\n\n\n");
                        break;
                case 7: pacientes = Hospital.deserializarPacientesYSusHistoriales();//Hay que asignar al atrib 
                        for(Paciente aux : pacientes){  // pacientes lo que se des-serializa.
                            Paciente aux1 = (Paciente) aux; 
                            System.out.println("Nombre : "+aux1.getNombre()+"\nDni : "+aux1.getDni()+
                                    "\nFecha de nacimiento : "+aux1.getFechaNac()+"\nSangre tipo : "+aux.getTipoSangre());
                            aux.verHistorialDeEventos();                          
                        }
                        System.out.println("\n\n\n");
                        break;
                case 8: System.out.println(" >>> Fin de programa!!!");
                        break;
                default: System.out.println("|||||>>>Opcion no valida<<<|||||");
                         break;                     
        }
    }
        
    }
    //Fin metodo principal a ejecutar en este archivo .java
    
    //Inicio Declaracion e implementacion metodos de la clase Hospital a emplear en metodo main.
    private static String getNombreHospital() {
        return (LeerFichero.leerDatos("nombreHospital.txt"));
    }
    private static void mostrarMenu(){
        System.out.println(Hospital.getNombreHospital()+"\n"+
                           "Menu :\n"+
                            "1. Listar Doctores.\n"+
                            "2. Registrar un nuevo paciente.\n"+
                            "3. Actualiza informacion personal de un paciente.\n"+
                            "4. Consulta el historia medico de un paciente.\n"+
                            "5. Nuevo historial de un paciente.\n"+
                            "6. Guadar Historial de pacientes hacia achivo.\n"+
                            "7. Cargar Historial de pacientes desde archivo.\n"+
                            "8. Salir.\n");
    }
    private static void mostrarDoctores(ArrayList<Doctor> doctores){
        for(Doctor aux : doctores){
            System.out.println(aux.toString());
        }
    }
    private static void registrarNuevoPaciente(){
        System.out.print("Nombe paciente : >>> ");
        String nombre = sc.nextLine();
        
        System.out.print("Dni paciente : >>> ");
        int dni = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Fecha de Nacimiento (dd/mm/aaaa) paciente : >>> ");
        String fechaNac = sc.nextLine();
        
        System.out.print("Num Tel paciente : >>> ");
        int numTel = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Tipo Sangre paciente : >>> ");
        int sngre = sc.nextInt();
        sc.nextLine();
        //
        Paciente pacienteNuevo = new Paciente(nombre, fechaNac, dni, numTel, sngre);
        pacientes.add(pacienteNuevo);
        System.out.println("Paciente Agregado.\nRecuerde seleccionar opc 6 y luego opc 7"+
                ", para hacer efectivos los cambios y/o adiciones hechas.\n\n");
    }
    private static void actualizarInfoDePaciente(){
        System.out.print("Dni : >>> ");
        int dniBuscado = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<pacientes.size(); i++){
            if(pacientes.get(i).getDni() == dniBuscado){
                System.out.print("Nombre actual : "+pacientes.get(i).getNombre()+"\nNuevo : >>> ");                           
                String nombre = sc.nextLine();
                sc.nextLine();
                System.out.print("Numero actual : "+pacientes.get(i).getNumTel()+"\nNuevo : >>> "); 
                int numTel = sc.nextInt();
                System.out.print("Fecha de Nacimiento actual : >>> "+pacientes.get(i).getFechaNac()+"\nNuevo : >>> ");
                String fechaNac = sc.nextLine();
                System.out.print("Tipo Sange actual : >>> "+pacientes.get(i).getTipoSangre()+"\nNuevo : >>> ");
                int sngre = sc.nextInt();
                sc.nextLine();
                Paciente pacienteMod = new Paciente(nombre, fechaNac, dniBuscado, numTel, sngre, pacientes.get(i).getHistorial());
                pacientes.remove(i);
                pacientes.add(pacienteMod);
                System.out.println("Paciente Actualizado!\n\n\n");
                System.out.println("\nRecuerde seleccionar opc 6 y luego opc 7"+
                ", para hacer efectivos los cambios y/o adiciones hechas.\n\n");
            }                             
        }
    }
    private static void consultarHistorialDeUnPaciente(){
        System.out.println("Indique el DNI del paciente a buscar ");
        int dni = sc.nextInt();
        for(int i = 0; i<pacientes.size(); i++){
            if(pacientes.get(i).getDni() == dni){ 
                pacientes.get(i).verHistorialDeEventos();
            }
        }  
    }
    private static void agregarEventoAHistorial(){
        System.out.println("Indique el DNI del paciente a buscar ");
        int dni = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<pacientes.size(); i++){
            if(pacientes.get(i).getDni() == dni){
                System.out.println("Nuevo Historial");
                System.out.print("Fecha : ");
                String fecha = sc.nextLine();
                sc.nextLine();
                System.out.print("Evento : ");
                String obsevacion = sc.nextLine();
                Evento nuevoEvento = new Evento(fecha, obsevacion);
                if(pacientes.get(i).getHistorial()==null){
                    ArrayList<Evento> historial = new ArrayList();
                    pacientes.get(i).setHistorial(historial);
                    pacientes.get(i).getHistorial().add(nuevoEvento);
                }else{
                pacientes.get(i).getHistorial().add(nuevoEvento);
                }
            }
        }
        System.out.println("\nRecuerde seleccionar opc 6 y luego opc 7"+
                ", para hacer efectivos los cambios y/o adiciones hechas.\n\n");
    }
    private static void serializarPacientesySusHistoriales(){     
        Serializador.serializar(pacientes);
    }   
    private static ArrayList deserializarPacientesYSusHistoriales(){
        return Serializador.deserializar();
    }
    //Fin Declaracion e implementacion metodos de la clase Hospital a emplear en metodo main.
}
//Fin Clase Hospital------------------------------------------------------------

//Inicio clase Persona----------------------------------------------------------
abstract class Persona implements Serializable{
    protected String nombre;
    protected String fechaNac;
    protected int dni;
    
    public Persona(){}
    public Persona(String nombre, String fechaNac, int dni) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }     
}
//Fin clase Persona-------------------------------------------------------------

//Inicio clase Doctor-----------------------------------------------------------
class Doctor extends Persona{
    
    private String especialidad;
    
    public Doctor(){
        super();
    }
    
    public Doctor(String nombre, String fechaNac, int dni, String especialidad){
        super(nombre, fechaNac, dni);
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
        return ("Doctor : "+this.nombre+"; especialidad : "+this.especialidad);
    }   
}
//Fin clase Doctor--------------------------------------------------------------

//Inicio clase Paciente---------------------------------------------------------
class Paciente extends Persona implements Informacion, Serializable{

    private int numTel;
    private int tipoSangre;
    private ArrayList<Evento> historial; 
    
        public Paciente(){}
        public Paciente(String nombre, String fechaNac, int dni, int numTel, int tipoSangre){
            super(nombre, fechaNac, dni);
            this.numTel = numTel;
            this.tipoSangre = tipoSangre;
            this.historial = null;
        }
        public Paciente(String nombre, String fechaNac, int dni, int numTel, int tipoSangre, ArrayList historial){
            super(nombre, fechaNac, dni);
            this.numTel = numTel;
            this.tipoSangre = tipoSangre;
            this.historial = historial;    
        }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public ArrayList<Evento> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Evento> historial) {
        this.historial = historial;
    }
    
    @Override
    public void verHistorialDeEventos() {
        try{
        for(int i = 0; i<historial.size(); i++){
            System.out.println("\n/////////////////////////////////////");
            System.out.println(historial.get(i).toString());
            System.out.println("/////////////////////////////////////\n");
        }
        }catch(NullPointerException npE){
            System.out.println("ESTE PACIENTE NO TIENE HISTORIAL AUN.");
        }
    }
    
}
//Fin clase Paciente------------------------------------------------------------

//Inicio clase Evento-----------------------------------------------------------
class Evento implements Serializable{
    private String fecha;
    private String observaciones;
    
    public Evento(){}
    public Evento(String fecha, String observaciones){
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return (this.getFecha()+" - "+this.getObservaciones());
    }   
}
//Fin clase Evento--------------------------------------------------------------

//Inicio interface Informacion--------------------------------------------------
interface Informacion{
    void verHistorialDeEventos();
}
//Fin interface Informacion-----------------------------------------------------

//Inicio clase Serializador-----------------------------------------------------
class Serializador{
    
    public static void serializar(ArrayList<Paciente> pacientes ) {
        try {
            // Crear un flujo de salida para escribir en un archivo llamado "datos.txt"
            FileOutputStream archivoSalida = new FileOutputStream("datos.txt");
            // Crear un flujo de objeto para escribir objetos en el flujo de salida
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            // Escribir el objeto "pacientes" en el flujo de salida
            flujoSalida.writeObject(pacientes);
            // Importante: cerrar el flujo de salida para liberar recursos
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
    }

    public static ArrayList<Paciente> deserializar() {
        ArrayList<Paciente> pacientes = null;
        try {
            // Abrir un flujo de entrada para leer desde el archivo "datos.txt"
            FileInputStream archivoEntrada = new FileInputStream("datos.txt");
            // Crear un flujo de objeto para leer objetos desde el flujo de entrada
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            // Leer el objeto serializado desde el flujo de entrada y lo convierte a un objeto ArrayList
            pacientes = (ArrayList) flujoEntrada.readObject();
            // Importante: cerrar el flujo de entrada para liberar recursos
            flujoEntrada.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
        return pacientes; // Devolver el objeto ArrayList<Paciente> deserializado
    }
}
//Fin clase Serializador--------------------------------------------------------


//Inicio Clase LeerFichero------------------------------------------------------
class LeerFichero {
   public static String leerDatos(String nombreArchivo) {
       String cadena = new String();
       try {  
         FileReader entrada = new FileReader(nombreArchivo);        
         int caracter = entrada.read();
         char letra = (char)caracter; 
         while(caracter != -1){           
            cadena = cadena+letra;
            caracter = entrada.read();
            letra =(char)caracter;
         }
         entrada.close(); 
      } catch (Exception e) {
         e.printStackTrace();
      }
      return cadena;
   }   
}
//Fin Clase LeerFichero---------------------------------------------------------


//Aparentemente todas las clases se vean involucradas en un proceso de serializacion deben implementar
// la interfaz Serializable, incluso si una clase que solo heredara sus metodos y atributos a otra sub-
//clase que sera serializada, la super-clase debe implementar Serializable.
//Conviene que la primer des-serializcion se haga al inicio del programa asi se tiene, cargada la info
//de los pacientes para comenzar a trabajar.