import java.util.Scanner;

public class 数组输入数字练习 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10]; // 创建一个长度为10的数组

        System.out.println("请输入10个数字：");
        for (int i = 0; i < 10; i++) {
            System.out.print("请输入第" + (i + 1) + "个数字：");
            numbers[i] = scanner.nextInt();
        }

        System.out.print("数组内容： [");
        for (int i = 0; i < 10; i++) {szhu
            System.out.print(numbers[i]);
            if (i < 9) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
