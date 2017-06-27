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
public class About_owner_main extends Buttons_Abstract_Fragment implements MVPInterface_aboutowner {

    private int expvalue;
    private int timevalue;
    private int agevalue;
    private int activvalue;
    private int familyvalue;

    private Spinner spiner_exp;
    private Spinner spiner_time;
    private Spinner spiner_age;
    private Spinner spiner_activ;
    private Spinner spiner_family;

    Presenter_aboutowner presenter;

     public About_owner_main() {
        // Required empty public constructor

         presenter = new Presenter_aboutowner(this);

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

        presenterinactsetter(inact);

        createspinner(spiner_exp, inact.getSpinner_exp_array());
        createspinner(spiner_time, inact.getSpinner_time_array());
        createspinner(spiner_age, inact.getSpinner_age_array());
        createspinner(spiner_activ, inact.getSpinner_activ_array());
        createspinner(spiner_family, inact.getSpinner_family_array());

        //код спиннера возраст ТОЛЬКО влияет только на значение активность if (position > 3){ setActivvalue(getActivvalue()-(-3+position));}

        //код спиннера семья влияет ТОЛЬКО на значение активность if (position == 4) {setActivvalue(getActivvalue()-1);}

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

    private void presenterinactsetter(InitiationActivity inact) {

        presenter.inactsetter(inact);

    }



    //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

    View.OnClickListener myOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            inact.obidienceincreaser(obidiencescond());
            inact.aggresivedecreaser(min(expvalue+1, min(timevalue+2, agressivecon()))); //минимальное значение из если прямой зависимости от опыта и времени, возраст менее 16 лет то уменьшить максимально допустимую агрессивность до 2, даже если ранее выставлено больше
            inact.activeincreaser(max(activvalue+1, max(expvalue+1, timevalue+2))); //чем больше времени готовы тратить на собаку, тем более активная порода допускается, чем больше опыть тем более активная порода допускается, чем вы активнее, тем более активная порода допускается
            inact.sizedecreaser(sizecon());
            inact.caredecreaser(min(timevalue+1, expvalue +1));// обратная зависимость от совободного времени и экспертизы

            valuereader();

            myButtonListner.buttonClicked(v);

        }
    };

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

                    case (R.id.spinner_exp):
                        expvalue = position;
                        break;

                    case (R.id.spinner_time):
                        timevalue = position;
                        break;

                    case (R.id.spinner_age):

                        agevalue = position;
                        break;

                    case (R.id.spinner_activ):

                        activvalue = position;
                        break;

                    case (R.id.spinner_family):

                        familyvalue = position;
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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




    @Override
    public int isexp() {
        return expvalue;
    }

    @Override
    public int istime() {
        return timevalue;
    }

    @Override
    public int isage() {
        return agevalue;
    }

    @Override
    public int isactive() {
        return activvalue;
    }

    @Override
    public int isfamily() {
        return familyvalue;
    }


    private void valuereader() {
        presenter.valuereader();
    }

}
