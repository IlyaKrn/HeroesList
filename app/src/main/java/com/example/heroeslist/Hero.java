package com.example.heroeslist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;


// класс, описывающий героя
public class Hero implements Serializable {

    private static int ids = 0; // номер последнего созданного героя
    public String id; // уникальный номер героя. присваивается при создании нового объекта класса Hero

    public String birthYear; // год рождения героя
    public String eventYear; // год героического поступка
    public String ageAtEvent; // возраст героя на момент совершения героического поступка

    public String name; // имя героя
    public String surname; // фамилия героя
    public String fatherName; // отчество героя

    public String dataRef; // ссылка на источник инфотмации о герое

    public Bitmap image; // фотография героя
    public String text; // текст статьи о герое

    // конструктор без параметров
    public Hero() {
        // присвоение номера
        id = String.valueOf(ids);
        // обновление последнего присвоенного номера
        ids++;
    }

    // конструктор
    public Hero(String birthYear, String eventYear, String ageAtEvent, String name, String surname, String fatherName, String dataRef, String text, Bitmap image) {
        // присвоение номера
        id = String.valueOf(ids);
        // обновление последнего присвоенного номера
        ids++;
        // присвоение значений полям
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
