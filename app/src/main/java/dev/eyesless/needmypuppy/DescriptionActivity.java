package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class DescriptionActivity extends AppCompatActivity implements Fragment_nxtbtn.onButtonListner
 {

    public static final String GETBREEDID = "getbreedid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //получаем ссылку на фрагмент breed description через создание его экземпляра

//        Fragment_description mydescription = (Fragment_description)getFragmentManager()
//                .findFragmentById(R.id.frame_breed_description);

        //вызываем метод fragment_description чтобы передать ID отображаемого айтема

//        mydescription.setBreedId((int)getIntent().getExtras().get("getbreedid"));

        Fragment_description newdescription = new Fragment_description();
        newdescription.setBreedId((int)getIntent().getExtras().get("getbreedid"));
        FragmentTransaction fratra = getFragmentManager().beginTransaction();
        fratra.add(R.id.frame_breed_description, newdescription);
        fratra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratra.commit();

    }

    @Override
    public void buttonClicked(View v) {

        //gjлучаем ID из интента
        int interid = ((int)getIntent().getExtras().get("getbreedid"));

        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getSupportFragmentManager().findFragmentById(R.id.frame_nxtbtn);
        Fragment_description newdescription = new Fragment_description();
        FragmentTransaction fratra_up = getFragmentManager().beginTransaction();


            switch (v.getId()) {
              case R.id.nxtbtn_imageButton_next:

                  if (fragmentCounter(Main_logic.finalListOfBreedTitles, interid)){
                        interid ++;
                        newdescription.setBreedId(interid);
                        fratra_up.replace(R.id.frame_breed_description, newdescription);
                        fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fratra_up.commit();}

              break;
              case R.id.nxtbtn_imageButton_prev:

                  if (fragmentCounter(Main_logic.finalListOfBreedTitles, interid)){
                      interid --;
                      newdescription.setBreedId(interid);
                      fratra_up.replace(R.id.frame_breed_description, newdescription);
                      fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                      fratra_up.commit();}

              break;
            }




    }

    //метод для установки значения при переключении фрагмента, получает на вход лист коллекции чтобы узнать обще кол-во записей и теекущую запись

    public boolean fragmentCounter (ArrayList<String> array, int count){

        if ( count < array.size() & count > -1){

           return true;

        } else return false;



    }
 }
