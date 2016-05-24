package data;

import android.support.annotation.NonNull;

import com.mj.riddled.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by mariam.javed on 22/05/16.
 */
public class DummyData {


    public static List<Category> CATEGORY = null;
    public static List<Question> QUESTION = null;

    /**
     * To get the list of categories for quizzes
     * @return List of categories
     */
    @NonNull
    public static List<Category> getCategories() {
        if (CATEGORY == null) {
            CATEGORY = new ArrayList<>();
            CATEGORY.add(new Category("History", R.drawable.history, 1));
            CATEGORY.add(new Category("Science", R.drawable.science1, 2));
            CATEGORY.add(new Category("Math", R.drawable.math1, 3));
            CATEGORY.add(new Category("Current Affairs", R.drawable.coins, 4));
            CATEGORY.add(new Category("Geography", R.drawable.geography, 5));
            CATEGORY.add(new Category("Art", R.drawable.art, 6));
        }
        return CATEGORY;
    }

    /**
     * To get the gategory type for each of the questions
     * @param id
     * @return
     */
    public static Category getCategory(int id){
        List<Category> categories = getCategories();
        for(Category c:categories){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    /**
     * Fetches list of all the questions from all categories
     * @return list of questions
     */
    public static List<Question> getQuestions(){
        if(QUESTION == null){
            QUESTION = new ArrayList<>();
            List<Option> options = new ArrayList<Option>();
            options.add(new Option(1, "Italy"));
            options.add(new Option(2, "France"));
            options.add(new Option(3, "Spain"));
            options.add(new Option(4, "Hungary"));
            QUESTION.add(new Question(1, "Where is Pisa situated?", getCategory(5), options, options.get(0) ));

            List<Option> options2 = new ArrayList<Option>();
            options2.add(new Option(1, "8"));
            options2.add(new Option(2, "6"));
            options2.add(new Option(3, "3"));
            options2.add(new Option(4, "1"));
            QUESTION.add(new Question(2, "How many hearts does an octopus have?", getCategory(2), options2, options.get(2)));

            List<Option> options3 = new ArrayList<Option>();
            options3.add(new Option(1, "Newton's Law"));
            options3.add(new Option(2, "Hooke's law"));
            options3.add(new Option(3, "Darwin's Law"));
            options3.add(new Option(4, "Archimedes' principle"));
            QUESTION.add(new Question(3, "Whose law states that the force needed to extend a spring by some distance is proportional to that distance?", getCategory(2), options3, new Option(1)));

            List<Option> options4 = new ArrayList<Option>();
            options4.add(new Option(1, "M"));
            options4.add(new Option(2, "$"));
            options4.add(new Option(3, "W"));
            options4.add(new Option(4, "#"));
            QUESTION.add(new Question(4, "What is the chemical symbol for tungsten?", getCategory(2), options4, options.get(2)));

            List<Option> options5 = new ArrayList<Option>();
            options5.add(new Option(1, "Pulsar"));
            options5.add(new Option(2, "Draconis"));
            options5.add(new Option(3, "Aludra"));
            options5.add(new Option(4, "Alwaid"));
            QUESTION.add(new Question(5, "What is a highly magnetized, rotating neutron star that emits a beam of electromagnetic radiation?", getCategory(2), options5, options.get(0)));

            List<Option> options6 = new ArrayList<Option>();
            options6.add(new Option(1, "2"));
            options6.add(new Option(2, "4"));
            options6.add(new Option(3, "7"));
            options6.add(new Option(4, "10"));
            QUESTION.add(new Question(6, "At what temperature is Centigrade equal to Fahrenheit?", getCategory(2), options6, options.get(2)));

            List<Option> options7 = new ArrayList<Option>();
            options7.add(new Option(1, "2"));
            options7.add(new Option(2, "4"));
            options7.add(new Option(3, "7"));
            options7.add(new Option(4, "10"));
            QUESTION.add(new Question(7, "Kelvin is a unit to measure what?", getCategory(2), options7, options.get(2)));

            List<Option> options8 = new ArrayList<Option>();
            options8.add(new Option(1, "2"));
            options8.add(new Option(2, "4"));
            options8.add(new Option(3, "7"));
            options8.add(new Option(4, "10"));
            QUESTION.add(new Question(8, "Triton is the largest moon of what planet?", getCategory(2), options8, options.get(2)));

            List<Option> options9 = new ArrayList<Option>();
            options9.add(new Option(1, "2"));
            options9.add(new Option(2, "4"));
            options9.add(new Option(3, "7"));
            options9.add(new Option(4, "10"));
            QUESTION.add(new Question(9, "What is the human body’s biggest organ?", getCategory(2), options9, options.get(2)));

            List<Option> options10 = new ArrayList<Option>();
            options10.add(new Option(1, "2"));
            options10.add(new Option(2, "4"));
            options10.add(new Option(3, "7"));
            options10.add(new Option(4, "10"));
            QUESTION.add(new Question(10,"What is the more common name for the patella?", getCategory(2), options10, options.get(3)));
        }
        return QUESTION;
    }

    /**
     * Fetch all questions for given category id
     * @param cat
     * @return list of categoryQuestions
     */
    public static List<Question> getAllCategoryQuestions(Category cat){
        List<Question> questions = getQuestions(); //get all the questions
        List<Question> categoryQuestions = new ArrayList<Question>(); //make new list of questions
        for(Question q:questions){
            if(q.getCategory().getId() == cat.getId()){
                categoryQuestions.add(q);
            }
        }
        return categoryQuestions;
    }

    /**
     * Fetch a question based on question id
     * @param questionId
     * @return question
     */
    public static Question getQuestion(int questionId){
        List<Question> allQuestions = getQuestions();
        for(Question ques: allQuestions){
            if(ques.getQuesId() == questionId){
                return ques;
            }
        }
        return null;
    }

    /**
     * Fetches next not visited question in the current game
     * if game is not running, then start a new game and get the first not visited question
     * @param category
     * @return
     */
    public static Question getNextQuestion(Category category){
        if(GameData.QUESTION_STATUS_LIST == null || GameData.QUESTION_STATUS_LIST.size() == 0 ){
            GameData.startNewGame(category);
        }
        for(QuestionStatus q : GameData.QUESTION_STATUS_LIST){
            if(!q.isVisited()){
                q.setVisited(true);
                return q.getQuestion();
            }
        }
        return null;
    }


}
