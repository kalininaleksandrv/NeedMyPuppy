package dev.eyesless.needmypuppy;


import android.os.Bundle;

import android.support.v4.app.Fragment;
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


    protected int myBreedId;
    private View parentview;
    protected InitiationActivity inact;
    protected ArrayList<Breed_mod> myListOfBreed;
    protected static String MY_BREED_ID = "myBreedId";
    protected static String MY_LIST_OF_BREED = "myListOfBreed";


    public Fragment_description() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState !=null) {
            this.myBreedId = savedInstanceState.getInt(MY_BREED_ID);
            this.myListOfBreed = (ArrayList<Breed_mod>) savedInstanceState.getSerializable(MY_LIST_OF_BREED);
        }

        View mView = inflater.inflate(R.layout.fragment_description, container, false);


        inact = ((InitiationActivity) getActivity().getApplicationContext());
        // Inflate the layout for this fragment
        return mView;

    }

    @Override
    public void onStart() {
        super.onStart();
        parentview = getView();
        myListOfBreed = inact.getMyListOfBreed_m();

        ((MainActivity) getActivity()).gudlinesetter((float) 0.1);

        if (parentview != null){

            // из листа пород по ID выводим название описание и картинку конкретной породы
            TextView myBreedTitle = (TextView) parentview.findViewById(R.id.breed_title);
            myBreedTitle.setText(myListOfBreed.get(myBreedId).getB_title());

            ImageView myBreedImage = (ImageView) parentview.findViewById(R.id.breed_image);
            myBreedImage.setImageResource(myListOfBreed.get(myBreedId).getB_image_fs_res_id());

            TextView myBreedDescript = (TextView) parentview.findViewById(R.id.breed_descript);
            myBreedDescript.setText(myListOfBreed.get(myBreedId).getB_description_full());

        }

    }

    public void onSaveInstanceState (Bundle savedInstanceState) {

        savedInstanceState.putInt(MY_BREED_ID, myBreedId);
        savedInstanceState.putSerializable(MY_LIST_OF_BREED, myListOfBreed);

    }

    public void setBreedId (int id) {
        this.myBreedId = id;
    }

}


