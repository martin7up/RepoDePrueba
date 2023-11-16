
package universidadgrupo69.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "universidad";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    
        private Conexion(){}/*PorCuestiones de seguridad talvez*/
        
        public static Connection getConexion(){
            if(connection == null){
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    connection = DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
                } catch (ClassNotFoundException cnE ) {
                    System.out.println(cnE.getMessage()+"Error al cargar driver de conexion.");
                    
                } catch (SQLException sqlE) {
                    System.out.println(sqlE.getMessage()+"Error al intentar la conexion.");
                }
            }
            return connection;
        
        }
}