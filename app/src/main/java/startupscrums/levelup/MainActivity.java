package startupscrums.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import startupscrums.levelup.Adapters.CustomListviewAdapter;
import startupscrums.levelup.Adapters.User;
import startupscrums.levelup.Logic.ParseInitialize;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ParseInitialize();
        setContentView(R.layout.activity_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        getSupportActionBar().show();
        ArrayList<User> arrayAdapter = new ArrayList<>();
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Subject");
        try {
            List<ParseObject> findQuery = parseQuery.find();
            for (int i=0; i<findQuery.size(); i++){
                ParseObject parseObject = findQuery.get(i);
                String CourseName = parseObject.getString("subjectName");
                String CourseDescription = parseObject.getString("description");
                arrayAdapter.add(new User(CourseName, CourseDescription));

            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CustomListviewAdapter customListviewAdapter = new CustomListviewAdapter(this, arrayAdapter);
        ListView listView = (ListView)findViewById(R.id.custom_listview_root);
        listView.setAdapter(customListviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), PeersActivity.class);
                    startActivity(intent);
                }
            }
        });


        /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }); */

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
