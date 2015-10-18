package startupscrums.levelup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-17.
 */
public class CustomListviewAdapter extends ArrayAdapter<CustomListViewAdapterModel> {
    public CustomListviewAdapter(Context context, ArrayList<CustomListViewAdapterModel> customListViewAdapterModels) {
        super(context, 0, customListViewAdapterModels);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CustomListViewAdapterModel customListViewAdapterModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_adapter, parent, false);
        }
        // Lookup views
        TextView textview_name = (TextView) convertView.findViewById(R.id.customlistview_textview_name);
        TextView textview_description = (TextView) convertView.findViewById(R.id.customlistview_textview_description);
        // Populate the data into the template view using the data object
        textview_name.setText(customListViewAdapterModel.name);
        textview_description.setText(customListViewAdapterModel.description);
        // Return the completed view to render on screen
        return convertView;
    }
}


