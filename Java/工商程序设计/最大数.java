import java.util.Scanner;

public class 最大数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入三个整数
        System.out.print("请输入第一个整数: ");
        int num1 = scanner.nextInt();

        System.out.print("请输入第二个整数: ");
        int num2 = scanner.nextInt();

        System.out.print("请输入第三个整数: ");
        int num3 = scanner.nextInt();

        // 使用三元运算符比较三个整数的大小
        int max = (num1 > num2) ? (num1 > num3 ? num1 : num3) : (num2 > num3 ? num2 : num3);

        // 输出最大值
        System.out.println("最大值是: " + max);
    }
}
