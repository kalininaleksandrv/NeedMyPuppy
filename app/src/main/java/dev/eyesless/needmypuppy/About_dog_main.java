package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_dog_main extends Fragment {

    onButtonListner myButtonListner;


    public About_dog_main() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.about_dog_main, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (onButtonListner) context;

    }

    @Override
    public void onStart() {
        super.onStart();

        final View parentview = getView();

        ImageButton completebutton = (ImageButton) parentview.findViewById(R.id.button_complete);

        //создаем онклик листнер для кнопок и передаем в методе онклик значение кнопки в метод buttonclicked интерфейса

        View.OnClickListener myOnClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myButtonListner.buttonClicked(v);

            }
        };

        //реализуем онкликлистнер на подключенной кнопке

        completebutton.setOnClickListener(myOnClickListner);
    }

}
