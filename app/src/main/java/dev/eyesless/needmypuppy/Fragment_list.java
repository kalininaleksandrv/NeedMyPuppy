package dev.eyesless.needmypuppy;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_list extends ListFragment {


    public Fragment_list() {

    }

    //создаем интерфейс для слушателя
    // TODO: 03.05.2017 реализовать без интерфейса?

    static interface Fragment_list_listner {

        void itemClicked (long id);

    };

    // добавляем слушатель к фрагменту

    private Fragment_list_listner myfraglistner;

    //получаем из листа пород лист строк названий через итератор в методе setListOfBreed

    ArrayList<String> mylist = new ArrayList<String>(Main_logic.finalListOfBreedTitles);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> breedAdapter = new ArrayAdapter<String>(inflater.getContext(),
                R.layout.list_item, mylist);
        setListAdapter(breedAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //метод регистрирующий слушатель который передает активность во фрагменте при прикреплении фрагмента к активности
    // для возврата к варианту метода deprecated сменить аргумент на Activity activity
    public void onAttach (Context context) {
        super.onAttach(context);
        this.myfraglistner = (Fragment_list_listner) context;
            }


    //слушатель собственно

    public void onListItemClick (ListView lv, View v, int pozition, long id) {

        if (myfraglistner != null) myfraglistner.itemClicked(id);

    }

}
