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


/**
 * Starting activity for each of the quiz categories
 */
public class QuizStartActivity extends AppCompatActivity {
    int categoryId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_start);
        TextView startPuzzleTextView = (TextView) findViewById(R.id.startPuzzleTV_id);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            categoryId = bundle.getInt(Constants.CATEGORY_ID);
            Category category = DummyData.getCategory(categoryId);
            if (category != null) {
                if (startPuzzleTextView != null) {
                    startPuzzleTextView.setText(DummyData.getCategoryDesc(category, this));
                }
            }
        }

        View startPuzzleView = findViewById(R.id.start_puzzle_id);
        if (startPuzzleView != null) {
            startPuzzleView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startPuzzle(categoryId);
                }
            });
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Start puzzle as per the given category id
     *
     * @param categoryId
     */
    public void startPuzzle(int categoryId) {
        Category category = DummyData.getCategory(categoryId);
        GameData.startNewGame(category);

        Intent intent = new Intent(QuizStartActivity.this, QuestionsActivity.class);
        intent.putExtra(Constants.CATEGORY_ID, categoryId);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }


}
