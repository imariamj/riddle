package com.mj.riddled;

import android.app.ActionBar;
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
        if (bundle != null) {
            categoryId = bundle.getInt(Constants.CATEGORY_ID);
        }
        if (categoryId == 1) {
            startPuzzleTextView.setText("How much do you know about\nBollywood?\n\nTest your knowledge with this quiz.");
        }
        if (categoryId == 2) {
            startPuzzleTextView.setText("How much do you know about\n" +
                    "Hollywood?\n\n" +
                    "Test your knowledge with this quiz.");
        }
        if (categoryId == 3) {
            startPuzzleTextView.setText("How much do you know about\n" +
                    "Cricket\n\n" +
                    "Test your knowledge with this quiz.");
        }
        if (categoryId == 4) {
            startPuzzleTextView.setText("How much do you know about\n" +
                    "Science?\n\n" +
                    "Test your knowledge with this quiz.");
        }
        if (categoryId == 5) {
            startPuzzleTextView.setText("How much do you know about\n" +
                    "Geography?\n\n" +
                    "Test your knowledge with this quiz.");
        }
        if (categoryId == 6) {
            startPuzzleTextView.setText("How much do you know about\n" +
                    "History?\n\n" +
                    "Test your knowledge with this quiz.");
        }

        View startPuzzleView = findViewById(R.id.start_puzzle_id);
        startPuzzleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category category = DummyData.getCategory(categoryId);
                GameData.startNewGame(category);
                Intent intent = new Intent(PuzzleStart.this, QuestionsActivity.class);
                intent.putExtra(Constants.CATEGORY_ID, categoryId);
                startActivity(intent);
            }
        });
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }
}
