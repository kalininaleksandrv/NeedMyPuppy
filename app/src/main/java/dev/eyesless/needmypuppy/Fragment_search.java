package dev.eyesless.needmypuppy;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_search extends Fragment implements MVPInterface_search {

    onButtonListner myButtonListner;

    private View parentview;
    private Button gonextbutton;
    private ImageButton findbutton;
    private TextView incomtext;
    private EditText outcomtext;
    private String searchasq;

    public InitiationActivity inact;


    Presenter_search presenter;



    public Fragment_search() {
        // Required empty public constructor

        presenter = new Presenter_search(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inact = ((InitiationActivity) getActivity().getApplicationContext());

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myButtonListner = (onButtonListner) context;

    }

    @Override
    public void onStart() {
        super.onStart();

        ((MainActivity) getActivity()).gudlinesetter((float) 0.1);

        parentview = getView();

        iteminitier();

        presenterinactsetter(inact, getActivity().getApplicationContext());

        findbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchasq = outcomtext.getText().toString();
                searchstarter();

            }
        });

        gonextbutton.setOnClickListener(myOnClickListner);

    }

    private void iteminitier() {

        gonextbutton = (Button) parentview.findViewById(R.id.button_gonext);
        findbutton = (ImageButton) parentview.findViewById(R.id.imageButton_find);
        incomtext = (TextView) parentview.findViewById(R.id.db_text_recived);
        outcomtext = (EditText) parentview.findViewById(R.id.db_editText_sended);
    }

    private void presenterinactsetter(InitiationActivity inact, Context context) {

        presenter.inactsetter(inact, context);

    }

    View.OnClickListener myOnClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            myButtonListner.buttonClicked(v);

        }
    };

    @Override
    public String onRecive() {

        String asq;

       if (searchasq !=null) asq = "%"+searchasq+"%"; else asq = "%";

        return asq;
    }

    @Override
    public void onSend(String s) {

        toastmaker(s);

        incomtext.setText(s);

    }

    public void toastmaker(String s) {
        Toast myToast = Toast.makeText(getContext(), s, Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.BOTTOM, 0, 30);
        myToast.show();
    }

    private void searchstarter() {

        presenter.searchstarter();

    }
}
