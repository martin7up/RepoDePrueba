
package TPDisenioClases3_0_SotoMartin_Leg26907;

import java.io.Serializable;
import java.time.LocalDate;


public abstract class Rodado implements Serializable {
   
    protected String marca;
    protected String modelo;
    protected LocalDate anio;
    protected String color;
    protected TipoCarroceria carroceria;
    protected Boolean esUsado;
    protected Boolean mantenimientoHecho;
    
        public Rodado(){}
        public Rodado(String marca, String modelo, LocalDate anio, String color 
                        , TipoCarroceria carroceria, Boolean esUsado, Boolean mantenimientoHecho){
            this.marca = marca;
            this.modelo = modelo;
            this.anio = anio;
            this.color = color;
            this.carroceria = carroceria;
            this.esUsado = esUsado;
            this.mantenimientoHecho = mantenimientoHecho;
        }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnio() {
        return anio;
    }

    public void setAnio(LocalDate anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TipoCarroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(TipoCarroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Boolean getEsUsado() {
        return esUsado;
    }

    public void setEsUsado(Boolean esUsado) {
        this.esUsado = esUsado;
    }

    public Boolean getMantenimientoHecho() {
        return mantenimientoHecho;
    }

    public void setMantenimientoHecho(Boolean mantenimientoHecho) {
        this.mantenimientoHecho = mantenimientoHecho;
    }
        
            
}
