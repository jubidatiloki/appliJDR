package procorp.applijdr.database;

import procorp.applijdr.Constante;

/**
 * Created by benja on 15/12/2017.
 */

public class Rang {

    private int idRang;
    private String nomRang;
    private String libRang;
    private int niveauRang;


    public Rang(){
        this.nomRang = Constante.NOM_RANG_DEFAUT;
        this.libRang = Constante.LIB_RANG_DEFAUT;
        this.niveauRang = Constante.NIVEAU_RANG_DEFAUT;
    }

    public Rang(int idRang, String nomRang, String libRang, int niveauRang){
        this.idRang = idRang;
        this.nomRang = nomRang;
        this.libRang = libRang;
        this.niveauRang = niveauRang;
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
                ", idRang=" + idRang +
                ", nomRang='" + nomRang + '\'' +
                ", libRang='" + libRang + '\'' +
                ", niveauRang=" + niveauRang +
                '}';
    }
}
