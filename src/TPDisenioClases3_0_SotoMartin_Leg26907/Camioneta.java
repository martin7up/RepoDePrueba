
package TPDisenioClases3_0_SotoMartin_Leg26907;

import java.time.LocalDate;


public class Camioneta extends Rodado{
    
        public Camioneta(){}
        public Camioneta(String marca, String modelo, LocalDate anio, String color 
                        , TipoCarroceria carroceria, Boolean esUsado, Boolean mantenimientoHecho){
            
            super(marca, modelo, anio, color, carroceria, esUsado, mantenimientoHecho);
        }

    @Override
    public String toString() {
        return (">>> Camioneta\n___________________________"+
                "Marca >>> "+Camioneta.super.getMarca()+"\n"+
                "Modelo >>> "+Camioneta.super.getModelo()+"\n"+
                "Carroceria >>> "+Camioneta.super.getCarroceria()+"\n"+
                "Anio >>> "+Camioneta.super.getAnio()+"\n"+
                "Color >>> "+Camioneta.super.getColor()+"\n"+
                "Es usada/o >>> "+Camioneta.super.getEsUsado()+"\n"+
                "Se ha realizado mantenimiento >>> "+Camioneta.super.getMantenimientoHecho()+"\n");
    }
        
            
}
