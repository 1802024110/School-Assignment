import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 接受输入数字输出平均值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("请输入数字，以空格分隔，#结束输入：");
        String input = scanner.nextLine();
        
        if (input.contains("#")) {
            input = input.substring(0, input.indexOf("#")).trim();
            String[] parts = input.split(" ");
            List<Double> numbers = new ArrayList<>();
            
            for (String part : parts) {
                try {
                    numbers.add(Double.parseDouble(part));
                } catch (NumberFormatException e) {
                    System.out.println(part + " 不是有效的数字，跳过。");
                }
            }
            
            if (!numbers.isEmpty()) {
                double sum = 0;
                for (double number : numbers) {
                    sum += number;
                }
                double average = sum / numbers.size();
                System.out.println("平均值为: " + average);
            } else {
                System.out.println("没有输入有效的数字。");
            }
        } else {
            System.out.println("输入中未找到 # 符号。");
        }
        
        scanner.close();
    }
}
