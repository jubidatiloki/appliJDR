package procorp.applijdr.database;

import procorp.applijdr.Constante;

/**
 * Created by benja on 23/11/2017.
 */

public class Perso {

    private int idPerso;
    private String nom;
    private String classe;
    private String race;
    private int pvMax;
    private int pv;
    private String description;
    private String inventaire;
    private String notePerso;
    private int niveau;
    private int defense;
    private int initiative;
    private int FOR;
    private int DEX;
    private int CON;
    private int INT;
    private int SAG;
    private int CHA;


    public Perso(){
        this.nom = Constante.NOM_DEFAUT;
        this.classe = Constante.CLASSE_DEFAUT;
        this.race = Constante.RACE_DEFAUT;
        this.pvMax = Constante.PV_DEFAUT;
        this.pv = Constante.PV_DEFAUT;
        this.description = Constante.DESCRIPTION_DEFAUT;
        this.inventaire = Constante.INVENTAIRE_DEFAUT;
        this.notePerso = Constante.NOTEPERSO_DEFAUT;
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

    public Perso(int idPerso){
        this.idPerso = idPerso;
        this.nom = Constante.NOM_DEFAUT;
        this.classe = Constante.CLASSE_DEFAUT;
        this.race = Constante.RACE_DEFAUT;
        this.pvMax = Constante.PV_DEFAUT;
        this.pv = Constante.PV_DEFAUT;
        this.description = Constante.DESCRIPTION_DEFAUT;
        this.inventaire = Constante.INVENTAIRE_DEFAUT;
        this.notePerso = Constante.NOTEPERSO_DEFAUT;
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

    public Perso(int idPerso, String nom, String classe, String race, int pv, String description, String inventaire, String notePerso, int niveau, int defense, int initiative, int FOR, int DEX, int CON, int INT, int SAG, int CHA) {
        this.idPerso = idPerso;
        this.nom = nom;
        this.classe = classe;
        this.race = race;
        this.pvMax = pv;
        this.pv = pv;
        this.description = description;
        this.inventaire = inventaire;
        this.notePerso = notePerso;
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
        return this.idPerso;
    }

    public String getNom() {
        return this.nom;
    }

    public String getClasse() {
        return this.classe;
    }

    public String getRace() {
        return this.race;
    }

    public int getPvMax() { return this.pvMax; }

    public int getPv() { return this.pv; }

    public String getDescription() {
        return this.description;
    }

    public String getInventaire() {
        return this.inventaire;
    }

    public String getNotePerso() {
        return this.notePerso;
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
        this.idPerso = idPerso;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setPvMax(int pvMax) { this.pvMax = pvMax; }

    public void setPv(int pv){ this.pv = pv; }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInventaire(String inventaire) {
        this.inventaire = inventaire;
    }

    public void setNotePerso(String notePerso) {
        this.notePerso = notePerso;
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
                "idPerso=" + idPerso +
                ", nom='" + nom + '\'' +
                ", classe='" + classe + '\'' +
                ", race='" + race + '\'' +
                ", pvMax='" + pvMax + '\'' +
                ", pv='" + pv + '\'' +
                ", description='" + description + '\'' +
                ", inventaire='" + inventaire + '\'' +
                ", notePerso='" + notePerso + '\'' +
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
