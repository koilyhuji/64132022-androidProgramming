package com.example.call_api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GridCustomAdapter extends ArrayAdapter<ExampleObj> {
    List<ExampleObj> objects;
    Context context;
    public GridCustomAdapter(@NonNull Context context, int resource,@NonNull ArrayList<ExampleObj> objects) {
        super(context, resource,objects);
        this.objects = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ExampleObj obj = objects.get(position);
        LayoutInflater inflater = LayoutInflater.from(this.context);
        convertView = inflater.inflate(R.layout.product_item,null);
        ImageView imgview = convertView.findViewById(R.id.productimageView);
        TextView textView = convertView.findViewById(R.id.producttextView);
        if(obj.getImage() != NO_SELECTION){
            imgview.setImageResource(obj.getImage());
        }
        textView.setText(obj.getText());
        return convertView;
    }
}
