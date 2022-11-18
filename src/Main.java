import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        Connection con = null;
        String sURL = "jdbc:mysql://localhost:3306/lineadecodigo";
        try {
            con = DriverManager.getConnection(sURL,"root","");
            Statement stmt = con.createStatement();
            stmt.execute("create database lineadecodigo");
            System.out.println("Base de datos creada correctamente");
        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString() );
        } finally {
            try {
                // Cerramos posibles conexiones abiertas
                if (con!=null) con.close();
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: "
                        + e.toString());
            }
        }

        System.out.println("Hello world!");
    }
}