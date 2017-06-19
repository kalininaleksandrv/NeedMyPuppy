package dev.eyesless.needmypuppy;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Eyesless on 17.06.2017.
 */

public class BreedDataBaseCreator {

    private Context myContext;
    private InitiationActivity inact;

    public BreedDataBaseCreator(Context context, InitiationActivity inact) {

        this.myContext = context;
        this.inact = inact;

    }

    public void onCreateDb (){

            try {

                SQLiteOpenHelper newbreeddatabasehelper = new BreedDataBaseHelper(myContext);
                SQLiteDatabase mybreeddatabase = newbreeddatabasehelper.getWritableDatabase();
                cursorCreator(mybreeddatabase);

                Toast myToast = Toast.makeText(myContext, "Database successfully created", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                myToast.show();

            } catch (SQLiteException e) {
                Toast myToast = Toast.makeText(myContext, "Database Unavailable", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                myToast.show();
            }
    }

    private void cursorCreator (SQLiteDatabase db) {

        ArrayList<String> myListOfTitles = new ArrayList<>();

        String title = BreedDataBaseHelper.KEY_TITLE;
        String description = BreedDataBaseHelper.KEY_DECRIPTION;
        String size = BreedDataBaseHelper.KEY_SIZE;

        String [] selectionArgs = getAsqCondition();

        Cursor myCursor = db.query(BreedDataBaseHelper.TABLE_NAME, new String[] {title, description},
                "size < ?", selectionArgs, null, null, null);

        if (myCursor.moveToFirst()) {

            String tempstr = myCursor.getString(0);
            myListOfTitles.add(tempstr);

        }

        while (myCursor.moveToNext()){

            String tempstr_next = myCursor.getString(0);
            myListOfTitles.add(tempstr_next);

        }


        myCursor.close();
        db.close();


        inact.setListOfTitles(myListOfTitles);

        inact.setDataBaseCreated(true);

        Toast myToast = Toast.makeText(myContext, "List of breeds successfully created", Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 70);
        myToast.show();
    }

    private String[] getAsqCondition() {

        return new String [] {"4"};
    }


}
