package procorp.applijdr.database;

/**
 * Created by benja on 31/01/2018.
 */

public class RegroupeVoie {

    private int idPerso;
    private int idVoie;
    private int niveauRang;

    public RegroupeVoie(){}

    public RegroupeVoie(int idPerso, int idVoie, int niveauRang) {
        this.idPerso = idPerso;
        this.idVoie = idVoie;
        this.niveauRang = niveauRang;
    }

    public int getIdPerso() {
        return idPerso;
    }

    public void setIdPerso(int idPerso) {
        this.idPerso = idPerso;
    }

    public int getIdVoie() {
        return idVoie;
    }

    public void setIdVoie(int idVoie) {
        this.idVoie = idVoie;
    }

    public int getNiveauRang() {
        return niveauRang;
    }

    public void setNiveauRang(int niveauRang) {
        this.niveauRang = niveauRang;
    }

    @Override
    public String toString() {
        return "RegroupeVoie{" +
                "idPerso=" + idPerso +
                ", idVoie=" + idVoie +
                ", niveauRang=" + niveauRang +
                '}';
    }
}
