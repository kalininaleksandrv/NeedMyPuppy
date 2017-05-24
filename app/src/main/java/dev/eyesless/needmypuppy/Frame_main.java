package dev.eyesless.needmypuppy;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frame_main extends Fragment {



    private Fragment myfragment;


    public Frame_main() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (myfragment == null) { myfragment = new About_owner_main();}
        android.support.v4.app.FragmentTransaction fratramain =  getFragmentManager().beginTransaction();
        fratramain.replace(R.id.replaced_main, myfragment);
        fratramain.addToBackStack(null);
        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratramain.commit();

        return inflater.inflate(R.layout.fragment_frame_main, container, false);
    }


    public void setMyfragment(Fragment myfragment) {
        this.myfragment = myfragment;
    }


}
