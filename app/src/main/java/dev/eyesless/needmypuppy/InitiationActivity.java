package dev.eyesless.needmypuppy;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

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

    private String [] drawer_titles = {"сохранить ответы",
            "загрузить ответы", "написать разработчику"};

    public String[] getSpinner_exp_array() { return spinner_exp_array; }

    public String[] getSpinner_time_array() { return spinner_time_array; }

    public String[] getDrawer_titles() { return drawer_titles; }

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

    MyBucket obidience = new MyBucket("Послушание / обучаемость", 1);
    MyBucket guard = new MyBucket("Охранные качества", 1);
    MyBucket agressive = new MyBucket("Агрессивность", 5);//в логике показатель снижается по этому выставлен максимальный
    MyBucket active = new MyBucket("Активность", 1);
    MyBucket hardy = new MyBucket("Выносливость", 1);
    MyBucket size = new MyBucket("Размер", 5);//в логике показатель снижается по этому выставлен максимальный
    MyBucket care = new MyBucket("Сложный / специфичный уход", 1);

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

        return mybusketslist;
    }


    private boolean buttonforwhatispressed;
    private boolean buttonaboutownerispressed;

    private boolean buttonaboutdogispressed;

    public void bucketseraser () {

        obidience.setValue(1);
        guard.setValue(1);
        agressive.setValue(5);
        active.setValue(1);
        hardy.setValue(1);
        size.setValue(1);
        care.setValue(1);
        buttonforwhatispressed = false;

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

}
