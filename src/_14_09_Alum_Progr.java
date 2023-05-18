import java.util.Date;

public class _14_09_Alum_Progr
{
    private String name, grade;
    private int num;
    private Date birthDate;
    private double averageGrade;

    public _14_09_Alum_Progr(int num, String name, String grade, Date birthDate, double averageGrade)
    {
        this.name = name;
        this.grade = grade;
        this.num = num;
        this.birthDate = birthDate;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
