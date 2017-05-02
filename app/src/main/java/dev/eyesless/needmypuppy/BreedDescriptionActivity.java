package dev.eyesless.needmypuppy;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class BreedDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_BREED_ID = "breedID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_description);

        //получаем ID выбранного варианта из BreedListActivity
        int breedId = (Integer) getIntent().getExtras().get(EXTRA_BREED_ID);

        // получаем лист выбранных пород
        ArrayList<Breed> myListOfBreed = Main_logic.sortedBreeds;

        // из листа пород по ID выводим название описание и картинку конкретной породы
        TextView myBreedTitle = (TextView) findViewById(R.id.breed_title);
        myBreedTitle.setText(myListOfBreed.get(breedId).getBreed_title());

        ImageView myBreedImage = (ImageView) findViewById(R.id.breed_image);
        myBreedImage.setImageResource(myListOfBreed.get(breedId).getImageId());

        TextView myBreedDescript = (TextView) findViewById(R.id.breed_descript);
        myBreedDescript.setText(myListOfBreed.get(breedId).getBreed_descr());


    }
}
