package data;

/**
 * Created by mariam.javed on 22/05/16.
 */
public class QuestionStatus {

    private Question question;
    private Category category;
    private boolean visited = false;
    private Option selectedAnswer;

    public QuestionStatus(Question question, Category category, boolean visited) {
        this.question = question;
        this.category = category;
        this.visited = visited;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Option getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Option selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
