package procorp.applijdr.database;

/**
 * Created by benja on 15/12/2017.
 */

public class Rang {

    private int idVoie;
    private int idRang;
    private String nomRang;
    private String libRang;
    private int niveauRang;


    public Rang(){}

    public Rang(int idVoie, int idRang, String nomRang, String libRang, int niveauRang){
        this.idVoie = idVoie;
        this.idRang = idRang;
        this.nomRang = nomRang;
        this.libRang = libRang;
        this.niveauRang = niveauRang;
    }

    public int getIdVoie() {
        return idVoie;
    }

    public int getIdRang() {
        return idRang;
    }

    public String getNomRang() {
        return nomRang;
    }

    public String getLibRang() {
        return libRang;
    }

    public int getNiveauRang() {
        return niveauRang;
    }

    public void setIdVoie(int idVoie) {
        this.idVoie = idVoie;
    }

    public void setIdRang(int idRang) {
        this.idRang = idRang;
    }

    public void setNomRang(String nomRang) {
        this.nomRang = nomRang;
    }

    public void setLibRang(String libRang) {
        this.libRang = libRang;
    }

    public void setNiveauRang(int niveauRang) {
        this.niveauRang = niveauRang;
    }

    @Override
    public String toString() {
        return "Rang{" +
                "idVoie=" + idVoie +
                ", idRang=" + idRang +
                ", nomRang='" + nomRang + '\'' +
                ", libRang='" + libRang + '\'' +
                ", niveauRang=" + niveauRang +
                '}';
    }
}
