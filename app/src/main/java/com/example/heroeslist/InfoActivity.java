package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    TextView name, surname, fatherName, eventYear, dataText;
    ArrayList<Hero> heroes;
    int currentHero;
    Hero hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    private void init(){
        heroes = new ArrayList<>();
        currentHero = getIntent().getIntExtra("hero_index", 0);
        int arrSize = getIntent().getIntExtra("arr_size", 0);
        for (int i = 0; i < arrSize; i++) {
            heroes.add((Hero) getIntent().getSerializableExtra("name" + i));
        }
        for (Hero h : heroes){
            if (h.id.equals(currentHero)){
                hero = h;
            }
        }
        Log.e("INFO", "N:" + hero.name + " S:" + hero.surname + " F:" + hero.fatherName);

    }

}