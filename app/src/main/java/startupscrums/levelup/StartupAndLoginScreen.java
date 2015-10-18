package startupscrums.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import startupscrums.levelup.AndysCustomStuff.OldActivityMainListView;

/**
 * Created by Andy W on 2015-10-17.
 * Startup screen, includes FACEBOOK & GOOGLE+ login functions
 */
public class StartupAndLoginScreen extends AppCompatActivity {
    private ParseUser parseUser;
    final List<String> permissions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_screen);
        ImageView facebookImageView = (ImageView)findViewById(R.id.facebook_button);
        ImageView googleplusImageView = (ImageView)findViewById(R.id.googleplus_button);
        permissions.add("public_profile");


        facebookImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                /** Does facebook -- UNCOMMENT LATER **/
                /*
                ParseFacebookUtils.logInWithReadPermissionsInBackground(StartupAndLoginScreen.this, permissions, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, com.parse.ParseException e) {
                        if (user == null) {
                            Log.d("MyApp", "The user cancelled the Facebook login.");
                            Toast.makeText(getApplicationContext(), "Login Cancelled", Toast.LENGTH_LONG).show();
                        } else if (user.isNew()) {
                            Log.d("MyApp", "CustomListViewAdapterModel signed up and logged in through Facebook!");
                            finish();
                            startActivity(new Intent(getApplicationContext(), old_activity.class));
                        } else {
                            Log.d("MyApp", "CustomListViewAdapterModel logged in through Facebook!");
                            finish();
                            startActivity(new Intent(getApplicationContext(), old_activity.class));
                        }
                    }
                });
                */
            }
        });

        googleplusImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        parseUser = ParseUser.getCurrentUser();
        if (parseUser != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}
