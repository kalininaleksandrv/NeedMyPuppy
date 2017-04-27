package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class For_what extends AppCompatActivity {


    private boolean Show_flag_bool;
    private boolean Company_flag_bool;
    private boolean Running_flag_bool;
    private boolean Tracking_flag_bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_what);

        //tODO сделать подсказку возможно выбрать любое количество вариантов


    }

    // код чекбоксов про использование собаки
    public void onCheckboxClicked(View view) {

        CheckBox opt_checkfield = (CheckBox) view;

        boolean checked = opt_checkfield.isChecked();

        switch(view.getId()) {
            case R.id.checkBox_opt1:
                setShow_flag_bool(checked);
                break;
            case R.id.checkBox_opt2:
                setCompany_flag_bool(checked);
                break;
            case R.id.checkBox_opt3:
                setRunning_flag_bool(checked);
                break;
            case R.id.checkBox_opt4:
                setTracking_flag_bool(checked);
                break;
        }
    }

    public void setShow_flag_bool(boolean show_flag_bool) {
        Show_flag_bool = show_flag_bool;
    }

    public void setCompany_flag_bool(boolean company_flag_bool) {
        Company_flag_bool = company_flag_bool;
    }

    public void setRunning_flag_bool(boolean running_flag_bool) {
        Running_flag_bool = running_flag_bool;
    }

    public void setTracking_flag_bool(boolean tracking_flag_bool) {
        Tracking_flag_bool = tracking_flag_bool;
    }
}
