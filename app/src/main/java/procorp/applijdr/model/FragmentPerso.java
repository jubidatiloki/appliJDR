package procorp.applijdr.model;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import procorp.applijdr.Couple;
import procorp.applijdr.FragmentPopupPerso;
import procorp.applijdr.R;
import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;

/**
 * Created by benja on 23/11/2017.
 */

public class FragmentPerso extends Activity {
    private List<Couple> coupleList = new ArrayList<>();
    private TextView t_nom;
    private TextView t_classe;
    private TextView t_race;
    private TextView t_pv;
    private TextView t_pvmax;
    private TextView t_niveau;
    private TextView t_defense;
    private TextView t_initiative;
    private TextView t_for;
    private TextView t_dex;
    private TextView t_con;
    private TextView t_int;
    private TextView t_sag;
    private TextView t_cha;
    private TextView t_description;
    private TextView t_inventaire;
    private TextView t_noteperso;
    Perso perso;
    private String idPerso;
    private PersoManager persoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_perso);
        persoManager = new PersoManager(this);
        persoManager.open();

        t_nom = findViewById(R.id.t_nom);
        t_classe = findViewById(R.id.t_classe);
        t_race = findViewById(R.id.t_race);
        t_pv = findViewById(R.id.t_pv);
        t_pvmax = findViewById(R.id.t_pvmax);
        t_niveau = findViewById(R.id.t_niveau);
        t_defense = findViewById(R.id.t_defense);
        t_initiative = findViewById(R.id.t_initiative);
        t_for = findViewById(R.id.t_for);
        t_dex = findViewById(R.id.t_dex);
        t_con = findViewById(R.id.t_con);
        t_int = findViewById(R.id.t_int);
        t_sag = findViewById(R.id.t_sag);
        t_cha = findViewById(R.id.t_cha);
        t_description = findViewById(R.id.t_description);
        t_inventaire = findViewById(R.id.t_inventaire);
        t_noteperso = findViewById(R.id.t_noteperso);

        // intent
        final Intent intent = getIntent();
        if(intent.getStringExtra(FragmentChoix.EXTRA_MESSAGE)!=null) {
            idPerso = intent.getStringExtra(FragmentChoix.EXTRA_MESSAGE);
        }
        if(idPerso.equals("tag")){
            this.perso = new Perso();
            this.persoManager.insertPerso(this.perso);

        }else{
            perso = persoManager.getPersoById(Integer.parseInt(idPerso));
        }


        t_nom.setText("nom:" + perso.getNom());
        t_classe.setText("classe:" + perso.getClasse());
        t_race.setText("race:" + perso.getRace());
        t_pv.setText("pv:" + perso.getPv());
        t_pvmax.setText("pvMax:" + perso.getPvMax());
        t_niveau.setText("niveau:" + perso.getNiveau());
        t_defense.setText("defense:" + perso.getDefense());
        t_initiative.setText("init:" + perso.getInitiative());
        t_for.setText("FOR:" + perso.getFOR());
        t_dex.setText("DEX:" + perso.getDEX());
        t_con.setText("CON:" + perso.getCON());
        t_int.setText("INT:" + perso.getINT());
        t_sag.setText("SAG:" + perso.getSAG());
        t_cha.setText("CHA:" + perso.getCHA());
        t_description.setText("description:" + perso.getDescription());
        t_inventaire.setText("inventaire:" + perso.getInventaire());
        t_noteperso.setText("notePerso:" + perso.getNotePerso());


        t_nom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_nom.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
            public void onLongClick(View view, int position) {

            }
        });

        t_classe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_classe.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_race.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_race.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_pv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_pv.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_pvmax.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_pvmax.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_defense.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_defense.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_niveau.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_niveau.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_initiative.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_initiative.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_for.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_for.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_dex.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_dex.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_con.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_con.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_int.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_int.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_sag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_sag.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_cha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_cha.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_description.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_description.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_inventaire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_inventaire.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });

        t_noteperso.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new FragmentPopupPerso();
                String[] liste = t_noteperso.getText().toString().split(":");
                dialog.show(getFragmentManager(), liste[0] + ";" + liste[1] + ";" + perso.getIdPerso());
            }
        });



    }
}