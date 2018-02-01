package procorp.applijdr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;

import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.model.FragmentChoix;
import procorp.applijdr.model.FragmentPerso;

/**
 * Created by benja on 15/12/2017.
 */

public class FragmentPopupRemove extends DialogFragment {

    private PersoManager persoManager;
    private String[] list;
    private Perso perso;
    public final static String EXTRA_MESSAGE = "procorp.applijdr.model.MESSAGE";

    public FragmentPopupRemove(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        list = getTag().split(";");
        if(getActivity().getIntent()!=null){
            String message = getActivity().getIntent().getStringExtra(this.EXTRA_MESSAGE);
        }


            persoManager = new PersoManager(getActivity().getBaseContext());
            persoManager.open();
            builder.setMessage("voulez vous supprimer " + list[0]);
            builder.setPositiveButton("supprimez !!", new okOnClickListener());
            builder.setNegativeButton("oups :o", new cancelOnClickListener());

        // Create the AlertDialog object and return it
        return builder.create();
    }

    private final class okOnClickListener implements  DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            persoManager.removePersoWithID(Integer.parseInt(list[2]));
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChoix()).commit();
        }
    }

    private final class cancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
        }
    }
}