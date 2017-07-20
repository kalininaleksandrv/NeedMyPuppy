package dev.eyesless.needmypuppy;


import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState !=null) {
            this.myBreedId = savedInstanceState.getInt(MY_BREED_ID);
            this.myListOfBreed = (ArrayList<Breed_mod>) savedInstanceState.getSerializable(MY_LIST_OF_BREED);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



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

            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;

            String weblinc =  myListOfBreed.get(myBreedId).getB_weblinc();

            ImageView myBreedImage = (ImageView) parentview.findViewById(R.id.breed_image);

            Picasso.with(getActivity().getApplicationContext())
                    .load(weblinc)
                    .placeholder(R.drawable.try_to_download)
                    .error(R.drawable.sad_dog)
                    .resize(width, width*(int)0.75)
                    .into(myBreedImage);

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

    public int getMyBreedId() {
        return myBreedId;
    }

}


