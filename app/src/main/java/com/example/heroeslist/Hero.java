package com.example.heroeslist;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Hero implements Serializable {

    public String birthYear;
    public String eventYear;
    public String ageAtEvent;

    public String name;
    public String surname;

    public String dataRef;

    public Bitmap image;
    public String text;

    public Hero() {
    }


    public Hero(String birthYear, String eventYear, String ageAtEvent, String name, String surname, String dataRef, String text, Bitmap image) {
        this.birthYear = birthYear;
        this.eventYear = eventYear;
        this.ageAtEvent = ageAtEvent;
        this.name = name;
        this.surname = surname;
        this.dataRef = dataRef;
        this.image = image;
        this.text = text;
    }
}
