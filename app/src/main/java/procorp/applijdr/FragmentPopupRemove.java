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
import android.widget.Toast;

import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.database.VoieManager;
import procorp.applijdr.model.FragmentChoix;
import procorp.applijdr.model.FragmentPerso;
import procorp.applijdr.model.FragmentVoie;

/**
 * Created by benja on 15/12/2017.
 */

public class FragmentPopupRemove extends DialogFragment {

    private PersoManager persoManager;
    private VoieManager voieManager;
    private String[] list;
    private Perso perso;
    public final static String EXTRA_MESSAGE = "procorp.applijdr.model.MESSAGE";

    public FragmentPopupRemove(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        list = getTag().split(";");
        if(list[0].equals("perso")){
            persoManager = new PersoManager(getActivity().getBaseContext());
            persoManager.open();
            builder.setMessage("voulez vous supprimer " + list[1]);
            builder.setPositiveButton("supprimez !!", new okPerso());
            builder.setNegativeButton("oh nan :'(", new cancelPerso());

        }else if(list[0].equals("voie")){
            voieManager = new VoieManager(getActivity().getBaseContext());
            voieManager.open();
            String nom = voieManager.getVoieById(Integer.parseInt(list[1])).getNomVoie();
            builder.setMessage("voulez vous supprimer la voie: " + nom);
            builder.setPositiveButton("supprimez !!", new okVoie());
            builder.setNegativeButton("oh nan :'(", new cancelVoie());
        }
        if(getActivity().getIntent()!=null){
            String message = getActivity().getIntent().getStringExtra(this.EXTRA_MESSAGE);
        }

        // Create the AlertDialog object and return it
        return builder.create();
    }

    private final class okPerso implements  DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            persoManager.removePersoWithID(Integer.parseInt(list[3]));
            Toast.makeText(getActivity().getBaseContext(), "perso supprimé", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentChoix()).commit();
        }
    }

    private final class cancelPerso implements  DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private final class okVoie implements  DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            voieManager.removeVoieWithID(Integer.parseInt(list[1]));
            Toast.makeText(getActivity().getBaseContext(), "voie supprimée", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentVoie()).commit();
        }
    }

    private final class cancelVoie implements  DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}