package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DescriptionActivity extends AppCompatActivity {

    public static final String GETBREEDID = "getbreedid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Fragment_description mydescription = (Fragment_description)getFragmentManager()
                .findFragmentById(R.id.frame_breed_description);

        mydescription.setBreedId((int)getIntent().getExtras().get("getbreedid"));


    }
}
