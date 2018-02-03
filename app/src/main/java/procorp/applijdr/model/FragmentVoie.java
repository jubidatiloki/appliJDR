package procorp.applijdr.model;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
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

import procorp.applijdr.Couple;
import procorp.applijdr.FragmentPopupPerso;
import procorp.applijdr.FragmentPopupRemove;
import procorp.applijdr.FragmentPopupVoie;
import procorp.applijdr.R;
import procorp.applijdr.database.PersoManager;
import procorp.applijdr.database.VoieManager;
import procorp.applijdr.listage.PersoAdapter;
import procorp.applijdr.listage.RecyclerTouchListener;
import procorp.applijdr.listage.VoieAdapter;

/**
 * Created by benja on 02/02/2018.
 */

public class FragmentVoie extends Fragment {

    View myView;
    private VoieManager voieManager;
    private List<Couple> coupleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private VoieAdapter voieAdapter;
    private Couple couple;
    public final static String EXTRA_MESSAGE = "procorp.applijdr.model.MESSAGE";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.layout_voie, container, false);

        voieManager = new VoieManager(myView.getContext());
        voieManager.open();


        recyclerView = myView.findViewById(R.id.recycler_view);

        voieAdapter = new VoieAdapter(coupleList);

        recyclerView.setHasFixedSize(true);

        // vertical RecyclerView
        // keep movie_list_row.xml width to `match_parent`
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this.getActivity().getBaseContext());


        // horizontal RecyclerView
        // keep movie_list_row.xml width to `wrap_content`
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(mLayoutManager);

        // adding inbuilt divider line
        recyclerView.addItemDecoration(new DividerItemDecoration(myView.getContext(), LinearLayoutManager.VERTICAL));

        // adding custom divider line with padding 16dp
        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        prepareCoupleData();

        recyclerView.setAdapter(voieAdapter);

        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this.getActivity().getBaseContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Couple couple = coupleList.get(position);
                DialogFragment dialog = new FragmentPopupVoie();
                dialog.show(getFragmentManager(), couple.getLabel() + ";" + couple.getLibelle() + ";" + couple.getTag());

                /*
                Intent i1 = new Intent(myView.getContext(), FragmentPerso.class );
                i1.putExtra(EXTRA_MESSAGE, couple.getTag());
                startActivityForResult(i1, 0);
                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                getActivity().recreate();*/
            }

            @Override
            public void onLongClick(View view, int position) {
                Couple couple = coupleList.get(position);
                if(!couple.getTag().equals("tag")) {
                    //Toast.makeText(myView.getContext(), persoManager.getPersoById(Integer.parseInt(couple.getTag())).toString(), Toast.LENGTH_SHORT).show();
                    DialogFragment dialog = new FragmentPopupRemove();
                    dialog.show(getFragmentManager(), "voie;" + couple.getLibelle());
                }
            }
        }));



        return myView;
    }

    private void prepareCoupleData() {

        if (voieManager.nbreVoie() != 0) {
            Cursor c = voieManager.getAllVoie();
            c.moveToFirst();
            for(int i=0; i<voieManager.getAllVoie().getCount(); i++){
                //Toast.makeText(myView.getContext(), "taille: "+c.getCount(), Toast.LENGTH_SHORT).show();
                int n = c.getInt(0);
                //Toast.makeText(myView.getContext(), "i: "+ i+ ", n: "+n, Toast.LENGTH_SHORT).show();
                couple = new Couple(voieManager.getVoieById(n).getNomVoie(), Integer.toString(voieManager.getVoieById(n).getIdVoie()) ,Integer.toString(n));
                coupleList.add(couple);
                c.moveToNext();
            }
        }
        couple = new Couple("Ajouter une voie", null, "tag");
        coupleList.add(couple);
        // notify adapter about data set changes
        // so that it will render the list with new data
        voieAdapter.notifyDataSetChanged();
    }

}

