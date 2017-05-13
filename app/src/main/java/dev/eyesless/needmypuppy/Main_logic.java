package dev.eyesless.needmypuppy;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Eyesless on 21.03.2017.
 */

public class Main_logic {

    private int bucket_activ;
    private int bucket_hard = 0;
    private int bucket_frendly = 0;

    public static ArrayList<Breed> sortedBreeds;
    public static ArrayList<String> finalListOfBreedTitles;

    //конструктор по умолчанию
    public Main_logic (){

        Log.w("MY_TAG", "Main_Logic");
    }



    // формирование финального списка пород по заданной логике формируем arraylist т.к. нам важна последовательность хранения

    public void setFinalListOfBreed() {

        Data mydata = new Data();
        ArrayList<Breed> finalListOfBreed = new ArrayList<>();
        Iterator<Breed> myBreedIterator = mydata.initBreedColl().iterator();

        while (myBreedIterator.hasNext()) {
            Breed breed = myBreedIterator.next();
            //TODO сделать полноценную логику формирования
            if (breed.getSize() < 10) {
                finalListOfBreed.add(breed);
            }
            this.sortedBreeds = finalListOfBreed;

        }
        Log.w("MY_TAG", "setFinalListOfBreed");
    }

    //возврат только названий пород из финального списка пород

    public void setReturnbreed() {

        ArrayList<String> finalListOfBreedTitles = new ArrayList<>();
        Iterator<Breed> myBreedIterator = sortedBreeds.iterator();

        while (myBreedIterator.hasNext()) {
            Breed breed = myBreedIterator.next();
            finalListOfBreedTitles.add(breed.getBreed_title());
        }
        this.finalListOfBreedTitles = finalListOfBreedTitles;
        Log.w("MY_TAG", "setReturnbreed");
    }


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

}
