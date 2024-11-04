import java.util.Scanner;

public class 矩阵的输入输出 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 获取矩阵的行数和列数
        System.out.print("请输入矩阵的行数: ");
        int rows = scanner.nextInt();
        System.out.print("请输入矩阵的列数: ");
        int cols = scanner.nextInt();

        // 创建矩阵
        int[][] matrix = new int[rows][cols];

        // 从键盘输入矩阵元素
        System.out.println("请输入矩阵元素:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 输出矩阵
        System.out.println("输出矩阵:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
