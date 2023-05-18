import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class _14_15_Check_Insert_Delete
{
    public static Connection Connection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521";
        String username = "DAM";
        String password = "1234";
        return DriverManager.getConnection(url, username, password);
    }

    public static boolean EmployeeExists (int emp_no) throws SQLException {
        Connection conec = Connection();
        String sql = "SELECT EMP_NO FROM EMPLE WHERE EMP_NO = ?";
        try
        {
            PreparedStatement preparedStatement = conec.prepareStatement(sql);
            preparedStatement.setInt(1, emp_no);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                conec.close();
                return true;
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return false;
    }
    public static boolean DepartExists (int dept_no) throws SQLException {
        Connection conec = Connection();
        String sql = "SELECT DEPT_NO FROM EMPLE WHERE DEPT_NO = ?";
        try
        {
            PreparedStatement preparedStatement = conec.prepareStatement(sql);
            //this sets the value for the placeholders, it is one because that is
            // the index of that placeholder in the statement
            preparedStatement.setInt(1 , dept_no);
            //execute the query and store the result in the resultset variable
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
            {
                conec.close();
                ShowDepartList();
                return true;
            }
            return false;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void CreateEmple (_14_15_Empleado emple) throws SQLException {
        if(emple != null)
        {
            int emp_no = emple.getEmp_no();
            int dept_no = emple.getDept_no();
            if (EmployeeExists(emp_no))
            {
                System.out.println("This employee already exists.");
            }
            if (DepartExists(dept_no))
            {
                System.out.println("This department already exists.");
            }
            Connection connection = Connection();
            try
            {
                String sql = "INSERT INTO EMPLE (EMP_NO, APELLIDO, OFICIO, DIR, FECHA_ALT, SALARIO, COMISION, DEPT_NO) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, emple.getEmp_no());
                preparedStatement.setString(2, emple.getApellido());
                preparedStatement.setString(3, emple.getOficio());
                preparedStatement.setInt(4, emple.getDir());
                preparedStatement.setDate(5, Date.valueOf(emple.getFecha_alt()));
                preparedStatement.setInt(6, emple.getSalario());
                preparedStatement.setInt(7, emple.getComision());
                preparedStatement.setInt(8, emple.getDept_no());
                preparedStatement.executeUpdate();
                connection.close();
                System.out.println("Employee added successfully");
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    public static void DeleteEmployee (int emp_no) throws SQLException
    {
        Connection connection = Connection();
        try
        {
            String sql = "DELETE FROM EMPLE WHERE EMP_NO = ?";
            //prepare the query
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //set the value of the first placeholder
            preparedStatement.setInt(1, emp_no);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Employee deleted successfully.");
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void ShowDepartList () throws SQLException {
        List<_14_12_Depart> departList = new ArrayList<_14_12_Depart>();
        Connection connection = Connection();
        try
        {
            String sql = "SELECT * FROM DEPART";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next())
            {
                int dept_no = rs.getInt("DEPT_NO");
                String name = rs.getString("DNOMBRE");
                String loc = rs.getString("LOC");
                _14_12_Depart depart = new _14_12_Depart(dept_no, name, loc);
                departList.add(depart);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }
}
