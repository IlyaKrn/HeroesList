package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Hero> heroesMainList; // список всех героев
    public static ArrayList<Hero> heroesSearchList; // список отображаемых героев
    private EditText search; // EditText для поиска героя по году подвига
    private RecyclerView recyclerView; // RecyclerView для отображения списка героев
    private RVAdapter adapter; // адаптер для RecyclerView
    private GridLayoutManager layoutManager; // LayoutManager для RecyclerView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получение полей
        init();

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.e("ET", "TEXT CHANGE");
                sort();
            }
        });

    }


    private void init(){
        // инициализация списков и объектов разметки
        heroesMainList = new ArrayList<>();
        heroesSearchList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        search = findViewById(R.id.et_search);
        // создание GridLayoutManager
        layoutManager = new GridLayoutManager(this, 2);
        // создание адаптера
        adapter = new RVAdapter(heroesSearchList);
        // установка лушателя нажатий на элемент списка
        adapter.setOnStateClick(new RVAdapter.OnStateClick() {
            @Override
            public void onStateClick(Hero hero) {
                // Intent для перехода нат InfoActivity
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                // передача выбранного героя
                intent.putExtra("hero_index", hero.id);
                // запуск InfoActivity
                startActivity(intent);
            }
        });

        // установка адаптера и layoutManager для recyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        // заполнение списков
        fillList();
    }
    // поиск героев с заданным годом подвига
    private void sort(){
        // очистка списка для адаптера
        if (heroesSearchList.size() > 0) heroesSearchList.clear();
        // перебор списка всех героев
        for (Hero h : heroesMainList){
            // если edittext для поиска пуст
             if (search.getText().toString().equals("") || search.getText().toString() == null){
                 // установка всех героев для отображения
                 heroesSearchList.addAll(heroesMainList);
             }
             // если edittext для поиска не пуст
             else if (search.getText().toString().equals(h.eventYear)){
                 // добавление для отображения героя текущей итерации
                 heroesSearchList.add(h);
             }
        }
        // обновление адаптера
        adapter.notifyDataSetChanged();
    }

    // заполнение списков
    private void fillList(){
        // добавление  новых героев в список всех героев
        // данные берутся из strings.xml
        heroesMainList.add(new Hero(getString(R.string.birth_year_1), getString(R.string.event_year_1), getString(R.string.age_at_event_1), getString(R.string.name_1), getString(R.string.surname_1), getString(R.string.father_name_1), getString(R.string.data_ref_1), getString(R.string.text_1), ((BitmapDrawable) getDrawable(R.drawable.img_1)).getBitmap()));
        heroesMainList.add(new Hero(getString(R.string.birth_year_2), getString(R.string.event_year_2), getString(R.string.age_at_event_2), getString(R.string.name_2), getString(R.string.surname_2), getString(R.string.father_name_2), getString(R.string.data_ref_2), getString(R.string.text_2), ((BitmapDrawable) getDrawable(R.drawable.img_2)).getBitmap()));
        heroesMainList.add(new Hero(getString(R.string.birth_year_3), getString(R.string.event_year_3), getString(R.string.age_at_event_3), getString(R.string.name_3), getString(R.string.surname_3), getString(R.string.father_name_3), getString(R.string.data_ref_3), getString(R.string.text_3), ((BitmapDrawable) getDrawable(R.drawable.img_3)).getBitmap()));
        heroesMainList.add(new Hero(getString(R.string.birth_year_4), getString(R.string.event_year_4), getString(R.string.age_at_event_4), getString(R.string.name_4), getString(R.string.surname_4), getString(R.string.father_name_4), getString(R.string.data_ref_4), getString(R.string.text_4), ((BitmapDrawable) getDrawable(R.drawable.img_4)).getBitmap()));
        heroesMainList.add(new Hero(getString(R.string.birth_year_5), getString(R.string.event_year_5), getString(R.string.age_at_event_5), getString(R.string.name_5), getString(R.string.surname_5), getString(R.string.father_name_5), getString(R.string.data_ref_5), getString(R.string.text_5), ((BitmapDrawable) getDrawable(R.drawable.img_5)).getBitmap()));
    //    heroesMainList.add(new Hero(getString(R.string.birth_year_6), getString(R.string.event_year_6), getString(R.string.age_at_event_6), getString(R.string.name_6), getString(R.string.surname_6), getString(R.string.father_name_6), getString(R.string.data_ref_6), getString(R.string.text_6), ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
    //    heroesMainList.add(new Hero(getString(R.string.birth_year_7), getString(R.string.event_year_7), getString(R.string.age_at_event_7), getString(R.string.name_7), getString(R.string.surname_7), getString(R.string.father_name_7), getString(R.string.data_ref_7), getString(R.string.text_7), ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
    //    heroesMainList.add(new Hero(getString(R.string.birth_year_8), getString(R.string.event_year_8), getString(R.string.age_at_event_8), getString(R.string.name_8), getString(R.string.surname_8), getString(R.string.father_name_8), getString(R.string.data_ref_8), getString(R.string.text_8), ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
    //    heroesMainList.add(new Hero(getString(R.string.birth_year_9), getString(R.string.event_year_9), getString(R.string.age_at_event_9), getString(R.string.name_9), getString(R.string.surname_9), getString(R.string.father_name_9), getString(R.string.data_ref_9), getString(R.string.text_9), ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
    //    heroesMainList.add(new Hero(getString(R.string.birth_year_10), getString(R.string.event_year_10), getString(R.string.age_at_event_10), getString(R.string.name_10), getString(R.string.surname_10), getString(R.string.father_name_10), getString(R.string.data_ref_10), getString(R.string.text_10), ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));

        // заполнение списка для отображения всеми героями
        heroesSearchList.addAll(heroesMainList);
    }


}