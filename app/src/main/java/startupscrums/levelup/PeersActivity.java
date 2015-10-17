package startupscrums.levelup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

import startupscrums.levelup.Adapters.CustomGridViewAdapter;
import startupscrums.levelup.Adapters.Mentor;

/**
 * Created by Andy W on 2015-10-17.
 */
public class PeersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_gridview);
        ArrayList<Mentor> arrayAdapter = new ArrayList<>();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.earth);
        Log.e("BitmapID", bitmap.toString());
        for (int i=0; i<51; i++){
            arrayAdapter.add(new Mentor(bitmap, "PERSON "+i));
        }
        GridView gridView = (GridView)findViewById(R.id.profile_image_gridview);
        CustomGridViewAdapter customGridViewAdapter = new CustomGridViewAdapter(this, arrayAdapter);
        gridView.setAdapter(customGridViewAdapter);
    }
}