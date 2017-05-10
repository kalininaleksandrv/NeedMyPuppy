package dev.eyesless.needmypuppy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class InitiationActivity extends Application {

    @Override
    public void onCreate() {

        super.onCreate();

        Log.w("MY_TAG", "InitiationActivity");


    }
}
