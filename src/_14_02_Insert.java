import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class _14_02_Insert
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost/instituto";
            String username = "root";
            String password = "admin1234_";
            Connection con = DriverManager.getConnection(url, username, password);

            String sqlCheck = "SELECT NUM FROM ALUMNOS";
            PreparedStatement preparedStatement01 = con.prepareStatement(sqlCheck);
            ResultSet resultSet = preparedStatement01.executeQuery();

            System.out.println("Enter the following data for the new student: " +
                    "\nId: " +
                    "\nName: " +
                    "\nBirth date (YYYY-MM-DD):" +
                    "\nAverage grade: " +
                    "\nClass: ");
            int id = scanner.nextInt();

            int idCheck = resultSet.getInt("NUM");
            if (id == idCheck)
            {
                System.out.println("This student is in the database.");
            }
            else
            {
                String name = scanner.next();
                //birthdate
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                LocalDate birthDate = LocalDate.of(year, month, day);
                double averageGrade = scanner.nextDouble();
                String className = scanner.next();
                String sql = "INSERT INTO ALUM_PROGRAMACION (NUM, NOMBRE, FNAC, MEDIA, CURSO)" +
                        " VALUES (" +id+ ", '"+name+"', '"+birthDate+"', '"+averageGrade+"', '"+averageGrade+"', '"+className+"')";
                PreparedStatement preparedStatement02 = con.prepareStatement(sql);
                int rowsAffected = preparedStatement02.executeUpdate();
                System.out.println(rowsAffected + " rows affected.");
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("There was an error: " + ex.getMessage());
        }
    }
}
