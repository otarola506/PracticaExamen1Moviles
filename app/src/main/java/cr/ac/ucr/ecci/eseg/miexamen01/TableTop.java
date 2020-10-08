package cr.ac.ucr.ecci.eseg.miexamen01;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
// Clase TableTop que tiene los atributos respectivos de la clase e implementa TableTop.
public class TableTop implements Parcelable {
    private String id;
    private String name;
    private int year;
    private String publisher;
    private String country;
    private double latitude;
    private double longitude;
    private String description;
    private String numPlayers;
    private String ages;
    private String playingTime;

    public TableTop () {}

    public TableTop(String id, String name, int year, String publisher, String country, double latitude, double longitude, String description, String numPlayers, String ages, String playingTime) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.publisher = publisher;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.numPlayers = numPlayers;
        this.ages = ages;
        this.playingTime = playingTime;
    }

    protected TableTop(Parcel in) {
        id = in.readString();
        name = in.readString();
        year = in.readInt();
        publisher = in.readString();
        country = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        description = in.readString();
        numPlayers = in.readString();
        ages = in.readString();
        playingTime = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeInt(year);
        dest.writeString(publisher);
        dest.writeString(country);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(description);
        dest.writeString(numPlayers);
        dest.writeString(ages);
        dest.writeString(playingTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TableTop> CREATOR = new Creator<TableTop>() {
        @Override
        public TableTop createFromParcel(Parcel in) {
            return new TableTop(in);
        }

        @Override
        public TableTop[] newArray(int size) {
            return new TableTop[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(String numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(String playingTime) {
        this.playingTime = playingTime;
    }

    public void insertar( Context context){
        // usar la clase DataBaseHelper para realizar la operacion de insertar
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo escritura
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        // Crear un mapa de valores donde las columnas son las llaves
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.DataBaseEntry._ID, getId());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_NAME, getName());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_YEAR, getYear());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER, getPublisher());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY, getCountry());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_LATITUDE, getLatitude());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_LONGITUDE, getLongitude());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION, getDescription());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_NUM_PLAYERS, getNumPlayers());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_AGES, getAges());
        values.put(DatabaseContract.DataBaseEntry.COLUMN_NAME_PLAYING_TIME, getPlayingTime());

        // Insertar la nueva fila
         db.insert(DatabaseContract.DataBaseEntry.TABLE_NAME_TABLE_TOP, null,
                values);
    }

    public List<TableTop> consultar(Context context){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(context);
        // Obtiene la base de datos en modo lectura
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        // Define cuales columnas quiere solicitar
        // en este caso todas las de la clase
        String[] projection = {
                DatabaseContract.DataBaseEntry._ID,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_NAME,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_YEAR,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_LATITUDE,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_LONGITUDE,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_NUM_PLAYERS,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_AGES,
                DatabaseContract.DataBaseEntry.COLUMN_NAME_PLAYING_TIME

        };

        // Resultados en el cursor
        Cursor cursor = db.query(DatabaseContract.DataBaseEntry.TABLE_NAME_TABLE_TOP, //Tabla
                projection, // columnas
                null, // where
                null, // valores del where
                null, // agrupamiento
                null, // filtros por grupo
                null // orden
        );

        return convertirCursorALista(cursor);



    }
    public List<TableTop> convertirCursorALista(Cursor cursor){
        int iId = cursor.getColumnIndex(DatabaseContract.DataBaseEntry._ID);
        int iName = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_NAME);
        int iYear = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_YEAR);
        int iPublisher = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_PUBLISHER);
        int iCountry = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_COUNTRY);
        int iLatitude = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_LATITUDE);
        int iLongitude = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_LONGITUDE);
        int iDescription = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_DESCRIPTION);
        int iNumPlayers = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_NUM_PLAYERS);
        int iAges =  cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_AGES);
        int iPlayingTime = cursor.getColumnIndex(DatabaseContract.DataBaseEntry.COLUMN_NAME_PLAYING_TIME);

        List<TableTop> listaDatos = new ArrayList<>();
        while (cursor.moveToNext()){
            String Id =  cursor.getString(iId);
            String name = cursor.getString(iName);
            int year = cursor.getInt(iYear);
            String publisher = cursor.getString(iPublisher);
            String country = cursor.getString(iCountry);
            double latitude = cursor.getDouble(iLatitude);
            double longitude = cursor.getDouble(iLongitude);
            String description = cursor.getString(iDescription);
            String numPlayers = cursor.getString(iNumPlayers);
            String ages = cursor.getString(iAges);
            String playingTime = cursor.getString(iPlayingTime);

            listaDatos.add(new TableTop(Id,name,year,publisher,country,latitude,longitude,description,numPlayers,ages,playingTime));

        }
        return listaDatos;

    }



}
