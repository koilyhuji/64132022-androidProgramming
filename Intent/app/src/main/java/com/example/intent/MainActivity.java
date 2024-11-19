package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void SwitchToSubOne(View v){
        Intent toSub1 = new Intent(this, activity_sub_one.class);
        toSub1.putExtra("ten","something");
        startActivity(toSub1);
    }
    public void SwitchToSubTwo(View v){
        Intent toSub1 = new Intent(this, activity_sub_one.class);
        toSub1.putExtra("ten","something 2");
        startActivity(toSub1);
    }
}