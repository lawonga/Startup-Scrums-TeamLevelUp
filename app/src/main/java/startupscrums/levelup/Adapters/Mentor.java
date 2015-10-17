package startupscrums.levelup.Adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by Andy W on 2015-10-17.
 */

/*
Profile Picture: profilepic;
Profile Name: name;
 */

public class Mentor {
    public Bitmap profilepic;
    public String name;
    public Mentor(Bitmap profilepic, String name) {
        this.profilepic = profilepic;
        this.name = name;
    }
}
