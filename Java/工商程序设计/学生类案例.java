class Student {
    private int no;        // 学号
    private String name;   // 姓名
    private double score;  // 成绩

    // 构造函数
    public Student(int no, String name, double score) {
        this.no = no;
        this.name = name;
        this.score = score;
    }

    // 获取学生学号的方法
    public int getNo() {
        return no;
    }

    // 获取学生姓名的方法
    public String getName() {
        return name;
    }

    // 获取学生分数的方法
    public double getScore() {
        return score;
    }

    // 输出学生信息的方法
    public void showStu() {
        System.out.println("学号: " + no + ", 姓名: " + name + ", 成绩: " + score);
    }

    // 返回学生信息的字符串表示
    @Override
    public String toString() {
        return "学号: " + no + ", 姓名: " + name + ", 成绩: " + score;
    }

}

public class 学生类案例 {
    public static void main(String[] args) {
        Student student = new Student(1, "张三", 95.5);
        student.showStu();
    }
}
