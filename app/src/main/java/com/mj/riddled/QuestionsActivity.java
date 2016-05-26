package com.mj.riddled;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.session.PlaybackState;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import data.Category;
import data.Constants;
import data.DummyData;
import data.GameData;
import data.Option;
import data.Question;

/**
 * It displays questions and the options for each of those questions.
 * if all the questions for that category have been asked, it will take you to the ScoreActivity
 */
public class QuestionsActivity extends AppCompatActivity {

    Question question;
    int categoryId = -1;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            categoryId = extras.getInt(Constants.CATEGORY_ID);
        }
        final Category category = DummyData.getCategory(categoryId);
        question = DummyData.getNextQuestion(category);
        TextView questionText = (TextView) findViewById(R.id.questionText_id);
        if (question == null) {
            Intent scoreIntent = new Intent(QuestionsActivity.this, ScoreActivity.class);
            startActivity(scoreIntent);
        } else {
            questionText.setText(question.getQuesText());
            addRadioButtons(question.getOptions());
        }
        Button nextButton = (Button) findViewById(R.id.next_question_id);
        nextButton.setOnClickListener(nextQuestionListener());

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.bulb);
    }

    /**
     * It returns next question.
     * @return
     */
    @NonNull
    private View.OnClickListener nextQuestionListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();
                if (selectedOption > 0) {
                    GameData.setAnswer(question, selectedOption);
                    Intent intent = new Intent(QuestionsActivity.this, QuestionsActivity.class);
                    intent.putExtra(Constants.CATEGORY_ID, categoryId);
                    startActivity(intent);
                } else {
                    Toast.makeText(QuestionsActivity.this, R.string.select_answer_toast, Toast.LENGTH_LONG).show();
                }
            }
        };
    }

    /**
     * If device back button is pressed while playing the quiz,
     * it gives an alert if the user wants to exit the quiz with Yes and Cancel options
     */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.exit_quiz_alert));
        builder.setMessage(getString(R.string.exit_quiz_description));
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent mainIntent = new Intent(QuestionsActivity.this, MainActivity.class);
                mainIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(mainIntent);
            }
        });
        builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /**
     * Adds radio buttons dynamically to display answers for each of the questions
     * @param options
     */
    public void addRadioButtons(List<Option> options) {
        for (int row = 0; row < 1; row++) {
            radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(LinearLayout.VERTICAL);

            for (Option o : options) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId((o.getId()));
                rdbtn.setTextSize(16);
                rdbtn.setText(o.getOptionText());
                radioGroup.addView(rdbtn);
            }
            ((ViewGroup) findViewById(R.id.radiogroup_id)).addView(radioGroup);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    radioButton = (RadioButton) findViewById(checkedId);
                }
            });
        }

    }
}
