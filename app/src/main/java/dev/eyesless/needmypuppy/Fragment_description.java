package dev.eyesless.needmypuppy;


import android.app.Fragment;
import android.os.Bundle;

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


    private Integer myBreedId;

    // получаем лист выбранных пород
    ArrayList<Breed> myListOfBreed = Main_logic.sortedBreeds;

    public Fragment_description() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View myview = getView();

        if (myview != null){

            // из листа пород по ID выводим название описание и картинку конкретной породы
            TextView myBreedTitle = (TextView) myview.findViewById(R.id.breed_title);
            myBreedTitle.setText(myListOfBreed.get(myBreedId).getBreed_title());

            ImageView myBreedImage = (ImageView) myview.findViewById(R.id.breed_image);
            myBreedImage.setImageResource(myListOfBreed.get(myBreedId).getImageId());

            TextView myBreedDescript = (TextView) myview.findViewById(R.id.breed_descript);
            myBreedDescript.setText(myListOfBreed.get(myBreedId).getBreed_descr());

        }

    }

    public void setBreedId (int id) {
        this.myBreedId = (Integer) id;
    }

}
