package cr.ac.ucr.ecci.eseg.miexamen01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Clase que permite crear la base de datos
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    // Nombre de la base de datos
    public static final String DATABASE_NAME = "BoardGames.db";

    // constructor de la clase, el contexto tiene la informacion global sobre el ambiente de la app
    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // implementamos el metodo para la creacion de la base de datos
    public void onCreate(SQLiteDatabase db) {
        // Crear la base de datos de la app
        db.execSQL(DatabaseContract.SQL_CREATE_TABLE_TOP);
    }

    // implementamos el metodo para la actualizacion de la base de datos
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Administracion de actualizaciones
        db.execSQL(DatabaseContract.SQL_DELETE_TABLE_TOP);

        onCreate(db);
    }

    // inplementamos el metodo para volver a la version anterior de la base de datos
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
