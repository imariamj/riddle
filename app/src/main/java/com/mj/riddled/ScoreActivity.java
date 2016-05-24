package com.mj.riddled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import data.DummyData;
import data.GameData;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        TextView scoreView = (TextView) findViewById(R.id.score_count_id);

        int totalQuestionCount = 0;
        if(GameData.QUESTION_STATUS_LIST != null && GameData.QUESTION_STATUS_LIST.size() > 0) {
            totalQuestionCount = GameData.QUESTION_STATUS_LIST.size();
            int score = GameData.calculateScore();
            scoreView.setText(score + "/" + totalQuestionCount);
        }
        else{
            scoreView.setText("There are no questions in this category");
        }
    }
}
