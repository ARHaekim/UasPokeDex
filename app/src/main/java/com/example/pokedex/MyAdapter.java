package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyPoke> myPokes;

    public MyAdapter(Context c, ArrayList<MyPoke> list)
    {
        context = c;
        myPokes = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama_poke.setText(myPokes.get(position).getNama());
        holder.type_poke.setText(myPokes.get(position).getType());
        Picasso.with(context).load(myPokes.get(position).getPhoto()).into(holder.image);

        final String getNamaPoke = myPokes.get(position).getNama();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gopokemon = new Intent(context,Pokedex.class);
                gopokemon.putExtra("nama_pokemon", getNamaPoke);
                context.startActivity(gopokemon);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myPokes.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nama_poke,type_poke;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama_poke = (TextView) itemView.findViewById(R.id.nama_poke);
            type_poke = (TextView) itemView.findViewById(R.id.type_poke);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }

}
