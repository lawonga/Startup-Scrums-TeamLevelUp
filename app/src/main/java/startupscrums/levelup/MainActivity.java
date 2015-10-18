package startupscrums.levelup;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import startupscrums.levelup.Adapters.CustomGridViewAdapter;
import startupscrums.levelup.Adapters.CustomGridViewAdapterModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "WELCOME", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /** END OF GENERATED CODE **/
        // No time for beautiful code, i'm gonna be lazy because its 2am
        final ArrayList<String> subjectNameHolder = new ArrayList<>();
        final ArrayList<String> objectIdHolder = new ArrayList<>();
        final ArrayList<String> descriptionHolder = new ArrayList<>();
        final ArrayList<String> difficultyHolder = new ArrayList<>();
        final ArrayList<Byte> bitmapByte = new ArrayList<>();

        // Code here temporary to test
        // No time to make code efficient or pretty...
        final ArrayList<CustomGridViewAdapterModel> arrayAdapter = new ArrayList<>();
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Subject");
        try {
            List<ParseObject> findQuery = parseQuery.find();
            for (int i = 0; i < findQuery.size(); i++) {
                String subjectName, description, difficulty, objectId;
                ParseObject parseObject = findQuery.get(i);
                ParseFile parseFile = parseObject.getParseFile("Image");
                byte[] file = parseFile.getData();
                Bitmap bmp = BitmapFactory.decodeByteArray(file, 0,
                        file.length);
                subjectName = parseObject.getString("subjectName");
                description = parseObject.getString("description");
                difficulty = parseObject.getString("difficulty");
                objectId = parseObject.getObjectId();
                arrayAdapter.add(new CustomGridViewAdapterModel(bmp, subjectName, description, difficulty, objectId));
                subjectNameHolder.add(subjectName);
                objectIdHolder.add(objectId);
                descriptionHolder.add(description);
                difficultyHolder.add(difficulty);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.e("ArrayAdapter", String.valueOf(arrayAdapter));
        GridView gridView = (GridView) findViewById(R.id.profile_image_gridview);
        CustomGridViewAdapter customGridViewAdapter = new CustomGridViewAdapter(this, arrayAdapter);
        gridView.setAdapter(customGridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedSubjectName, clickedObjectId, clickedDescription, clickedDifficulty;
                clickedSubjectName = subjectNameHolder.get(position);
                clickedObjectId = objectIdHolder.get(position);
                clickedDescription = descriptionHolder.get(position);
                clickedDifficulty= difficultyHolder.get(position);
                Intent intent = new Intent(MainActivity.this, TimelineScreen.class);
                intent.putExtra("objectId", clickedObjectId);
                intent.putExtra("clickedSubjectName", clickedSubjectName);
                intent.putExtra("clickedDescription", clickedDescription);
                intent.putExtra("clickedDifficulty", clickedDifficulty);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_chat) {
            // Handle the chat action
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_settings) {

        } /*else if (id == R.id.nav_spam) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
