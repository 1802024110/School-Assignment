package chengji;

public class Student {
    private String name;
    private String snum;
    private double cg;

    public Student() {
    }

    public Student(String name, String snum, double cg) {
        this.name = name;
        this.snum = snum;
        this.cg = cg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public double getCg() {
        return cg;
    }

    public void setCg(double cg) {
        this.cg = cg;
    }
}
