package procorp.applijdr.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by benja on 23/11/2017.
 */

public class PersoManager {

    private static final int VERSION_BDD = 2;
    private static final String NOM_BDD = "perso.db";

    private static final String TABLE_PERSO = "table_perso";

    private static final String COL_IDPERSO = "idPerso";
    public static final int NUM_COL_IDPERSO = 0;

    private static final String COL_NOM = "nom";
    public static final int NUM_COL_NOM = 1;

    private static final String COL_CLASSE = "classe";
    public static final int NUM_COL_CLASSE = 2;

    private static final String COL_RACE = "race";
    public static final int NUM_COL_RACE = 3;

    private static final String COL_PVMAX = "pvMax";
    public static final int NUM_COL_PVMAX = 4;

    private static final String COL_PV = "pv";
    public static final int NUM_COL_PV = 5;

    private static final String COL_DESCRIPTION = "description";
    public static final int NUM_COL_DESCRIPTION = 6;

    private static final String COL_INVENTAIRE = "inventaire";
    public static final int NUM_COL_INVENTAIRE = 7;

    private static final String COL_NOTEPERSO = "notePerso";
    public static final int NUM_COL_NOTEPERSO = 8;

    private static final String COL_NIVEAU = "niveau";
    public static final int NUM_COL_NIVEAU = 9;

    private static final String COL_DEFENSE = "defense";
    public static final int NUM_COL_DEFENSE = 10;

    private static final String COL_INITIATIVE = "initiative";
    public static final int NUM_COL_INITIATIVE = 11;

    private static final String COL_FOR = "FOR";
    public static final int NUM_COL_FOR = 12;

    private static final String COL_DEX = "DEX";
    public static final int NUM_COL_DEX = 13;

    private static final String COL_CON = "CON";
    public static final int NUM_COL_CON = 14;

    private static final String COL_INT = "INT";
    public static final int NUM_COL_INT = 15;

    private static final String COL_SAG = "SAG";
    public static final int NUM_COL_SAG = 16;

    private static final String COL_CHA = "CHA";
    public static final int NUM_COL_CHA = 17;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;


    public PersoManager(Context context){
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public long insertPerso(Perso perso) {
        ContentValues values = new ContentValues();

        //values.put(COL_IDPERSO, perso.getIdPerso());
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

        return bdd.insert(TABLE_PERSO, null, values);
    }



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

    public void removePersoWithID(int id){
        //Suppression d'une commande de la BDD grâce à l'ID
        bdd.delete(TABLE_PERSO, COL_IDPERSO + " = " +id, null);
        String req = "UPDATE SQLITE_SEQUENCE SET SEQ=0 WHERE NAME='"+TABLE_PERSO+"';";
        bdd.execSQL(req);
    }



    /*
    public int reset(){
        Cursor cursor = bdd.rawQuery("select max("+COL_IDPERSO+") from "+TABLE_PERSO, new String[] {COL_IDPERSO});
        cursor.moveToFirst();
        int number = cursor.getInt(NUM_COL_IDPERSO);
        return number;
    }
*/

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
    }

    public Cursor getAllPerso(){
        Cursor c = bdd.query(TABLE_PERSO, new String[] {COL_IDPERSO, COL_NOM, COL_CLASSE, COL_RACE, COL_PVMAX, COL_PV, COL_DESCRIPTION, COL_INVENTAIRE, COL_NOTEPERSO, COL_NIVEAU, COL_DEFENSE, COL_INITIATIVE, COL_FOR, COL_DEX, COL_CON, COL_INT, COL_SAG, COL_CHA} , null, null, null, null, null );
        return c;
    }




}
