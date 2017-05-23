package dev.eyesless.needmypuppy;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    private String [] titles;
    private ListView drawerList;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //код diwider-а

        InitiationActivity inact = ((InitiationActivity) getApplicationContext());

        titles = inact.getDrawer_titles();
        drawerList = (ListView) findViewById(R.id.list_drawer_main);
        drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, titles));
        DrawlerItemClickListner myDrawlerListner = new DrawlerItemClickListner
                (getSupportActionBar(), drawer, drawerList, titles);
        drawerList.setOnItemClickListener(myDrawlerListner);

        //код Drawer Togle (кнопка выдвижения и задвижения drawer-а)

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

        drawer.setDrawerListener(drawerToggle);
        // TODO: 22.05.2017 разобраться с deprecated

        //вызов основного фрагмента

        Fragment_main newFragmentMain = new Fragment_main();
        FragmentTransaction fratramain = getFragmentManager().beginTransaction();
        fratramain.replace(R.id.frame_main, newFragmentMain);
        fratramain.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratramain.commit();


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
                        return true;
                    case R.id.action_settings:
                        //todo реализовать настройки
                        return true;
                    case R.id.action_delet:
                        //todo реализовать обнуление ответов
                        return true;

                    default:
                        return super.onOptionsItemSelected(item);
                }


    }

}

    /*
todo 8 реализовать класс Application для хранения данных (пояснение: aplication это по сути реалтизация патерна
todo 8 singleton - когда создаешь объекты они не вызывают чей нибудь статический getInstance а ты им передаешь
todo 8 экземпляр в конструктор, т.е. они не опираются на какой о конкретный синглтон)
todo 9 при повороте экрана не сохраняются выбранные значения в детализирующих активностях
todo 11 на 6.0. нет картинок ОК в landscape
todo 12 сделать кнопки на mainactivity рабочими точнее перевести контент мэйнактивити во фрагмент
    */