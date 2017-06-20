package dev.eyesless.needmypuppy;


import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_description extends Fragment {


    private int myBreedId;
    private View parentview;
    private InitiationActivity inact;
    ArrayList<Breed_mod> myListOfBreed;


    public Fragment_description() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState !=null) {
            myBreedId = savedInstanceState.getInt("myBreedId");
            myListOfBreed = (ArrayList<Breed_mod>) savedInstanceState.getSerializable("myListOfBreed");
        }


        inact = ((InitiationActivity) getActivity().getApplicationContext());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        parentview = getView();
        myListOfBreed = inact.getMyListOfBreed_m();

        if (parentview != null){

            // из листа пород по ID выводим название описание и картинку конкретной породы
            TextView myBreedTitle = (TextView) parentview.findViewById(R.id.breed_title);
            myBreedTitle.setText(myListOfBreed.get(myBreedId).getB_title());

            ImageView myBreedImage = (ImageView) parentview.findViewById(R.id.breed_image);
            myBreedImage.setImageResource(myListOfBreed.get(myBreedId).getB_image_res_id());

            TextView myBreedDescript = (TextView) parentview.findViewById(R.id.breed_descript);
            myBreedDescript.setText(myListOfBreed.get(myBreedId).getB_description());

        }

    }

    public void onSaveInstanceState (Bundle savedState) {

        savedState.putInt("myBreedId", myBreedId);
        savedState.putSerializable("myListOfBreed", myListOfBreed);

    }

    public void setBreedId (int id) {
        this.myBreedId = id;
    }

}


