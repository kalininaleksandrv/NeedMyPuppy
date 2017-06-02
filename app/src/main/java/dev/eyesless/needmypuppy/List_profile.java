package dev.eyesless.needmypuppy;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class List_profile extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InitiationActivity inact = ((InitiationActivity) getApplicationContext());

        ListView listBuskets = getListView();

        ArrayList<MyBucket> newlist = inact.mybuckelisttmaker();

        MyCustomAdapter bucketadapter = new MyCustomAdapter(this, R.layout.list_item_doubletext, newlist);

        listBuskets.setAdapter(bucketadapter);
    }
}
