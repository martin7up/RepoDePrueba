
package TPDisenioClases3_0_SotoMartin_Leg26907;

import java.time.LocalDate;


public class Motocicleta extends Rodado {
    public Motocicleta(){}
        public Motocicleta(String marca, String modelo, LocalDate anio, String color 
                        , TipoCarroceria carroceria, Boolean esUsado, Boolean mantenimientoHecho){
            
        super(marca, modelo, anio, color, carroceria, esUsado, mantenimientoHecho);
    }
        
    @Override
    public String toString() {
        return (">>> Motocicleta\n___________________________"+
                "Marca >>> "+Motocicleta.super.getMarca()+"\n"+
                "Modelo >>> "+Motocicleta.super.getModelo()+"\n"+
                "Carroceria >>> "+Motocicleta.super.getCarroceria()+"\n"+
                "Anio >>> "+Motocicleta.super.getAnio()+"\n"+
                "Color >>> "+Motocicleta.super.getColor()+"\n"+
                "Es usada/o >>> "+Motocicleta.super.getEsUsado()+"\n"+
                "Se ha realizado mantenimiento >>> "+Motocicleta.super.getMantenimientoHecho()+"\n");
    }
}
