package dev.eyesless.needmypuppy;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Eyesless on 28.03.2017.
 */

public class Data {

    //конструктор по умолчанию
    public Data (){

        Log.w("MY_TAG", "Data");
    }


    // инициируем классы пород

    public static final Breed haski = new Breed(270, "Сибирский Хаски",
            "Хаски - средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
            "http://www.fci.be/en/nomenclature/SIBERIAN-HUSKY-270.html", 1, 8, 4, R.drawable.haski_1_1);

    public static final Breed labr = new Breed(122, "Лабрадор-ретривер",
            "   Лабрадор - средняя по размеру служебная собака, подвижная, веселая и прекрано ладящая с людьми",
            "http://www.fci.be/en/nomenclature/LABRADOR-RETRIEVER-122.html", 1, 8, 5, R.drawable.labr_1_1);

    public static final Breed ger_sheperd = new Breed(166, "Hемецкая овчарка",
            "   Немецкая овчарка - средняя по размеру служебная собака с уравновешенным, подвижным типом поведения, способная к разнообразной дрессировке",
            "http://www.fci.be/en/nomenclature/GERMAN-SHEPHERD-DOG-166.html", 1, 8, 7,  R.drawable.germshep_1_1);

    // Создаем коллекцию хэш сет для пород - хэш сет т.к. максимальное быстродействие

    public HashSet<Breed> initBreedColl () {

        Log.w("MY_TAG", "initBreedColl");

       HashSet<Breed> myBreedColl = new HashSet<Breed>();

       Collections.addAll(myBreedColl, haski, labr, ger_sheperd);

        return myBreedColl;
    }

    public static boolean is_about_owner = false;
    public static boolean is_about_structure = false;
    public static boolean is_for_what = false;






}
