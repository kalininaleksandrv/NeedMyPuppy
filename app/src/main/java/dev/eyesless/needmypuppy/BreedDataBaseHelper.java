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

    public BreedDataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE BREEDS("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "TITLE TEXT, "
                + "DESCRIPTION TEXT, "
                + "IMAGE_RESOURCE_ID INTEGER, "
                + "SIZE INTEGER, "
                + "FAVOR NUMERIC, "
                + "COMMENT TEXT);");

        incertBreedsToDb (db,
                "Сибирский Хаски",
                "Хаски - средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
                R.drawable.haski_1_1);
        incertBreedsToDb (db,
                "Лабрадор-ретривер",
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

    }

    private void incertBreedsToDb(SQLiteDatabase db, String name, String description, int resourceId) {

        ContentValues con_breed = new ContentValues();
        con_breed.put ("TITLE", name);
        con_breed.put ("DESCRIPTION", description);
        con_breed.put ("IMAGE_RESOURCE_ID", resourceId);

        db.insert("BREEDS", null, con_breed);

    }
}
