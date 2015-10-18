package startupscrums.levelup.Adapters;

import android.graphics.Bitmap;

/**
 * Created by Andy W on 2015-10-17.
 */

/*
Profile Picture: coursepic;
Profile Name: name;
 */

public class Subject {
    public Bitmap coursepic;
    public String name, description, difficulty, objectId;
    public Subject(Bitmap coursepic, String name, String description, String difficulty, String objectId) {
        this.coursepic = coursepic;
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.objectId = objectId;
    }

    public String getBitmap(){
        return getBitmap();
    }

    public String getDescription(){
        return getDescription();
    }

    public String getDifficulty(){
        return getDifficulty();
    }

    public Bitmap getCoursepic(){
        return getCoursepic();
    }
    public String getObjectId(){
        return getObjectId();
    }

}
