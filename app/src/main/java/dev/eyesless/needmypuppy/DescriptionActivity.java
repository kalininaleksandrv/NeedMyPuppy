package dev.eyesless.needmypuppy;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class DescriptionActivity extends AppCompatActivity implements onButtonListner
 {
    public static final String GETBREEDID = "getbreedid";
    private int interID;

     // переменная для меню share
     private ShareActionProvider myshareactionprovider;

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
            //запускаем отдельный метод замещающий фрагменты
            fragmentReplacer();
        }

    }

    @Override
    public void buttonClicked(View v) {

        //создаем экземпляры кнопок для установки в дальнейшем состояния и цветового мода
        ImageButton prev = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_prev);
        ImageButton next = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_next);

        // переключатель получает вью кнопки и в зависимости от id уменьшает или увеличивает счетчик
        // после чего запускает заместитель фрагментов
            switch (v.getId()) {
                  case R.id.nxtbtn_imageButton_next:

                      setInterID(getInterID()+1);

                      if (fragmentCounter(getInterID())){
                          fragmentReplacer();
                         }
                      else {
                          next.setEnabled(false); //если дошел до последнего айтема установим кнопке falce (см onClickReplacer)
                          next.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                          setInterID(getInterID()-1);
                      }
                  break;

                  case R.id.nxtbtn_imageButton_prev:

                      setInterID(getInterID()-1);
                      if (fragmentCounter(getInterID())){
                          fragmentReplacer();
                      }
                      else {
                          prev.setEnabled(false);
                          prev.setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                          setInterID(getInterID()+1);
                      }
                  break;
            }
    }

    //заместитель фрагментов
    public void fragmentReplacer (){

//        Fragment_nxtbtn mynxtbtn = (Fragment_nxtbtn) getSupportFragmentManager().findFragmentById(R.id.frame_nxtbtn);
//        Fragment_description newdescription = new Fragment_description();
//        FragmentTransaction fratra_up = getFragmentManager().beginTransaction();
//        newdescription.setBreedId(getInterID());
//        fratra_up.replace(R.id.frame_breed_description, newdescription);
//        fratra_up.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        fratra_up.commit();

        //устанавливаем значение кнопок в true a вид в обычный
//        View v = mynxtbtn.getView();
//        ImageButton prev = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_prev);
//        ImageButton next = (ImageButton) v.findViewById(R.id.nxtbtn_imageButton_next);
//        prev.setEnabled(true);
//        next.setEnabled(true);
//        prev.setColorFilter(null);
//        next.setColorFilter(null);

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


     //создаем  action-menu

     @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_descriptionactivity, menu);

         MenuItem sharemenu = menu.findItem(R.id.action_share);
         myshareactionprovider = (ShareActionProvider) MenuItemCompat.getActionProvider(sharemenu);
         setIntent("This is example text");

         return super.onCreateOptionsMenu(menu);
     }

     private void setIntent (String s) {
         Intent myintent = new Intent(Intent.ACTION_SEND);
         myintent.setType("text/plain");
         myintent.putExtra(Intent.EXTRA_TEXT, s);
         myshareactionprovider.setShareIntent(myintent);
     }

     //слушатель для меню

     @Override
     public boolean onOptionsItemSelected(MenuItem item) {

         switch (item.getItemId()){

             case R.id.action_share:
                 //do something
                 return true;

             default: return super.onOptionsItemSelected(item);
         }


     }
 }
