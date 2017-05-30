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


/**
 * A simple {@link Fragment} subclass.
 */
public class Forwhat_main extends Fragment {


   onButtonListner myButtonListner;

    private boolean show;
    private boolean frend;
    private boolean run;
    private boolean hunt;
    private boolean obidence;
    private boolean guard;


    public Forwhat_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (savedInstanceState != null) {
           show = savedInstanceState.getBoolean("show");
           frend = savedInstanceState.getBoolean("frend");
           run = savedInstanceState.getBoolean("run");
           hunt = savedInstanceState.getBoolean("hunt");
           obidence = savedInstanceState.getBoolean("obidence");
           guard = savedInstanceState.getBoolean("guard");
        }
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

                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);

        //подключаем чекбоксы

        CheckBox showcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt1);
        CheckBox frendcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt2);
        CheckBox runcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt3);
        CheckBox huntcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt4);
        CheckBox obidencecheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt5);
        CheckBox guardcheck = (CheckBox) parentview.findViewById(R.id.checkBox_opt6);

        //создаем слушатель

        View.OnClickListener myCheckboxOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checked = ((CheckBox) v).isChecked();

                switch (v.getId()) {

                    case R.id.checkBox_opt1:

                      if (checked) {show = true;
                      } else {
                          show = false;
                      }
                        break;

                    case R.id.checkBox_opt2:

                      if (checked) {frend = true;
                      } else {
                          frend = false;
                      }
                        break;

                    case R.id.checkBox_opt3:

                      if (checked) {run = true;
                      } else {
                          run = false;
                      }
                        break;

                    case R.id.checkBox_opt4:

                      if (checked) {hunt = true;
                      } else {
                          hunt = false;
                      }
                        break;

                    case R.id.checkBox_opt5:

                      if (checked) {obidence = true;
                      } else {
                          obidence = false;
                      }
                        break;

                    case R.id.checkBox_opt6:

                      if (checked) {guard = true;
                      } else {
                          guard = false;
                      }
                        break;
                }
            }
        };

        // TODO: 30.05.2017 упростить за счет считывания значений только в конце работы фрагмента (онлайн не нужен) 
        
        //привязываем слушатель к кнопкам

        showcheck.setOnClickListener(myCheckboxOnClickListner);
        frendcheck.setOnClickListener(myCheckboxOnClickListner);
        runcheck.setOnClickListener(myCheckboxOnClickListner);
        huntcheck.setOnClickListener(myCheckboxOnClickListner);
        obidencecheck.setOnClickListener(myCheckboxOnClickListner);
        guardcheck.setOnClickListener(myCheckboxOnClickListner);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // TODO: 30.05.2017 при упрощении сохранения значений не нужно при уничтожении активности все переменные считываются и передаются вовне 

        outState.putBoolean("show", show);
        outState.putBoolean("frend", frend);
        outState.putBoolean("run", run);
        outState.putBoolean("hunt", hunt);
        outState.putBoolean("obidence", obidence);
        outState.putBoolean("guard", guard);

    }



}
