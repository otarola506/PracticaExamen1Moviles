package cr.ac.ucr.ecci.eseg.miexamen01;
import android.provider.BaseColumns;

public class DatabaseContract {

    private DatabaseContract() {}

    public static class DataBaseEntry implements BaseColumns {
        // Clase TableTop
        public static final String TABLE_NAME_TABLE_TOP = "TableTop";
        // PRIMARY KEY de cada una de las filas definimos que el ID de la fila sea DataBaseEntry._ID ; Utilizamos DataBaseEntry._ID de BaseColumns

        public static final String COLUMN_NAME_NAME = "name";

        public static final String COLUMN_NAME_YEAR = "year";

        public static final String COLUMN_NAME_PUBLISHER = "publisher";

        public static final String COLUMN_NAME_COUNTRY = "country";

        public static final String COLUMN_NAME_LATITUDE = "latitude";

        public static final String COLUMN_NAME_LONGITUDE = "longitude";

        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String COLUMN_NAME_NUM_PLAYERS = "numPlayers";

        public static final String COLUMN_NAME_AGES = "ages";

        public static final String COLUMN_NAME_PLAYING_TIME = "playingTime";

    }

    // Tipos de dato para mapeo entre SQL y Java
    private static final String TEXT_TYPE = " TEXT ";
    private static final String INTEGER_TYPE = " INTEGER ";
    private static final String REAL_TYPE = " REAL ";
    private static final String COMMA_SEP = ",";

    // Creación de comandos SQL

    public static final String SQL_CREATE_TABLE_TOP =
            "CREATE TABLE " + DataBaseEntry.TABLE_NAME_TABLE_TOP + " (" +
                    DataBaseEntry._ID + TEXT_TYPE + "PRIMARY KEY," +
                    DataBaseEntry.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_YEAR + INTEGER_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_PUBLISHER + TEXT_TYPE +
                    COMMA_SEP + DataBaseEntry.COLUMN_NAME_COUNTRY + TEXT_TYPE +
                    COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_LATITUDE + REAL_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_LONGITUDE + REAL_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE +
                    COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_NUM_PLAYERS + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_AGES + TEXT_TYPE + COMMA_SEP +
                    DataBaseEntry.COLUMN_NAME_PLAYING_TIME + TEXT_TYPE + " )";

    public static final String SQL_DELETE_TABLE_TOP =
            "DROP TABLE IF EXISTS " + DataBaseEntry.TABLE_NAME_TABLE_TOP;



}
