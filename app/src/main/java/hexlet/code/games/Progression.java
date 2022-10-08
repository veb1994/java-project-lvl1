package hexlet.code.games;

import java.util.Random;

public final class Progression implements GameTemplate {
    private final int maxNumber;
    private final int minProgressionLength = 5;
    private final int maxProgressionLength = 10;
    private final int maxProgressionStep = 10;

    private String correctAnswer;
    public Progression(int maxRandomNumber) {
        this.maxNumber = maxRandomNumber;
    }
    public String getGameRules() {
        return "What number is missing in the progression?";
    }

    public String[] getQuestionAndAnswer() {
        Random generator = new Random();
        String[] questionAndAnswer = new String[2]; // [0] - question, [1] - correct answer
        int number = generator.nextInt(maxNumber);
        int progressionStep = generator.nextInt(1, maxProgressionStep);
        int progressionLength = generator.nextInt(minProgressionLength, maxProgressionLength);
        int missingNumber = generator.nextInt(progressionLength - 1);
        questionAndAnswer[0] = "";
        for (var i = 0; i < progressionLength; i++) {
            if (i != missingNumber) {
                questionAndAnswer[0] = questionAndAnswer[0] + number + " ";
            } else {
                questionAndAnswer[0] = questionAndAnswer[0] + ".. ";
                correctAnswer = Integer.toString(number);
            }
            number += progressionStep;
        }
        questionAndAnswer[1] = correctAnswer; //answer
        return questionAndAnswer;
    }
}
