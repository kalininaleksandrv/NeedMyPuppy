package dev.eyesless.needmypuppy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Eyesless on 23.06.2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    protected ArrayList<Breed_mod> myListOfBreed;


    public ViewPagerAdapter(FragmentManager fm, ArrayList<Breed_mod> arrayList) {

        super(fm);

        this.myListOfBreed = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment_description myDescrFragm = new Fragment_description();
        myDescrFragm.setBreedId(position);
        return myDescrFragm;
    }

    @Override
    public int getCount() {
        return myListOfBreed.size();
    }
}
