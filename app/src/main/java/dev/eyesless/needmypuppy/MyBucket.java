package dev.eyesless.needmypuppy;

/**
 * Created by Eyesless on 31.05.2017.
 */

public class MyBucket {

    private String title;
    private int value;

    MyBucket (String title, int value){

        this.title = title;
        this.value = value;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
