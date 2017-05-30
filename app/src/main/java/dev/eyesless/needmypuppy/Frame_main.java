package dev.eyesless.needmypuppy;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);

            Log.w("MY_TAG", "restored FRAGMENT");

        }


 //       if (myfragment == null) { myfragment = new Buttons_main();}
        android.support.v4.app.FragmentTransaction fratramain =  getFragmentManager().beginTransaction();
        fratramain.replace(R.id.replaced_main, myfragment);
        fratramain.addToBackStack(null);
        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratramain.commit();

        return inflater.inflate(R.layout.fragment_frame_main, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        getFragmentManager().putFragment(outState, "myFragment", myfragment);
        Log.w("MY_TAG", "saved FRAGMENT");

    }

    public void onRestoreInstanceState (Bundle inState){

        myfragment = getFragmentManager().getFragment(inState, "myFragment");
    }


    public void setMyfragment(Fragment myfragment) {
        this.myfragment = myfragment;
    }


}
