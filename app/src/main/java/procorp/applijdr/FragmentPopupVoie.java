package procorp.applijdr;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.Toast;

import procorp.applijdr.database.Voie;
import procorp.applijdr.database.VoieManager;
import procorp.applijdr.model.FragmentChoix;
import procorp.applijdr.model.FragmentPerso;
import procorp.applijdr.model.FragmentVoie;

/**
 * Created by benja on 03/02/2018.
 */

public class FragmentPopupVoie extends DialogFragment{

    private String[] list;
    private EditText input;
    private AlertDialog.Builder builder;
    private VoieManager voieManager;
    private int id;
    private Voie voie;

    public final static String EXTRA_MESSAGE = "procorp.applijdr.model.MESSAGE";



    public FragmentPopupVoie(){};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        builder = new AlertDialog.Builder(getActivity());
        list = getTag().trim().split(";");

        input = new EditText(getActivity());
        input.setText(list[0]);

        voieManager = new VoieManager(getActivity().getBaseContext());
        voieManager.open();

        if (list[2].equals("tag")) {
            voie = new Voie();
        } else {
            id = Integer.parseInt(list[2]);
            voie = voieManager.getVoieById(id);
        }
        input.setText(voie.getNomVoie());

        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setIcon(R.drawable.ic_dice);
        builder.setView(input);
        builder.setMessage("création/modification de voie: ");
        builder.setPositiveButton("confirmer", new okOnClickListener());
        builder.setNegativeButton("annuler", new cancelOnClickListener());


        return builder.create();
    }


    public void modif(){
        if(!input.getText().toString().equals("")){
            voie = new Voie(id, input.getText().toString());
            if(voieManager.getVoieById(voie.getIdVoie())==null){
                voieManager.insertVoie(voie);
                Toast.makeText(getActivity().getBaseContext(), "Voie créée", Toast.LENGTH_SHORT).show();
            }else{
                voieManager.updateVoie(voie);
                Toast.makeText(getActivity().getBaseContext(), "Voie modifiée", Toast.LENGTH_SHORT).show();
            }
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FragmentVoie()).commit();

        }else{
            Toast.makeText(getActivity().getBaseContext(), "Tu dois remplir le champs," +" ou bien supprimer cette voie si tu n'en veux plus.", Toast.LENGTH_SHORT).show();
        }
    }

    private final class okOnClickListener implements  DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
            modif();
        }
    }

    private final class cancelOnClickListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int id) {
        }
    }


}
