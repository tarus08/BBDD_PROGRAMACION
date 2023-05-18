
public class _14_12_Depart
{
    public int dept_no;
    public String name;
    public String loc;

    protected  _14_12_Depart(int dept_no, String name, String loc) {
        this.dept_no = dept_no;
        this.name = name;
        this.loc = loc;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
