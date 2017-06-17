package dev.eyesless.needmypuppy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Eyesless on 10.06.2017.
 */

public class BreedDataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "breeds_base";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "breeds";
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DECRIPTION = "description";
    public static final String KEY_IMAGE_RES_ID = "image_resource_id";
    public static final String KEY_SIZE = "size";
    public static final String KEY_FAVOR = "favorite";
    public static final String KEY_COMMENT = "comment";

    public BreedDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(" + KEY_ID
                + " integer primary key autoincrement,"
                + KEY_TITLE + " text,"
                + KEY_DECRIPTION + " text,"
                + KEY_IMAGE_RES_ID + " integer,"
                + KEY_SIZE + " integer,"
                + KEY_FAVOR + " numeric,"
                + KEY_COMMENT + " text" + ")");

        incertBreedsToDb (db,
                "Сибирский Хаски",
                "Хаски - средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
                R.drawable.haski_1_1);
        incertBreedsToDb (db,
                "Лабрадор - ретривер",
                "Лабрадор - средняя по размеру служебная собака, подвижная, веселая и прекрано ладящая с людьми",
                R.drawable.labr_1_1);
        incertBreedsToDb (db,
                "Hемецкая овчарка",
                "Немецкая овчарка - средняя по размеру служебная собака с уравновешенным, подвижным типом поведения, способная к разнообразной дрессировке",
                R.drawable.germshep_1_1);
        incertBreedsToDb (db,
                "Bельш корги",
                "миниатюрная пастушья собака с веселым и дружелюбным харакером",
                R.drawable.velsh_1_1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);

    }

    public void incertBreedsToDb(SQLiteDatabase db, String name, String description, int resourceId) {

        ContentValues con_breed = new ContentValues();
        con_breed.put (KEY_TITLE, name);
        con_breed.put (KEY_DECRIPTION, description);
        con_breed.put (KEY_IMAGE_RES_ID, resourceId);

        db.insert(TABLE_NAME, null, con_breed);

    }
}
