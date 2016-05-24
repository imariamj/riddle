package data;

import java.util.List;

/**
 * Created by mariam.javed on 22/05/16.
 */
public class Question {

    private int quesId;
    private String quesText;
    private Category category;
    private List<Option> options;
    private Option correctAnswer;

    public Question(int quesId, String quesText, Category category, List<Option> options, Option correctAnswer) {
        this.quesId = quesId;
        this.quesText = quesText;
        this.category = category;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public String getQuesText() {
        return quesText;
    }

    public void setQuesText(String quesText) {
        this.quesText = quesText;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Option getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Option correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
