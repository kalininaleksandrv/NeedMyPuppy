package dev.eyesless.needmypuppy;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //код конопки "какая собака подходит вам"

        Button dog_to_you_button = (Button) findViewById(R.id.button_block1);
        ImageView dog_to_you_image = (ImageView) findViewById(R.id.dog_to_you_image);
        if (Data.is_about_owner) dog_to_you_image.setImageResource(R.drawable.ic_check_green_36dp);
        else dog_to_you_image.setImageResource(R.drawable.ic_warning_yello_36dp);


        dog_to_you_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent start_new_block = new Intent(MainActivity.this, About_owner.class);

                startActivity(start_new_block);

            }
        });

        //код конопки "какой собаке подходите вы"

        Button you_to_dog_button = (Button) findViewById(R.id.button_block2);
        ImageView you_to_dog_image = (ImageView) findViewById(R.id.you_to_dog_image);
        if (Data.is_about_structure) you_to_dog_image.setImageResource(R.drawable.ic_check_green_36dp);
        else you_to_dog_image.setImageResource(R.drawable.ic_warning_yello_36dp);

        you_to_dog_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent start_new_block = new Intent(MainActivity.this, Infrastructure.class);
                startActivity(start_new_block);

            }
        });

        Button happy_minutes_button  = (Button) findViewById(R.id.button_block3);
        ImageView infrastr_image = (ImageView) findViewById(R.id.infrastructure_image);
        if (Data.is_for_what) infrastr_image.setImageResource(R.drawable.ic_check_green_36dp);
        else infrastr_image.setImageResource(R.drawable.ic_warning_yello_36dp);

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
                Main_logic newlogic = new Main_logic();
                newlogic.setFinalListOfBreed();
                newlogic.setReturnbreed();
                Intent resultintent = new Intent(MainActivity.this, BreedDescriptionActivity_frag.class);
                startActivity(resultintent);
            }
        });

    };

    //создаем  action-menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);

        return super.onCreateOptionsMenu(menu);
    }


    //слушатель для меню

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_saveoptions:
                //do something
                return true;
            case R.id.action_email:
                //do something
                return true;
            case R.id.action_settings:
                //do something
                return true;
            case R.id.action_delet:
                //do something
                return true;

          default: return super.onOptionsItemSelected(item);
        }


    }
}

    /*
TODO 6 В стартовую активность запилить форму "написать разработчику" с выбором приложеня e-mail
todo 8 реализовать класс Application для хранения данных (пояснение: aplication это по сути реалтизация патерна
todo 8 singleton - когда создаешь объекты они не вызывают чей нибудь статический getInstance а ты им передаешь
todo 8 экземпляр в конструктор, т.е. они не опираются на какой о конкретный синглтон)
todo 9 при повороте экрана не сохраняются выбранные значения в детализирующих активностях
todo 10 на 6.0 нет вариантов share
todo 11 на 6.0. нет картинок ОК в landscape
    */