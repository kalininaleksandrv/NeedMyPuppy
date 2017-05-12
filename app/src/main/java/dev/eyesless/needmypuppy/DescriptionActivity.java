package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class DescriptionActivity extends AppCompatActivity implements Fragment_nxtbtn.onButtonListner {

    public static final String GETBREEDID = "getbreedid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //получаем ссылку на фрагмент breed description через создание его экземпляра

        Fragment_description mydescription = (Fragment_description)getFragmentManager()
                .findFragmentById(R.id.frame_breed_description);

        //вызываем метод fragment_description чтобы передать ID отображаемого айтема

        mydescription.setBreedId((int)getIntent().getExtras().get("getbreedid"));

        //вызываем фрагмент nxtbtn

//        mynxtbtn.setBreed_id((int)getIntent().getExtras().get("getbreedid"));
//        mynxtbtn.setCounter(Main_logic.sortedBreeds.size());

        // TODO: 11.05.2017 здесь вызываем метод фрагмента nxtbtn для передачи ему (как?) количества айтемов в списке


    }

    @Override
    public void buttonClicked(String s) {

        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getFragmentManager().findFragmentById(R.id.frame_nxtbtn);
        mynxtbtn.setMytesttext("test");
        Log.w("MY_TAG", "buttonClicked");


    }
}
