import java.sql.*;
public class _14_06_Cursor_Before_After
{
    public static void main(String[] args)
    {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521";
            String username = "DAM";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT NOMBRE, MEDIA FROM ALUM_PROGRAMACION ORDER BY MEDIA DESC";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("All the students.");
            while (resultSet.next())
            {
                System.out.println("Name: " + resultSet.getString(1) + ". Average grade: " + resultSet.getDouble(2));
                System.out.println(" ");
            }

            System.out.println("The student with the highest average grade is: ");
            if (resultSet.first()) {
                String name = resultSet.getString("NOMBRE");
                double avgGrade = resultSet.getDouble("MEDIA");
                System.out.println("Name: " + name + ". Average grade: " + avgGrade);
            }
            System.out.println(" ");
            System.out.println("The student with the lowest average grade is: ");
            if (resultSet.last()) {
                String name = resultSet.getString(1);
                double avgGrade = resultSet.getDouble(2);
                System.out.println("Name: " + name + ". Average grade: " + avgGrade);
            }
            connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
