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
                "средняя по размеру, с энергичным характером",
                R.drawable.b_husky, 3);
        incertBreedsToDb (db,
                "Лабрадор - ретривер",
                "средняя по размеру, подвижная, веселая",
                R.drawable.b_labrador, 3);
        incertBreedsToDb (db,
                "Hемецкая овчарка",
                "крупная по размеру служебная собака",
                R.drawable.b_germshep, 4);
        incertBreedsToDb (db,
                "Bельш корги Пемброк",
                "миниатюрная пастушья собака, дружелюбная",
                R.drawable.b_welsh_pembrok, 2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);

    }

    public void incertBreedsToDb(SQLiteDatabase db, String name, String description, int resourceId, int size) {

        ContentValues con_breed = new ContentValues();
        con_breed.put (KEY_TITLE, name);
        con_breed.put (KEY_DECRIPTION, description);
        con_breed.put (KEY_IMAGE_RES_ID, resourceId);
        con_breed.put (KEY_SIZE, size);

        db.insert(TABLE_NAME, null, con_breed);

    }
}
