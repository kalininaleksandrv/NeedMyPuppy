package dev.eyesless.needmypuppy;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

public class InitiationActivity extends Application {

    private String [] spinner_exp_array = {"есть ли опыт содержания и воспитания собак?",
            "нет опыта", "опыт минимальный", "я довольно опытный", "эксперт"};

    private String [] spinner_time_array = {"cколько времени готов тратить на собаку?",
            "не более 1 часа в день", "не более 2-3 часов в день", "все свободное время"};

    private String [] drawer_titles = {"сохранить ответы",
            "загрузить ответы", "написать разработчику"};

    public String[] getSpinner_exp_array() {
        return spinner_exp_array;
    }

    public String[] getSpinner_time_array() {
        return spinner_time_array;
    }

    public String[] getDrawer_titles() { return drawer_titles; }

    MyBucket obidience = new MyBucket(getString(R.string.obidience), 1);
    MyBucket guard = new MyBucket(getString(R.string.guard), 1);

// TODO: 31.05.2017 make agressive, active, size

    ArrayList<MyBucket> mybuckelisttmaker () {

        ArrayList<MyBucket> mybusketslist = new ArrayList<>();

        mybusketslist.add(obidience);
        mybusketslist.add(guard);

        return mybusketslist;
    }

}
