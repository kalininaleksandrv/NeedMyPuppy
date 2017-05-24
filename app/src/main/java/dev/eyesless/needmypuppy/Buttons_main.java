package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Buttons_main extends Fragment {

    static interface onButtonListner {
        void buttonClicked (View s);
    }

    About_owner_main.onButtonListner myButtonListner;

    public Buttons_main() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.buttons_main, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (About_owner_main.onButtonListner) context;

    }

    @Override
    public void onStart() {
        super.onStart();

        final View parentview = getView();

        ImageButton aboutownerbutton = (ImageButton) parentview.findViewById(R.id.imageButton_aboutowner);

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        aboutownerbutton.setOnClickListener(myOnClickListner);
    }

}
