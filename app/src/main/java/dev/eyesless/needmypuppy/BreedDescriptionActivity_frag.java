package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class BreedDescriptionActivity_frag extends AppCompatActivity implements Fragment_list.Fragment_list_listner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breed_description_frag);

    }

    @Override
    public void itemClicked(long id) {

        View frame_breed_description = findViewById(R.id.frame_breed_description);

        if (frame_breed_description != null)
        {
//            Fragment_description newdescription = new Fragment_description();
//            newdescription.setBreedId((int)id);
//            FragmentTransaction fratra = getFragmentManager().beginTransaction();
//            fratra.replace(R.id.frame_breed_description, newdescription);
//            fratra.addToBackStack(null);
//            fratra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//            fratra.commit();
        }
        else
        {
            Intent myintent = new Intent(this, DescriptionActivity.class);
            myintent.putExtra(DescriptionActivity.GETBREEDID, (int) id);
            startActivity(myintent);
        }
    }
}

