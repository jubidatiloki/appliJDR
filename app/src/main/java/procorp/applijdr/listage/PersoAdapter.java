package procorp.applijdr.listage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import procorp.applijdr.R;

/**
 * Created by benja on 15/12/2017.
 */

public class PersoAdapter extends RecyclerView.Adapter<PersoAdapter.MyViewHolder> {

    private List<Couple> couplesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, libelle;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            libelle = (TextView) view.findViewById(R.id.libelle);
        }
    }


    public PersoAdapter(List<Couple> couplesList) {
        this.couplesList = couplesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_perso1, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Couple couple = couplesList.get(position);
        holder.title.setText(couple.getLabel());
        holder.libelle.setText(couple.getLibelle());
    }

    @Override
    public int getItemCount() {
        return couplesList.size();
    }
}
