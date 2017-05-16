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



     private int interID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        //получаем ссылку на фрагмент breed description через создание его экземпляра

        setInterID((int)getIntent().getExtras().get("getbreedid"));
        Fragment_description newdescription = new Fragment_description();
        newdescription.setBreedId(getInterID());
        FragmentTransaction fratra = getFragmentManager().beginTransaction();
        fratra.add(R.id.frame_breed_description, newdescription);
        fratra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratra.commit();

    }

    @Override
    public void buttonClicked(View v) {

        //gjлучаем ID из интента


        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getSupportFragmentManager().findFragmentById(R.id.frame_nxtbtn);
        Fragment_description newdescription = new Fragment_description();
        FragmentTransaction fratra_up = getFragmentManager().beginTransaction();

        // TODO: 16.05.2017 оптимизировать эту жесть


            switch (v.getId()) {
              case R.id.nxtbtn_imageButton_next:

                  setInterID(getInterID()+1);

                  if (fragmentCounter(getInterID())){

                        newdescription.setBreedId(getInterID());
                        fratra_up.replace(R.id.frame_breed_description, newdescription);
                        fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fratra_up.commit();}
                  else setInterID(getInterID()-1);

              break;
              case R.id.nxtbtn_imageButton_prev:

                  setInterID(getInterID()-1);

                  if (fragmentCounter(getInterID())){

                      newdescription.setBreedId(getInterID());
                      fratra_up.replace(R.id.frame_breed_description, newdescription);
                      fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                      fratra_up.commit();}
                  else setInterID(getInterID()+1);

              break;
            }




    }

    //метод для установки значения при переключении фрагмента, получает на вход лист коллекции чтобы узнать обще кол-во записей и теекущую запись

    public boolean fragmentCounter (int count){

       int temp = Main_logic.finalListOfBreedTitles.size();

        if (count < temp & count > -1 ){

           return true;

        } else return false;



    }

    //геттер и сеттер для interID

     public int getInterID() {
         return interID;
     }

     public void setInterID(int interID) {
         this.interID = interID;
     }
 }
