package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariam.javed on 22/05/16.
 */
public class GameData {

    public static List<QuestionStatus> QUESTION_STATUS_LIST;

    /**
     * On game start, reset the game and create a new list of question status for a given category
     *
     * @param cat
     * @return
     */
    public static List<QuestionStatus> startNewGame(Category cat) {
        resetGame();
        QUESTION_STATUS_LIST = new ArrayList<QuestionStatus>();
        List<Question> categoryQuestions = DummyData.getAllCategoryQuestions(cat);
        for (Question q : categoryQuestions) {
            QUESTION_STATUS_LIST.add(new QuestionStatus(q, q.getCategory(), false));
        }

        return QUESTION_STATUS_LIST;
    }

    public static void setAnswer(Question question, int selectedAnswer) {
        if (QUESTION_STATUS_LIST != null && QUESTION_STATUS_LIST.size() > 0) {
            for (QuestionStatus questionStatus : QUESTION_STATUS_LIST) {
                if (questionStatus.getQuestion().getQuesId() == question.getQuesId()) {
                    for (Option option : question.getOptions()) {
                        if (option.getId() == selectedAnswer) {
                            questionStatus.setSelectedAnswer(option);
                        }
                    }
                }
            }
        }
    }

    public static int calculateScore() {
        int score = 0;
        if (QUESTION_STATUS_LIST != null && QUESTION_STATUS_LIST.size() > 0) {
            for (QuestionStatus questionStatus : QUESTION_STATUS_LIST) {
                if (questionStatus.getSelectedAnswer().getId() == questionStatus.getQuestion().getCorrectAnswer().getId()) {
                    score = score + 1;
                }
            }
        }
        return score;
    }

    /**
     * to reset the game
     */
    public static void resetGame() {
        QUESTION_STATUS_LIST = null;
    }
}
