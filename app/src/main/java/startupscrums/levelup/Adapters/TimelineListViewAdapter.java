package startupscrums.levelup.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-17.
 */
public class TimelineListViewAdapter extends ArrayAdapter<TimelineListViewAdapterModel> {
    public TimelineListViewAdapter(Context context, ArrayList<TimelineListViewAdapterModel> TimelineListViewAdapterModels) {
        super(context, 0, TimelineListViewAdapterModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TimelineListViewAdapterModel timelineListViewAdapterModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.timeline_listview_adapter, parent, false);
        }
        // Lookup views
        ImageView timeline_checkbox = (ImageView) convertView.findViewById(R.id.timelineadapter_checkbox);
        TextView textview_description = (TextView) convertView.findViewById(R.id.timelineadapter_course_description);
        // Populate the data into the template view using the data object
        // Change to checkbox when i get it..
        /** timeline_checkbox.setImageBitmap(); **/
        textview_description.setText(timelineListViewAdapterModel.timelineDescription);
        if (timelineListViewAdapterModel.timelineDescription.equals("Week 1") || timelineListViewAdapterModel.timelineDescription.equals("Week 2")){
            textview_description.setTypeface(null, Typeface.BOLD);
            textview_description.setGravity(Gravity.CENTER);
        }
        // Return the completed view to render on screen
        return convertView;
    }
}




