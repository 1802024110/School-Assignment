class Teacher {
    private String tno;       // 教师工号
    private String tname;     // 姓名
    private int tage;         // 年龄
    private String tdept;     // 部门
    private int selfNum;      // 教师注册顺序号
    private static int count = 0;  // 教师人数

    // 全参构造
    public Teacher(String tno, String tname, int tage, String tdept) {
        this.tno = tno;
        this.tname = tname;
        this.tage = tage;
        this.tdept = tdept;
        this.selfNum = ++count; // 自增教师注册顺序号
    }

    // 无参构造
    public Teacher() {
        this.selfNum = ++count; // 自增教师注册顺序号
    }

    // 获取属性的方法
    public String getTno() {
        return tno;
    }

    public String getTname() {
        return tname;
    }

    public int getTage() {
        return tage;
    }

    public String getTdept() {
        return tdept;
    }

    // 设置属性的方法
    public void setTno(String tno) {
        this.tno = tno;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTage(int tage) {
        this.tage = tage;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    // toString()方法
    @Override
    public String toString() {
        return "工号: " + tno + ", 姓名: " + tname + ", 年龄: " + tage + ", 部门: " + tdept + ", 注册顺序号: " + selfNum;
    }

    // 输出教师信息
    public void show() {
        System.out.println(toString());
    }

    // 类方法：输出教师总数
    public static int totalTeachers() {
        return count;
    }
}


public class 个人流水号 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("T001", "张老师", 30, "数学");
        Teacher teacher2 = new Teacher("T002", "李老师", 35, "英语");
        Teacher teacher3 = new Teacher("T003", "王老师", 40, "物理");

        teacher1.show();
        teacher2.show();
        teacher3.show();

        System.out.println("学校教师总数: " + Teacher.totalTeachers());
    }
}

