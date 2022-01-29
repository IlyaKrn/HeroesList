package com.example.heroeslist;

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

    private ArrayList<Hero> heroes;
    private OnStateClick onStateClick;


    public RVAdapter(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }




    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Log.e("adapter", "pre create holder");
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        HeroViewHolder holder = new HeroViewHolder(v);
        if (holder == null)
            Log.e("adapter", "holder created: " + " null");
        return holder;
    }



    @Override
    public int getItemCount() {
        return heroes.size();
    }


    @Override
    public void onBindViewHolder(HeroViewHolder heroViewHolder, int i) {
        heroViewHolder.bind(i);
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

    interface OnStateClick {
        public void onStateClick(Hero hero);
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        TextView surname;
        TextView ageAtEvent;
        ImageView image;
        HeroViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            name = (TextView)itemView.findViewById(R.id.tv_name);
            surname = (TextView)itemView.findViewById(R.id.tv_surname);
            ageAtEvent = (TextView)itemView.findViewById(R.id.tv_age_at_event);
            image = (ImageView)itemView.findViewById(R.id.iv_image);
            Log.e("holder", "created");
        }

        public void bind(int index){
            name.setText(heroes.get(index).name);
            surname.setText(heroes.get(index).surname);
            ageAtEvent.setText(heroes.get(index).ageAtEvent);
            if (heroes.get(index).image != null){
                image.setImageBitmap(heroes.get(index).image);
            }
            Log.e("holder", "bind: " + name.getText() + " " + surname.getText() + " " + ageAtEvent.getText());
        }
    }

    public void setOnStateClick(OnStateClick onStateClick) {
        this.onStateClick = onStateClick;
    }
}