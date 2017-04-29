package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Main_logic newlogic = new Main_logic();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //код конопки "какая собака подходит вам"

        Button dog_to_you_button = (Button) findViewById(R.id.button_block1);
        dog_to_you_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_new_block = new Intent(MainActivity.this, About_owner.class);

                startActivity(start_new_block);

            }
        });

        //код конопки "какой собаке подходите вы"

        Button you_to_dog_button = (Button) findViewById(R.id.button_block2);
        you_to_dog_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent start_new_block = new Intent(MainActivity.this, Infrastructure.class);

                startActivity(start_new_block);

            }
        });

        Button happy_minutes_button  = (Button) findViewById(R.id.button_block3);
        happy_minutes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_new_block = new Intent(MainActivity.this, For_what.class);

                startActivity(start_new_block);

            }
        });



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

    };

}

    /*
TODO 4 Релизовать description-активность создаваемую по клику на списковой активности (5).
TODO 5 Реализовать фрагменты
TODO 6 В стартовую активность запилить форму "написать разработчику" с выбором приложеня e-mail
    */