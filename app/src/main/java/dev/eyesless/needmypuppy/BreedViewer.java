package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BreedViewer extends AppCompatActivity {

    private static int THISLAYOUT = R.layout.activity_breed_viewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(THISLAYOUT);
    }
}
