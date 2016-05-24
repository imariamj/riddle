package com.mj.riddled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import adapter.PuzzleAdapter;
import data.Category;
import data.DummyData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Category> categoryType = DummyData.getCategories();

        ListView puzzleList = (ListView) findViewById(R.id.list_view_id);

        PuzzleAdapter adapter = new PuzzleAdapter(this, 0, categoryType);

        puzzleList.setAdapter(adapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.puzzle_red);
    }

}
