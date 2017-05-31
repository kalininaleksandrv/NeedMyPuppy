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
                // myButtonListner.buttonClicked(v);
                // TODO: 31.05.2017 после создания инфраструктуры учета, открыть mybuttonlistner и убрать тосты
            }
        };
        completebutton.setOnClickListener(myOnClickListner);
    }

    // подключаем чекбоксы и передаем состояние

    public void checkboxReader (View view) {

        CheckBox showcheck = (CheckBox) view.findViewById(R.id.checkBox_opt1);
        CheckBox frendcheck = (CheckBox) view.findViewById(R.id.checkBox_opt2);
        CheckBox runcheck = (CheckBox) view.findViewById(R.id.checkBox_opt3);
        CheckBox huntcheck = (CheckBox) view.findViewById(R.id.checkBox_opt4);
        CheckBox obidencecheck = (CheckBox) view.findViewById(R.id.checkBox_opt5);
        CheckBox guardcheck = (CheckBox) view.findViewById(R.id.checkBox_opt6);

        if (showcheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "SHOW", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (frendcheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "FREND", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (runcheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "RUN", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (huntcheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "HUNT", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (obidencecheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "OBIDIENCE", Toast.LENGTH_SHORT);
            toast.show();
        }
        if (guardcheck.isChecked()){
            Toast toast = Toast.makeText(getContext(), "GUARD", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
