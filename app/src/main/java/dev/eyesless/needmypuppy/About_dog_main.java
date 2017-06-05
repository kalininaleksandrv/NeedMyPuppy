package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_dog_main extends Fragment {

    onButtonListner myButtonListner;

    private View parentview;
    private InitiationActivity inact;
    private CheckBox havedog;
    private CheckBox havechild;

    private Spinner spinner_walking;
    private Spinner spinner_cynologist;
    private Spinner spinner_vet;

    private int walkvalue;
    private int cynologistvalue;
    private int vetvalue;


    public About_dog_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inact = ((InitiationActivity) getActivity().getApplicationContext());
        View layout = inflater.inflate(R.layout.about_dog_main, container, false);

        //spinner walking
        spinner_walking = (Spinner)layout.findViewById(R.id.spinner_walking);
        ArrayAdapter<String> spiner_walk_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_walk_array());
        spinner_walking.setAdapter(spiner_walk_adapter);
        spinner_walking.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                walkvalue = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //spinner walking
        spinner_cynologist = (Spinner)layout.findViewById(R.id.spinner_cynologist);
        ArrayAdapter<String> spiner_cynolog_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_cynologist_array());
        spinner_cynologist.setAdapter(spiner_cynolog_adapter);
        spinner_cynologist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cynologistvalue = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //spinner walking
        spinner_vet = (Spinner)layout.findViewById(R.id.spinner_vet);
        ArrayAdapter<String> spiner_vet_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_vet_array());
        spinner_vet.setAdapter(spiner_vet_adapter);
        spinner_vet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                vetvalue = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Inflate the layout for this fragment
        return layout;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (onButtonListner) context;

    }

    @Override
    public void onStart() {
        super.onStart();

        parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        statussetter ();

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inact.setButtonaboutdogispressed(true);
              //  checkboxReader();
                // TODO: 05.06.2017 implement spinners realizatoin

                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

    private void checkboxReader() {

        if (havedog.isChecked()){
            // TODO: 05.06.2017 implement

        }

        if (havechild.isChecked()){
            // TODO: 05.06.2017 implement

        }
    }

    private void statussetter() {

        havedog = (CheckBox) parentview.findViewById(R.id.checkBox_opt1);
        havechild = (CheckBox) parentview.findViewById(R.id.checkBox_opt2);

        if (inact.isButtonaboutdogispressed()) {

            toastmaker();

            havedog.setEnabled(false);
            havechild.setEnabled(false);
            spinner_walking.setEnabled(false);
            spinner_cynologist.setEnabled(false);
            spinner_vet.setEnabled(false);
        }
    }

    // if button was pressed and trying next time, set toast about
    private void toastmaker() {
        String helpstring = getString(R.string.disabled_button_short);
        Toast myToast = Toast.makeText(getContext(), helpstring, Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 30);
        myToast.show();
    }

}
