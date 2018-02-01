package procorp.applijdr.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by benja on 23/11/2017.
 */

public class MaBaseSQLite extends SQLiteOpenHelper {

    //perso
    private static final String TABLE_PERSO = "table_perso";
    public static final String COL_IDPERSO = "idPerso";
    public static final String COL_NOM = "nom";
    public static final String COL_CLASSE = "classe";
    public static final String COL_RACE = "race";
    public static final String COL_PVMAX = "pvMax";
    public static final String COL_PV = "pv";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_INVENTAIRE = "inventaire";
    public static final String COL_NOTEPERSO = "notePerso";
    public static final String COL_NIVEAU = "niveau";
    public static final String COL_DEFENSE = "defense";
    public static final String COL_INITIATIVE = "initiative";
    public static final String COL_FOR = "FOR";
    public static final String COL_DEX = "DEX";
    public static final String COL_CON = "CON";
    public static final String COL_INT = "INT";
    public static final String COL_SAG = "SAG";
    public static final String COL_CHA = "CHA";

    //voie

    //rang

    private static final String CREATE_TABLE_PERSO = "CREATE TABLE " + TABLE_PERSO + " ( "
            + COL_IDPERSO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM + " TEXT, "
            + COL_CLASSE + " TEXT, "
            + COL_RACE + " TEXT, "
            + COL_PVMAX + " INTEGER, "
            + COL_PV + " INTEGER, "
            + COL_DESCRIPTION + " TEXT, "
            + COL_INVENTAIRE + " TEXT, "
            + COL_NOTEPERSO + " TEXT, "
            + COL_NIVEAU + " INTEGER, "
            + COL_DEFENSE + " INTEGER, "
            + COL_INITIATIVE + " INTEGER, "
            + COL_FOR + " INTEGER, "
            + COL_DEX + " INTEGER, "
            + COL_CON + " INTEGER, "
            + COL_INT + " INTEGER, "
            + COL_SAG + " INTEGER, "
            + COL_CHA + " INTEGER );";


    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_PERSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0

        db.execSQL("DROP TABLE " + TABLE_PERSO + ";");
        onCreate(db);
    }
}
