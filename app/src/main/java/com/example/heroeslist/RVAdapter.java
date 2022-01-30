package com.example.heroeslist;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.HeroViewHolder> {

    private ArrayList<Hero> heroes; // список героев для отображения
    private OnStateClick onStateClick; // обработчик нажатия на элемент

    // конструктор
    public RVAdapter(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }



    // создание холдера
    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // создание разметки для холдера
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        // создание холдера
        HeroViewHolder holder = new HeroViewHolder(v);
        return holder;
    }


    // получение колличества элементов
    @Override
    public int getItemCount() {
        return heroes.size();
    }

    // обновление холдера
    @Override
    public void onBindViewHolder(HeroViewHolder heroViewHolder, @SuppressLint("RecyclerView") int i) {
        // обновление холдера
        heroViewHolder.bind(i);
        // установка слушателя нажатий
        heroViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onStateClick != null){
                    onStateClick.onStateClick(heroes.get(i));
                }
            }
        });
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // интерфейс для упрощения обработки нажатия на элемент списка
    interface OnStateClick {
        public void onStateClick(Hero hero);
    }

    // холдер
    public class HeroViewHolder extends RecyclerView.ViewHolder {
        CardView cv; // CardView холдера
        TextView name; // имя героя
        TextView surname; // фамилия героя
        TextView ageAtEvent; // возраст героя на момент подвига
        ImageView image; // фото героя

        // конструктор
        HeroViewHolder(View itemView) {
            super(itemView);
            // получение объектов разметки
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.tv_name);
            surname = (TextView)itemView.findViewById(R.id.tv_surname);
            ageAtEvent = (TextView)itemView.findViewById(R.id.tv_age_at_event);
            image = (ImageView)itemView.findViewById(R.id.iv_image);
        }

        // обновление данных холдера
        public void bind(int index){
            name.setText(heroes.get(index).name);  // обновление имени
            surname.setText(heroes.get(index).surname);  // обновление фамилии
            ageAtEvent.setText(heroes.get(index).ageAtEvent + " лет");  // обновление возраста героя на момент подвига
            if (heroes.get(index).image != null){
                image.setImageBitmap(heroes.get(index).image);  // обновление фотографии
            }
            image.setMaxHeight(image.getWidth());
            Log.e("holder", "bind: " + name.getText() + " " + surname.getText() + " " + ageAtEvent.getText());
        }
    }

    // установка обработки нажатия на элемент списка
    public void setOnStateClick(OnStateClick onStateClick) {
        this.onStateClick = onStateClick;
    }
}