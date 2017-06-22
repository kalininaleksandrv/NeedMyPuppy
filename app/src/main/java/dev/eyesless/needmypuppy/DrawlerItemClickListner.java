package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Eyesless on 22.05.2017.
 */

public class DrawlerItemClickListner extends MainActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout myDrawer;
    NavigationView myNaviView;
    MainActivity activity;
    InitiationActivity inact;
    

    public DrawlerItemClickListner(InitiationActivity inact, MainActivity activity, DrawerLayout myDrawer, NavigationView myNaviView) {
        super();


        this.myDrawer = myDrawer;
        this.myNaviView = myNaviView;
        this.activity = activity;
        this.inact = inact;
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//       selectItem (position);
//
//
//    }
//
//    private void selectItem(long position) {
//
//        switch ((int) position){
//
//            case 0:
//                activity.activitystarter(BreedViewer.class, null);
//                break;
//
//            case 1:
//                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
//                break;
//
//            case 2:
//                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
//                break;
//
//            default:
//                break;
//        }
//
//        myDrawer.closeDrawer(myNaviView);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.menu_navigation_find:
                activity.activitystarter(BreedViewer.class, null);
                break;
            case R.id.menu_navigation_mail:
                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
                break;
            case R.id.menu_navigation_about:
                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
                break;
            default:
                break;
        }

        myDrawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
