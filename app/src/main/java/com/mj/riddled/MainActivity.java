package com.mj.riddled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import adapter.PuzzleAdapter;
import data.Category;
import data.DummyData;


/**
 * This is the entry point of riddle application.
 * It shows list of riddle categories.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setCustomView(R.layout.action_bar_style);
        setActionBarProperties();
        setContentView(R.layout.activity_main);

        final List<Category> categoryType = DummyData.getCategories();
        ListView puzzleList = (ListView) findViewById(R.id.list_view_id);
        PuzzleAdapter adapter = new PuzzleAdapter(this, 0, categoryType);
        puzzleList.setAdapter(adapter);
    }

    /**
     * It sets the action bar properties.
     * Custom view is used in action bar.
     */
    private void setActionBarProperties() {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

}
