import java.time.LocalDate;
import java.util.Date;
public class _14_15_Empleado
{
    private int emp_no, dir, comision, dept_no, salario;
    private LocalDate fecha_alt;
    private String apellido, oficio;
    _14_15_Empleado(int emp_no, String apellido, String oficio, int dir, LocalDate fecha_alt, int salario, int comision, int dept_no)
    {
        this.emp_no = emp_no;
        this.dir = dir;
        this.comision = comision;
        this.dept_no = dept_no;
        this.salario = salario;
        this.fecha_alt = fecha_alt;
        this.apellido = apellido;
        this.oficio = oficio;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public LocalDate getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(LocalDate fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
}
