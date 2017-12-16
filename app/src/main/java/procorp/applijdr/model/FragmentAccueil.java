package procorp.applijdr.model;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import procorp.applijdr.R;
import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;

/**
 * Created by benja on 23/11/2017.
 */

public class FragmentAccueil extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_accueil, container, false);


        return myView;
    }
}