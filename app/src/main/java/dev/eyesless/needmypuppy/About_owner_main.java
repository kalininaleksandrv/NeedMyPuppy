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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

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

    private Spinner spiner_exp;
    private Spinner spiner_time;
    private Spinner spiner_age;
    private Spinner spiner_activ;
    private Spinner spiner_family;

    private View parentview;

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

        spiner_exp = (Spinner)layout.findViewById(R.id.spinner_exp);
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
        spiner_time = (Spinner)layout.findViewById(R.id.spinner_time);
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
        spiner_age = (Spinner)layout.findViewById(R.id.spinner_age);
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
        spiner_activ = (Spinner)layout.findViewById(R.id.spinner_activ);
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

        //код спиннера семья влияет ТОЛЬКО на значение активность
        spiner_family = (Spinner)layout.findViewById(R.id.spinner_family);
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

        parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        spinnerstatussetter ();

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inact.setButtonaboutownerispressed(true);

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

    //init spinners and set it disabled if re-entry

    private void spinnerstatussetter() {

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

    private void obidiencesetter() {

        inact.obidience.setValue(max(inact.obidience.getValue(),4-timevalue)); //установить послушание максимальное из (уже установленное, 4-значение временных затрат (т.е. чем меньше временные затраты тем больше послушание)
        inact.obidience.setValue(max(inact.obidience.getValue(),3-activvalue)); //установить послушание максимальное из (уже установленное, 4-значение активности (т.е. чем меньше активность тем больше послушание - важно! возраст и члени семьи влияют на активность прямо а на этот показатель соответственно опосредованно)
        if (expvalue >3){inact.obidience.setValue(min(inact.obidience.getValue(),3));} //если опыт ЭКСПЕРТ то уменьшить минимально допустимое послушание до 3, даже если ранее выставлено больше
        if (agevalue < 2) {inact.obidience.setValue(max(inact.obidience.getValue(),4));} //если возраст менее 16 лет то увеличить минимально допустимое послушание до 4, даже если ранее выставлено меньше, превалирует над ЭКСПЕРТ
    }

    private void guardsetter() {

        if (expvalue < 3 || timevalue < 2) { inact.guard.setValue(min(inact.guard.getValue(),4));} //если опыт хотя бы 2 ИЛИ временные затраты хотя бы 1 то допускается охранные качества 5 иначе не более 4
    }

    private void agressivesetter() {

        inact.agressive.setValue(min(inact.agressive.getValue(), timevalue+2)); //чем больше времени готовы тратить на собаку, тем более агрессивная порода допускается, но возвращается наименьшее возможное между уже установленным и рассчитанным
        inact.agressive.setValue(min(inact.agressive.getValue(), expvalue+1)); //чем больше опыть тем более агрессивная порода допускается, но возвращается наименьшее возможное между уже установленным и рассчитанным
        inact.agressive.setValue(min(inact.agressive.getValue(), activvalue+1)); //чем вы активнее, тем более агрессивная порода допускается, но возвращается наименьшее возможное между уже установленным и рассчитанным
        if (agevalue < 2) {inact.agressive.setValue(min(inact.agressive.getValue(),2));} //если возраст менее 16 лет то уменьшить максимально допустимую агрессивность до 2, даже если ранее выставлено больше

    }

    private void activsetter() {

        inact.active.setValue(max(inact.active.getValue(), timevalue+2)); //чем больше времени готовы тратить на собаку, тем более активная порода допускается
        inact.active.setValue(max(inact.active.getValue(), expvalue+1)); //чем больше опыть тем более активная порода допускается
        inact.active.setValue(max(inact.active.getValue(), activvalue+1)); //чем вы активнее, тем более активная порода допускается
    }

    private void sizesetter() {

        if (timevalue < 2 || expvalue < 2) { inact.size.setValue(min(inact.size.getValue(),4));} //если не на собаку готов тратить менее часа в день или опыта нет то размер не более 4
        if (agevalue < 2 || activvalue < 2) { inact.size.setValue(min(inact.size.getValue(),3));} //если возраст менее 16 или активность менее нормальной (для старшего возраста менее хорошей), то максимальный размер не более 3
    }

    private void caresetter() {

        if (timevalue > 1)inact.care.setValue(max(inact.care.getValue(),timevalue));//допускаются породы со специальным уходом при готовности временных затрат (значение 2 и 3)
        if (expvalue > 2)inact.care.setValue(max(inact.care.getValue(),expvalue +1));//при уровне экспертизы >2 допускаются собаки со сложным уходом (экспертиза +1)
    }

    // if button was pressed and trying next time, set toast about
    private void toastmaker() {
        String helpstring = getString(R.string.disabled_button_short);
        Toast myToast = Toast.makeText(getContext(), helpstring, Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 30);
        myToast.show();
    }

    //utilitarian getters and setters

    public int getActivvalue() {
        return activvalue;
    }

    public void setActivvalue(int activvalue) {
        this.activvalue = activvalue;
    }

}
