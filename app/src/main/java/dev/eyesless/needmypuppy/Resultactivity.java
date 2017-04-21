package dev.eyesless.needmypuppy;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Resultactivity extends ListActivity {

    public static final String EXTRA_MSG = "myBreeds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> arrayFromIntent = (ArrayList<String>)getIntent().getSerializableExtra(EXTRA_MSG);
        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, arrayFromIntent);

        ListView listBreeds = getListView();
        listBreeds.setAdapter(breedAdapter);

    }
}
