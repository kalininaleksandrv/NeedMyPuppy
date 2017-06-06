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
                checkboxReader();

                obidiencesetter();
                guardsetter ();
                agressivesetter ();
                activsetter ();
                sizesetter ();
                caresetter ();

                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

    private void checkboxReader() {

        if (havedog.isChecked()){
            inact.agressive.setValue(min(inact.agressive.getValue(),3)); //в случае другой собаки агрессивность не более 3
        }

        if (havechild.isChecked()){
            inact.agressive.setValue(min(inact.agressive.getValue(),2)); //в случае наличия детей агрессивность не более 2
        }
    }

    private void statussetter() {

        havedog = (CheckBox) parentview.findViewById(R.id.checkBox_havedog);
        havechild = (CheckBox) parentview.findViewById(R.id.checkBox_havechild);

        if (inact.isButtonaboutdogispressed()) {

            toastmaker();

            havedog.setEnabled(false);
            havechild.setEnabled(false);
            spinner_walking.setEnabled(false);
            spinner_cynologist.setEnabled(false);
            spinner_vet.setEnabled(false);
        }
    }

    //main logic - setting different parameters on Initiation Activity

    private void obidiencesetter() {
        inact.obidience.setValue(max(inact.obidience.getValue(),4-cynologistvalue)); //чем хуже развиты кинологические услуги, тем послушнее должна быть собака (дисконт 1)
    }

    private void guardsetter() {
        inact.guard.setValue(max(inact.guard.getValue(), cynologistvalue)); //чем хуже развиты кинологические услуги, тем менее выраженные охранные качества допускаются
    }

    private void agressivesetter() {
        inact.agressive.setValue(min(inact.agressive.getValue(), walkvalue+1)); //чем хуже условия выгула, тем менее агрессивная собака допускается
        inact.agressive.setValue(min(inact.agressive.getValue(), cynologistvalue)); // чем хуже развиты кинологические услуги, тем менее агрессивная собака допускается
    }

    private void activsetter() {
        inact.active.setValue(max(inact.active.getValue(), walkvalue)); //чем хуже условия выгула, тем менее активная собака допускается
        inact.active.setValue(max(inact.active.getValue(), cynologistvalue+1)); // чем хуже развиты кинологические услуги, тем менее активная собака допускается
    }

    private void sizesetter() {
        inact.size.setValue(min(inact.size.getValue(), walkvalue+1)); //чем хуже условия выгула, тем менее крупная собака допускается
    }

    private void caresetter() {
        inact.care.setValue(max(inact.care.getValue(), vetvalue+1)); //чем хуже ветеринарная поддержка тем более неприхотливая собака допускается
    }

    // if button was pressed and trying next time, set toast about
    private void toastmaker() {
        String helpstring = getString(R.string.disabled_button_short);
        Toast myToast = Toast.makeText(getContext(), helpstring, Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 30);
        myToast.show();
    }

}
