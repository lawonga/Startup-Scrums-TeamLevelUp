package startupscrums.levelup.AndysCustomStuff;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import startupscrums.levelup.Adapters.CustomGridViewAdapter;
import startupscrums.levelup.Adapters.CustomGridViewAdapterModel;
import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-17.
 */
public class PeersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_gridview);
        ArrayList<CustomGridViewAdapterModel> arrayAdapter = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.earth);
        /*for (int i=0; i<51; i++){
            arrayAdapter.add(new CustomGridViewAdapterModel(bitmap, "PERSON "+i));
        }*/
        GridView gridView = (GridView)findViewById(R.id.profile_image_gridview);
        CustomGridViewAdapter customGridViewAdapter = new CustomGridViewAdapter(this, arrayAdapter);
        gridView.setAdapter(customGridViewAdapter);
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
