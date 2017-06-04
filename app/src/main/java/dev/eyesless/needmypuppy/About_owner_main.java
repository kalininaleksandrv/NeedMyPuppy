package dev.eyesless.needmypuppy;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.StrictMath.abs;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_owner_main extends Fragment {


    onButtonListner myButtonListner;
    private InitiationActivity inact;
    private int expvalue;
    private int timevalue;
    private int agevalue;



    private int activvalue;
    private int familyvalue;

    public About_owner_main() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        inact = ((InitiationActivity) getActivity().getApplicationContext());
        View layout = inflater.inflate(R.layout.about_owner_main, container, false);

        //код спиннера опыт

        Spinner spiner_exp = (Spinner)layout.findViewById(R.id.spinner_exp);
        ArrayAdapter<String> spiner_exp_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_exp_array());
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

        Spinner spiner_time = (Spinner)layout.findViewById(R.id.spinner_time);
        ArrayAdapter<String> spiner_time_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_time_array());
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

        Spinner spiner_age = (Spinner)layout.findViewById(R.id.spinner_age);
        ArrayAdapter<String> spiner_age_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_age_array());
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

        Spinner spiner_activ = (Spinner)layout.findViewById(R.id.spinner_activ);
        ArrayAdapter<String> spiner_activ_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_activ_array());
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
        //код спиннера семья влияет только на значение активность

        Spinner spiner_family = (Spinner)layout.findViewById(R.id.spinner_family);
        ArrayAdapter<String> spiner_family_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_family_array());
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

        final View parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                obidiencesetter();
                guardsetter ();
                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

    private void guardsetter() {

        if (expvalue < 3 && timevalue < 2) { inact.guard.setValue(min(inact.guard.getValue(),4));} //если опыт хотя бы 2 ИЛИ временные затраты хотя бы 1 то допускается охранные качества 5 иначе не более 4

    }

    private void obidiencesetter() {

        inact.obidience.setValue(max(inact.obidience.getValue(),4-timevalue)); //установить послушание максимальное из (уже установленное, 4-значение временных затрат (т.е. чем меньше временные затраты тем больше послушание)
        inact.obidience.setValue(max(inact.obidience.getValue(),5-activvalue)); //установить послушание максимальное из (уже установленное, 4-значение активности (т.е. чем меньше активность тем больше послушание - важно! возраст и члени семьи влияют на активность прямо а на этот показатель соответственно опосредованно)
        if (expvalue >3){inact.obidience.setValue(min(inact.obidience.getValue(),3));} //если опыт ЭКСПЕРТ то уменьшить минимально допустимое послушание до 3, даже если ранее выставлено больше
        if (agevalue < 2) {inact.obidience.setValue(max(inact.obidience.getValue(),4));} //если возраст менее 16 лет то увеличить минимально допустимое послушание до 4, даже если ранее выставлено меньше, превалирует над ЭКСПЕРТ

    }


    public int getActivvalue() {
        return activvalue;
    }

    public void setActivvalue(int activvalue) {
        this.activvalue = activvalue;
    }

}
