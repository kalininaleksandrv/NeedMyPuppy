package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Eyesless on 22.05.2017.
 */

public class DrawlerItemClickListner extends MainActivity implements ListView.OnItemClickListener {

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       selectItem (position);


    }

    private void selectItem(long position) {

        switch ((int) position){

            case 0:
                activity.activitystarter(BreedViewer.class, null);
                break;

            case 1:
                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
                break;

            case 2:
                activity.activitystarter(List_profile.class, inact.mybuckelisttmaker());
                break;

            default:
                break;
        }

        myDrawer.closeDrawer(myNaviView);
    }

}
