import java.util.Scanner;

public class 异形数组的创建 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 创建不规则二维数组
        int[][] array = new int[3][];
        array[0] = new int[1];
        array[1] = new int[3];
        array[2] = new int[5];

        // 从键盘输入元素
        System.out.println("请输入数组元素:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        // 以梯形阵的形式输出
        System.out.println("梯形阵:");
        for (int i = 0; i < array.length; i++) {
            // 输出空格
            for (int
 k = 0; k < array.length - 1 - i; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // 计算最大值
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("数组中的最大值为: " + max);

        scanner.close();
    }
}
