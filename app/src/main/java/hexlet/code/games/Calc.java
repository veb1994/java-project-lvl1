package hexlet.code.games;

import java.util.Random;

public final class Calc implements GameTemplate {
    private final int maxNumber;
    private String correctAnswer;
    private final int divisor = 3;
    public Calc(int maxRandomNumber) {
        this.maxNumber = maxRandomNumber;
    }
    public String getGameRules() {
        return "What is the result of the expression?";
    }

    public String[] getQuestionAndAnswer() {
        Random generator = new Random();
        String[] questionAndAnswer = new String[2]; // [0] - question, [1] - correct answer
        int number1 = generator.nextInt(maxNumber);
        int number2 = generator.nextInt(maxNumber);
        int operator = generator.nextInt(maxNumber);
        String[] operators = {" + ", " - ", " * "};
        if (operator < maxNumber / divisor) {
            correctAnswer = Integer.toString(number1 + number2);
            operator = 0;
        } else if ((operator >= maxNumber / divisor) && (operator <= maxNumber * 2 / divisor)) {
            correctAnswer = Integer.toString(number1 - number2);
            operator = 1;
        } else if (operator > maxNumber * 2 / divisor) {
            correctAnswer = Integer.toString(number1 * number2);
            operator = 2;
        }
        questionAndAnswer[0] = number1 + operators[operator] + number2; //question
        questionAndAnswer[1] = correctAnswer; //answer
        return questionAndAnswer;
    }
}
