import java.util.Random;

public class 输出数组最大值 {
    public static void main(String[] args) {
        // 定义一个int型一维数组，包含10个元素
        int[] numbers = new int[10];
        
        // 创建一个Random对象，用于生成随机数
        Random random = new Random();
        
        // 赋予数组随机整数
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // 生成0到99之间的随机整数
        }
        
        // 计算最大值、最小值、和值、平均值
        int max = numbers[0];
        int min = numbers[0];
        int sum = 0;
        
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
            if (number < min) {
                min = number;
            }
            sum += number;
        }
        
        double average = (double) sum / numbers.length;
        
        // 输出结果
        System.out.println("数组中的元素为：");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("\n最大值：" + max);
        System.out.println("最小值：" + min);
        System.out.println("总和：" + sum);
        System.out.println("平均值：" + average);
    }
}
