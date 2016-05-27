package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mj.riddled.QuizStartActivity;
import com.mj.riddled.R;

import java.util.List;

import data.Category;
import data.Constants;

/**
 * Created by mariam.javed on 20/05/16.
 * QuizAdapter : Creates view for list of quiz categories
 */
public class QuizAdapter extends ArrayAdapter<Category>{

    public QuizAdapter(Context context, int resource, List<Category> data) {
        super(context, resource, data);
    }

    @Override
    public View getView(final int position, View rowView, ViewGroup parent){
        final Category category = getItem(position);

        //Inflate layout of each of the rows on puzzle type list
        if(rowView == null){
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.quiz_category_row_view, parent,false);
        }

        final TextView tvName = (TextView) rowView.findViewById(R.id.quiz_category_text);
        ImageView ivImage = (ImageView) rowView.findViewById(R.id.quiz_category_image_view);

        tvName.setText(category.getName());
        ivImage.setImageResource(category.getCategoryImage());

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puzzleIntent = new Intent(getContext(), QuizStartActivity.class);
                puzzleIntent.putExtra(Constants.CATEGORY_ID, category.getId());
                puzzleIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                getContext().startActivity(puzzleIntent);

            }
        });

        return rowView;

    }

}
