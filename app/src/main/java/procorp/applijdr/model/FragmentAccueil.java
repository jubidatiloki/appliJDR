package procorp.applijdr.model;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import procorp.applijdr.Couple;
import procorp.applijdr.R;
import procorp.applijdr.database.MaBaseSQLite;
import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.listage.PersoAdapter;

/**
 * Created by benja on 23/11/2017.
 */

public class FragmentAccueil extends Fragment {
    View myView;
    private List<Couple> coupleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersoAdapter persoAdapter;
    private Couple couple;
    private Perso perso;
    private PersoManager persoManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_accueil, container, false);

        persoManager = new PersoManager(myView.getContext());
        persoManager.open();
        perso = persoManager.getPersoById(0);



        persoAdapter = new PersoAdapter(coupleList);


        prepareCoupleData();
        return myView;
    }


    private void prepareCoupleData() {
        couple = new Couple("Retour", "retour à l'écran des choix", "retour");
        coupleList.add(couple);
        couple = new Couple("nom: ", perso.getNom(), MaBaseSQLite.COL_NOM);
        coupleList.add(couple);
        couple = new Couple("classe: ", perso.getClasse(), MaBaseSQLite.COL_CLASSE);
        coupleList.add(couple);
        couple = new Couple("race: ", perso.getRace(), MaBaseSQLite.COL_RACE);
        coupleList.add(couple);
        couple = new Couple("pv max: ", Integer.toString(perso.getPvMax()), MaBaseSQLite.COL_PVMAX);
        coupleList.add(couple);
        couple = new Couple("pv: ",Integer.toString(perso.getPvMax()), MaBaseSQLite.COL_PV);
        coupleList.add(couple);
        couple = new Couple("description: ", perso.getDescription(), MaBaseSQLite.COL_DESCRIPTION);
        coupleList.add(couple);
        couple = new Couple("inventaire: ", perso.getInventaire(), MaBaseSQLite.COL_INVENTAIRE);
        coupleList.add(couple);
        couple = new Couple("note perso: ", perso.getNotePerso(), MaBaseSQLite.COL_NOTEPERSO);
        coupleList.add(couple);
        couple = new Couple("niveau: ", Integer.toString(perso.getNiveau()), MaBaseSQLite.COL_NIVEAU);
        coupleList.add(couple);
        couple = new Couple("défense: ", Integer.toString(perso.getDefense()), MaBaseSQLite.COL_DEFENSE);
        coupleList.add(couple);
        couple = new Couple("initiative: ", Integer.toString(perso.getInitiative()), MaBaseSQLite.COL_INITIATIVE);
        coupleList.add(couple);
        couple = new Couple("FORCE: ", Integer.toString(perso.getFOR()), MaBaseSQLite.COL_FOR);
        coupleList.add(couple);
        couple = new Couple("DEXTERITE: ", Integer.toString(perso.getDEX()), MaBaseSQLite.COL_DEX);
        coupleList.add(couple);
        couple = new Couple("CONSTITUTION: ", Integer.toString(perso.getCON()), MaBaseSQLite.COL_CON);
        coupleList.add(couple);
        couple = new Couple("INTELLIGENCE: ", Integer.toString(perso.getINT()), MaBaseSQLite.COL_INT);
        coupleList.add(couple);
        couple = new Couple("SAGESSE: ", Integer.toString(perso.getSAG()), MaBaseSQLite.COL_SAG);
        coupleList.add(couple);
        couple = new Couple("CHARISME: ", Integer.toString(perso.getCHA()), MaBaseSQLite.COL_CHA);
        coupleList.add(couple);


        // notify adapter about data set changes
        // so that it will render the list with new data
        persoAdapter.notifyDataSetChanged();
    }
}