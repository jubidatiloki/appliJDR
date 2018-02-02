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

        values.put(COL_NOMVOIE, voie.getNomVoie());

        return bdd.insert(TABLE_VOIE, null, values);
    }



    public int updateVoie(Voie voie){
        ContentValues values = new ContentValues();
        values.put(COL_IDVOIE, voie.getIdVoie());
        values.put(COL_NOMVOIE, voie.getNomVoie());
        return bdd.update(TABLE_VOIE, values, COL_IDVOIE + " = " + voie.getIdVoie(), null);
    }



    public int removeVoieWithID(int id){
        //Suppression d'une commande de la BDD grâce à l'ID
        return bdd.delete(TABLE_VOIE, COL_IDVOIE + " = " +id, null);
    }


    public Voie cursorToVoie(Cursor c){
        if(c.getCount() == 0)
            return null;

        c.moveToFirst();
        Voie voie = new Voie();
        voie.setIdVoie(c.getInt(NUM_COL_IDVOIE));
        voie.setNomVoie(c.getString(NUM_COL_NOMVOIE));
        c.close();

        return voie;
    }

    public int nbreVoie(){
        Cursor curseur = bdd.query(TABLE_VOIE, null, null, null, null, null, null);
        //Renvoyer le nombre de lignes
        return curseur.getCount();
    }

    public Voie getVoieByNom(String nom){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_VOIE, new String[] {COL_IDVOIE, COL_NOMVOIE}, COL_NOMVOIE + " LIKE \"" + nom +"\"", null, null, null, null);
        return cursorToVoie(c);
    }

    public Voie getVoieById(int id){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_VOIE, new String[] {COL_IDVOIE, COL_NOMVOIE}, COL_IDVOIE + " LIKE \"" + id +"\"", null, null, null, null);
        return cursorToVoie(c);
    }

}
