
package TPDisenioClases3_0_SotoMartin_Leg26907;

import java.util.ArrayList;


public class GestorConcesionario {
    private ArrayList<Rodado> listaStock;
    private String menu;
        
        public GestorConcesionario(){}
        public GestorConcesionario(ArrayList listaStock, String menu){
                this.menu = menu;
                this.listaStock = listaStock;
        }
        
        public void agregarRodado(Automovil auto, ArrayList lista) {
            lista.add(auto);
        }
        
        public void agregarRodado(Camioneta camio, ArrayList lista) {
            lista.add(camio);
        }
        
        public void agregarRodado(Motocicleta moto, ArrayList lista) {
            lista.add(moto);
        }
        
        public void eliminarRodado(Rodado rodado, ArrayList lista){
                for(int i = 0; i<lista.size(); i++){
                    if(lista.get(i).equals(rodado)){
                        lista.remove(i);
                    }
                    break;
                }
            }
        
        
       

    public ArrayList<Rodado> getListaStock() {
        return listaStock;
    }

    public void setListaStock(ArrayList<Rodado> listaStock) {
        this.listaStock = listaStock;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
         
    public static void main(String args[]){
        ArrayList<Rodado> listaSucursal1 = new ArrayList<Rodado>();
        String menu = (">>>Menu_OPERACIONES_DE_SOCK\n"
                +"_______________________________\n"
                +"1 >>> Mostrar lista actual.\n"
                +"2 >>> Agregar un nuevo rodado.\n"
                +"3 >>> Eliminar un rodado existente\n"
                +"4 >>> Modificar un rodado existente.\n"
                +"5 >>> Buscar un rodado.\n"
                +"6 >>> Salir del menu."
                );
        GestorConcesionario gestorSucursal1 = new GestorConcesionario(listaSucursal1, menu);
        
        }
}
