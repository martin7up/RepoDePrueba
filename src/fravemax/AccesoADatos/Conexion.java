
package fravemax.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="FraveMax";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static Connection connection;

    public Conexion() {
    }
    
     public static Connection getConexion(){
        if(connection==null){
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                JOptionPane.showMessageDialog(null,"CONECTADO");
                
            } catch (ClassNotFoundException cnfE) {
                JOptionPane.showMessageDialog(null,"Error al cargar los driver");
                cnfE.printStackTrace();
            } catch (SQLException sqlE) {
                JOptionPane.showMessageDialog(null,"Error al cargarse la BD");
                sqlE.printStackTrace();
            }
        }
     return connection;
    }
    
}
