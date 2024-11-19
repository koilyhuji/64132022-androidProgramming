package com.example.profile.recycleviewb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.profile.MainActivity;
import com.example.profile.R;

import java.util.ArrayList;

public class BCardAdapter extends RecyclerView.Adapter<BCardAdapter.CardItemViewHolder>{
    Context context;
    ArrayList<CardItem> dsItem;
    public BCardAdapter(Context cx, ArrayList<CardItem> item) {
        this.context = cx;
        this.dsItem = item;
    }

    @NonNull
    @Override
    public CardItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_image,parent,false);
        return new CardItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardItemViewHolder holder, int position) {
        CardItem item = dsItem.get(position);

        Glide.with(context).load(dsItem.get(position).image).centerCrop().into(holder.image);

    }



    @Override
    public int getItemCount() {
        return dsItem.size();
    }

    public class CardItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public CardItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageViewcard);
        }
    }

}
