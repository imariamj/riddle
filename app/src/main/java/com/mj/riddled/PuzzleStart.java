package com.mj.riddled;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import data.Category;
import data.Constants;
import data.DummyData;
import data.GameData;

public class PuzzleStart extends AppCompatActivity {

    int categoryId = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_start);
        TextView startPuzzleTextView = (TextView) findViewById(R.id.startPuzzleTV_id);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            categoryId = bundle.getInt(Constants.CATEGORY_ID);
        }
        if(categoryId == 1){
            startPuzzleTextView.setText("Start History Quiz");
        }
        if(categoryId == 2){
            startPuzzleTextView.setText("Start Science Quiz");
        }

        if(categoryId == 3){
            startPuzzleTextView.setText("Start Maths Quiz");
        }

        if(categoryId == 4){
            startPuzzleTextView.setText("Start Current Affairs Quiz");
        }

        if(categoryId == 5){
            startPuzzleTextView.setText("Start Geography Quiz");
        }

        if(categoryId == 6){
            startPuzzleTextView.setText("Start Art Quiz");
        }

        View startPuzzleView = findViewById(R.id.start_puzzle_id);
        startPuzzleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = DummyData.getCategory(categoryId);
                GameData.startNewGame(category);
                Intent intent = new Intent(PuzzleStart.this, QuestionsActivity.class);
                intent.putExtra(Constants.CATEGORY_ID,categoryId);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.puzzle_red);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
