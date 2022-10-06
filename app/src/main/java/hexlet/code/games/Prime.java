package hexlet.code.games;

import java.util.Random;

public class Prime implements GameTemplate {
    private final int maxNumber;
    private String correctAnswer;
    public Prime(int maxRandomNumber) {
        this.maxNumber = maxRandomNumber;
    }
    public String getGameRules() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public String[] getQuestionAndAnswer() {
        Random generator = new Random();
        String[] questionAndAnswer = new String[2]; // [0] - question, [1] - correct answer
        int number = generator.nextInt(maxNumber);
        if (number < 2) {
            correctAnswer = "no";
        } else if (number == 2 || number == 3) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "yes";
            for (var i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    correctAnswer = "no";
                    break;
                }
            }
        }
        questionAndAnswer[0] = Integer.toString(number); //question
        questionAndAnswer[1] = correctAnswer; //answer
        return questionAndAnswer;
    }
}
