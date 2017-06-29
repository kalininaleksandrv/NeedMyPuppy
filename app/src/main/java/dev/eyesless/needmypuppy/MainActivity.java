package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements onButtonListner, ItemClickListner {


    private String [] titles;
    private DrawerLayout drawer;
    private NavigationView naview;
    private Toolbar mytoolbar;
    private ActionBarDrawerToggle drawerToggle;
    private InitiationActivity inact;
    private static int THISLAYOUT = R.layout.activity_main;
    protected Guideline myGuideline;
    protected ConstraintLayout.LayoutParams lp;
    public static String GUIDLINE_VALUE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(THISLAYOUT);

        inact = ((InitiationActivity) getApplicationContext());

        initguidline ();

        //call main fragmett if never call before
        if (savedInstanceState == null) {
            frameRemoover(new Buttons_main());
        }

        //restore guidline value if re-create fragment
        if (savedInstanceState != null){
            onRestoreGuidlineValue(savedInstanceState);
        }

        //код diwider-а
        initNavigationView ();
        inittoolbar();
        initDrawerTogle ();


        drawer.addDrawerListener(drawerToggle);

        // TODO: 28.06.2017 реализовать наполнение frame vision 

    }


    // create navigation view on drawer layout and set listner
    private void initNavigationView() {

        drawer = (DrawerLayout) findViewById(R.id.drawer_main);
        naview = (NavigationView) findViewById(R.id.navigation_view);
        naview.getMenu().clear();
        naview.inflateMenu(R.menu.menu_navigation);
        naview.inflateHeaderView(R.layout.navigation_header);

        DrawlerItemClickListner myDrawlerListner = new DrawlerItemClickListner
                (inact, this, drawer, naview);
        naview.setNavigationItemSelectedListener(myDrawlerListner);
    }

    //create custom toolbar
    private void inittoolbar() {

        mytoolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mytoolbar);
    }

    //код Drawer Togle кнопка выдвижения и задвижения drawer-а
    private ActionBarDrawerToggle initDrawerTogle() {

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

        return drawerToggle;
    }

    //init guidline

    private void initguidline() {
        myGuideline = (Guideline) findViewById(R.id.guideline2);
        lp = (ConstraintLayout.LayoutParams) myGuideline.getLayoutParams();
    }

    //save guidline value
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        //saved current value of guidline
        float f = lp.guidePercent;
        savedInstanceState.putFloat(GUIDLINE_VALUE, f);
        Log.w("MY_TAG", "save guideline value");
        super.onSaveInstanceState(savedInstanceState);
    }

    //restore saved value of guideline to correct work with recycle view
    public void onRestoreGuidlineValue (Bundle savedInstanceState){

        lp.guidePercent = savedInstanceState.getFloat(GUIDLINE_VALUE);
        myGuideline.setLayoutParams(lp);
        Log.w("MY_TAG", "restore guideline value");
    }

    //set a guidline value to change screen proportions depend on content
    public void gudlinesetter (Float f) {

        Guideline dragview = (Guideline) findViewById(R.id.guideline2);
        ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) dragview.getLayoutParams();
        lp.guidePercent = f;
        dragview.setLayoutParams(lp);

    }

    //create  action-menu
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
                        activitystarter(List_profile.class, inact.mybuckelisttmaker());
                        return true;

                    case R.id.action_settings:
                        //todo реализовать настройки
                        databaseinitiator();
                        activitystarter(List_profile.class, inact.getListOfTitles());
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

            case R.id.imageButton_morpho:
                if (inact.isButtonmorphoispressed()){toastmaker();}
                else
                frameRemoover(new Fragment_morpho());
                break;

            case R.id.button_gonext:

                databaseinitiator();

                frameRemoover(new Recycle_view_fragment());

                break;
        }
    }

    //onClick to get data (position) from RecycleView's CardView and show appropriate breed in Fragment Description
    @Override
    public void onClick(View view, int position) {

        ArrayList<Breed_mod> breeds = inact.getMyListOfBreed_m();

        Fragment_viewpager myViewPagerFragm = new Fragment_viewpager();
        myViewPagerFragm.setBreedId(position);

        frameRemoover(myViewPagerFragm);

    }

    // tis method start new activitys, including second optional parameter - arraylist, if null just ignored, if not null - put on intent
    public void activitystarter(Object o, ArrayList<?> al) {

        Intent intent = new Intent(this, (Class<?>) o);

        if (al != null) {
            intent.putExtra(List_profile.LIST, al);
        }
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

    //init database if it does not
    public void databaseinitiator(){

        if (inact.isDataBaseCreated() == false) {

            BreedDataBaseCreator myDataCreator = new BreedDataBaseCreator(this, inact);
            myDataCreator.databasecreator();
            myDataCreator.onCreateDb(null);
            inact.setListOfTitles();
        }
    }

}
