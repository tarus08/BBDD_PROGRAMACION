import java.sql.*;

public class _14_11_Mostrar_Todos
{
    public static void main(String[] args) throws SQLException {
        Statement statement;
        String sql;
        Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "DAM", "1234");
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
