package dev.eyesless.needmypuppy;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frame_main extends Fragment {


    public Frame_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//        Buttons_main newButtonsMain = new Buttons_main();
//        FragmentTransaction fratramain = getChildFragmentManager().beginTransaction();
//        fratramain.replace(R.id.replaced_main, newButtonsMain);
//        fratramain.addToBackStack(null);
//        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        fratramain.commit();

        About_owner_main newAboutOwner = new About_owner_main();
        FragmentTransaction fratramain = getChildFragmentManager().beginTransaction();
        fratramain.replace(R.id.replaced_main, newAboutOwner);
        fratramain.addToBackStack(null);
        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratramain.commit();



        return inflater.inflate(R.layout.fragment_frame_main, container, false);
    }

}
