package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private TextView name, surname, fatherName, eventYear, text, dataRef;
    private ImageView image;
    private ArrayList<Hero> heroes;
    private Hero hero;
    private int currentId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        init();
        getData();
        updateData();
    }


    private void getData(){
        heroes = MainActivity.heroesMainList;
        String id = getIntent().getStringExtra("hero_index");

        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).id.equals(id)){
                hero = heroes.get(i);
                currentId = i;
            }
        }
        Log.e("hero",
                " n:" + hero.name +
                " s:" + hero.surname +
                " f:" + hero.fatherName +
                " e:" + hero.eventYear +
                " d:" + hero.text
                );
    }
    private void init() {
        image = findViewById(R.id.iv_image);
        name = findViewById(R.id.tv_name);
        surname = findViewById(R.id.tv_surname);
        fatherName = findViewById(R.id.tv_father_name);
        eventYear = findViewById(R.id.tv_event_year);
        text = findViewById(R.id.tv_text);
        dataRef = findViewById(R.id.tv_data_ref);
    }

    private void updateData(){
        name.setText(hero.name);
        surname.setText(hero.surname);
        fatherName.setText(hero.fatherName);
        eventYear.setText(hero.eventYear + " год");
        text.setText(hero.text);
        if (hero.image != null){
            image.setImageBitmap(hero.image);
        }
        Log.e("text",
                " n:" + name.getText().toString() +
                        " s:" + surname.getText().toString() +
                        " f:" + fatherName.getText().toString() +
                        " e:" + eventYear.getText().toString() +
                        " d:" + text.getText().toString()
        );
        dataRef.setText("Источник: " + hero.dataRef);

        dataRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void onCloseInfo(View view) {
        finish();
    }

    public void onPrev(View view) {
        if (currentId > 0){
            currentId--;
            hero = heroes.get(currentId);
            updateData();
        }
    }

    public void onNext(View view) {
        if (currentId < heroes.size()-1){
            currentId++;
            hero = heroes.get(currentId);
            updateData();
        }
    }
}