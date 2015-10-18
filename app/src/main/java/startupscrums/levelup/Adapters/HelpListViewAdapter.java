package startupscrums.levelup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-17.
 */
public class HelpListViewAdapter extends ArrayAdapter<HelpListViewAdapterModel> {
    public HelpListViewAdapter(Context context, ArrayList<HelpListViewAdapterModel> helpListViewAdapterModels) {
        super(context, 0, helpListViewAdapterModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        HelpListViewAdapterModel helpListViewAdapterModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.community_adapter, parent, false);
        }
        // Lookup views
        TextView studentName = (TextView) convertView.findViewById(R.id.community_StudentName);
        TextView studentDescription = (TextView) convertView.findViewById(R.id.community_StudentDescription);
        TextView studentAnswer = (TextView) convertView.findViewById(R.id.community_answer);
        TextView studentQuestion = (TextView) convertView.findViewById(R.id.community_question);
        Button studentButton = (Button)convertView.findViewById(R.id.community_button);
        CircleImageView circleImageView = (CircleImageView)convertView.findViewById(R.id.community_circleimageview);
        // Populate the data into the template view using the data object
        studentName.setText(helpListViewAdapterModel.communityName);
        studentDescription.setText(helpListViewAdapterModel.communityDescription);
        studentAnswer.setText(helpListViewAdapterModel.communityAnswer);
        studentQuestion.setText(helpListViewAdapterModel.communityQuestion);
        circleImageView.setImageBitmap(helpListViewAdapterModel.bitmap);
        // Return the completed view to render on screen
        return convertView;
    }
}


