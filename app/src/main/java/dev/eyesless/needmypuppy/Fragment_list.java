package dev.eyesless.needmypuppy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_list extends ListFragment {


    public Fragment_list() {
        // Required empty public constructor
    }

    ArrayList<String> mylist = new ArrayList<String>(setListOfBreed());


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(inflater.getContext(),
                R.layout.list_item, mylist);
        setListAdapter(breedAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public ArrayList<String> setListOfBreed () {

        ArrayList<String> finalListOfBreedDescr = new ArrayList<>();
        Iterator<Breed> myBreedIterator = Main_logic.sortedBreeds.iterator();

        while (myBreedIterator.hasNext()) {
            Breed breed = myBreedIterator.next();
            finalListOfBreedDescr.add(breed.getBreed_title());
        }

        return finalListOfBreedDescr;
    }

}
