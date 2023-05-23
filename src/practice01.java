import java.sql.*;

public class practice01
{
    public static void main(String[] args)
    {
        Connection con;
        String url = "jdbc:mysql://localhost/instituto";
        String username = "root";
        String password = "admin1234_";
        String sql;

        try
        {
            con = DriverManager.getConnection(url, username, password);
            sql = "SELECT MEDIA, NOMBRE FROM ALUMNOS ORDER BY MEDIA DESC";
            System.out.println("These are the alumnos and their average grades: ");
            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                String name = resultSet.getString("nombre");
                double grade = resultSet.getDouble("media");
                System.out.println(" ");
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            }

            System.out.println("The student with the highest grade: ");

            if (resultSet.first())
            {
                String name = resultSet.getString("nombre");
                double grade = resultSet.getDouble("media");
                System.out.println(" ");
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            }

            System.out.println("The student with the lowest grade: ");
            if (resultSet.last())
            {
                String name = resultSet.getString("nombre");
                double grade = resultSet.getDouble("media");
                System.out.println(" ");
                System.out.println("Name: " + name);
                System.out.println("Grade: " + grade);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
