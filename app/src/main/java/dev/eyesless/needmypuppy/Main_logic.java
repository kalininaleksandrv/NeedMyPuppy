package dev.eyesless.needmypuppy;

/**
 * Created by Eyesless on 21.03.2017.
 */

public class Main_logic {

    private int bucket_activ;
    private int bucket_hard = 0;
    private int bucket_frendly = 0;
    private String bestchoise;
    private String returnbreed = "just empty";

    private boolean opt_switch_temp = false;
    private boolean show_flag_bool = false;
    private boolean company_flag_bool = false;
    private boolean running_flag_bool = false;
    private boolean tracking_flag_bool = false;
    private int exp_level = 0;
    private int time_level = 0;

    public void bucket_changer () {

        if (opt_switch_temp) setBestchoise("уже есть собака +"); else setBestchoise("нет собаки + ");
        if (show_flag_bool) setBestchoise(getBestchoise().concat("выставки + ")) ;
        if (company_flag_bool) setBestchoise(getBestchoise().concat("для компании + ")) ;
        if (running_flag_bool) setBestchoise(getBestchoise().concat("совместные прбежки + ")) ;
        if (tracking_flag_bool) setBestchoise(getBestchoise().concat("прогулки + ")) ;
        setBestchoise(getBestchoise().concat(String.valueOf(getExp_level())).concat(" + "));
        setBestchoise(getBestchoise().concat(String.valueOf(getTime_level())).concat(" + "));

        // для тестирования корректного запоминания выбора спиннеров и т.п.
    }
    public String getBestchoise() {return bestchoise;}

    public void setBestchoise(String bestchoise) {
        this.bestchoise = bestchoise;
    }


        //для тестирования возврата пород

    public String getReturnbreed () {return returnbreed;}

    public void setReturnbreed() {this.returnbreed = Data.haski.getBreedFullDescription();}

    // сеттеры и геттеры для корзин

    public int getBucket_activ() {
        return bucket_activ;
    }

    public void setBucket_activ(int bucket_activ) {
        this.bucket_activ = bucket_activ;
    }

    public int getBucket_hard() {
        return bucket_hard;
    }

    public void setBucket_hard(int bucket_hard) {
        this.bucket_hard = bucket_hard;
    }

    public int getBucket_frendly() {
        return bucket_frendly;
    }

    public void setBucket_frendly(int bucket_frendly) {
        this.bucket_frendly = bucket_frendly;
    }


    //TODO зачем все эти онлайн сеттеры и геттеры пусть юзер выбирает значения потом перед созданием новой активности создается из логики контент, все упрощается

    //сеттер и геттер для свитча была ли собака

    public boolean isOpt_switch_temp() {
        return opt_switch_temp;
    }

    public void setOpt_switch_temp(boolean opt_switch_temp) {
        this.opt_switch_temp = opt_switch_temp;
    }

    //сеттеры и геттеры для чекбоксов зачем собака

    public boolean isShow_flag_bool() {
        return show_flag_bool;
    }

    public void setShow_flag_bool(boolean show_flag_bool) {
        this.show_flag_bool = show_flag_bool;
    }

    public boolean isCompany_flag_bool() {
        return company_flag_bool;
    }

    public void setCompany_flag_bool(boolean company_flag_bool) {this.company_flag_bool = company_flag_bool;}

    public boolean isRunning_flag_bool() {
        return running_flag_bool;
    }

    public void setRunning_flag_bool(boolean running_flag_bool) {this.running_flag_bool = running_flag_bool;}

    public boolean isTracking_flag_bool() {
        return tracking_flag_bool;
    }

    public void setTracking_flag_bool(boolean tracking_flag_bool) {this.tracking_flag_bool = tracking_flag_bool;}

    // сеттеры и геттеры для свитчей уровень опыта и свободное время

    public int getExp_level() {
        return exp_level;
    }

    public void setExp_level(int exp_level) {
        this.exp_level = exp_level;
    }

    public int getTime_level() {
        return time_level;
    }

    public void setTime_level(int time_level) {
        this.time_level = time_level;
    }
}
