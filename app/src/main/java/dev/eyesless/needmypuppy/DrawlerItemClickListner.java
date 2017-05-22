package dev.eyesless.needmypuppy;


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


    public DrawlerItemClickListner(ActionBar myBar, String[] titles) {
        super();

        this.myBar = myBar;
        this.titles = titles;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        selectItem (id, this.myBar);

    }

    private void selectItem(long id, android.support.v7.app.ActionBar abar) {

        abar.setTitle(titles[(int) id]);

        switch ((int) id){

            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;

        }

    }
}
