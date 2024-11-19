package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }

    public void switchbai1(View v){
       Intent bai1 = new Intent(this, BMIActivity.class);
       startActivity(bai1);
    }
    public void switchbai2(View v){
        Intent bai2 = new Intent(this, BaiListView.class);
        startActivity(bai2);
    }
    public void switchbai3(View v){
        Intent bai3 = new Intent(this, BaiRecycleView.class);
        startActivity(bai3);
    }
    public void switchbai4(View v){
        Intent bai4 = new Intent(this, Profileview.class);
        startActivity(bai4);
    }
}