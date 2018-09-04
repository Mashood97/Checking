package com.example.masho.checking;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by OK Computers on 8/26/2018.
 */

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.MyViewHolder> {

    Context context;
    ArrayList<FoodItemclass> profiles;
    int Quantity =0;


    public FoodItemAdapter(Context c , ArrayList<FoodItemclass> p)
    {
        context = c;
        profiles = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.name.setText(profiles.get(position).getName());
        holder.price.setText(String.valueOf(profiles.get(position).getPrice()));
        //holder.quantity.setText(String.valueOf(profiles.get(position).getQuantity()));
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Quantity = Quantity + 1;
                holder.quantity.setText(Quantity);
                }
        });
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,price,quantity;
        Button add,sub;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.ItemNameIds);
            price = (TextView) itemView.findViewById(R.id.ItemPriceId);
            quantity = (TextView)itemView.findViewById(R.id.quantity);
            add = (Button)itemView.findViewById(R.id.addBtn);
            sub = (Button)itemView.findViewById(R.id.subBtn);

        }
    }
}
