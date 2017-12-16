package procorp.applijdr.model;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import procorp.applijdr.listage.*;
import procorp.applijdr.FragmentPopup;
import procorp.applijdr.R;
import procorp.applijdr.listage.RecyclerTouchListener;
import procorp.applijdr.database.MaBaseSQLite;
import procorp.applijdr.database.Perso;
import procorp.applijdr.database.PersoManager;

/**
 * Created by benja on 23/11/2017.
 */

public class FragmentPerso1 extends Fragment {
    View myView;
    private List<Couple> coupleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PersoAdapter persoAdapter;
    Perso perso;
    Couple couple;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_perso1, container, false);

        final PersoManager persoManager = new PersoManager(this.getActivity().getBaseContext());
        persoManager.open();
        perso = persoManager.getPersoById(1);

        recyclerView = (RecyclerView)myView.findViewById(R.id.recycler_view);

        persoAdapter = new PersoAdapter(coupleList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity().getBaseContext());


        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        // RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(myView.getContext(), LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(persoAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this.getActivity().getBaseContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Couple couple = coupleList.get(position);
                DialogFragment dialog = new FragmentPopup();
                dialog.show(getFragmentManager(), couple.getTag()+" 1 " + couple.getTag() + " " + couple.getLibelle());
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareCoupleData();

        return myView;
    }

    private void prepareCoupleData() {
        couple = new Couple("nom: ", perso.getNom(), MaBaseSQLite.COL_NOM);
        coupleList.add(couple);
        couple = new Couple("classe: ", perso.getClasse(), MaBaseSQLite.COL_CLASSE);
        coupleList.add(couple);
        couple = new Couple("race: ", perso.getRace(), MaBaseSQLite.COL_RACE);
        coupleList.add(couple);
        couple = new Couple("description: ", perso.getDescription(), MaBaseSQLite.COL_DESCRIPTION);
        coupleList.add(couple);
        couple = new Couple("inventaire: ", perso.getInventaire(), MaBaseSQLite.COL_INVENTAIRE);
        coupleList.add(couple);
        couple = new Couple("note personnelle: ", perso.getNotePerso(), MaBaseSQLite.COL_NOTEPERSO);
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