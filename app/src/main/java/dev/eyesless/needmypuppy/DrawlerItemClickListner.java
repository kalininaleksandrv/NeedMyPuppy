package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Eyesless on 22.05.2017.
 */

public class DrawlerItemClickListner extends MainActivity implements ListView.OnItemClickListener {

    android.support.v7.app.ActionBar myBar;
    String[] titles;
    DrawerLayout myDrawer;
    ListView myDrawerList;
    MainActivity activity;
    InitiationActivity inact;
    

    public DrawlerItemClickListner(InitiationActivity inact, MainActivity activity, DrawerLayout myDrawer, ListView myDrawerList, String[] titles) {
        super();

        this.titles = titles;
        this.myDrawer = myDrawer;
        this.myDrawerList = myDrawerList;
        this.activity = activity;
        this.inact = inact;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       selectItem (id);


    }

    private void selectItem(long id) {

        switch ((int) id){

            case 0:
                activity.activitystarter(BreedViewer.class, null);
                break;

            case 1:
                ArrayList<MyBucket> myList = inact.mybuckelisttmaker();
                activity.activitystarter(List_profile.class, myList);
                break;

            case 2:
//                Main_logic newlogic = new Main_logic();
//                newlogic.setFinalListOfBreed();
//                newlogic.setReturnbreed();
//                ArrayList<String> myStringList = Main_logic.finalListOfBreedTitles;

//                ArrayList<String> myStringList = inact.getListOfTitles();
//                activity.activitystarter(List_profile.class, myStringList);
                break;

            default:
                break;
        }

        myDrawer.closeDrawer(myDrawerList);
    }

}
