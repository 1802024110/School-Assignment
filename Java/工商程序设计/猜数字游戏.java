import java.util.Random;
import java.util.Scanner;

public class 猜数字游戏 {

    public static void main(
String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            boolean guessed = false;

            System.out.println("我选择了一个 " + minNumber + " 到 " + maxNumber + " 之间的数字。");

            while ( !guessed) {
                int guess = scanner.nextInt();

                if (guess < numberToGuess) {
                    System.out.println("太低了！");
                } else if (guess > numberToGuess) {
                    System.out.println("太高了！");
                } else {
                    guessed = true;
                    System.out.println("恭喜你！你猜对了，用了 " );
                }
            }

            if (!guessed) {
                System.out.println("你没有猜到。数字是 " + numberToGuess + "。");
            }

            System.out.print("再玩一次？（是/否）：");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("是");
        }

        scanner.close();
    }
}
