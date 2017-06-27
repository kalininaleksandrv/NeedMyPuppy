package dev.eyesless.needmypuppy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import static java.lang.Math.min;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_morpho extends Buttons_Abstract_Fragment implements MVPInterface {


    protected CheckBox noalergy;
    protected Spinner spinnerblackorwhite;

    Presenter_morpho presenter;

    public Fragment_morpho() {
        // Required empty public constructor

        presenter = new Presenter_morpho(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_morpho, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        spinnerinit ();

        statussetter ();

        blackorwhitespinner ();

        completebutton.setOnClickListener(myOnClickListner);

    }

    private void spinnerinit() {

        spinnerblackorwhite = (Spinner) parentview.findViewById(R.id.spinner_blackorwhite);

    }

    //spinner blackorwhite 

    private void blackorwhitespinner() {

        ArrayAdapter<String> spinnerblackorwhite = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_blackorwhite());

        this.spinnerblackorwhite.setAdapter(spinnerblackorwhite);

    }

    private void statussetter() {

        noalergy = (CheckBox) parentview.findViewById(R.id.checkBox_noalergy);

        if (inact.isButtonaboutdogispressed()) {

            toastmaker();

            noalergy.setEnabled(false);
        }
    }

    View.OnClickListener myOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            checkboxreader(inact);

            myButtonListner.buttonClicked(v);

        }
    };


    @Override
    public boolean isboxchecked() {

        if (noalergy.isChecked()) return true;
        else return false;
    }

    public void checkboxreader(InitiationActivity inact) {

        presenter.checkboxreader(inact);

    }
}
