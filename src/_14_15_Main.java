import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class _14_15_Main
{
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to add a new employee, 2 to remove a employee.");
        int choice = scanner.nextInt();
        switch (choice)
        {
            case 1 ->
            {
                System.out.println("""
                Introduce:\s
                EMP_NO (int):
                APELLIDO (string):\s
                OFICIO (string):\s
                DIRECCION (int):\s
                FECHA ALTA (YYYY-MM-DD):
                SALARIO (int):\s
                COMISION (int):\s
                DEPT_NO (int):\s""");
                int emp_no = scanner.nextInt();
                String apellido = scanner.next();
                String oficio = scanner.next();
                int direccion = scanner.nextInt();
                //fecha alta
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                LocalDate fechaAlta = LocalDate.of(year, month, day);
                int salary = scanner.nextInt();
                int comission = scanner.nextInt();
                int dept_no = scanner.nextInt();
                _14_15_Empleado emple = new _14_15_Empleado (emp_no, apellido, oficio, direccion, fechaAlta, salary, comission, dept_no);
                try
                {
                    _14_15_Check_Insert_Delete.CreateEmple(emple);
                }
                catch (SQLException e)
                {
                    System.out.println("An error occurred while creating the employee: " + e.getMessage());
                }
            }
            case 2 ->
            {
                System.out.println("Enter the emp_no of the employee to delete.");
                int emp_no_delete = scanner.nextInt();
                try
                {
                    _14_15_Check_Insert_Delete.DeleteEmployee(emp_no_delete);
                }
                catch (Exception e) {
                    System.out.println("An error occurred while deleting the employee." + e.getMessage());

                }
            }
        }
    }
}
