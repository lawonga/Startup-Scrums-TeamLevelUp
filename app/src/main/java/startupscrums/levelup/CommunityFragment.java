package startupscrums.levelup;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import startupscrums.levelup.Adapters.HelpListViewAdapter;
import startupscrums.levelup.Adapters.HelpListViewAdapterModel;

/**
 * Created by Andy W on 2015-10-18.
 */
public class CommunityFragment extends Fragment {
    public ListView listView;
    public static HelpListViewAdapter helpListViewAdapter;
    public static ArrayList<HelpListViewAdapterModel> helpListViewAdapterModels = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.community_fragment, container, false);
        listView = (ListView)rootView.findViewById(R.id.community_listview);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.earth);

        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap, "Bob joe", "5th year, Math Major", "PLS HELP", "17 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap, "Joe John", "3rd year, Chemistry Major", "PLS HELP", "12 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap, "Sarah joe", "5th year, Physics Major", "PLS HELP", "5 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap, "Bob Tiffany", "1st year, Biology Major", "PLS HELP", "16 answers"));

        helpListViewAdapter = new HelpListViewAdapter(listView.getContext(), helpListViewAdapterModels);
        listView.setAdapter(helpListViewAdapter);
        return listView;
    }
}
