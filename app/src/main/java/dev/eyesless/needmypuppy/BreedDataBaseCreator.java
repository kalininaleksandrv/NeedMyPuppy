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

                ArrayList<String> myListOfTitles = new ArrayList<>();

                SQLiteOpenHelper newbreeddatabasehelper = new BreedDataBaseHelper(myContext);

                SQLiteDatabase mybreeddatabase = newbreeddatabasehelper.getWritableDatabase();

                Cursor myCursor = mybreeddatabase.query(BreedDataBaseHelper.TABLE_NAME, new String[] {BreedDataBaseHelper.KEY_TITLE, BreedDataBaseHelper.KEY_DECRIPTION}, null, null, null, null, null);

                if (myCursor.moveToFirst()) {

                    String tempstr = myCursor.getString(0);
                    myListOfTitles.add(tempstr);

                }

                while (myCursor.moveToNext()){

                    String tempstr_next = myCursor.getString(0);
                    myListOfTitles.add(tempstr_next);

                }


                myCursor.close();
                mybreeddatabase.close();

                Toast myToast = Toast.makeText(myContext, "Database successfully created", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                myToast.show();

                inact.setListOfTitles(myListOfTitles);

                inact.setDataBaseCreated(true);

            } catch (SQLiteException e) {
                Toast myToast = Toast.makeText(myContext, "Database Unavailable", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                myToast.show();
            }



    }

     public void onReCreateDb () {

         Toast myToast = Toast.makeText(myContext, "Database successfully upload", Toast.LENGTH_SHORT);
         myToast.setGravity(Gravity.BOTTOM, 0, 30);
         myToast.show();



    }


}
