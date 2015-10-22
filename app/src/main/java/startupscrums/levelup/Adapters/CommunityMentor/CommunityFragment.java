package startupscrums.levelup.Adapters.CommunityMentor;

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
import startupscrums.levelup.R;

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
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.profile5);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.profile1);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.profile3);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.profile4);

        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap1, "Bob joe", "5th year, Math Major", "Help me find X", "17 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap2,  "Joe John", "3rd year, Chemistry Major", "What happens when you mix ammonia and bleach? ", "12 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap3,"Sarah joe", "5th year, Physics Major", "I need help on my lab", "5 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap4, "Bob Tiffany", "1st year, Biology Major", "Why do I run slower than a horse?", "16 answers"));
        helpListViewAdapterModels.add(new HelpListViewAdapterModel(bitmap1, "Iron Man", "Graduate Student, Minerals", "LOL WHAT QUESTIONS", "1 answer"));

        helpListViewAdapter = new HelpListViewAdapter(listView.getContext(), helpListViewAdapterModels);
        listView.setAdapter(helpListViewAdapter);
        return listView;
    }
}
