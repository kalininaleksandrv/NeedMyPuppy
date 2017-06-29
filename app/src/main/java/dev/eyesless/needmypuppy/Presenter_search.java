package dev.eyesless.needmypuppy;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Eyesless on 29.06.2017.
 */

public class Presenter_search {

    private MVPInterface_search minterface;
    private Context context;
    private InitiationActivity inact;




    public Presenter_search(MVPInterface_search minterface) {

        this.minterface = minterface;
    }

    public void inactsetter(InitiationActivity inact, Context context) {

        this.inact = inact;
        this.context = context;
    }


    public void searchstarter() {

        String [] s = new String[] {minterface.onRecive()};

        if (inact.isDataBaseCreated() == false) {

            BreedDataBaseCreator myDataCreator = new BreedDataBaseCreator(context, inact);
            myDataCreator.onCreateDb(null);
            inact.setListOfTitles();
        }

        String result = null;

        ArrayList<String> ret = inact.getListOfTitles();

        Iterator<String> itr = ret.iterator();

        while (itr.hasNext()) {

            result = result.concat(itr.next().concat(", "));

        }

        minterface.onSend(result);

    }



}
