package hexlet.code.games;

import java.util.Random;

public final class Even implements GameTemplate {
    private final int maxNumber;
    private String correctAnswer;
    public Even(int maxRandomNumber) {
        this.maxNumber = maxRandomNumber;
    }
    public String getGameRules() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public String[] getQuestionAndAnswer() {
        Random generator = new Random();
        String[] questionAndAnswer = new String[2]; // [0] - question, [1] - correct answer
        int number = generator.nextInt(maxNumber);
        if (number % 2 == 0) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }
        questionAndAnswer[0] = Integer.toString(number);
        questionAndAnswer[1] = correctAnswer;
        return questionAndAnswer;
    }
}
