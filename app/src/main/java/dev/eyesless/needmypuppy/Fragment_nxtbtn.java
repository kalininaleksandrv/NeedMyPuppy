package dev.eyesless.needmypuppy;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_nxtbtn extends Fragment {

    private int breed_id;
    private int counter;


    private String mytesttext;

    // реализуем интерфейс и его экземпляр

    static interface onButtonListner {
        void buttonClicked (String s);
    }
    onButtonListner myButtonListner;


    public Fragment_nxtbtn() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();

        final View parentview = getView();

        ImageButton nextbtn = (ImageButton) parentview.findViewById(R.id.nxtbtn_imageButton_next);
        ImageButton prevbtn = (ImageButton) parentview.findViewById(R.id.nxtbtn_imageButton_prev);

         //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

  //             myButtonListner.buttonClicked("test");

                TextView testtextview = (TextView) parentview.findViewById(R.id.textView_idofitem);

                switch (v.getId()){

                    case R.id.nxtbtn_imageButton_next: testtextview.setText("next");
                        break;
                    case R.id.nxtbtn_imageButton_prev: testtextview.setText("prev");
                        break;
                }



            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        nextbtn.setOnClickListener(myOnClickListner);
        prevbtn.setOnClickListener(myOnClickListner);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return  inflater.inflate(R.layout.fragment_nxtbtn, container, false);


    }

    //получаем на вход родительское активити и приводим его к типу интерфейса чтобы можно было вызвать метод интерфейса из активности

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (onButtonListner) context;

    }

    public void setBreed_id(int breed_id) {
        this.breed_id = breed_id;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public void setMytesttext(String mytesttext) {
        this.mytesttext = mytesttext;
    }

}
