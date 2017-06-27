package dev.eyesless.needmypuppy;

/**
 * Created by Eyesless on 27.06.2017.
 */

class Presenter_aboutowner {

    private MVPInterface_aboutowner minterface;

    private InitiationActivity inact;

    public Presenter_aboutowner(MVPInterface_aboutowner minterface) {

        this.minterface = minterface;

    }

    public void inactsetter(InitiationActivity inact) {

        this.inact = inact;

    }

    public void valuereader() {

        inact.setButtonaboutownerispressed(true);


    }
}
