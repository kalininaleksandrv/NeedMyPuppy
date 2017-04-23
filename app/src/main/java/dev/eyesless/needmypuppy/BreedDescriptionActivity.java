package dev.eyesless.needmypuppy;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BreedDescriptionActivity extends AppCompatActivity {

    public static final String EXTRA_BREED_ID = "breedID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_description);

        int breedId = (Integer) getIntent().getExtras().get(EXTRA_BREED_ID);
        String breed_in_descr = String.valueOf(breedId);

        TextView myBreedTitle = (TextView) findViewById(R.id.breed_title);
        myBreedTitle.setText(breed_in_descr);
    }
}
