package procorp.applijdr.database;

import procorp.applijdr.Constante;

/**
 * Created by benja on 15/12/2017.
 */

public class Voie {

    private int idVoie;
    private String nomVoie;

    public Voie(){
        this.nomVoie = Constante.NOM_VOIE_DEFAUT;
    }

    public Voie(int idVoie, String nomVoie) {
        this.idVoie = idVoie;
        this.nomVoie = nomVoie;
    }

    public int getIdVoie() {
        return idVoie;
    }

    public void setIdVoie(int idVoie) {
        this.idVoie = idVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    @Override
    public String toString() {
        return "Voie{" +
                "idVoie=" + idVoie +
                ", nomVoie='" + nomVoie + '\'' +
                '}';
    }
}
