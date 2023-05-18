import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _14_13_Ask_Show
{
    public static void main(String[] args)
    {
        Connection connection;
        List<_14_12_Depart> departList = new LinkedList<>();
        try
        {
            _14_12_Depart depart = null;
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "DAM", "1234");
            Statement statement = connection.createStatement();
            System.out.println("Insert the name of the city to show the data of: ");
            String loc = new Scanner(System.in).nextLine().toUpperCase();

            String sql = "SELECT * FROM DEPART WHERE LOC = '" + loc + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                int dept_no = resultSet.getInt(1);
                String dnombre = resultSet.getString(2);
                String locShow = resultSet.getString(3);
                depart = new _14_12_Depart(dept_no, dnombre, locShow);
                departList.add(depart);
            }
            assert depart != null;
            int showDeptNo = depart.getDept_no();
            String showDnombre = depart.getName();
            String showLoc = depart.getLoc();
            System.out.println("DEPT_NO: " + showDeptNo + "\nDNOMBRE: " + showDnombre + "\nLOC: " +  showLoc);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
