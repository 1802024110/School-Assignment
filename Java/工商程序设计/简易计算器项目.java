import java.util.Scanner;

public class 简易计算器项目 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        String operator;
        boolean continueCalculation = true;

        while (continueCalculation) {
            System.out.print("请输入第一个数字: ");
            num1 = scanner.nextDouble();

            System.out.print("请输入运算符 (+, -, *, /): ");
            operator = scanner.next();

            System.out.print("请输入第二个数字: ");
            num2 = scanner.nextDouble();

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("除数不能为0！");
                        continue;
                    }
                    break;
                default:
                    System.out.println("无效的运算符！");
                    continue;
            }

            System.out.println("结果是: " + result);

            System.out.print("是否继续计算？(y/n): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) {
                continueCalculation = false;
            }
        }

        scanner.close();
        System.out.println("计算结束！");
    }
}
