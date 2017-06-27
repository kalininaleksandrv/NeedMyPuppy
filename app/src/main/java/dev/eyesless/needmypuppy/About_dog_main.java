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
public class About_dog_main extends Buttons_Abstract_Fragment {


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
        return inflater.inflate(R.layout.about_dog_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        statussetter ();

        createspinner(spinner_walking, inact.getSpinner_walk_array());
        createspinner(spinner_cynologist, inact.getSpinner_cynologist_array());
        createspinner(spinner_vet, inact.getSpinner_vet_array());

        //реализуем онкликлистнер на подключенной кнопке
        completebutton.setOnClickListener(myOnClickListner);
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

                    case (R.id.spinner_walking):
                        walkvalue = position;
                        break;

                    case (R.id.spinner_cynologist):
                        cynologistvalue = position;
                        break;

                    case (R.id.spinner_vet):

                        vetvalue = position;
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

    View.OnClickListener myOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            inact.setButtonaboutdogispressed(true);
            checkboxReader();

            inact.obidienceincreaser(4-cynologistvalue);

            guardsetter ();
            agressivesetter ();
            activsetter ();
            sizesetter ();
            caresetter ();

            myButtonListner.buttonClicked(v);

        }
    };

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
        spinner_walking = (Spinner)parentview.findViewById(R.id.spinner_walking);
        spinner_cynologist = (Spinner)parentview.findViewById(R.id.spinner_cynologist);
        spinner_vet = (Spinner)parentview.findViewById(R.id.spinner_vet);


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



}
