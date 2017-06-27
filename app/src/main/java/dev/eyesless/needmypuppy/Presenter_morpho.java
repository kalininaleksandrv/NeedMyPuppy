package dev.eyesless.needmypuppy;

import android.util.Log;

/**
 * Created by Eyesless on 27.06.2017.
 */

public class Presenter_morpho {

    private MVPInterface minterface;

    private InitiationActivity inact;

    public Presenter_morpho(MVPInterface minterface) {

        this.minterface = minterface;

    }


    public void inactsetter(InitiationActivity inact) {

        this.inact = inact;
    }

    public void checkboxreader() {

        inact.setButtonmorphoispressed(true);


        if (minterface.isboxchecked()){


            inact.noalergy.setValue(1);

        }

        int blackorwhite = (minterface.isblackorwhite());

        inact.blackorwhite.setValue(blackorwhite);


    }
}
