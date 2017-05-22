package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Eyesless on 22.05.2017.
 */

public class DrawlerItemClickListner extends MainActivity implements ListView.OnItemClickListener {

    android.support.v7.app.ActionBar myBar;
    String[] titles;
    DrawerLayout myDrawer;
    ListView myDrawerList;


    public DrawlerItemClickListner(ActionBar myBar, DrawerLayout myDrawer, ListView myDrawerList, String[] titles) {
        super();

        this.myBar = myBar;
        this.titles = titles;
        this.myDrawer = myDrawer;
        this.myDrawerList = myDrawerList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        selectItem (id, this.myBar);

    }

    private void selectItem(long id, android.support.v7.app.ActionBar abar) {

        abar.setTitle(titles[(int) id]);

        switch ((int) id){

            case 0:
                // TODO: 22.05.2017 реализовать сохранение ответов
                break;
            case 1:
                // TODO: 22.05.2017 реализовать загрузку ответов
                break;
            case 2:
                // TODO: 22.05.2017 реализовать письмо разработчикам
                break;
            default:
                break;

        }

        myDrawer.closeDrawer(myDrawerList);

    }
}
