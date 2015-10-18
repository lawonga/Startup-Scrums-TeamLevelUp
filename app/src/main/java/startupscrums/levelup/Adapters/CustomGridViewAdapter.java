package startupscrums.levelup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-17.
 */
public class CustomGridViewAdapter extends ArrayAdapter<Subject> {
    public CustomGridViewAdapter(Context context, ArrayList<Subject> subjects) {
        super(context, 0, subjects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Subject subject = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_circleimageview_adapter, parent, false);
        }
        // Lookup views
        CircleImageView drawable_profilepic = (CircleImageView) convertView.findViewById(R.id.mentor_profile_image);
        TextView textview_name = (TextView) convertView.findViewById(R.id.course_name);
        TextView textview_description = (TextView) convertView.findViewById(R.id.course_description);
        TextView textview_difficulty = (TextView) convertView.findViewById(R.id.course_difficulty);
        // Populate the data into the template view using the data object
        drawable_profilepic.setImageBitmap(subject.coursepic);
        textview_name.setText(subject.name);
        textview_description.setText(subject.description);
        textview_difficulty.setText(subject.difficulty);
        // Return the completed view to render on screen
        return convertView;
    }
}
