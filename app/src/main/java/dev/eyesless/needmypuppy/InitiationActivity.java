package dev.eyesless.needmypuppy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class InitiationActivity extends Application {



    private String [] spinner_exp_array = {"есть ли опыт содержания и воспитания собак?",
            "нет опыта", "опыт минимальный", "я довольно опытный", "эксперт"};

    private String [] spinner_time_array = {"cколько времени готов тратить на собаку?",
            "не более 1 часа в день", "не более 2-3 часов в день", "все свободное время"};

    @Override
    public void onCreate() {

        super.onCreate();

        Log.w("MY_TAG", "InitiationActivity");

    }

    public String[] getSpinner_exp_array() {
        return spinner_exp_array;
    }

    public String[] getSpinner_time_array() {
        return spinner_time_array;
    }
}
