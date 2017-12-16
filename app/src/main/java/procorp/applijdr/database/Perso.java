package procorp.applijdr.database;

import procorp.applijdr.Constante;

/**
 * Created by benja on 23/11/2017.
 */

public class Perso {

    private int IdPerso;
    private String Nom;
    private String Classe;
    private String Race;
    private String Description;
    private String Inventaire;
    private String NotePerso;
    private int niveau;
    private int defense;
    private int initiative;
    private int FOR;
    private int DEX;
    private int CON;
    private int INT;
    private int SAG;
    private int CHA;

    public Perso(){}

    public Perso(int idPerso){
        IdPerso = idPerso;
        Nom = Constante.NOM_DEFAUT;
        Classe = Constante.CLASSE_DEFAUT;
        Race = Constante.RACE_DEFAUT;
        Description = Constante.DESCRIPTION_DEFAUT;
        Inventaire = Constante.INVENTAIRE_DEFAUT;
        NotePerso = Constante.NOTEPERSO_DEFAUT;
        this.niveau = Constante.NIVEAU_DEFAUT;
        this.defense = Constante.DEFENSE_DEFAUT;
        this.initiative = Constante.INITIATIVE_DEFAUT;
        this.FOR = Constante.STAT_DEFAUT;
        this.DEX = Constante.STAT_DEFAUT;
        this.CON = Constante.STAT_DEFAUT;
        this.INT = Constante.STAT_DEFAUT;
        this.SAG = Constante.STAT_DEFAUT;
        this.CHA = Constante.STAT_DEFAUT;
    }

    public Perso(int idPerso, String nom, String classe, String race, String description, String inventaire, String notePerso, int niveau, int defense, int initiative, int FOR, int DEX, int CON, int INT, int SAG, int CHA) {
        IdPerso = idPerso;
        Nom = nom;
        Classe = classe;
        Race = race;
        Description = description;
        Inventaire = inventaire;
        NotePerso = notePerso;
        this.niveau = niveau;
        this.defense = defense;
        this.initiative = initiative;
        this.FOR = FOR;
        this.DEX = DEX;
        this.CON = CON;
        this.INT = INT;
        this.SAG = SAG;
        this.CHA = CHA;
    }

    public int getIdPerso() {
        return this.IdPerso;
    }

    public String getNom() {
        return this.Nom;
    }

    public String getClasse() {
        return this.Classe;
    }

    public String getRace() {
        return this.Race;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getInventaire() {
        return this.Inventaire;
    }

    public String getNotePerso() {
        return this.NotePerso;
    }

    public int getNiveau() {
        return this.niveau;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getInitiative() {
        return this.initiative;
    }

    public int getFOR() {
        return this.FOR;
    }

    public int getDEX() {
        return this.DEX;
    }

    public int getCON() {
        return this.CON;
    }

    public int getINT() {
        return this.INT;
    }

    public int getSAG() {
        return this.SAG;
    }

    public int getCHA() {
        return this.CHA;
    }

    public void setIdPerso(int idPerso) {
        IdPerso = idPerso;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setClasse(String classe) {
        Classe = classe;
    }

    public void setRace(String race) {
        Race = race;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setInventaire(String inventaire) {
        Inventaire = inventaire;
    }

    public void setNotePerso(String notePerso) {
        NotePerso = notePerso;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public void setFOR(int FOR) {
        this.FOR = FOR;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public void setSAG(int SAG) {
        this.SAG = SAG;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
    }


    @Override
    public String toString() {
        return "Perso{" +
                "IdPerso=" + IdPerso +
                ", Nom='" + Nom + '\'' +
                ", Classe='" + Classe + '\'' +
                ", Race='" + Race + '\'' +
                ", Description='" + Description + '\'' +
                ", Inventaire='" + Inventaire + '\'' +
                ", NotePerso='" + NotePerso + '\'' +
                ", niveau=" + niveau +
                ", defense=" + defense +
                ", initiative=" + initiative +
                ", FOR=" + FOR +
                ", DEX=" + DEX +
                ", CON=" + CON +
                ", INT=" + INT +
                ", SAG=" + SAG +
                ", CHA=" + CHA +
                '}';
    }
}
