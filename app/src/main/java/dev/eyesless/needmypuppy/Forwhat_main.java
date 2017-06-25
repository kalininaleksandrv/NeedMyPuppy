package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
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
   private InitiationActivity inact;
   private View parentview;
   private CheckBox babycheck;
   private CheckBox frendcheck;
   private CheckBox runcheck;
   private CheckBox huntcheck;
   private CheckBox obidencecheck;
   private CheckBox guardcheck;

    public Forwhat_main() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inact = ((InitiationActivity) getActivity().getApplicationContext());

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

        parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        checkbuttonstatussetter ();

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inact.setButtonforwhatispressed(true);
                checkboxReader();
                myButtonListner.buttonClicked(v);
            }
        };
        completebutton.setOnClickListener(myOnClickListner);
    }

    // подключаем чекбоксы и передаем состояние

    private void checkboxReader () {


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
                    inact.hunt.setValue(1);
                }

                if (obidencecheck.isChecked()){

                    inact.obidience.setValue(max(inact.obidience.getValue(),5));
                    inact.agressive.setValue(min(inact.agressive.getValue(),2));
                    inact.active.setValue(max(inact.active.getValue(),3));
                    inact.size.setValue(max(inact.size.getValue(),3));

                }
                if (guardcheck.isChecked()){

                    inact.guard.setValue(max(inact.guard.getValue(),4));

                }

    }

    //init checkboxes and set it disabled if re-entry

    private void checkbuttonstatussetter() {

        babycheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt1);
        frendcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt2);
        runcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt3);
        huntcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt4);
        obidencecheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt5);
        guardcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt6);

        if (inact.isButtonforwhatispressed()) {

            toastmaker();

            babycheck.setEnabled(false);
            frendcheck.setEnabled(false);
            runcheck.setEnabled(false);
            huntcheck.setEnabled(false);
            obidencecheck.setEnabled(false);
            guardcheck.setEnabled(false);

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

