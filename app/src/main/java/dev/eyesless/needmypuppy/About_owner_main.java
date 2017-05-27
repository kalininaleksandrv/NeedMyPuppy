package dev.eyesless.needmypuppy;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_owner_main extends Fragment {


    onButtonListner myButtonListner;

    public About_owner_main() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        InitiationActivity inact = ((InitiationActivity) getActivity().getApplicationContext());
        Log.w("MY_TAG", "About_owner");

        View layout = inflater.inflate(R.layout.about_owner_main, container, false);

        //код спиннера опыт

        Spinner spiner_exp = (Spinner)layout.findViewById(R.id.spinner_exp);
        ArrayAdapter<String> spiner_exp_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_exp_array());
        spiner_exp.setAdapter(spiner_exp_adapter);
        spiner_exp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //код спиннера время

        Spinner spiner_time = (Spinner)layout.findViewById(R.id.spinner_time);
        ArrayAdapter<String> spiner_time_adapter = new ArrayAdapter<String>
                (inflater.getContext(), R.layout.list_item, inact.getSpinner_time_array());
        spiner_time.setAdapter(spiner_time_adapter);
        spiner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

         return layout;
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
