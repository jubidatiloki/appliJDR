package procorp.applijdr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;

import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.model.FragmentPerso;

/**
 * Created by benja on 15/12/2017.
 */

public class FragmentPopup extends DialogFragment {

    private PersoManager persoManager;
    private String[] list;
    private Perso perso;
    private EditText input;
    public final static String EXTRA_MESSAGE = "procorp.applijdr.model.MESSAGE";

    public FragmentPopup(){}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        input = new EditText(getActivity());
        list = getTag().trim().split(";");
        if(getActivity().getIntent()!=null){
            String message = getActivity().getIntent().getStringExtra(this.EXTRA_MESSAGE);
        }
        //retour vers le menu de choix des perso
        if(list[0].equals("retour")){
            getActivity().finish();
        }else {
            input.setText(list[1]);
            //Toast.makeText(getActivity().getBaseContext(), Integer.toString(list[2].length()), Toast.LENGTH_SHORT).show();
            if (list[0].equals("FOR") || list[0].equals("DEX") || list[0].equals("CON") || list[0].equals("INT") || list[0].equals("SAG") || list[0].equals("CHA") || list[0].equals("niveau") || list[0].equals("defense") || list[0].equals("initiative")|| list[0].equals("pvMax") || list[0].equals("pv")) {
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
            } else {
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                if (list[1].length() >= 34) {
                    input.setLines(5);
                    input.setGravity(Gravity.LEFT | Gravity.TOP);
                    input.setSingleLine(false);
                }

            }
            persoManager = new PersoManager(getActivity().getBaseContext());
            persoManager.open();
            perso = persoManager.getPersoById(Integer.parseInt(list[2]));
            builder.setView(input);
            builder.setMessage("modification du paramètre: " + list[0]);
            builder.setPositiveButton("confirmer", new okOnClickListener());
            builder.setNegativeButton("annuler", new cancelOnClickListener());
        }
        // Create the AlertDialog object and return it
        return builder.create();

    }

    private final class okOnClickListener implements  DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            persoManager.UpdateByNomCol(perso, list[0], input.getText().toString());
            Intent intent = new Intent( getActivity().getBaseContext(), FragmentPerso.class);
            intent.putExtra(EXTRA_MESSAGE, Integer.toString(perso.getIdPerso()));
            //fermeture de l'activité courante (pour éviter qu'elle s'entasse)
            getActivity().finish();
            //relancement de l'activité
            startActivityForResult(intent, 0);
        }
    }

    private final class cancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
        }
    }
}