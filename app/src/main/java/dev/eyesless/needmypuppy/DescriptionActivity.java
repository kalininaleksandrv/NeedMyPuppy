package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.function.ToDoubleBiFunction;

public class DescriptionActivity extends AppCompatActivity {

    public static final String GETBREEDID = "getbreedid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //вызываем фрагмент breed description

        Fragment_description mydescription = (Fragment_description)getFragmentManager()
                .findFragmentById(R.id.frame_breed_description);

        //вызываем метод fragment_description чтобы передать ID отображаемого айтема

        mydescription.setBreedId((int)getIntent().getExtras().get("getbreedid"));

        //вызываем фрагмент btns
        // TODO: 11.05.2017 здесь вызываем метод фрагмента nxtbtn для передачи ему (как?) количества айтемов в списке


    }
}
