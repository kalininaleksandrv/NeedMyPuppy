package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class About_owner extends AppCompatActivity {

    private int exp_level;
    private int time_level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_owner);

        //получаем контекст инициирующей активности чтобы обратиться к методам, устанавливающим спиннеры
        InitiationActivity inact = ((InitiationActivity) getApplicationContext());
        Log.w("MY_TAG", "About_owner");


        // код спиннера про опыт с адаптером на массив в классе Data,
        // кастомное представление list_item
        Spinner spiner_exp = (Spinner) findViewById(R.id.spinner_exp);
        ArrayAdapter<String> spiner_exp_adapter = new ArrayAdapter<String>
                (this, R.layout.list_item, inact.getSpinner_exp_array());
        spiner_exp.setAdapter(spiner_exp_adapter);
        spiner_exp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setExp_level(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                setExp_level(0);
            }
        });

        // код спиннера про располагаемое время
        // кастомное представление list_item
        Spinner spiner_time = (Spinner) findViewById(R.id.spinner_time);

        ArrayAdapter<String> spiner_time_adapter = new ArrayAdapter<String>
                (this, R.layout.list_item, inact.getSpinner_time_array());
        spiner_time.setAdapter(spiner_time_adapter);


        spiner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setTime_level(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                setTime_level(0);
            }
        });

        //код кнопки готово

        Button complete_button = (Button) findViewById(R.id.button_complete);
        complete_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Data.is_about_owner = true;

                Intent start_new_block = new Intent(About_owner.this, MainActivity.class);
                startActivity(start_new_block);

            }
        });

    }

    // сеттеры для запоминания значений спиннеров
    public void setExp_level(int exp_level) {
        this.exp_level = exp_level;
    }

    public void setTime_level(int time_level) {
        this.time_level = time_level;
    }
}
