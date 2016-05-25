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
            CATEGORY.add(new Category("Bollywood", R.drawable.bollywood, 1));
            CATEGORY.add(new Category("Hollywood", R.drawable.hollywood3, 2));
            CATEGORY.add(new Category("Cricket", R.drawable.cricket4, 3));
            CATEGORY.add(new Category("Science", R.drawable.science1, 4));
            CATEGORY.add(new Category("Geography", R.drawable.geography, 5));
            CATEGORY.add(new Category("History", R.drawable.history, 6));
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
            options.add(new Option(1, "Radio Waves"));
            options.add(new Option(2, "Sound Waves"));
            options.add(new Option(3, "Gravity Waves"));
            options.add(new Option(4, "Light Waves"));
            QUESTION.add(new Question(1, "Which kind of waves are used to make and receive cellphone calls?", getCategory(4), options, options.get(0)));

            List<Option> options2 = new ArrayList<Option>();
            options2.add(new Option(1, "8"));
            options2.add(new Option(2, "6"));
            options2.add(new Option(3, "3"));
            options2.add(new Option(4, "1"));
            QUESTION.add(new Question(2, "How many hearts does an octopus have?", getCategory(4), options2, options2.get(2)));

            List<Option> options3 = new ArrayList<Option>();
            options3.add(new Option(1, "Newton's Law"));
            options3.add(new Option(2, "Hooke's law"));
            options3.add(new Option(3, "Darwin's Law"));
            options3.add(new Option(4, "Archimedes' principle"));
            QUESTION.add(new Question(3, "Whose law states that the force needed to extend a spring by some distance is proportional to that distance?", getCategory(4), options3, options3.get(1)));

            List<Option> options4 = new ArrayList<Option>();
            options4.add(new Option(1, "M"));
            options4.add(new Option(2, "$"));
            options4.add(new Option(3, "W"));
            options4.add(new Option(4, "#"));
            QUESTION.add(new Question(4, "What is the chemical symbol for tungsten?", getCategory(4), options4, options4.get(2)));

            List<Option> options5 = new ArrayList<Option>();
            options5.add(new Option(1, "Pulsar"));
            options5.add(new Option(2, "Draconis"));
            options5.add(new Option(3, "Aludra"));
            options5.add(new Option(4, "Alwaid"));
            QUESTION.add(new Question(5, "What is a highly magnetized, rotating neutron star that emits a beam of electromagnetic radiation?", getCategory(4), options5, options5.get(0)));

            List<Option> options6 = new ArrayList<Option>();
            options6.add(new Option(1, "2"));
            options6.add(new Option(2, "4"));
            options6.add(new Option(3, "7"));
            options6.add(new Option(4, "10"));
            QUESTION.add(new Question(6, "At what temperature is Centigrade equal to Fahrenheit?", getCategory(4), options6, options6.get(2)));

            List<Option> options7 = new ArrayList<Option>();
            options7.add(new Option(1, "Temperature"));
            options7.add(new Option(2, "Distance"));
            options7.add(new Option(3, "Light Intensity"));
            options7.add(new Option(4, "Noise"));
            QUESTION.add(new Question(7, "Kelvin is a unit to measure what?", getCategory(4), options7, options7.get(2)));

            List<Option> options8 = new ArrayList<Option>();
            options8.add(new Option(1, "Mars"));
            options8.add(new Option(2, "Jupiter"));
            options8.add(new Option(3, "Saturn"));
            options8.add(new Option(4, "Neptune"));
            QUESTION.add(new Question(8, "Triton is the largest moon of what planet?", getCategory(4), options8, options8.get(3)));

            List<Option> options9 = new ArrayList<Option>();
            options9.add(new Option(1, "Brain"));
            options9.add(new Option(2, "Heart"));
            options9.add(new Option(3, "Lungs"));
            options9.add(new Option(4, "Skin"));
            QUESTION.add(new Question(9, "What is the human body’s biggest organ?", getCategory(4), options9, options9.get(3)));

            List<Option> options10 = new ArrayList<Option>();
            options10.add(new Option(1, "Skull"));
            options10.add(new Option(2, "Knee Cap"));
            options10.add(new Option(3, "Shoulder Joint"));
            options10.add(new Option(4, "Backbone"));
            QUESTION.add(new Question(10,"What is the more common name for the patella?", getCategory(4), options10, options10.get(1)));

            List<Option> options11 = new ArrayList<Option>();
            options11.add(new Option(1, "Mother India"));
            options11.add(new Option(2, "The Guide"));
            options11.add(new Option(3, "Madhumati"));
            options11.add(new Option(4, "Amrapali"));
            QUESTION.add(new Question(11,"Which was the 1st Indian movie submitted for Oscar?", getCategory(1), options11, options11.get(0)));

            List<Option> options12 = new ArrayList<Option>();
            options12.add(new Option(1, "Gunda"));
            options12.add(new Option(2, "Sholey"));
            options12.add(new Option(3, "Satte pe Satta"));
            options12.add(new Option(4, "Angoor"));
            QUESTION.add(new Question(12,"Which film is similar to Seven Brides For Seven Brothers?", getCategory(1), options12, options12.get(2)));

            List<Option> options13 = new ArrayList<Option>();
            options13.add(new Option(1, "Rocky"));
            options13.add(new Option(2, "Pancham"));
            options13.add(new Option(3, "Chichi"));
            options13.add(new Option(4, "Chintu"));
            QUESTION.add(new Question(13,"Music Director R.D. Burman is also known as?", getCategory(1), options13, options13.get(1)));

            List<Option> options14 = new ArrayList<Option>();
            options14.add(new Option(1, "Nagarjuna"));
            options14.add(new Option(2, "Chiranjeevi"));
            options14.add(new Option(3, "Rajinikanth"));
            options14.add(new Option(4, "NTR"));
            QUESTION.add(new Question(14,"Shivaji Rao Gaikwad is the real name of which actor?", getCategory(1), options14, options14.get(2)));

            List<Option> options15 = new ArrayList<Option>();
            options15.add(new Option(1, "Geraftaar"));
            options15.add(new Option(2, "Hum"));
            options15.add(new Option(3, "Andha kanoon"));
            options15.add(new Option(4, "Agneepath"));
            QUESTION.add(new Question(15,"Name the film in which Amitabh Bachchan, Rajinikanth and Kamal Hasan worked together.", getCategory(1), options15, options15.get(0)));

            List<Option> options16 = new ArrayList<Option>();
            options16.add(new Option(1, "AR Rahman"));
            options16.add(new Option(2, "Bhanu Athaiya"));
            options16.add(new Option(3, "Gulzar"));
            options16.add(new Option(4, "Rasul Pookutty"));
            QUESTION.add(new Question(16,"First Indian to win Oscar award?", getCategory(1), options16, options16.get(1)));

            List<Option> options17 = new ArrayList<Option>();
            options17.add(new Option(1, "Jab tak hai jaan"));
            options17.add(new Option(2, "Rab ne bana di jodi"));
            options17.add(new Option(3, "Veer zara"));
            options17.add(new Option(4, "Ek tha tiger"));
            QUESTION.add(new Question(17,"Which was the last movie directed by Yash Chopra?", getCategory(1), options17, options17.get(0)));


            List<Option> options18 = new ArrayList<Option>();
            options18.add(new Option(1, "‘Thala’ Ajith"));
            options18.add(new Option(2, "Arjun Sarja"));
            options18.add(new Option(3, "Ashutosh Gawariker"));
            options18.add(new Option(4, "AK Hangal"));
            QUESTION.add(new Question(18,"\"Itna sannata kyun hai bhai?\" Who said this, now legendary words, in 'Sholay'?", getCategory(1), options18, options18.get(3)));

            List<Option> options19 = new ArrayList<Option>();
            options19.add(new Option(1, "Tommy"));
            options19.add(new Option(2, "Tuffy"));
            options19.add(new Option(3, "Toffy"));
            options19.add(new Option(4, "Timmy"));
            QUESTION.add(new Question(19,"What was the name of Madhuri Dixit’s dog in Hum Aapke Hain Koun?", getCategory(1), options19, options19.get(1)));

            List<Option> options20 = new ArrayList<Option>();
            options20.add(new Option(1, "Premnath"));
            options20.add(new Option(2, "Dilip Kumar"));
            options20.add(new Option(3, "Raj Kapoor"));
            options20.add(new Option(4, "Kishore Kumar"));
            QUESTION.add(new Question(20,"Beautiful actress Madhubala was married to?", getCategory(1), options20, options20.get(3)));


            List<Option> options21 = new ArrayList<Option>();
            options21.add(new Option(1, "Sher Khan"));
            options21.add(new Option(2, "Mufasa"));
            options21.add(new Option(3, "Simba"));
            options21.add(new Option(4, "Sarabi"));
            QUESTION.add(new Question(21,"What is the name of the young lion whose story is told in the musical 'The Lion King'?", getCategory(2), options21, options21.get(2)));

            List<Option> options22 = new ArrayList<Option>();
            options22.add(new Option(1, "Scotland"));
            options22.add(new Option(2, "England"));
            options22.add(new Option(3, "Germany"));
            options22.add(new Option(4, "Netherland"));
            QUESTION.add(new Question(22,"Which country's freedom struggle is portrayed in the Mel Gibson movie 'Braveheart'?", getCategory(2), options22, options22.get(3)));

            List<Option> options23 = new ArrayList<Option>();
            options23.add(new Option(1, "Letters to Juliet"));
            options23.add(new Option(2, "Saving Private Ryan"));
            options23.add(new Option(3, "Forest Gump"));
            options23.add(new Option(4, "Gone With The Wind"));
            QUESTION.add(new Question(23,"Which movie had this dialogue \"My mama always said, life was like a box of chocolates. You never know what you're gonna get.", getCategory(2), options23, options23.get(2)));

            List<Option> options24 = new ArrayList<Option>();
            options24.add(new Option(1, "Die"));
            options24.add(new Option(2, "Golden"));
            options24.add(new Option(3, "Casino"));
            options24.add(new Option(4, "Never"));
            QUESTION.add(new Question(24,"Excluding \"the\", which word appears most often in Bond movie titles?", getCategory(2), options24, options24.get(3)));

            List<Option> options25 = new ArrayList<Option>();
            options25.add(new Option(1, "Bishop"));
            options25.add(new Option(2, "Ash"));
            options25.add(new Option(3, "Call"));
            options25.add(new Option(4, "Carlos"));
            QUESTION.add(new Question(25,"Name the android in movie Alien ", getCategory(2), options25, options25.get(1)));

            List<Option> options26 = new ArrayList<Option>();
            options26.add(new Option(1, "Gone with the wind"));
            options26.add(new Option(2, "Home footage"));
            options26.add(new Option(3, "With Our King and Queen Through India"));
            options26.add(new Option(4, "Treasure Island"));
            QUESTION.add(new Question(26,"Which was the first colour film to win a Best Picture Oscar?", getCategory(2), options26, options26.get(0)));

            List<Option> options27 = new ArrayList<Option>();
            options27.add(new Option(1, "Robert Redford"));
            options27.add(new Option(2, "Michael Douglas"));
            options27.add(new Option(3, "Harrison Ford"));
            options27.add(new Option(4, "Patrick Swayze"));
            QUESTION.add(new Question(27,"Who played the male lead opposite Sharon Stone in the hugely successful movie 'The Basic Instinct'?", getCategory(2), options27, options27.get(1)));

            List<Option> options28 = new ArrayList<Option>();
            options28.add(new Option(1, "10,000 BC"));
            options28.add(new Option(2, "Day after tomorrow"));
            options28.add(new Option(3, "2012"));
            options28.add(new Option(4, "The Noah's Ark Principle"));
            QUESTION.add(new Question(28,"Which Roland Emmerich movie portrays fictional cataclysmic events that were to take place in early 21st century?", getCategory(2), options28, options28.get(2)));

            List<Option> options29 = new ArrayList<Option>();
            options29.add(new Option(1, "Finding Nemo"));
            options29.add(new Option(2, "The Incredibles"));
            options29.add(new Option(3, "Monsters, Inc."));
            options29.add(new Option(4, "Toy Story"));
            QUESTION.add(new Question(29,"What was the first movie by Pixar to receive a rating higher than G in the United States?", getCategory(2), options29, options29.get(1)));

            List<Option> options30 = new ArrayList<Option>();
            options30.add(new Option(1, "Draco"));
            options30.add(new Option(2, "Harry"));
            options30.add(new Option(3, "Hermione"));
            options30.add(new Option(4, "Ron"));
            QUESTION.add(new Question(30,"In the 'Prisoner of Azkaban', who throws rocks at Hagrid's hut so that Harry, Ron and Hermione can leave?", getCategory(2), options30, options30.get(2)));

            List<Option> options31 = new ArrayList<Option>();
            options31.add(new Option(1, "Brett Lee"));
            options31.add(new Option(2, "Adam Gilchrist"));
            options31.add(new Option(3, "Jason Gillespie"));
            options31.add(new Option(4, "Glenn McGrath"));
            QUESTION.add(new Question(31,"'Dizzy' is the nickname of what Australian player?", getCategory(3), options31, options31.get(2)));

            List<Option> options32 = new ArrayList<Option>();
            options32.add(new Option(1, "1883 between Australia and Wales"));
            options32.add(new Option(2, "1844 between Canada and the USA"));
            options32.add(new Option(3, "1869 between England and Australia"));
            options32.add(new Option(4, "1892 between England and India"));
            QUESTION.add(new Question(32,"In what year was the first international cricket match held?", getCategory(3), options32, options32.get(1)));

            List<Option> options33 = new ArrayList<Option>();
            options33.add(new Option(1, "Salim Durrani"));
            options33.add(new Option(2, "Farooq Engineer"));
            options33.add(new Option(3, "Vijay Hazare"));
            options33.add(new Option(4, "Mansur Ali Khan Pataudi"));
            QUESTION.add(new Question(33,"Which former Indian cricketer was nicknamed 'Tiger'?", getCategory(3), options33, options33.get(3)));

            List<Option> options34 = new ArrayList<Option>();
            options34.add(new Option(1, "Piyush Chawla"));
            options34.add(new Option(2, "Gautam Gambhir"));
            options34.add(new Option(3, "Irfan Pathan"));
            options34.add(new Option(4, "Suresh Raina"));
            QUESTION.add(new Question(34,"Who was named as the ICC Emerging Player of the Year 2004?", getCategory(3), options34, options34.get(2)));

            List<Option> options35 = new ArrayList<Option>();
            options35.add(new Option(1, "Subhash Gupte"));
            options35.add(new Option(2, "M.L.Jaisimha"));
            options35.add(new Option(3, "Raman Lamba"));
            options35.add(new Option(4, "Lala Amarnath"));
            QUESTION.add(new Question(35,"Which cricketer died on the field in Bangladesh while playing for Abahani Club?", getCategory(3), options35, options35.get(2)));

            List<Option> options36 = new ArrayList<Option>();
            options36.add(new Option(1, "V. Raju"));
            options36.add(new Option(2, "Rajesh Chauhan"));
            options36.add(new Option(3, "Arshad Ayub"));
            options36.add(new Option(4, "Narendra Hirwani"));
            QUESTION.add(new Question(36,"In 1987-88, which Indian spinner took 16 wickets on his Test debut?", getCategory(3), options36, options36.get(3)));

            List<Option> options37 = new ArrayList<Option>();
            options37.add(new Option(1, "Ravi Shastri"));
            options37.add(new Option(2, "Dilip Vengsarkar"));
            options37.add(new Option(3, "Sachin Tendulkar"));
            options37.add(new Option(4, "Sanjay Manjrekar"));
            QUESTION.add(new Question(37,"Which former Indian Test cricketer equalled Gary Sobers world record of six sixes in an over in a Ranji Trophy match?", getCategory(3), options37, options37.get(0)));

            List<Option> options38 = new ArrayList<Option>();
            options38.add(new Option(1, "Mohsin khan"));
            options38.add(new Option(2, "Wasim Akram"));
            options38.add(new Option(3, "Naveen Nischol"));
            options38.add(new Option(4, "None Of The Above"));
            QUESTION.add(new Question(38,"Reena Roy the Indian film actress married a cricketer?", getCategory(3), options38, options38.get(0)));

            List<Option> options39 = new ArrayList<Option>();
            options39.add(new Option(1, "London, England"));
            options39.add(new Option(2, "Mumbai, India"));
            options39.add(new Option(3, "Lahore, Pakistan"));
            options39.add(new Option(4, "Nairobi, Kenya"));
            QUESTION.add(new Question(39,"Where did Yuvraj Singh make his ODI debut?", getCategory(3), options39, options39.get(3)));

            List<Option> options40 = new ArrayList<Option>();
            options40.add(new Option(1, "Arvind De Silva"));
            options40.add(new Option(2, "Roshan Mahanama"));
            options40.add(new Option(3, "Harshan Tilakaratne"));
            options40.add(new Option(4, "None Of The Above"));
            QUESTION.add(new Question(40,"Kapil Dev's 432 (world) record breaking victim was?", getCategory(3), options40, options40.get(2)));

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
