package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BreedDescriptionActivity_frag extends AppCompatActivity implements Fragment_list.Fragment_list_listner{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_description_frag);

    }

    @Override
    public void itemClicked(long id) {

        // TODO: 03.05.2017  при создании этого класса сразу в конструкторе передавать ему все данные по породе а расшифровывать в этом классе
        Fragment_description newdescription = new Fragment_description();
        newdescription.setBreedId((int)id);
        FragmentTransaction fratra = getFragmentManager().beginTransaction();
        fratra.replace(R.id.frame_breed_description, newdescription);
        fratra.addToBackStack(null);
        fratra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratra.commit();
    }
}

//TODO: 02.05.2017 создавая Фрагмент-описание и фрагмент-список нужно передавать им лист пород еще в конструкторе создавая в этом классе их экземпляры