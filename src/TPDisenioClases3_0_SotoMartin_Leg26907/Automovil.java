
package TPDisenioClases3_0_SotoMartin_Leg26907;

import java.io.Serializable;
import java.time.LocalDate;



public class Automovil extends Rodado{
    public Automovil(){}
        public Automovil(String marca, String modelo, LocalDate anio, String color 
                        , TipoCarroceria carroceria, Boolean esUsado, Boolean mantenimientoHecho){
            
            super(marca, modelo, anio, color, carroceria, esUsado, mantenimientoHecho);
        }
        
    @Override
    public String toString() {
        return (">>> Automovil\n___________________________"+
                "Marca >>> "+Automovil.super.getMarca()+"\n"+
                "Modelo >>> "+Automovil.super.getModelo()+"\n"+
                "Carroceria >>> "+Automovil.super.getCarroceria()+"\n"+
                "Anio >>> "+Automovil.super.getAnio()+"\n"+
                "Color >>> "+Automovil.super.getColor()+"\n"+
                "Es usada/o >>> "+Automovil.super.getEsUsado()+"\n"+
                "Se ha realizado mantenimiento >>> "+Automovil.super.getMantenimientoHecho()+"\n");
    }
}
