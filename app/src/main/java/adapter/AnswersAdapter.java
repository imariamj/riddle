package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mj.riddled.R;

import org.w3c.dom.Text;

import java.util.List;

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
        final TextView correctAns = (TextView) rowView.findViewById(R.id.CorrectAnswer_TVId);
        final TextView selectedAns = (TextView) rowView.findViewById(R.id.selectedAnswer_id);

        qText.setText(qs.getQuestion().getQuesText());

        if(qs.getSelectedAnswer().getId() == qs.getQuestion().getCorrectAnswer().getId()){
            correctAns.setText(qs.getQuestion().getCorrectAnswer().getOptionText());
            selectedAns.setVisibility(View.GONE);
        }
        else {
            correctAns.setText(qs.getQuestion().getCorrectAnswer().getOptionText());
            selectedAns.setText(qs.getSelectedAnswer().getOptionText());
            selectedAns.setVisibility(View.VISIBLE);
        }

      return rowView;
    }


}
