package dev.eyesless.needmypuppy;

import android.animation.ObjectAnimator;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements onButtonListner {


    private String [] titles;
    private ListView drawerList;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;
    private InitiationActivity inact;
    private static int THISLAYOUT = R.layout.activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(THISLAYOUT);

        inact = ((InitiationActivity) getApplicationContext());
        //код diwider-а

        titles = inact.getDrawer_titles();
        drawerList = (ListView) findViewById(R.id.list_drawer_main);
        drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, titles));
        DrawlerItemClickListner myDrawlerListner = new DrawlerItemClickListner
                (this, drawer, drawerList, titles);
        drawerList.setOnItemClickListener(myDrawlerListner);

        //код Drawer Togle кнопка выдвижения и задвижения drawer-а

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_closed){

            public void onDrawerClosed (View v) {
                super.onDrawerClosed(v);
            }

            public void onDrawerOpened (View v) {
                super.onDrawerOpened(v);
            }

        };

        drawer.addDrawerListener(drawerToggle);

        //вызов основного фрагмента

        if (savedInstanceState == null) {

            frameRemoover(new Buttons_main());
        }
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

        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
                switch (item.getItemId()) {

                    case R.id.action_email:
                        //todo реализовать отправку списка порорд по e-mail
                        activitystarter(List_profile.class);

                        return true;

                    case R.id.action_settings:
                        //todo реализовать настройки
                        return true;

                    case R.id.action_delet:
                        //deliting all choosing parameters ant set buttons status NOT pressed
                        inact.bucketseraser();
                        return true;

                    default:
                        return super.onOptionsItemSelected(item);
                }

    }

    //реакция на нажате кнопок в фрагменте buttons main

    @Override
    public void buttonClicked(View v) {

        switch (v.getId()){
            case R.id.button_complete:
                frameRemoover(new Buttons_main());
                break;

            case R.id.imageButton_aboutowner:
                //check if button already been pressed, cant pressed next time
                if (inact.isButtonaboutownerispressed()){toastmaker();}
                else
                frameRemoover(new About_owner_main());
                break;

            case R.id.imageButton_forwhat:
                //check if button already been pressed, cant pressed next time
                if (inact.isButtonforwhatispressed()){toastmaker();}
                else
                    frameRemoover(new Forwhat_main());
                break;

            case R.id.imageButton_aboutdog:
                if (inact.isButtonaboutdogispressed()){toastmaker();}
                else
                frameRemoover(new About_dog_main());
                break;

            case R.id.button_gonext:
                Main_logic newlogic = new Main_logic();
                newlogic.setFinalListOfBreed();
                newlogic.setReturnbreed();
                Intent resultintent = new Intent(MainActivity.this, BreedDescriptionActivity_frag.class);
                startActivity(resultintent);
                break;
        }
    }

    // tis method start new activitys, including by external call of DrawerListner

    public void activitystarter(Object o) {

        Intent intent = new Intent(this, (Class<?>) o);
        startActivity(intent);

    }

    //main method for remoove frames when clicked
    public void frameRemoover (Fragment fragment){

        android.support.v4.app.FragmentTransaction fratramain = getSupportFragmentManager().beginTransaction();
        fratramain.replace(R.id.replaced_main, fragment);
        fratramain.addToBackStack(null);
        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratramain.commit();

    }

    // if button was pressed and trying next time, set toast about
    public void toastmaker() {
        String helpstring = getString(R.string.disabled_button);
        Toast myToast = Toast.makeText(getApplicationContext(), helpstring, Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 30);
        myToast.show();
    }
}

    /*
todo 8 реализовать класс Application для хранения данных (пояснение: aplication это по сути реалтизация патерна
todo 8 singleton - когда создаешь объекты они не вызывают чей нибудь статический getInstance а ты им передаешь
todo 8 экземпляр в конструктор, т.е. они не опираются на какой о конкретный синглтон)
todo 11 реализовать слушатели для чекбоксов, спиннеров и т.п.
todo 13 реализовать recycle view вместо listview для 5.0 +

    */