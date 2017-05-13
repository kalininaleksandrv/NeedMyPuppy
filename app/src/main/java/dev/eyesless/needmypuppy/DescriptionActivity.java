package dev.eyesless.needmypuppy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class DescriptionActivity extends AppCompatActivity implements Fragment_nxtbtn.onButtonListner
 {

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

    }

    @Override
    public void buttonClicked(View v) {

        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getSupportFragmentManager().findFragmentById(R.id.frame_nxtbtn);

            switch (v.getId()) {

              case R.id.nxtbtn_imageButton_next:
              ((TextView) mynxtbtn.getView().findViewById(R.id.textView_idofitem)).setText("good");
              break;
              case R.id.nxtbtn_imageButton_prev:
              ((TextView) mynxtbtn.getView().findViewById(R.id.textView_idofitem)).setText("bad");
              break;
            }




    }
 }
