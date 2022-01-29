package com.example.heroeslist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

public class Hero implements Serializable {

    private static int ids = 0;
    public String id;

    public String birthYear;
    public String eventYear;
    public String ageAtEvent;

    public String name;
    public String surname;
    public String fatherName;

    public String dataRef;

    public Bitmap image;
    public String text;

    public Hero() {
    }

    public Hero(String birthYear, String eventYear, String ageAtEvent, String name, String surname, String fatherName, String dataRef, String text, Bitmap image) {
        id = String.valueOf(ids);// String.valueOf(System.currentTimeMillis() * Math.random() * Math.random() - Math.random());
        ids++;
        this.birthYear = birthYear;
        this.eventYear = eventYear;
        this.ageAtEvent = ageAtEvent;
        this.name = name;
        this.surname = surname;
        this.fatherName = fatherName;
        this.dataRef = dataRef;
        this.text = text;
        this.image = image;

    }
}
