package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private Connection conex;
    private String host = "jdbc:mariadb://localhost:3306/afa";
    private String user = "root";
    private String pass = "";
    
    public ConexionBD() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conex = DriverManager.getConnection(host, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public Connection getCon() {
        return conex;
    }
}
