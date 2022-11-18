import javax.swing.*;
import java.sql.*;
public class BBDDprueba {
    public static void main(String[] args) {
        Connection con = null;
        String sURL = "jdbc:mysql://localhost/bbdd_prueba";
        try {
            con = DriverManager.getConnection(sURL,"root","");



            //Statement stmt = con.createStatement(); //este es el metodo de google, el de abajo es el metodo del video
            //stmt.execute("create database lineadecodigo");
            //System.out.println("Base de datos creada correctamente");

//            PreparedStatement pstm = con.prepareStatement("insert into cuenta values(?,?,?,?,?,?,null,null,null)");
//            pstm.setString(1,"Ricardo Adorno");
//            pstm.setString(2,"4872651");
//            pstm.setString(3,"1234");
//            pstm.setString(4,"1345000");
//            pstm.setString(5,"45757200542581423");
//            pstm.setString(6,"12/24");
//            pstm.setString(7,"12345");
//            pstm.setString(8,"12345");
//            pstm.setString(9,"12345");
//            pstm.setString(2,"Ricardo Adorno, cerrista de corazon");
//            pstm.setString(3,"1000000");
//            pstm.executeUpdate();


            //System.out.println("Registro creado correctamente");

            PreparedStatement pstm = con.prepareStatement("select * from cuenta where PinCuenta = 1234 ");
            ResultSet rs = pstm.executeQuery();




            while(rs.next()){
                System.out.println("Numero de cuenta: "+rs.getString("NumCuenta"));
                System.out.println("Nombre: "+rs.getString("Nombre"));
                System.out.println("Saldo: "+rs.getString("Saldo"));
                System.out.println("Pin de cuenta: "+rs.getString("PinCuenta"));
                System.out.println("Numero de Tarjeta: "+rs.getString("NumTarjeta"));
                System.out.println("Fecha de vencimiento: "+rs.getString("FechaValid"));
                System.out.println("Numero Secreto: "+rs.getString("NumSecreto"));
                System.out.println("Cedula de identidad: "+rs.getString("CI"));
                System.out.println("Contrasenha: "+rs.getString("Password"));;
                System.out.println();
            }



        } catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString() );
        } finally {
            try {
                // Cerramos posibles conexiones abiertas
                if (con!=null) con.close();
            } catch (Exception e) {
                System.out.println("Error cerrando conexiones: " + e.toString());
            }
        }

        //System.out.println("Hello world!");
    }
}
