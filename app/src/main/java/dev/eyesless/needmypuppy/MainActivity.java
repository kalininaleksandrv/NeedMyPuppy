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
                newlogic.setFinalListOfBreed();
                newlogic.setReturnbreed();
                Intent resultintent = new Intent(MainActivity.this, BreedListActivity.class);
                ArrayList <String> temp = new ArrayList<String>(newlogic.getReturnbreed());
                resultintent.putExtra(BreedListActivity.EXTRA_MSG, temp);
                startActivity(resultintent);
            }
        });

        // код конпки "Надоело"
        Button luck_button = (Button) findViewById(R.id.button_block1);
        luck_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView chektext = (TextView) findViewById(R.id.opt_starttext);
                newlogic.bucket_changer();
                chektext.setText(newlogic.getBestchoise());
            }
        });



    };

}

    /*
TODO 4 Релизовать description-активность создаваемую по клику на списковой активности (5).
TODO 5 Реализовать фрагменты
TODO 6 В стартовую активность запилить форму "написать разработчику" с выбором приложеня e-mail
    */