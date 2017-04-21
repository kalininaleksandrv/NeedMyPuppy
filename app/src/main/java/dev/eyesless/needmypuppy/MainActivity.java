package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {

    Main_logic newlogic = new Main_logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // код кнопки "Дальше"
        Button go_button = (Button) findViewById(R.id.button_opt2);
        go_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newlogic.setReturnbreed();
                Intent resultintent = new Intent(MainActivity.this, Resultactivity.class);
                ArrayList <String> temp = new ArrayList<String>(newlogic.getReturnbreed());
                resultintent.putExtra(Resultactivity.EXTRA_MSG, temp);
                startActivity(resultintent);
            }
        });

        // код конпки "Надоело"
        Button luck_button = (Button) findViewById(R.id.button_opt1);
        luck_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView chektext = (TextView) findViewById(R.id.opt_starttext);
                newlogic.bucket_changer();
                chektext.setText(newlogic.getBestchoise());
            }
        });

        // код свитча была ли собака
        SwitchCompat opt_switch = (SwitchCompat) findViewById(R.id.opt_switch);
        opt_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                newlogic.setOpt_switch_temp(isChecked);
            }
        });

        // код спиннера про опыт с адаптером на массив в классе Data,
        // кастомное представление list_item
        Spinner spiner_exp = (Spinner) findViewById(R.id.spinner_exp);

        ArrayAdapter<String> spiner_exp_adapter = new ArrayAdapter<String>
                (this, R.layout.list_item, Data.spinner_exp_array);
        spiner_exp.setAdapter(spiner_exp_adapter);
        spiner_exp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              newlogic.setExp_level(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newlogic.setExp_level(0);
            }
        });

        // код спиннера про располагаемое время без адаптера, т.е. значения из values-string
                Spinner spiner_time = (Spinner) findViewById(R.id.spinner_time);
        spiner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newlogic.setTime_level(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newlogic.setTime_level(0);
            }
        });
    };

    // код чекбоксов про использование собаки
    public void onCheckboxClicked(View view) {

        CheckBox opt_checkfield = (CheckBox) view;

        boolean checked = opt_checkfield.isChecked();

        switch(view.getId()) {
            case R.id.checkBox_opt1:
                newlogic.setShow_flag_bool(checked);
                break;
            case R.id.checkBox_opt2:
                newlogic.setCompany_flag_bool(checked);
                break;
            case R.id.checkBox_opt3:
                newlogic.setRunning_flag_bool(checked);
                break;
            case R.id.checkBox_opt4:
                newlogic.setTracking_flag_bool(checked);
                break;
        }
    }

}

    /*

TODO 2 Реализовать перебор коллекции с формированием выходных  записей в новый массив (пока без логики)
TODO 4 Релизовать description-активность создаваемую по клику на списковой активности (5).
TODO 5 Реализовать фрагменты
TODO 6 Встартовую активность запилить форму "написать разработчику" с выбором приложеня e-mail



    */