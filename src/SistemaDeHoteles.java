
package modeloExamenPrimerParcial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class SistemaDeHoteles {
       
    private static int opcion;
    
    public static void main(String args[]){
        
      Scanner sc = new Scanner(System.in); 
      //Se crea el hotel, y se le asig
      Hotel hotel1 = new Hotel();
      //Se crean unas cuantas habitaciones vacias(sin huespedes.)
      Habitacion habitacion1 = new Habitacion(3,2,115);
      Habitacion habitacion2 = new Habitacion(1,1,119);
      Habitacion habitacion3 = new Habitacion(4,4,95);
      Habitacion habitacion4 = new Habitacion(4,3,102);
      //Se crea una lista con las habitaciones y se lo asigna al hotel instanciado.
      ArrayList<Habitacion> habitaciones = new ArrayList();
      habitaciones.add(habitacion1);
      habitaciones.add(habitacion2);
      habitaciones.add(habitacion3);
      habitaciones.add(habitacion4);
      hotel1.setHabitaciones(habitaciones);
      //Creacion de un par de huespedes que ocuparan las habitaciones.
      Huesped huespedA = new Huesped("Juan","Pacheco",4485696,9965);
      Huesped huespedB = new Huesped("Rodrigo","Diaz",4482596,9255);
      Huesped huespedC = new Huesped("Manuel","Pacheco",3485696,9948);
      Huesped huespedD = new Huesped("Pedro","Gunter",2486696,3365);
      Huesped huespedE = new Huesped("Jorge","Strauss",4105696,1103);
      Huesped huespedF = new Huesped("Laura","Caceres",1465896,6631);
      Huesped huespedG = new Huesped("Maria","Bradfor",326896,2213);
      Huesped huespedH = new Huesped("Julio","Benavidez",2085696,1030);
      Huesped huespedJ = new Huesped("Mirian","Felp",4116396,7513);
      
      
        do{
            System.out.println("Bienvenido al Sistema de reservas /// "+hotel1.getNombreHotel());
            System.out.println(SistemaDeHoteles.mostrarMenu());
            System.out.print(" Su opcion  ¿? : >>> ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: hotel1.mostrarHabitaciones();
                        System.out.println("///Fin_Ejecucion_Opcion1.///\n\n\n");
                        break;
                case 2: System.out.print("Seleccione un numero de habitacion a reservar : >>> ");
                        break;
                case 3: ;break;
                case 4: hotel1.serializarHabitacionRyNR();
                        break;
                case 5: ArrayList<Habitacion> lista = hotel1.deserializarHabitacionesRyNR();
                        for(Habitacion aux : lista){
                            System.out.println(aux.mostrarInformacion());
                        }
                        break;
                case 6: System.out.println("Gracias por utilizar los servicios de : "+
                        "//Aqui se debe hacer lectura del archivo que contenga el nombre del hotel.");
                        break;
                default :System.out.println("Opcion >>> "+opcion+", no es una opcion valida.");
            }
            
        }while(opcion!=6);
    }
    public static String mostrarMenu(){
        return ("Menu:\n"+"1. Ver la lista de habitaciones.\n"+"2. Reservar una habitacion.\n"+
                "3. Cancelar una reserva.\n"+"4. Guardar reservas en un archivo.\n"+
                "5. Cargar reservas desde un archivo.\n"+"6. Salir.");
    } //static para no tener que instanciar SistemaDeHoteles.  
}
//---------------------------------------------Clase Hotel---------------------------------------------
class Hotel{
    private String nombreHotel;
    private ArrayList<Habitacion> habitaciones;
 
    public void mostrarHabitaciones(){
        for(int i = 0; i<this.habitaciones.size(); i++){
            Habitacion habitacion = this.habitaciones.get(i);
            System.out.println(habitacion.mostrarInformacion()+
                    "\n----------------------------------");
        }
    }
    
    public boolean reservarUnaHabitacion(int numeroHabitacion, ArrayList<Huesped> listaHuespedes){
        for(int i = 0; i<this.habitaciones.size(); i++){
            if(habitaciones.get(i).getNumeroHabitacion() == numeroHabitacion){
                return habitaciones.get(i).reservarEstaHabitacion(listaHuespedes);
             //Si la habitacion se pudo reservar devolvera true.   
            }
        }
        return false;
    }
    
    public void serializarHabitacionRyNR(){
        Serializador serializador = new Serializador();
        serializador.serializar(this.habitaciones);
    }
    
    public ArrayList deserializarHabitacionesRyNR(){
        Serializador serializador = new Serializador();
        ArrayList<Habitacion> habitaciones = serializador.deserializar();
        return habitaciones;
    }

    public String getNombreHotel() {
        LeerFichero accesoExternos = new LeerFichero();
        String cadena = accesoExternos.leeDatos();
        return cadena;
    }

    public void setNombreHotel(String nombreHotel) {
        Escritura escribeElArchivo = new Escritura();
        escribeElArchivo.escribir(nombreHotel);
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
    
}
//-------------------------------------------Clase Persona---------------------------------------------
abstract class Persona { 
    protected String nombre;
    protected String apellido;
    protected int dni;
        
        public Persona(){}
        public Persona(String nombre, String apellido, int dni){
            try{
                this.nombre = nombre;
                this.apellido = apellido;
                this.dni = dni;
            }catch(NullPointerException npE){
                JOptionPane.showMessageDialog(null, "Todos los campos deben ser completados.");
            }catch(NumberFormatException nfE){
                JOptionPane.showMessageDialog(null, "Dni debe ser completado como un entero sin puntos.");
            }
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
        
}
//-------------------------------------------Clase Huesped---------------------------------------------
final class Huesped extends Persona implements MostrarInformacion{

    private int idHuesped;
        public Huesped(){}
        public Huesped(String nombre, String apellido, int dni, int idHuesped){
            super(nombre, apellido, dni);
            try{
                this.dni = dni;
            }catch(NumberFormatException nfE){
                JOptionPane.showMessageDialog(null, "idHuesped debe ser completado como un entero sin puntos.");
                return;
            }
        }
    @Override
    public String mostrarInformacion() {
        return (this.nombre+" "+this.apellido+
                "\n id : "+this.idHuesped+"\n dni : "+this.dni);
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }
    
}
//-------------------------------------------Clase Habitacion------------------------------------------
final class Habitacion implements MostrarInformacion, Serializable{
    
    ArrayList<Huesped> listaHuespedes;
    private int numeroHabitacion;
    private int capacidadHuespedes;
    private int cantidadCamas;
    private EstaLibreONo estado;
    
    public Habitacion(){
        this.capacidadHuespedes = 1;
        this.cantidadCamas = 1;
        this.estado = estado.LIBRE;
    }  
    public Habitacion( int capacidadHuespedes, int cantidaCamas, int numeroHabitacion){
        try{
            this.capacidadHuespedes = capacidadHuespedes;
            this.cantidadCamas = cantidaCamas;
            this.numeroHabitacion = numeroHabitacion;
        }catch(NullPointerException npE){
            return;
        }
        this.estado = estado.LIBRE;    
    }

    public ArrayList<Huesped> getListaHuespedes() {
        return listaHuespedes;
    }

    public int getCapacidadHuespedes() {
        return capacidadHuespedes;
    }

    public void setCapacidadHuespedes(int capacidadHuespedes) {
        this.capacidadHuespedes = capacidadHuespedes;
    }

    public int getCantidadCamas() {
        return cantidadCamas;
    }

    public void setCantidadCamas(int cantidadCamas) {
        this.cantidadCamas = cantidadCamas;
    }

    public EstaLibreONo getEstado() {
        return estado;
    }

    public void setEstado(EstaLibreONo estado) {
        this.estado = estado;
    }
    
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int nuevoNumeroHabitacion) {
        this.numeroHabitacion = nuevoNumeroHabitacion;
    }
    
    public boolean reservarEstaHabitacion(ArrayList<Huesped> listaHuespedes){
        if(this.estado == estado.LIBRE){
            try{
                if(listaHuespedes.size()>=1){
                    this.listaHuespedes = listaHuespedes;
                }else{
                    return false;
                }           
            }catch(NullPointerException npE){
                return false;
            }
            this.estado = estado.OCUPADO;
            return true;
        }else{
            return false;
        }     
    }
    
    public void cancelarReservacionEnEstaHabitacion(){
        this.listaHuespedes = null;
        this.estado = estado.LIBRE;
    }
    
    public Huesped desvincularUnHuespedEnLaListaDeUnaHabitacion(int numHabitacion, int idHuesped){
        for(int i = 0; i < this.listaHuespedes.size(); i++){
            if(this.listaHuespedes.get(i).getIdHuesped() == idHuesped){
                Huesped huesped = (Huesped)this.listaHuespedes.remove(i);
                return huesped;//Se retorna con el huesped eliminado.
            }
        }
        return null;//Si el huesped con el idHuesped epecificado en parametro no esta en la lista.
    }
       
    @Override
    public String mostrarInformacion() {
        int contingencia;
        try{
             contingencia = this.listaHuespedes.size();
        }catch(NullPointerException npE){
             contingencia = 0;
        }
        return ("\nHabitacion nro : "+this.numeroHabitacion+
                "\nEstado actual : "+this.estado+
                "\nCantidad camas : "+this.cantidadCamas+
                "\nCapacidad huespedes : "+this.capacidadHuespedes+
                "\nOcupacion actual : "+contingencia+" huespedes.");
    }   
}
//------------------------------------------Clase Interface--------------------------------------------
interface MostrarInformacion{
    public String mostrarInformacion();
}
//------------------------------------------Clase Enumerados-------------------------------------------
enum EstaLibreONo{
    LIBRE,
    OCUPADO;
}
//------------------------------------------Clase Escritura--------------------------------------------
class Escritura{
    public void escribir(String nombre){

        try {

            FileWriter escritura = new FileWriter("nombreHotel.txt", true);
               //El archivo se crea por defecto en la carpeta donde esta guardado el proyecto.
            for(int i =0; i < nombre.length(); i++){
                escritura.write(nombre.charAt(i));
            }
            escritura.write("\n");
            escritura.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
//-------------------------------------------Clase Lectura---------------------------------------------
class LeerFichero {

   public String leeDatos() {
       String cadena = new String();
       try {
         
         FileReader entrada = new FileReader("nombreHotel.txt");
         
         int caracter = entrada.read(); 
         char letra =(char)caracter; 

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
//-----------------------------------------Clase Serializador------------------------------------------
class Serializador{
    public void serializar(ArrayList<Habitacion> habitaciones ) {
        try {
            // Crear un flujo de salida para escribir en un archivo llamado "curso.txt"
            FileOutputStream archivoSalida = new FileOutputStream("habitacionesRyNR.txt");
            // Crear un flujo de objeto para escribir objetos en el flujo de salida
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            // Escribir el objeto "curso" en el flujo de salida
            flujoSalida.writeObject(habitaciones);
            // Importante: cerrar el flujo de salida para liberar recursos
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
    }

    public ArrayList deserializar() {
        ArrayList<Habitacion> habitaciones = null;
        try {
            // Abrir un flujo de entrada para leer desde el archivo "curso.txt"
            FileInputStream archivoEntrada = new FileInputStream("habitacionesRyNR.txt");
            // Crear un flujo de objeto para leer objetos desde el flujo de entrada
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            // Leer el objeto serializado desde el flujo de entrada y convertirlo a un objeto Curso
            habitaciones = (ArrayList) flujoEntrada.readObject();
            // Importante: cerrar el flujo de entrada para liberar recursos
            flujoEntrada.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
        return habitaciones; // Devolver el objeto Curso deserializado
    }
}

/*Archivos. 
 "..."+File.separator+"..."
File archivo = new File("ruta y nombre del archivo.");
archivo.exists()
String[] nombres = carpeta.list();
File f = new File(carpeta.getAbsolutePath(), nombres[i])
if(f.isDirectory()){
    String[] nombresEnSubCarpeta = f.list();
        //Recorre nombresEnSubCarpeta con un for.

File carpeta = new File("Ubicacion");
carpeta.mkdir();

//Agregar contenido
..desde teclado..
String frase = lectura.nextLine();
File Writer escribidor = new FileWriter("direccion"), (append) true);
escribidor.write(frase.toString())
escribidor.close()
*/