package procorp.applijdr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.model.FragmentPerso1;
import procorp.applijdr.model.FragmentPerso2;

/**
 * Created by benja on 15/12/2017.
 */

public class FragmentPopup extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText input = new EditText(getActivity());
        final String[] list = getTag().split(" ");
        input.setText(list[3]);
        //Toast.makeText(getActivity().getBaseContext(), list[2], Toast.LENGTH_SHORT).show();
        if(list[2].equals("FOR") || list[2].equals("DEX") || list[2].equals("CON") ||list[2].equals("INT") ||list[2].equals("SAG") ||list[2].equals("CHA")){
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
        }else{
            input.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        final PersoManager persoManager = new PersoManager(getActivity().getBaseContext());
        persoManager.open();
        final Perso perso = persoManager.getPersoById(Integer.parseInt(list[1]));
        builder.setView(input);
        builder.setMessage("modification du paramètre: "+list[0])
                .setPositiveButton("confirmer", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        persoManager.updateByNumCol(perso, list[2], input.getText().toString());
                        FragmentManager fragmentManager = getFragmentManager();
                        if(list[1].equals("1")){
                            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentPerso1()).commit();
                        }else{
                            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentPerso2()).commit();
                        }

                    }
                })
                .setNegativeButton("annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}