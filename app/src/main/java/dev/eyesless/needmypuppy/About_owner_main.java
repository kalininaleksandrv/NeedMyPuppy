package dev.eyesless.needmypuppy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static java.lang.Math.max;
import static java.lang.Math.min;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_owner_main extends Buttons_Abstract_Fragment {

    private int expvalue;
    private int timevalue;
    private int agevalue;
    private int activvalue;

    private Spinner spiner_exp;
    private Spinner spiner_time;
    private Spinner spiner_age;
    private Spinner spiner_activ;
    private Spinner spiner_family;

     public About_owner_main() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.about_owner_main, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();

        spinnerstatussetter ();

        //код спиннера опыт

        ArrayAdapter<String> spiner_exp_adapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_exp_array());
        spiner_exp.setAdapter(spiner_exp_adapter);
        spiner_exp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                expvalue = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //код спиннера время
        ArrayAdapter<String> spiner_time_adapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_time_array());
        spiner_time.setAdapter(spiner_time_adapter);
        spiner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timevalue = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //код спиннера возраст ТОЛЬКО влияет только на значение активность
        ArrayAdapter<String> spiner_age_adapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_age_array());
        spiner_age.setAdapter(spiner_age_adapter);
        spiner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                agevalue = position;
                if (position > 3){ setActivvalue(getActivvalue()-(-3+position));}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //код спиннера активность
        ArrayAdapter<String> spiner_activ_adapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_activ_array());
        spiner_activ.setAdapter(spiner_activ_adapter);
        spiner_activ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setActivvalue(getActivvalue()+position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //код спиннера семья влияет ТОЛЬКО на значение активность
        ArrayAdapter<String> spiner_family_adapter = new ArrayAdapter<String>
                (getContext(), R.layout.list_item, inact.getSpinner_family_array());
        spiner_family.setAdapter(spiner_family_adapter);
        spiner_family.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 4) {setActivvalue(getActivvalue()-1);}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inact.setButtonaboutownerispressed(true);

                inact.obidienceincreaser(obidiencescond());
                inact.aggresivedecreaser(min(expvalue+1, min(timevalue+2, agressivecon()))); //минимальное значение из если прямой зависимости от опыта и времени, возраст менее 16 лет то уменьшить максимально допустимую агрессивность до 2, даже если ранее выставлено больше
                inact.activeincreaser(max(activvalue+1, max(expvalue+1, timevalue+2))); //чем больше времени готовы тратить на собаку, тем более активная порода допускается, чем больше опыть тем более активная порода допускается, чем вы активнее, тем более активная порода допускается
                inact.sizedecreaser(sizecon());
                inact.caredecreaser(min(timevalue+1, expvalue +1));// обратная зависимость от совободного времени и экспертизы


                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

    //init spinners and set it disabled if re-entry

    private void spinnerstatussetter() {

        spiner_exp = (Spinner)parentview.findViewById(R.id.spinner_exp);
        spiner_time = (Spinner)parentview.findViewById(R.id.spinner_time);
        spiner_age = (Spinner)parentview.findViewById(R.id.spinner_age);
        spiner_activ = (Spinner)parentview.findViewById(R.id.spinner_activ);
        spiner_family = (Spinner)parentview.findViewById(R.id.spinner_family);

        if (inact.isButtonaboutownerispressed()) {

            toastmaker();

            spiner_exp.setEnabled(false);
            spiner_time.setEnabled(false);
            spiner_age.setEnabled(false);
            spiner_activ.setEnabled(false);
            spiner_family.setEnabled(false);
        }

    }

    //main logic - setting different parameters on Initiation Activity
    private int obidiencescond() {

        int i = max(4-timevalue, 3-activvalue); //чем меньше времени тем выше должно быть послушание породы, чем меньше активность тем выше послушание породы
        if (expvalue >3) i= 3; //если опыт ЭКСПЕРТ то уменьшить минимально допустимое послушание до 3, даже если ранее выставлено больше
        if (agevalue < 2)i= 4; //если возраст менее 16 лет то увеличить минимально допустимое послушание до 4, даже если ранее выставлено меньше, превалирует над ЭКСПЕРТ

        return i;
    }

    private int agressivecon() {
     if (agevalue < 2) {return 2;} //если возраст менее 16 лет то уменьшить максимально допустимую агрессивность до 2, даже если ранее выставлено больше
         else {

         if (expvalue < 3 || timevalue < 2) {return 3;} //если опыт хотя бы 2 ИЛИ временные затраты хотя бы 1 то допускается агрессивность 3
     }
         return 5;
    }

    private int sizecon() {
        int i;
        { inact.size.setValue(min(inact.size.getValue(),4));}
        if (agevalue < 2 || activvalue < 2) { i = 3;} //если возраст менее 16 или активность менее нормальной (для старшего возраста менее хорошей), то максимальный размер не более 3
        else {
            if (timevalue < 2 || expvalue < 2) {i = 4;} //если не на собаку готов тратить менее часа в день или опыта нет то размер не более 4
            else i = 5;
        }
        return i;
    }

    //utilitarian getters and setters

    public int getActivvalue() {
        return activvalue;
    }

    public void setActivvalue(int activvalue) {
        this.activvalue = activvalue;
    }

}
