package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class Infrastructure extends AppCompatActivity {



    private boolean opt_switch_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infrastructure);

        // код свитча есть ли собака
        SwitchCompat opt_switch = (SwitchCompat) findViewById(R.id.opt_switch);
        opt_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setOpt_switch_temp(isChecked);
            }
        });

        //кнопка готово

        Button complete_button = (Button) findViewById(R.id.button_complete);
        complete_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Data.is_about_structure = true;

                Intent start_new_block = new Intent(Infrastructure.this, MainActivity.class);
                startActivity(start_new_block);

            }
        });


    }

    public void setOpt_switch_temp(boolean opt_switch_temp) {
        this.opt_switch_temp = opt_switch_temp;
    }
}
