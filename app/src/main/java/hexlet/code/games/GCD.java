package hexlet.code.games;

import java.util.Random;

public class GCD implements GameTemplate {
    private final int maxNumber;
    private String correctAnswer;
    public GCD(int maxRandomNumber) {
        this.maxNumber = maxRandomNumber;
    }
    public String getGameRules() {
        return "Find the greatest common divisor of given numbers.";
    }

    public String[] getQuestionAndAnswer() {
        Random generator = new Random();
        String[] questionAndAnswer = new String[2]; // [0] - question, [1] - correct answer
        int number1 = generator.nextInt(maxNumber);
        int number2 = generator.nextInt(maxNumber);
        if (number1 == 0 && number2 != 0) {
            correctAnswer = Integer.toString(number2);
        } else if (number2 == 0 && number1 != 0) {
            correctAnswer = Integer.toString(number1);
        } else if (number1 == number2) {
            correctAnswer = Integer.toString(number1);
        } else {
            int biggerNumber;
            int smallerNumber;
            if (number1 > number2) {
                biggerNumber = number1;
                smallerNumber = number2;
            } else {
                biggerNumber = number2;
                smallerNumber = number1;
            }
            if (biggerNumber % smallerNumber == 0) {
                correctAnswer = Integer.toString(smallerNumber);
            } else {
                for (var i = 1; i <= smallerNumber / 2; i++) {
                    if ((biggerNumber % i == 0) && (smallerNumber % i == 0)) {
                        correctAnswer = Integer.toString(i);
                    }
                }
            }
        }
        questionAndAnswer[0] = number1 + " " + number2; //question
        questionAndAnswer[1] = correctAnswer; //answer
        return questionAndAnswer;
    }
}
