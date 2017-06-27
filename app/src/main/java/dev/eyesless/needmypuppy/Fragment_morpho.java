package dev.eyesless.needmypuppy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import static java.lang.Math.min;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_morpho extends Buttons_Abstract_Fragment implements MVPInterface {


    protected CheckBox noalergy;
    protected Spinner spinnerhair;
    protected Spinner spinnerblackorwhite;
    protected Spinner spinnersize;
    private int blackorwhiteposition;
    private int hairposition;
    private int sizeposition;

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

        presenterinactsetter(inact);

        spinnerinit ();

        statussetter ();

        createspinner (spinnerblackorwhite, inact.getSpinner_blackorwhite());
        createspinner (spinnerhair, inact.getSpinner_hair());
        createspinner(spinnersize, inact.getSpinner_size());

        completebutton.setOnClickListener(myOnClickListner);

    }

    private void presenterinactsetter(InitiationActivity inact) {

        presenter.inactsetter(inact);

    }

    private void spinnerinit() {

        spinnerhair = (Spinner) parentview.findViewById(R.id.spinner_hair);
        spinnerblackorwhite = (Spinner) parentview.findViewById(R.id.spinner_blackorwhite);
        spinnersize = (Spinner) parentview.findViewById(R.id.spinner_size);

        noalergy = (CheckBox) parentview.findViewById(R.id.checkBox_noalergy);

    }

    //spinners creater

    private void createspinner(Spinner sp, String [] strar) {

        final int mSpinner = sp.getId();

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, strar);

        sp.setAdapter(myAdapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (mSpinner) {

                    case (R.id.spinner_blackorwhite):
                        blackorwhiteposition = position;
                        break;

                    case (R.id.spinner_hair):
                        hairposition = position;
                        break;

                    case (R.id.spinner_size):

                        if (position == 0 || position == 5 ) sizeposition = 5;
                        else sizeposition = position;
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void statussetter() {

        if (inact.isButtonaboutdogispressed()) {

            toastmaker();

            noalergy.setEnabled(false);
            spinnerhair.setEnabled(false);
            spinnerblackorwhite.setEnabled(false);
            spinnersize.setEnabled(false);

        }
    }

    View.OnClickListener myOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            checkboxreader();

            myButtonListner.buttonClicked(v);

        }
    };


    public void checkboxreader() {

        presenter.checkboxreader();

    }

    @Override
    public boolean isboxchecked() {

        if (noalergy.isChecked()) return true;
        else return false;
    }

    @Override
    public int issize() {
        return sizeposition;
    }

    @Override
    public int ishair() {
        return hairposition;
    }

    @Override
    public int isblackorwhite() {
        return blackorwhiteposition;
    }
}
