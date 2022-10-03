package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.GameTemplate;
import java.util.Scanner;

public class Engine {
    public static void chooseGame(String gameNumber) {
        final int maxNumber = 100;
        GameTemplate game;
        if (gameNumber.equals("1")) {
            Cli.greetUser();
        } else if (gameNumber.equals("2")) {
            game = new Even(maxNumber);
            playGame(game);
        } else if (gameNumber.equals("3")) {
            game = new Calc(maxNumber);
            playGame(game);
        } else {
            System.out.println("There is no game as " + gameNumber);
        }
    }
    public static void playGame(GameTemplate game) {
        boolean isGameOver = false;
        String question, playerAnswer, correctAnswer;
        int correctAnswerCount = 0;
        final int correctAnswersToWin = 3;
        String playerName = Cli.greetUser();
        Scanner sc = new Scanner(System.in);
        System.out.println(game.getGameRules());
        while (!isGameOver) {
            String[] questionAndAnswer = game.getQuestionAndAnswer();
            question = questionAndAnswer[0];
            correctAnswer = questionAndAnswer[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            playerAnswer = sc.next();
            if (playerAnswer.equals(correctAnswer)) {
                System.out.println("Correct!");
                correctAnswerCount += 1;
            } else {
                System.out.println("'" + playerAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
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
