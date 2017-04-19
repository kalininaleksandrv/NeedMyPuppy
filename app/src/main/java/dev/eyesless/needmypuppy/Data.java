package dev.eyesless.needmypuppy;

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

    Breed haski = new Breed(270, "Сибирский Хаски",
            "средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
            "http://www.fci.be/en/nomenclature/SIBERIAN-HUSKY-270.html", 1, 8, 5, 8, 1, 8, 5, 8, R.drawable.haski_1_1);

    Breed labr = new Breed(122, "Лабрадор-ретривер",
            "средняя по размеру собака с энергичным, живым характером, независимая но очень дружелюбная к человеку",
            "http://www.fci.be/en/nomenclature/LABRADOR-RETRIEVER-122.html", 1, 8, 5, 8, 1, 8, 5, 8, R.drawable.haski_1_1);

}
