package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.HttpURLConnection;
import java.util.ArrayList;

public class adapterPokemonRecyclr  extends RecyclerView.Adapter<adapterPokemonRecyclr.Viewholder>{


    private ArrayList<Pokemon> pokearray;
    private Context c;
    private View.OnClickListener pokelistner;


    public adapterPokemonRecyclr(ArrayList<Pokemon> pokearray, Context c) {
        this.pokearray = pokearray;
        this.c = c;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem, parent, false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        Glide.with(c).asBitmap().load(pokearray.get(position).getImage()).into(holder.ivPoke);
        holder.tvPoke.setText(pokearray.get(position).getName());
       // pokearray.setText(pokearray.get(position).getName());





    }

    public void setOnItemClickListner(View.OnClickListener itemClickListner){

        pokelistner = itemClickListner;
    }

    @Override
    public int getItemCount() {


        return pokearray.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder{

        ImageView ivPoke;
        TextView tvPoke;

        public Viewholder(@NonNull View itemView) {
            super(itemView);


            ivPoke= itemView.findViewById(R.id.ivPoke);
            tvPoke= itemView.findViewById(R.id.tvPoke);

            itemView.setTag(this);
            itemView.setOnClickListener(pokelistner);
        }
    }
}
