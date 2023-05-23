import java.sql.*;

public class _14_11_Mostrar_Todos
{
    public static void main(String[] args) throws SQLException {
        Statement statement;
        String sql;
        Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/instituto", "root", "admin1234_");
        try
        {
            statement = conec.createStatement();
            sql = "SELECT * FROM EMPLE";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("The sql statement was successfully executed.");
            conec.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
