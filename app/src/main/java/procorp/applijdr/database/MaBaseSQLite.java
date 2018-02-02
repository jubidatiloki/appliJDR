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
    private static final String TABLE_VOIE = "table_voie";
    public static final String COL_IDVOIE = "idVoie";
    public static final String COL_NOMVOIE = "nomVoie";

    //rang
    private static final String TABLE_RANG = "table_rang";
    public static final String COL_IDRANG = "idRang";
    public static final String COL_NOMRANG = "nomRang";
    public static final String COL_LIBRANG = "libRang";
    public static final String COL_NIVEAU_RANG = "niveauRang";

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

    private static final String CREATE_TABLE_VOIE = "CREATE TABLE " + TABLE_VOIE + " ( "
            + COL_IDVOIE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOMVOIE + " TEXT );";

    private static final String CREATE_TABLE_RANG = "CREATE TABLE " + TABLE_RANG + " ( "
            + COL_IDRANG + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOMRANG + " TEXT, "
            + COL_LIBRANG + " TEXT, "
            + COL_NIVEAU_RANG + " INTEGER );";


    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_TABLE_PERSO);
        db.execSQL(CREATE_TABLE_VOIE);
        db.execSQL(CREATE_TABLE_RANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0
        db.execSQL("DROP TABLE " + TABLE_PERSO + ";");
        db.execSQL("DROP TABLE " + TABLE_VOIE + ";");
        db.execSQL("DROP TABLE " + TABLE_RANG + ";");
        onCreate(db);
    }
}
