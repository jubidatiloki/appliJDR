package procorp.applijdr.model;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import procorp.applijdr.R;

/**
 * Created by benja on 02/02/2018.
 */

public class FragmentVoie extends Fragment {

    private View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_voie, container, false);

        return myView;
    }
}
