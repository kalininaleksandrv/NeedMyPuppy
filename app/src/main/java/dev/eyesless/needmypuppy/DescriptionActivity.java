package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

        //если активность создается впервые получаем ссылку на фрагмент breed description через создание его экземпляра
        // если повторно - просто берем значение ID из сейва

        if (savedInstanceState != null){

            int i = savedInstanceState.getInt("interID");
            setInterID(i);

        } else {

        setInterID((int)getIntent().getExtras().get("getbreedid"));
        Fragment_description newdescription = new Fragment_description();
        newdescription.setBreedId(getInterID());
        FragmentTransaction fratra = getFragmentManager().beginTransaction();
        fratra.replace(R.id.frame_breed_description, newdescription);
        fratra.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratra.commit();}

    }

    @Override
    public void buttonClicked(View v) {

        //получаем ID из интента

        ImageButton next = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_next);
        ImageButton prev = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_prev);




            switch (v.getId()) {
                  case R.id.nxtbtn_imageButton_next:

                      setInterID(getInterID()+1);

                      if (fragmentCounter(getInterID())){

                          fragmentOnClickReplacer();
                         }

                      else {next.setClickable(false);
                      setInterID(getInterID()-1);}


                  break;
                  case R.id.nxtbtn_imageButton_prev:

                      setInterID(getInterID()-1);
                      if (fragmentCounter(getInterID())){
                          fragmentOnClickReplacer();
                      }
                      else {prev.setClickable(false);
                          setInterID(getInterID()+1);}

                  break;
            }




    }

    public void fragmentOnClickReplacer (){

        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getSupportFragmentManager().findFragmentById(R.id.frame_nxtbtn);
        Fragment_description newdescription = new Fragment_description();
        FragmentTransaction fratra_up = getFragmentManager().beginTransaction();
        newdescription.setBreedId(getInterID());
        fratra_up.replace(R.id.frame_breed_description, newdescription);
        fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fratra_up.commit();
    }

    //метод для установки значения при переключении фрагмента, получает на вход лист коллекции чтобы узнать обще кол-во записей и теекущую запись

    public boolean fragmentCounter (int count){


        if (count > Main_logic.finalListOfBreedTitles.size()-1 || count<0){


           return false;

        } else return true;

    }

    //геттер и сеттер для interID

     public int getInterID() {
         return interID;
     }

     public void setInterID(int interID) {
         this.interID = interID;
     }
 }
