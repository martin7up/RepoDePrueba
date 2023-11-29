/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloExamenPrimerParcial;

/**
 *
 * @author Usuario
 */
public class Pruebas {
    private EstaLibreONo disponibilidad;
    private int vbl;
        public Pruebas(){
            this.disponibilidad = EstaLibreONo.LIBRE;
        }
        
        public Pruebas(int vbl, EstaLibreONo disponibilidad){
            this.disponibilidad = disponibilidad;
            this.vbl = vbl;
        }

    public EstaLibreONo getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(EstaLibreONo disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
        
        

    @Override
    public String toString() {
        return (this.vbl +" "+disponibilidad);
    }
        
        
        
        public static void main(String args[]){
            Pruebas prueba1 = new Pruebas();
            System.out.println(prueba1.toString());
            
            Pruebas prueba2 = new Pruebas(2, EstaLibreONo.LIBRE);
            System.out.println(prueba2.toString());
            
        }
}

