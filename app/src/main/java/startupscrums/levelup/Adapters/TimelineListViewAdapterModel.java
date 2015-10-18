package startupscrums.levelup.Adapters;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/**
 * Created by Andy W on 2015-10-18.
 */
public class TimelineListViewAdapterModel {
    public String timelineDescription;
    public Drawable timelineDrawable;
    public TimelineListViewAdapterModel(Drawable timelineDrawable, String timelineDescription) {
        this.timelineDrawable = timelineDrawable;
        this.timelineDescription = timelineDescription;
    }
}
