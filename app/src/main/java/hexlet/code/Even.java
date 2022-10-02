package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Even {
    public static void playEven() {
        String playerName = Cli.greetUser();
        boolean isGameOver = false;
        int number;
        String answer;
        String correctAnswer;
        int correctAnswerCount = 0;
        final int correctAnswersToWin = 3;
        final int maxNumber = 100;

        Random generator = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (!isGameOver) {
            number = generator.nextInt(maxNumber);
            if (number % 2 == 0) {
                correctAnswer = "yes";
            } else {
                correctAnswer = "no";
            }
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            answer = sc.next();
            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount += 1;
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                isGameOver = true;
            }
            if (correctAnswerCount == correctAnswersToWin) {
                System.out.println("Congratulations, " + playerName + "!");
                isGameOver = true;
            }
        }
    }
}
