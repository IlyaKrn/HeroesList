package com.example.heroeslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Hero> heroesMainList;
    private ArrayList<Hero> heroesSearchList;
    private EditText search;
    private RecyclerView recyclerView;
    private RVAdapter adapter;
    private GridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        search.removeTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sort();
            }
        });






    }

    private void sort(){
        for (Hero h : heroesMainList){
            if (String.valueOf(h.eventYear).equals(search.getText().toString())){
                heroesSearchList.add(h);
            }
        }




    }

    private void init(){
        heroesMainList = new ArrayList<>();
        heroesSearchList = new ArrayList<>();
        recyclerView = findViewById(R.id.rv);
        search = findViewById(R.id.et_search);

        fillList();

        layoutManager = new GridLayoutManager(this, 3);
        adapter = new RVAdapter(heroesSearchList);
        adapter.setOnStateClick(new RVAdapter.OnStateClick() {
            @Override
            public void onStateClick(Hero hero) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);





    }


    private void fillList(){
        for (int i = 0; i < 10; i++) {
            heroesMainList.add(new Hero("2000","200","20","" + i, "sdfds", "sdgsdg",  "text", ((BitmapDrawable) getDrawable(R.drawable.def)).getBitmap()));
        }
        heroesSearchList = heroesMainList;
    }


}