package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    TextView name, surname, fatherName, eventYear, dataText;
    ArrayList<Hero> heroes;
    Hero hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        initData();
    }

    private void initLayout(){


    }
    private void initData(){
        heroes = MainActivity.heroesMainList;
        String id = getIntent().getStringExtra("hero_index");
        for (Hero h : heroes){
            Log.i("ID", "ID: " + h.id);
            if (h.id.equals(id)){
                hero = h;
            }
        }
        Log.e("INFO", "N:" + hero.name + " S:" + hero.surname + " F:" + hero.fatherName);
    }

}