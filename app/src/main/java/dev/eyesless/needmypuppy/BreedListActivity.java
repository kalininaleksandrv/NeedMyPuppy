package dev.eyesless.needmypuppy;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class BreedListActivity extends ListActivity {

    public static final String EXTRA_MSG = "myBreeds";
    ArrayList<String> arrayFromIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // добавляем массив - результат выборки собак и через адаптер формируем ListActivity

        arrayFromIntent = (ArrayList<String>)getIntent().getSerializableExtra(EXTRA_MSG);


        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item, arrayFromIntent);
        ListView listBreeds = getListView();
        listBreeds.setAdapter(breedAdapter);
    }

    // метод для выбора варианта из активности


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent descrintent = new Intent(BreedListActivity.this, BreedDescriptionActivity_frag.class);
        descrintent.putExtra(BreedDescriptionActivity.EXTRA_BREED_ID, (int) id);
        startActivity(descrintent);


    }
}
