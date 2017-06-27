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


    public void checkboxreader(InitiationActivity inact) {

        if (minterface.isboxchecked()){

            inact.setButtonmorphoispressed(true);

            inact.noalergy.setValue(1);

        }

    }
}
