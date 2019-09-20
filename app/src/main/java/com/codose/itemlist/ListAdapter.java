package com.codose.itemlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.CustomViewHolder> {
    Context context;
    ArrayList<String> itemNames;
    ArrayList<Integer> itemImage;
    ArrayList<String> itemPrice;

    public ListAdapter(Context context, ArrayList<String> itemNames, ArrayList<String> itemPrice, ArrayList<Integer> itemImage) {
        this.context = context;
        this.itemNames = itemNames;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_menu, parent,false);
        CustomViewHolder vh =  new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        holder.itemName.setText(itemNames.get(position));
        holder.itemPic.setImageResource(itemImage.get(position));
        holder.itemPrice.setText(itemPrice.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, itemActivity.class);
                intent.putExtra("itemPrice", itemPrice.get(position))
                        .putExtra("itemName", itemNames.get(position))
                        .putExtra("itemPic", itemImage.get(position));
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemNames.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemPrice;
        ImageView itemPic;
        CardView cardView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.name);
            itemPrice = itemView.findViewById(R.id.price);
            itemPic = itemView.findViewById(R.id.itemImage);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
