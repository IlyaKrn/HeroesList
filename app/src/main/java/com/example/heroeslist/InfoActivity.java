package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private ScrollView scrollView; // в  ScrollView содержится вся залметка активности, кроме тулбаров
    private TextView name, surname, fatherName, eventYear, text, dataRef; // TextView для помещения в них инфотмации о герое
    private ImageView image; // ImageView для фотографии героя
    private ArrayList<Hero> heroes; // список всех героев для переключения между ними с помощью нижнего тулбара без вахода из активности
    private Hero hero; // объект текущего героя. берется из списка
    private int currentId; // индекс текущего героя в списке


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        // получение объектов разметки
        init();
        // получение информации из MainActivity (список героев и индекс выбранного героя)
        getData();
        // обновление данных о герое (установка данных в объекты разметки)
        updateData();
    }
    // получение объектов разметки
    private void init() {
        scrollView = findViewById(R.id.scroll_view);
        image = findViewById(R.id.iv_image);
        name = findViewById(R.id.tv_name);
        surname = findViewById(R.id.tv_surname);
        fatherName = findViewById(R.id.tv_father_name);
        eventYear = findViewById(R.id.tv_event_year);
        text = findViewById(R.id.tv_text);
        dataRef = findViewById(R.id.tv_data_ref);
    }

    // получение информации из MainActivity (список героев и индекс выбранного героя)
    private void getData(){
        heroes = MainActivity.heroesMainList;
        String id = getIntent().getStringExtra("hero_index");
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).id.equals(id)){
                hero = heroes.get(i);
                currentId = i;
            }
        }
    }
    // обновление данных о герое (установка данных в объекты разметки)
    private void updateData(){
        name.setText(hero.name); // установка имени
        surname.setText(hero.surname); // установка фымилии
        fatherName.setText(hero.fatherName); // установка отчества
        eventYear.setText(hero.eventYear + " год"); // установка года героического поступка
        text.setText(hero.text); // установка текста статьи
        // проверка на наличие фотографии
        if (hero.image != null){
            image.setImageBitmap(hero.image); // установка фотографии
        }

        dataRef.setText("Источник: " + hero.dataRef); // установка ссылки на источник информации
        // обработка нажатия на ссылку
        dataRef.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                // создание Intent для перехода по ссылке
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(hero.dataRef));
                // переход по ссылке
                startActivity(browserIntent);
            }
        });
        // установка ScrollView с информацией о герое в верхнее положение
        scrollView.scrollTo(0, 0);
    }
    // возвращение на MainActivity
    public void onCloseInfo(View view) {
        // завершение ативности
        finish();
    }

    // отображение данных героя, находящегося в списке раньше текущего героя
    public void onPrev(View view) {
        // проверка возможности получения героя
        if (currentId > 0){
            // уменьшение индекса текущего героя
            currentId--;
            // получение геря из списка по индексу
            hero = heroes.get(currentId);
            // обновление отображаемых данных
            updateData();
        }
    }
    // отображение данных героя, находящегося в списке позже текущего героя
    public void onNext(View view) {
        // проверка возможности получения героя
        if (currentId < heroes.size()-1){
            // увеличение индекса текущего героя
            currentId++;
            // получение геря из списка по индексу
            hero = heroes.get(currentId);
            // обновление отображаемых данных
            updateData();
        }
    }
}