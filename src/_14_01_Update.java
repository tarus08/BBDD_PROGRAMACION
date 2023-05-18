import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _14_01_Update {
    public static void main(String[] args) {
        try {
            Connection con;
            PreparedStatement sentencia;
            String sql;
            String url = "jdbc:oracle:thin:@localhost:1521/XE";
            String username = "DAM";
            String password = "1234";
            con = DriverManager.getConnection(url, username, password);
            sql = "UPDATE ALUM_PROGRAMACION SET MEDIA = MEDIA + 1 WHERE CURSO LIKE '1B'";
            sentencia = con.prepareStatement(sql);
            int rowsAffected = sentencia.executeUpdate();
            System.out.println("Se ha modificado la media de " + rowsAffected + " estudiantes");
            con.close();
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido un error: " + ex.getMessage());
        }
    }
}
