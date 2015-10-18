package startupscrums.levelup.COMMUNITYHELP;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import startupscrums.levelup.R;

/**
 * Created by Andy W on 2015-10-18.
 */
public class HelpFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.help_fragment, container, false);
        return rootView;
    }
}
