import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class _14_12_Mapeo
{
    public static void main(String[] args)
    {
        List<_14_12_Depart> departList = new LinkedList<>();
        try
        {
            _14_12_Depart depart;
            Connection conec = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "DAM", "1234");
            Statement statement = conec.createStatement();
            String sql = "SELECT * FROM DEPART";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                int dept_no = rs.getInt("DEPT_NO");
                String dnombre = rs.getString("DNOMBRE");
                String loc = rs.getString("LOC");
                depart = new _14_12_Depart(dept_no, dnombre, loc);
                departList.add(depart);
            }
            conec.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        for (_14_12_Depart dep : departList)
        {
            System.out.println("DEPT_NO: " + dep.getDept_no() + "\nDNOMBRE: " + dep.getName() + "\nLOC: " + dep.getLoc());
        }
    }
}
