import java.util.Scanner;
public class 键盘输入输出 {
    public static void main(String[] args){
        // 从键盘获取输入的学生信息(学号int,姓名string,成绩double,是否已报道boolean)
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学号: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // 清除换行符

        System.out.print("请输入姓名: ");
        String name = scanner.nextLine();

        System.out.print("请输入成绩: ");
        double score = scanner.nextDouble();

        System.out.print("是否已报道 (true/false): ");
        boolean reported = scanner.nextBoolean();

        System.out.println("学生信息:");
        System.out.println("学号: " + id);
        System.out.println("姓名: " + name);
        System.out.println("成绩: " + score);
        System.out.println("是否已报道: " + reported);
        
        scanner.close();
    }
}
