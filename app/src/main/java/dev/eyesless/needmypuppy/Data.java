package dev.eyesless.needmypuppy;

import java.util.ArrayList;

/**
 * Created by Eyesless on 28.03.2017.
 */

public class Data {


    /*
    массивы для спиннеров
    TODO реализовать массивы для всех спиннеров
    */

    public static final String [] spinner_exp_array = {"опыт содержания?",
        "нет опыта", "опыт минимальный", "я довольно опытный", "эксперт"};

    // инициируем классы пород

    public static final Breed haski = new Breed(270, "Сибирский Хаски",
            "средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
            "http://www.fci.be/en/nomenclature/SIBERIAN-HUSKY-270.html", 1, 8, 5, R.drawable.haski_1_1);

    public static final Breed labr = new Breed(122, "Лабрадор-ретривер",
            "средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
            "http://www.fci.be/en/nomenclature/LABRADOR-RETRIEVER-122.html", 1, 8, 5, R.drawable.labr_1_1);

    public static final Breed ger_sheperd = new Breed(166, "немецкая овчарка",
            "средняя по размеру служебная собака с уравновешенным, подвижным типом поведения, способная к разнообразной дрессировке",
            "http://www.fci.be/en/nomenclature/GERMAN-SHEPHERD-DOG-166.html", 1, 8, 5,  R.drawable.germshep_1_1);

    // Создаем коллекцию лист для пород

    public static ArrayList<Breed> breedArrayList;

    public static void BreedCollInit(){

        breedArrayList = new ArrayList<Breed>();
        breedArrayList.add(haski);
        breedArrayList.add(labr);
        breedArrayList.add(ger_sheperd);

    }




}
