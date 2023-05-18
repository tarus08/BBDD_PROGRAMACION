import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class _14_09_Informes
{
    public static void main(String[] args)
    {
        List<_14_09_Alum_Progr> alumProgrList6to7 = new LinkedList<>();
        List<_14_09_Alum_Progr> alumProgrList7to9 = new LinkedList<>();
        try
        {
            String url = "jdbc:oracle:thin:@localhost:1521";
            String username = "DAM";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Students whose grades are between 6 and 7, in ascending order.");
            String sql01 = "SELECT * FROM ALUM_PROGRAMACION WHERE MEDIA BETWEEN 6 AND 7 ORDER BY MEDIA ASC";
            PreparedStatement preparedStatement01 = connection.prepareStatement(sql01);
            ResultSet resultSet01 = preparedStatement01.executeQuery();
            while (resultSet01.next())
            {
                int num = resultSet01.getInt("NUM");
                String name = resultSet01.getString("NOMBRE");
                Date birthDate = resultSet01.getDate("FNAC");
                double avgGrade = resultSet01.getDouble("MEDIA");
                String grade = resultSet01.getString("CURSO");
                _14_09_Alum_Progr alumProgr = new _14_09_Alum_Progr(num, name, grade, birthDate, avgGrade);
                alumProgrList6to7.add(alumProgr);
            }
            for (_14_09_Alum_Progr al : alumProgrList6to7)
            {
                System.out.println("NUM: " + al.getNum() + "\nNAME: " + al.getName() + "\nGRADE: " + al.getGrade() + "\nBIRTHDATE: " + al.getBirthDate() + "\nAVGRADE: " + al.getAverageGrade());
            }
            System.out.println("---------------------------------------------");
            System.out.println("Students whose grades are between 7 and 9, in ascending order.");
            String sql02 = "SELECT * FROM ALUM_PROGRAMACION WHERE MEDIA BETWEEN 7 AND 9 ORDER BY MEDIA ASC";
            PreparedStatement preparedStatement02 = connection.prepareStatement(sql02);
            ResultSet resultSet02 = preparedStatement02.executeQuery();
            while (resultSet02.next())
            {
                int num = resultSet02.getInt("NUM");
                String name = resultSet02.getString("NOMBRE");
                String grade = resultSet02.getString("CURSO");
                Date birthDate = resultSet02.getDate("FNAC");
                double averageGrade = resultSet02.getDouble("MEDIA");
                _14_09_Alum_Progr alum = new _14_09_Alum_Progr(num, name, grade, birthDate, averageGrade);
                alumProgrList7to9.add(alum);
            }
            for(_14_09_Alum_Progr alumn : alumProgrList7to9)
            {
                System.out.println("NUM: " + alumn.getNum() + "\nNAME: " + alumn.getName() + "\nGRADE: " + alumn.getGrade() + "\nBIRTHDATE: " + alumn.getBirthDate() + "\nAVGRADE: " + alumn.getAverageGrade());
                System.out.println(" ");
            }
            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

