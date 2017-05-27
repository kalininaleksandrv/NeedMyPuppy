package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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


    // реализуем интерфейс и его экземпляр

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

               myButtonListner.buttonClicked(v);

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


}
