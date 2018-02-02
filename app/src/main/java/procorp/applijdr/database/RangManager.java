package procorp.applijdr.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by benja on 15/12/2017.
 */

public class RangManager {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "rang.db";

    private static final String TABLE_RANG = "table_rang";

    private static final String COL_IDRANG = "idRang";
    public static final int NUM_COL_IDRANG = 0;

    private static final String COL_NOMRANG = "nomRang";
    public static final int NUM_COL_NOMRANG = 1;

    private static final String COL_LIBRANG = "libRang";
    public static final int NUM_COL_LIBRANG = 2;

    private static final String COL_NIVEAU_RANG = "niveauRang";
    public static final int NUM_COL_NIVEAU_RANG = 3;

    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;


    public RangManager(Context context){
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public long insertRang(Rang rang) {
        ContentValues values = new ContentValues();

        values.put(COL_NOMRANG, rang.getNomRang());
        values.put(COL_LIBRANG, rang.getLibRang());
        values.put(COL_NIVEAU_RANG, rang.getNiveauRang());

        return bdd.insert(TABLE_RANG, null, values);
    }



    public int updateRang(Rang rang){
        ContentValues values = new ContentValues();
        values.put(COL_IDRANG, rang.getIdRang());
        values.put(COL_LIBRANG, rang.getLibRang());
        values.put(COL_NIVEAU_RANG, rang.getNiveauRang());
        return bdd.update(TABLE_RANG, values, COL_IDRANG + " = " + rang.getIdRang(), null);
    }



    public int removeRangWithID(int id){
        //Suppression d'une commande de la BDD grâce à l'ID
        return bdd.delete(TABLE_RANG, COL_IDRANG + " = " +id, null);
    }


    public Rang cursorToRang(Cursor c){
        if(c.getCount() == 0)
            return null;

        c.moveToFirst();
        Rang rang = new Rang();
        rang.setIdRang(c.getInt(NUM_COL_IDRANG));
        rang.setNomRang(c.getString(NUM_COL_NOMRANG));
        rang.setNiveauRang(c.getInt(NUM_COL_NIVEAU_RANG));
        c.close();

        return rang;
    }

    public int nbreRang(){
        Cursor curseur = bdd.query(TABLE_RANG, null, null, null, null, null, null);
        //Renvoyer le nombre de lignes
        return curseur.getCount();
    }

    public Rang getRangByNom(String nom){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_RANG, new String[] {COL_IDRANG, COL_NOMRANG, COL_NIVEAU_RANG}, COL_NOMRANG + " LIKE \"" + nom +"\"", null, null, null, null);
        return cursorToRang(c);
    }

    public Rang getRangById(int id){
        //Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TABLE_RANG, new String[] {COL_IDRANG, COL_NOMRANG, COL_NIVEAU_RANG}, COL_IDRANG + " LIKE \"" + id +"\"", null, null, null, null);
        return cursorToRang(c);
    }
}
