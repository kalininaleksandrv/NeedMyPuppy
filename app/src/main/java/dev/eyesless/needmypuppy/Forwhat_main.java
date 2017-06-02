package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * A simple {@link Fragment} subclass.
 */
public class Forwhat_main extends Fragment {

   onButtonListner myButtonListner;


    public Forwhat_main() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.forwhat_main, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (onButtonListner) context;

    }

    @Override
    public void onStart() {
        super.onStart();

        final View parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkboxReader(parentview);
                myButtonListner.buttonClicked(v);
            }
        };
        completebutton.setOnClickListener(myOnClickListner);
    }

    // подключаем чекбоксы и передаем состояние

    public void checkboxReader (View view) {

        InitiationActivity inact = ((InitiationActivity) getActivity().getApplicationContext());


        CheckBox babycheck = (CheckBox) view.findViewById(R.id.checkBox_opt1);
        CheckBox frendcheck = (CheckBox) view.findViewById(R.id.checkBox_opt2);
        CheckBox runcheck = (CheckBox) view.findViewById(R.id.checkBox_opt3);
        CheckBox huntcheck = (CheckBox) view.findViewById(R.id.checkBox_opt4);
        CheckBox obidencecheck = (CheckBox) view.findViewById(R.id.checkBox_opt5);
        CheckBox guardcheck = (CheckBox) view.findViewById(R.id.checkBox_opt6);

        if (babycheck.isChecked()){
            inact.obidience.setValue(max(inact.obidience.getValue(),2));
            inact.agressive.setValue(min(inact.agressive.getValue(),1));
            inact.active.setValue(max(inact.active.getValue(),3));
        }

        if (frendcheck.isChecked()){

            inact.obidience.setValue(max(inact.obidience.getValue(),2));
            inact.agressive.setValue(min(inact.agressive.getValue(),2));
            inact.active.setValue(max(inact.active.getValue(),2));

        }
        if (runcheck.isChecked()){

            inact.obidience.setValue(max(inact.obidience.getValue(),3));
            inact.agressive.setValue(min(inact.agressive.getValue(),2));
            inact.active.setValue(max(inact.active.getValue(),3));
            inact.hardy.setValue(max(inact.hardy.getValue(),4));


        }
        if (huntcheck.isChecked()){

        }

        if (obidencecheck.isChecked()){

            inact.obidience.setValue(max(inact.obidience.getValue(),5));
            inact.agressive.setValue(min(inact.agressive.getValue(),2));
            inact.active.setValue(max(inact.active.getValue(),3));
            inact.size.setValue(max(inact.size.getValue(),3));

        }
        if (guardcheck.isChecked()){

            inact.obidience.setValue(max(inact.obidience.getValue(),4));
            inact.guard.setValue(max(inact.guard.getValue(),5));
            inact.active.setValue(max(inact.active.getValue(),3));
            inact.size.setValue(max(inact.active.getValue(),4));
        }
    }
}
