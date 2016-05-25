package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mj.riddled.R;

import java.util.List;

import data.Option;
import data.Question;
import data.QuestionStatus;

/**
 * Created by mariam.javed on 25/05/16.
 */
public class AnswersAdapter extends ArrayAdapter<QuestionStatus>{

    public AnswersAdapter(Context context, int resource, List<QuestionStatus> qa) {
        super(context, resource, qa);
    }

    @Override
    public View getView(final int position, View rowView, ViewGroup parent){
        QuestionStatus qs = getItem(position);
        if(rowView == null){
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.answer_list_item, parent,false);
        }

        final TextView qText = (TextView) rowView.findViewById(R.id.questionAnsText_id);
        final TextView ansText = (TextView) rowView.findViewById(R.id.answer_TVId);

        qText.setText(qs.getQuestion().getQuesText());
        ansText.setText(qs.getQuestion().getCorrectAnswer().getOptionText());

      return rowView;
    }


}
