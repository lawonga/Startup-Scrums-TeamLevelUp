package startupscrums.levelup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Initialize stuff
        CircleImageView imageView_icon = (CircleImageView)findViewById(R.id.timeline_circleicon);
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

        // Query the image, no time to convert byteimages efficiently
        ParseQuery<ParseObject> bitmapQUery = ParseQuery.getQuery("Subject");
        bitmapQUery.whereEqualTo("objectId", objectId);
        try {
            List<ParseObject> findQuery = bitmapQUery.find();
            for (int i=0; i<findQuery.size(); i++){
                ParseObject parseObject = findQuery.get(i);
                ParseFile parseFile = parseObject.getParseFile("Image");
                byte[] file = parseFile.getData();
                Bitmap bmp = BitmapFactory.decodeByteArray(file, 0,
                        file.length);
                imageView_icon.setImageBitmap(bmp);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
            if (i ==0){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinegreen), localTimeLineArrayAdapter.get(i)));
            } else if (i > 0 && i <6) {
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinegreenmiddle), localTimeLineArrayAdapter.get(i)));
            } else if (i == 6){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinemiddle), localTimeLineArrayAdapter.get(i)));
            } else if (i == 7){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinebottom), localTimeLineArrayAdapter.get(i)));
            } else if (i == 9){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinetop), localTimeLineArrayAdapter.get(i)));
            } else if (i >9 && i <14){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinemiddle), localTimeLineArrayAdapter.get(i)));
            } else if (i==localTimeLineArrayAdapter.size()){
                timelineArrayList.add(new TimelineListViewAdapterModel(getResources().getDrawable(R.drawable.timelinebottom), localTimeLineArrayAdapter.get(i)));
            }

        }

        // Prepare the listview
        TimelineListViewAdapter timelineListViewAdapter = new TimelineListViewAdapter(this, timelineArrayList);
        timeline_listview.setAdapter(timelineListViewAdapter);
        timeline_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1){
                    startActivity(new Intent(TimelineScreen.this, CourseScreen.class));
                }
            }
        });
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
