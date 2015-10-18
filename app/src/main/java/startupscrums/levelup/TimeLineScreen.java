package startupscrums.levelup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import startupscrums.levelup.Adapters.CustomListViewAdapterModel;
import startupscrums.levelup.Adapters.CustomListviewAdapter;
import startupscrums.levelup.Adapters.TimelineListViewAdapter;
import startupscrums.levelup.Adapters.TimelineListViewAdapterModel;

/**
 * Created by Andy W on 2015-10-18.
 */
public class TimelineScreen extends AppCompatActivity{
    String objectId, difficulty, subjectName, timelineDescription;
    Integer indexNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        // Initialize stuf
        TextView textView_name = (TextView)findViewById(R.id.timeline_course_name);
        TextView textView_description = (TextView)findViewById(R.id.timeline_course_description);
        TextView textView_difficulty = (TextView)findViewById(R.id.timeline_course_difficulty);
        ListView timeline_listview = (ListView)findViewById(R.id.timeline_listview);

        // Get stuff
        Bundle extras = getIntent().getExtras();
        objectId = extras.getString("objectId");
        subjectName = extras.getString("clickedSubjectName");
        timelineDescription = extras.getString("clickedDescription");
        difficulty = extras.getString("clickedDifficulty");

        // Log to debug
        Log.e("objectId", objectId);
        Log.e("subjectName", subjectName);
        Log.e("timelineDescription", timelineDescription);
        Log.e("difficulty", difficulty);

        // Set the stuff we just initialized
        textView_name.setText(subjectName);
        textView_description.setText(timelineDescription);
        textView_difficulty.setText(difficulty);

        // Make a local temporary array adapter to put stuff we're about to query into...
        ArrayList<String> localTimeLineArrayAdapter= new ArrayList<>();

        // Query the timeline
        final ArrayList<TimelineListViewAdapterModel> timelineArrayList= new ArrayList<>();
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("SubjectTimeline");
        ParseObject pointer = ParseObject.createWithoutData("Subject", objectId);
        parseQuery.whereEqualTo("TimelinePointer", pointer);
        try {
            List<ParseObject> parseObjects = parseQuery.find();
            for (int i=0; i<parseObjects.size(); i++) {
                ParseObject object = parseObjects.get(i);
                timelineDescription = object.getString("TimelineDescription");
                indexNumber = object.getInt("Number");
                localTimeLineArrayAdapter.add(indexNumber, timelineDescription);
                Log.e("parseObject", timelineDescription);
                Log.e("Number", indexNumber.toString());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            localTimeLineArrayAdapter.add(0, "Week 1");
            localTimeLineArrayAdapter.add(8, "Week 2");
        }catch (Exception e){
            Log.e("BLAH", "BLAH");
        }
        for (int i = 0; i < localTimeLineArrayAdapter.size(); i++){
            timelineArrayList.add(new TimelineListViewAdapterModel(localTimeLineArrayAdapter.get(i)));
        }

        // Prepare the listview
        TimelineListViewAdapter timelineListViewAdapter = new TimelineListViewAdapter(this, timelineArrayList);
        timeline_listview.setAdapter(timelineListViewAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
