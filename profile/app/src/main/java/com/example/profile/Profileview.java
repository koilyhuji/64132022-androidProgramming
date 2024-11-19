package com.example.profile;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Profileview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profileview);
        int[] imageIds = {R.drawable.ll1,R.drawable.ll2,R.drawable.ll3};
        RecyclerView rc = findViewById(R.id.langugager);
        rc.setLayoutManager(new GridLayoutManager(this,3));
        rc.setAdapter(new ProfileImageAdapter(this,imageIds));
    }
}