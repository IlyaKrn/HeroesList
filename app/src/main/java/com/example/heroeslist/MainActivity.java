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

    public static ArrayList<Hero> heroesMainList;
    public static ArrayList<Hero> heroesSearchList;
    private EditText search;
    private RecyclerView recyclerView;
    private RVAdapter adapter;
    private GridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        heroesMainList = new ArrayList<>();
        heroesSearchList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        search = findViewById(R.id.et_search);

        layoutManager = new GridLayoutManager(this, 2);
        adapter = new RVAdapter(heroesSearchList);
        adapter.setOnStateClick(new RVAdapter.OnStateClick() {
            @Override
            public void onStateClick(Hero hero) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra("hero_index", hero.id);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        fillList();
    }

    private void sort(){
        if (heroesSearchList.size() > 0) heroesSearchList.clear();
        for (Hero h : heroesMainList){
            if (search.getText().toString().equals(h.ageAtEvent)){
                heroesSearchList.add(h);
            }
            else if (search.getText().toString().equals("") || search.getText().toString() == null){
                heroesSearchList.addAll(heroesMainList);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void fillList(){
        for (int i = 0; i < 99; i++) {
            heroesMainList.add(new Hero("2000","2010","10","name" + i, "surname", "fatherName", "ref",  "text", ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
        }
        heroesSearchList.addAll(heroesMainList);
    }


}