package startupscrums.levelup.Logic;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;

/**
 * Created by Andy W on 2015-10-17.
 */
public class ParseInitialize extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Zxw65WGQzFbwsmWNNOxJp9gZlpHTLHGEtJOsrFPn", "z3geS1EoG2xfvDGCz4QzhRYPbczBIi6GaMBTIbOH");
        ParseFacebookUtils.initialize(getApplicationContext());
    }
}
