package startupscrums.levelup.Adapters;

import android.graphics.Bitmap;
import android.widget.Button;

// Data Model for the listview
public class HelpListViewAdapterModel {
    public String communityName, communityDescription, communityQuestion, communityAnswer;
    public Bitmap bitmap;

    public HelpListViewAdapterModel(Bitmap bitmap, String communityName, String communityDescription, String communityQuestion, String communityAnswer){
        this.communityName = communityName;
        this.communityDescription = communityDescription;
        this.communityQuestion = communityQuestion;
        this.communityAnswer = communityAnswer;
        this.bitmap = bitmap;
    }

    public String getCommunityName(){
        return communityName;
    }
    public String getCommunityAnswer(){
        return communityAnswer;
    }
    public String getCommunityDescription(){
        return communityDescription;
    }
    public String getCommunityQuestion(){
        return communityQuestion;
    }
}
