package procorp.applijdr.listage;

/**
 * Created by benja on 15/12/2017.
 */

public class Couple {

    private String label;
    private String libelle;
    private String tag;


    public Couple(){}

    public Couple(String label, String libelle, String tag){
        this.label = label;
        this.libelle = libelle;
        this.tag = tag;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public String getTag() { return this.tag; }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setTag(String tag) { this.tag = tag; }

    @Override
    public String toString() {
        return "Couple{" +
                "label='" + label + '\'' +
                ", libelle='" + libelle + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
