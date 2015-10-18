package startupscrums.levelup.CommunityHelp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-18.
 */
public class CourseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.course_fragment, container, false);
        Button button = (Button)rootView.findViewById(R.id.course_fragment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(rootView.getContext(), "Error! Please watch the video", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }
}
