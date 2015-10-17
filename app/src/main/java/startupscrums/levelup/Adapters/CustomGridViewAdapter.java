package startupscrums.levelup.Adapters;

import android.content.Context;
import android.util.Log;
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
public class CustomGridViewAdapter extends ArrayAdapter<Mentor> {
    public CustomGridViewAdapter(Context context, ArrayList<Mentor> mentors) {
        super(context, 0, mentors);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Mentor mentor = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_circleimageview_adapter, parent, false);
        }
        // Lookup views
        CircleImageView drawable_profilepic = (CircleImageView) convertView.findViewById(R.id.mentor_profile_image);
        TextView textview_name = (TextView) convertView.findViewById(R.id.mentor_name);
        // Populate the data into the template view using the data object
        Log.e("Bitmap CUSTOMGRID", mentor.profilepic.toString());
        drawable_profilepic.setImageBitmap(mentor.profilepic);
        textview_name.setText(mentor.name);
        // Return the completed view to render on screen
        return convertView;
    }
}
