package startupscrums.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

import startupscrums.levelup.AndysCustomStuff.PeersActivity;

/**
 * Created by Andy W on 2015-10-17.
 */
public class DescriptionScreen extends AppCompatActivity {
    String objectId, descriptionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_textview_screen);
        TextView descriptionTextView = (TextView)findViewById(R.id.textview_screen_textview);
        Button helpButton = (Button)findViewById(R.id.textview_screen_help_button);
        Bundle extras = getIntent().getExtras();
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PeersActivity.class));
            }
        });

        objectId = extras.getString("objectId");
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("SubjectSteps");
        ParseObject pointer = ParseObject.createWithoutData("CustomGridViewAdapterModel", objectId);
        parseQuery.whereEqualTo("SubjectPointer", pointer);
        try {
            List<ParseObject> find = parseQuery.find();
            for (int i=0; i<find.size(); i++) {
                ParseObject foundObject = find.get(0);
                descriptionText = foundObject.getString("Description");
                descriptionTextView.setText(descriptionText);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
