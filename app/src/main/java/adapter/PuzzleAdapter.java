package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mj.riddled.PuzzleStart;
import com.mj.riddled.R;

import java.util.List;

import data.Category;
import data.Constants;

/**
 * Created by mariam.javed on 20/05/16.
 */
public class PuzzleAdapter extends ArrayAdapter<Category>{

    public PuzzleAdapter(Context context, int resource, List<Category> data) {
        super(context, resource, data);
    }

    @Override
    public View getView(final int position, View rowView, ViewGroup parent){
        final Category category = getItem(position);

        //Inflate layout of each of the rows on puzzle type list
        if(rowView == null){
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.puzzle_type_item, parent,false);
        }

        final TextView tvName = (TextView) rowView.findViewById(R.id.main_list_itemText_id);
        ImageView ivImage = (ImageView) rowView.findViewById(R.id.main_list_itemImage_id);

        tvName.setText(category.getName());
        ivImage.setImageResource(category.getCategoryImage());

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puzzleIntent = new Intent(getContext(), PuzzleStart.class);
                puzzleIntent.putExtra(Constants.CATEGORY_ID, category.getId());
                getContext().startActivity(puzzleIntent);
            }
        });

        return rowView;

    }

}
