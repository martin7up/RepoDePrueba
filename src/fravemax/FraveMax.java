
package fravemax;

import fravemax.Entidades.*;
import fravemax.AccesoADatos.*;
import java.time.LocalDate;
import java.util.Scanner;

public class FraveMax {

    public static void main(String[] args) {
  
//        ClienteData clDat = new ClienteData();
//        Cliente cl = new Cliente(365156, "Jorge", "Svez", "Correa 9984", "3624153564");
//        clDat.agregarCliente(cl);
//        Cliente cl;
        Cliente cl1;
        cl1 = new Cliente(19,335684, "pedro", "cardozo", "los kalces 365", "3625482");
//        clDat.agregarCliente(cl);
//        cl = new Cliente(365956, "Manuel", "Estebes", "Tepin 1000", "3623573564");
//        clDat.agregarCliente(cl);
//        cl = new Cliente(16,311156, "Laura", "Manich", "Danubio 34", "3674535641");
//        clDat.agregarCliente(cl);
//        cl1 = new Cliente(17,362256, "Nelly", "Dure", "Sarfield 224", "3625745640");
//        clDat.agregarCliente(cl);
//        cl = new Cliente(363956, "Damian", "Raosa", "Guernica 1504", "3624241464");
//        clDat.agregarCliente(cl);
//            
//        Producto prod;
        Producto prod1;
        prod1 = new Producto(3,"Heladera","Grande.",172000,25,true);
//        ProductoData prodDat = new ProductoData();
//        prodDat.registrarProducto(prod);
//        prod = new Producto("Freezer","Grande tambien.",192000,15,true);
//        prodDat.registrarProducto(prod);
//        prod = new Producto(5,"Licuadora","Potente.",9000,11,true);
//        prodDat.registrarProducto(prod);
//        prod = new Producto("Aire acondicionado","Split.",192000,3,true);
//        prodDat.registrarProducto(prod);
//        prod1 = new Producto(7,"Almohadon","Lujoso.",1589,35,true);
//        prodDat.registrarProducto(prod);
//        
//        VentaData ventData = new VentaData();
//        Venta vent;
        Venta vent1;
        String fecha = "2019-10-25";
        LocalDate fechaVent = LocalDate.parse(fecha);
//        vent = new Venta(3,cl, fechaVent);
//        ventData.registraVenta(vent);
//        fecha = "2022-09-08";
//        fechaVent = LocalDate.parse(fecha);
        vent1 = new Venta(1,cl1, fechaVent);
//        ventData.registraVenta(vent);
//        
       DetalleVentaData detVentData = new DetalleVentaData();
       DetalleVenta detVent;
       detVent = new DetalleVenta(1, vent1, 1, prod1);
        detVentData.cargarDetalleVenta(detVent);
//        detVent = new DetalleVenta(3, vent, 90000, prod);
//        detVentData.cargarDetalleVenta(detVent);
        
//        ClienteData clDat = new ClienteData();
//        clDat.eliminarCliente(17);
//    Scanner sc = new Scanner(System.in);
//    int i = sc.nextInt();
//    String i = sc.nextLine();
//    long j = Long.parseLong(i);
            
//        Scanner sc = new Scanner(System.in);
//        String i = sc.nextLine();
//        double j = Double.parseDouble(i);

        
       

        
    }  
}