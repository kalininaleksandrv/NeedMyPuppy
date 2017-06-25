package dev.eyesless.needmypuppy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class InitiationActivity extends Application {

    //значения для спиннеров

    private String [] spinner_exp_array = {"есть ли опыт содержания и воспитания собак?",
            "нет опыта", "опыт минимальный", "я довольно опытный", "эксперт"};

    private String [] spinner_time_array = {"cколько времени готов тратить на собаку?",
            "не более 1 часа в день", "не более 2-3 часов в день", "все свободное время"};

    private String [] spinner_age_array = {"сколько Вам лет?",
            "до 16", "16 - 25", "26 - 40", "41 - 60", "более 60"};

    private String [] spinner_activ_array = {"физическая форма (для Вашего возраста)",
            "неудовлетворительная", "обычная", "хорошая", "отличная"};

    private String [] spinner_family_array = {"кроме Вас с собакой будут заниматься другие люди:",
            "никто", "очень редко", "да, часто, их физическая форма лучше моей", "да, часто, их физическая форма хуже моей"};

    private String [] spinner_walk_array = {"где собака будет гулять чаще всего:",
            "минимальные условия для выгула", "ограниченный выгул в городской черте", "лес или лесопарк", "неограниченно на своей территории"};

    private String [] spinner_cynologist_array = {"есть ли доступ к профессиональному кинологу, дрессировщику:",
            "нет", "ролики в интернет, литертатура", "вероятно есть", "развитые кинологические услуги"};

    private String [] spinner_vet_array = {"оцените доступность ветеринарных услуг:",
            "не доступны", "минимально доступны", "не известно", "хорошо доступны"};


    public String[] getSpinner_exp_array() { return spinner_exp_array; }

    public String[] getSpinner_time_array() { return spinner_time_array; }

    public String[] getSpinner_age_array() {return spinner_age_array;}

    public String[] getSpinner_activ_array() {return spinner_activ_array;}

    public String[] getSpinner_family_array() {return spinner_family_array;}

    public String[] getSpinner_walk_array() {return spinner_walk_array; }

    public String[] getSpinner_cynologist_array() {return spinner_cynologist_array;}

    public String[] getSpinner_vet_array() {return spinner_vet_array;}

    //создаем 5 корзин для основных свойств выбора собаки
    //послушание 1- породы не способные к дрессировке, 2 -хаски, 5 миалинуа
    //охрана 1-хаски 5-малинуа
    //агрессивность 1-хаски 5-САО
    //активность 1-флегматичные собаки 5-джекрассел
    //выносливость 1-утомляемые собаки 4-хаски 5-риджбэк
    //размер 1-чихуа 2-джекрассел 3-хаски, лабр 4 - малинуа 5-САО
    //уход 1-не нуждается 5-специфичная длинная шерсть или стандарты грумминга
    //охота 0 - ПОДХОДИТ для охоты 1 НЕ подходит для охоты (чтобы < 2 давал весь лист а < 1 только охотничьи породы)

    MyBucket obidience = new MyBucket("Послушание / обучаемость", 1);
    MyBucket guard = new MyBucket("Охранные качества", 2);
    MyBucket agressive = new MyBucket("Агрессивность", 5);//в логике показатель снижается по этому выставлен максимальный
    MyBucket active = new MyBucket("Активность", 3);
    MyBucket hardy = new MyBucket("Выносливость", 1);
    MyBucket size = new MyBucket("Размер", 5);//в логике показатель снижается по этому выставлен максимальный
    MyBucket care = new MyBucket("Сложный / специфичный уход", 5);
    MyBucket hunt = new MyBucket("Является (1) или нет (0) охотничьей", 0); //если 0 то параметр SQL запроса принимает "yes", иначе "%"

    // создаем лист объектов корзина для передачи в список List_profile

    public ArrayList<MyBucket> mybuckelisttmaker () {

        ArrayList<MyBucket> mybusketslist = new ArrayList<>();

        mybusketslist.add(obidience);
        mybusketslist.add(guard);
        mybusketslist.add(agressive);
        mybusketslist.add(active);
        mybusketslist.add(hardy);
        mybusketslist.add(size);
        mybusketslist.add(care);
        mybusketslist.add(hunt);

        return mybusketslist;
    }

    //true if already answering question in one of fragment

    private boolean buttonforwhatispressed;
    private boolean buttonaboutownerispressed;
    private boolean buttonaboutdogispressed;

    public void bucketseraser () {

        obidience.setValue(1);
        guard.setValue(1);
        agressive.setValue(5);
        active.setValue(1);
        hardy.setValue(1);
        size.setValue(5);
        care.setValue(5);
        hunt.setValue(0);
        buttonforwhatispressed = false;
        buttonaboutdogispressed = false;
        buttonaboutownerispressed = false;

    }

    public void setButtonforwhatispressed(boolean buttonforwhatispressed) {
        this.buttonforwhatispressed = buttonforwhatispressed;
    }

    public boolean isButtonforwhatispressed() {return buttonforwhatispressed;}

    public void setButtonaboutownerispressed(boolean buttonforwhatispressed) {
        this.buttonaboutownerispressed = buttonforwhatispressed;
    }

    public boolean isButtonaboutownerispressed() {return buttonaboutownerispressed;}

    public boolean isButtonaboutdogispressed() {return buttonaboutdogispressed;}

    public void setButtonaboutdogispressed(boolean buttonaboutdogispressed) {
        this.buttonaboutdogispressed = buttonaboutdogispressed;
    }

    //obidience
    public void obidienceincreaser (int i) {
        obidience.setValue(max(obidience.getValue(), i));
    }

    //aggressive

    public void aggresivedecreaser (int i){ agressive.setValue(min(agressive.getValue(), i)); }

    //activesetter

    public void activeincreaser (int i) {
        active.setValue(max(active.getValue(), i));
    }

    //sizesetter

    public void sizedecreaser (int i) {
        size.setValue(min(size.getValue(), i));
    }

    //caresetter

    public void caredecreaser (int i) {
        care.setValue(min(care.getValue(), i));
    }




    //work with db

    private boolean isDataBaseCreated = false;

    public boolean isDataBaseCreated() { return isDataBaseCreated; }

    public void setDataBaseCreated(boolean dataBaseCreated) {
        isDataBaseCreated = dataBaseCreated;
    }


    //list of breeds

    private ArrayList <Breed_mod> myListOfBreed_m = new ArrayList<>();

    public ArrayList<Breed_mod> getMyListOfBreed_m() {
        return myListOfBreed_m;
    }

    public void setMyListOfBreed_m(ArrayList<Breed_mod> myListOfBreed_m) {
        this.myListOfBreed_m = myListOfBreed_m;
    }



    //list of titles


    private ArrayList <String> listOfTitles = new ArrayList<>();

    public ArrayList<String> getListOfTitles() {return listOfTitles;}

//    public void setListOfTitles(ArrayList<String> listOfTitles) {
//        this.listOfTitles = listOfTitles;
//    }

    //возврат только названий пород из финального списка пород

    public void setListOfTitles () {

        ArrayList<String> listOfBreedTitles = new ArrayList<>();
        Iterator<Breed_mod> myBreedIterator = getMyListOfBreed_m().iterator();

        while (myBreedIterator.hasNext()) {
            Breed_mod breed = myBreedIterator.next();
            listOfBreedTitles.add(breed.getB_title());
        }

        this.listOfTitles = listOfBreedTitles;

    }





}
