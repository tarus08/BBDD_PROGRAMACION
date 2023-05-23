import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection con;
        String url = "jdbc:mysql://localhost/instituto";
        String username = "root";
        String password = "admin1234_";
        System.out.println("Enter the name of the kid to modify the grade of: ");
        String name = scanner.nextLine();

        try {
            con = DriverManager.getConnection(url, username, password);
            Statement statement = con.createStatement();
            String sqlName = "SELECT MEDIA FROM ALUMNOS WHERE NOMBRE = '" + name + "'";
            ResultSet rs = statement.executeQuery(sqlName);
            if (rs.next())
            {
                double media = rs.getDouble(1);
                System.out.println(name+ " has a media of " + media);
                System.out.println("Enter the new media for: " + name);
                double newMedia = scanner.nextDouble();
                String sqlUpdate = "UPDATE ALUMNOS SET MEDIA = '" + newMedia + "' WHERE NOMBRE = '" + name + "'";
                int rowsAffected = statement.executeUpdate(sqlUpdate);
                String sqlCheck = "SELECT MEDIA FROM ALUMNOS WHERE NOMBRE = '" + name + "'";
                ResultSet resultSet = statement.executeQuery(sqlCheck);
                if (resultSet.next())
                {
                    double updatedMedia = resultSet.getDouble(1);
                    System.out.println(name + "'s updated media is " + updatedMedia);
                }
                else
                {
                    System.out.println("Error updating media");
                }
            }
            else
            {
                System.out.println("Error getting media");
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
