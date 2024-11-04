class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return year + "-" + month + "-" + day;
    }
}

class Student {
    private String sno; // 学号
    private String sname; // 姓名
    private Date birth; // 出生年月
    private String dept; // 系别

    public Student(String sno, String sname, Date birth, String dept) {
        this.sno = sno;
        this.sname = sname;
        this.birth = birth;
        this.dept = dept;
    }

    public void showStu() {
        System.out.println("学号: " + sno);
        System.out.println("姓名: " + sname);
        System.out.println("出生年月: " + birth.toString());
        System.out.println("系别: " + dept);
    }
}

public class 日期类对象 {
    public static void main(String[] args) {
        // 创建一个 Date 对象
        Date birthDate = new Date(1999, 9, 9);
        
        // 创建一个 Student 对象
        Student student = new Student("2021001", "张三", birthDate, "计算机科学与技术");
        
        // 显示学生信息
        student.showStu();
    }
}
