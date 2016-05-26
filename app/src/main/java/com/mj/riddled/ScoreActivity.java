package com.mj.riddled;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import adapter.AnswersAdapter;
import data.DummyData;
import data.GameData;
import data.Question;
import data.QuestionStatus;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView scoreView = (TextView) findViewById(R.id.score_count_id);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.bulb);
        double totalQuestionCount = 0;
        if (GameData.QUESTION_STATUS_LIST != null && GameData.QUESTION_STATUS_LIST.size() > 0) {
            totalQuestionCount = GameData.QUESTION_STATUS_LIST.size();
            double score = GameData.calculateScore();
            if ((score / totalQuestionCount) * 100 >= 80) {
                scoreView.setText("You scored" + "\n" + (int) score + "/" + (int) totalQuestionCount + "\nYou're awesome!");
            } else if ((score / totalQuestionCount) * 100 >= 50 && score < 80) {
                scoreView.setText("You scored" + "\n" + (int) score + "/" + (int) totalQuestionCount + "\nWell played!");
            } else if ((score / totalQuestionCount) * 100 < 50) {
                scoreView.setText("You scored" + "\n" + (int) score + "/" + (int) totalQuestionCount + "\nBetter luck next time");
            }
        } else {
            scoreView.setText("*There are no questions in this category*");
        }

        // Answers list view implementation
        ListView answerListView = (ListView) findViewById(R.id.correct_answers_lvID);
        AnswersAdapter qaAdapter = new AnswersAdapter(this, 0, GameData.QUESTION_STATUS_LIST);
        answerListView.setAdapter(qaAdapter);

        //Back to main page
        Button backToMainMenuBtn = (Button) findViewById(R.id.another_game_btnid);
        backToMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(backToMainIntent);
                finish();
            }
        });
    }
}
