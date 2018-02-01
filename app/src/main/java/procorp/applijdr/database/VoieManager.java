package procorp.applijdr.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by benja on 15/12/2017.
 */

public class VoieManager {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "voie.db";

    private static final String TABLE_VOIE = "table_voie";

    private static final String COL_IDVOIE = "idVoie";
    public static final int NUM_COL_IDVOIE = 0;

    private static final String COL_NOMVOIE = "nomVoie";
    public static final int NUM_COL_NOMVOIE = 1;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;


    public VoieManager(Context context){
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public long insertVoie(Voie voie) {
        ContentValues values = new ContentValues();

        values.put(COL_IDVOIE, voie.getIdVoie());
        values.put(COL_NOMVOIE, voie.getNomVoie());

        return bdd.insert(TABLE_VOIE, null, values);
    }


    /*
    public int updatePerso(Perso perso){
        ContentValues values = new ContentValues();
        values.put(COL_IDPERSO, perso.getIdPerso());
        values.put(COL_NOM, perso.getNom());
        values.put(COL_CLASSE, perso.getClasse());
        values.put(COL_RACE, perso.getRace());
        values.put(COL_PVMAX, perso.getPvMax());
        values.put(COL_PV, perso.getPv());
        values.put(COL_DESCRIPTION, perso.getDescription());
        values.put(COL_INVENTAIRE, perso.getInventaire());
        values.put(COL_NOTEPERSO, perso.getNotePerso());
        values.put(COL_NIVEAU, perso.getNiveau());
        values.put(COL_DEFENSE, perso.getDefense());
        values.put(COL_INITIATIVE, perso.getInitiative());
        values.put(COL_FOR, perso.getFOR());
        values.put(COL_DEX, perso.getDEX());
        values.put(COL_CON, perso.getCON());
        values.put(COL_INT, perso.getINT());
        values.put(COL_SAG, perso.getSAG());
        values.put(COL_CHA, perso.getCHA());
        return bdd.update(TABLE_PERSO, values, COL_IDPERSO + " = " + perso.getIdPerso(), null);
    }

    public int UpdateByNomCol(Perso perso, String nomCol, String modif){
        ContentValues values = new ContentValues();
        values.put(COL_IDPERSO, perso.getIdPerso());
        values.put(COL_NOM, perso.getNom());
        values.put(COL_CLASSE, perso.getClasse());
        values.put(COL_RACE, perso.getRace());
        values.put(COL_PVMAX, perso.getPvMax());
        values.put(COL_PV, perso.getPv());
        values.put(COL_DESCRIPTION, perso.getDescription());
        values.put(COL_INVENTAIRE, perso.getInventaire());
        values.put(COL_NOTEPERSO, perso.getNotePerso());
        values.put(COL_NIVEAU, perso.getNiveau());
        values.put(COL_DEFENSE, perso.getDefense());
        values.put(COL_INITIATIVE, perso.getInitiative());
        values.put(COL_FOR, perso.getFOR());
        values.put(COL_DEX, perso.getDEX());
        values.put(COL_CON, perso.getCON());
        values.put(COL_INT, perso.getINT());
        values.put(COL_SAG, perso.getSAG());
        values.put(COL_CHA, perso.getCHA());
        values.put(nomCol, modif);
        return bdd.update(TABLE_PERSO, values, COL_IDPERSO + " = " + perso.getIdPerso(), null);
    }

    //inutile mais on sait jamais
    public int removePersoWithID(int id){
        //Suppression d'une commande de la BDD grâce à l'ID
        return bdd.delete(TABLE_PERSO, COL_IDPERSO + " = " +id, null);
    }


    public Perso cursorToPerso(Cursor c){
        if(c.getCount() == 0)
            return null;

        c.moveToFirst();
        Perso perso = new Perso();
        perso.setIdPerso(c.getInt(NUM_COL_IDPERSO));
        perso.setNom(c.getString(NUM_COL_NOM));
        perso.setClasse(c.getString(NUM_COL_CLASSE));
        perso.setRace(c.getString(NUM_COL_RACE));
        perso.setPvMax(c.getInt(NUM_COL_PVMAX));
        perso.setPv(c.getInt(NUM_COL_PV));
        perso.setDescription(c.getString(NUM_COL_DESCRIPTION));
        perso.setInventaire(c.getString(NUM_COL_INVENTAIRE));
        perso.setNotePerso(c.getString(NUM_COL_NOTEPERSO));
        perso.setNiveau(c.getInt(NUM_COL_NIVEAU));
        perso.setDefense(c.getInt(NUM_COL_DEFENSE));
        perso.setInitiative(c.getInt(NUM_COL_INITIATIVE));
        perso.setFOR(c.getInt(NUM_COL_FOR));
        perso.setDEX(c.getInt(NUM_COL_DEX));
        perso.setCON(c.getInt(NUM_COL_CON));
        perso.setINT(c.getInt(NUM_COL_INT));
        perso.setSAG(c.getInt(NUM_COL_SAG));
        perso.setCHA(c.getInt(NUM_COL_CHA));

        c.close();

        return perso;
    }

    public int nbrePerso(){
        Cursor curseur = bdd.query(TABLE_PERSO, null, null, null, null, null, null);
        //Renvoyer le nombre de lignes
        return curseur.getCount();
    }

    public Perso getPersoByNom(String nom){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_PERSO, new String[] {COL_IDPERSO, COL_NOM, COL_CLASSE, COL_RACE, COL_PVMAX, COL_PV, COL_DESCRIPTION, COL_INVENTAIRE, COL_NOTEPERSO, COL_NIVEAU, COL_DEFENSE, COL_INITIATIVE, COL_FOR, COL_DEX, COL_CON, COL_INT, COL_SAG, COL_CHA}, COL_NOM + " LIKE \"" + nom +"\"", null, null, null, null);
        return cursorToPerso(c);
    }

    public Perso getPersoById(int id){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_PERSO, new String[] {COL_IDPERSO, COL_NOM, COL_CLASSE, COL_RACE, COL_PVMAX, COL_PV, COL_DESCRIPTION, COL_INVENTAIRE, COL_NOTEPERSO, COL_NIVEAU, COL_DEFENSE, COL_INITIATIVE, COL_FOR, COL_DEX, COL_CON, COL_INT, COL_SAG, COL_CHA}, COL_IDPERSO + " LIKE \"" + id +"\"", null, null, null, null);
        return cursorToPerso(c);
    }*/

}
