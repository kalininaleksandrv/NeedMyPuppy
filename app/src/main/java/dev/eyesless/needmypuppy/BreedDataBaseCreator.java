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
                Cursor mCursor = cursorCreator(mybreeddatabase);
                listOfBreedCreator(mCursor);
                mybreeddatabase.close();

            } catch (SQLiteException e) {
                Toast myToast = Toast.makeText(myContext, "Database Unavailable", Toast.LENGTH_SHORT);
                myToast.setGravity(Gravity.BOTTOM, 0, 30);
                myToast.show();
            }
    }

    private Cursor cursorCreator (SQLiteDatabase db) {


        String title = BreedDataBaseHelper.KEY_TITLE;
        String description = BreedDataBaseHelper.KEY_DECRIPTION;
        String description_full = BreedDataBaseHelper.KEY_DECRIPTION_FULL;
        String image_res_id = BreedDataBaseHelper.KEY_IMAGE_RES_ID;
        String image_fs_res_id = BreedDataBaseHelper.KEY_IMAGE_RES_ID_BIG;
        String obidience = BreedDataBaseHelper.KEY_OBIDIENCE;
        String guard = BreedDataBaseHelper.KEY_GUARD;
        String agressive = BreedDataBaseHelper.KEY_AGRESSIVE;
        String active = BreedDataBaseHelper.KEY_ACTIVE;
        String hardy = BreedDataBaseHelper.KEY_HARDY;
        String size = BreedDataBaseHelper.KEY_SIZE;
        String care = BreedDataBaseHelper.KEY_CARE;
        String hunt = BreedDataBaseHelper.KEY_HUNT;
        String weblinc = BreedDataBaseHelper.KEY_WEBLINC;
        String fciid = BreedDataBaseHelper.KEY_FCIID;

        String [] selectionArgs = getAsqCondition();

        Cursor myCursor = db.query(BreedDataBaseHelper.TABLE_NAME, new String[] {title, description, description_full, image_res_id, image_fs_res_id,
                        obidience, guard, agressive, active, hardy, size, care, hunt, weblinc, fciid},
                "size < ?", selectionArgs, null, null, null);

        return myCursor;
    }

    private String[] getAsqCondition() {

        return new String [] {"5"};

        // TODO: 19.06.2017 implement custom conditions of query
    }

    private void listOfBreedCreator (Cursor cursor) {

        Cursor myCursor = cursor;

        ArrayList <Breed_mod> myListOfBreed_m = new ArrayList<>();


        if (myCursor.moveToFirst()) {

            Breed_mod myBreedM = breed_m_creator(myCursor.getString(0), myCursor.getString(1), myCursor.getString(2),
                    myCursor.getInt(3), myCursor.getInt(4),
                    myCursor.getInt(5), myCursor.getInt(6), myCursor.getInt(7), myCursor.getInt(8),
                    myCursor.getInt(9), myCursor.getInt(10),myCursor.getInt(11),myCursor.getInt(12), myCursor.getString(13), myCursor.getInt(14) );
            myListOfBreed_m.add(myBreedM);

        }

        while (myCursor.moveToNext()){

            Breed_mod myBreedM = breed_m_creator(myCursor.getString(0), myCursor.getString(1), myCursor.getString(2),
                    myCursor.getInt(3), myCursor.getInt(4),
                    myCursor.getInt(5), myCursor.getInt(6), myCursor.getInt(7), myCursor.getInt(8),
                    myCursor.getInt(9), myCursor.getInt(10),myCursor.getInt(11),myCursor.getInt(12), myCursor.getString(13), myCursor.getInt(14));
            myListOfBreed_m.add(myBreedM);

        }

         inact.setMyListOfBreed_m(myListOfBreed_m);

         inact.setDataBaseCreated(true);

         cursor.close();

    }

    Breed_mod breed_m_creator (String name, String description, String description_full,
                               int resourceId, int resourceIdBig, int obidience, int guard, int agressive,
                               int active, int hardy, int size, int care, int hunt, String weblinc, int fciid){

        Breed_mod myBreedM = new Breed_mod();
        myBreedM.setB_title(name);
        myBreedM.setB_description(description);
        myBreedM.setB_description_full(description_full);
        myBreedM.setB_image_res_id(resourceId);
        myBreedM.setB_image_fs_res_id(resourceIdBig);
        myBreedM.setB_obidience(obidience);
        myBreedM.setB_guard(guard);
        myBreedM.setB_agresssive(agressive);
        myBreedM.setB_active(active);
        myBreedM.setB_hardy(hardy);
        myBreedM.setB_size(size);
        myBreedM.setB_care(care);
        myBreedM.setB_hunt(hunt);
        myBreedM.setB_weblinc(weblinc);
        myBreedM.setB_idfci(fciid);


        return myBreedM;
    }


}
