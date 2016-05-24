package com.mj.riddled;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.session.PlaybackState;
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
        if(extras != null){
            categoryId = extras.getInt(Constants.CATEGORY_ID);
        }
        final Category category = DummyData.getCategory(categoryId);
        question = DummyData.getNextQuestion(category);
        TextView questionText = (TextView) findViewById(R.id.questionText_id);
        if(question == null){
            Intent scoreIntent = new Intent(QuestionsActivity.this, ScoreActivity.class);
            startActivity(scoreIntent);
        }
        else{
            questionText.setText(question.getQuesText());
            addRadioButtons(question.getOptions());
        }
        Button nextButton = (Button) findViewById(R.id.next_question_id);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();
                if(selectedOption > 0 ) {
                    GameData.setAnswer(question, selectedOption);
                    Intent intent = new Intent(QuestionsActivity.this, QuestionsActivity.class);
                    intent.putExtra(Constants.CATEGORY_ID, categoryId);
                    startActivity(intent);

                }else{
                    Toast.makeText(QuestionsActivity.this, "Please select an answer", Toast.LENGTH_LONG).show();
                }
            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.puzzle_red);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit quiz?");
        builder.setMessage("This would make you exit the quiz.");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent mainIntent = new Intent(QuestionsActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public void addRadioButtons(List<Option> options) {

        for (int row = 0; row < 1; row++) {
             radioGroup = new RadioGroup(this);
            radioGroup.setOrientation(LinearLayout.VERTICAL);

            for (Option o: options) {
                RadioButton rdbtn = new RadioButton(this);
                rdbtn.setId((o.getId()));
                rdbtn.setText(o.getOptionText());
                radioGroup.addView(rdbtn);
            }
            ((ViewGroup) findViewById(R.id.radiogroup_id)).addView(radioGroup);

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    radioButton = (RadioButton) findViewById(checkedId);
                    //Toast.makeText(QuestionsActivity.this, radioButton.getText(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
