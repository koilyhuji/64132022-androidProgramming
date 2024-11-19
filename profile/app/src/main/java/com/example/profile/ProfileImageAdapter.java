package com.example.profile;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfileImageAdapter extends RecyclerView.Adapter<ProfileImageAdapter.Profile_image_holder> {
    private Context context;
    private int[] imglist;

    public ProfileImageAdapter(Context context, int[] imglist) {
        this.context = context;
        this.imglist = imglist;
    }

    @NonNull
    @Override
    public Profile_image_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_profile_card,parent,false);
        return new Profile_image_holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Profile_image_holder holder, int position) {
        holder.img.setImageResource(imglist[position]);
    }

    @Override
    public int getItemCount() {
        return this.imglist.length;
    }
    public class Profile_image_holder extends RecyclerView.ViewHolder{
        ImageView img;
        public Profile_image_holder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.card_icon);
        }
    }
}
