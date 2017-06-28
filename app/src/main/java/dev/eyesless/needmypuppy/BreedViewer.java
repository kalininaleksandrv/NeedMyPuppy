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

    // TODO: 28.06.2017 поиск по базе пород: создать фразмент поиска вместо класса, запускать onCreateDb с условиями в виде String []
}
