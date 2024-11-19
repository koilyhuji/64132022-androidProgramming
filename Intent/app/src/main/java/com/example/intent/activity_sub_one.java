package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class activity_sub_one extends AppCompatActivity {
    private TextView textViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub_one);
        textViewData = findViewById(R.id.textViewData);

    }
    public void ToMain(View v){
        Intent recived = getIntent();
        String data = recived.getStringExtra("ten");
        Toast.makeText(this,data,Toast.LENGTH_SHORT);

        // Display the data in the TextView
        if (data != null) {
            textViewData.setText(data);
        } else {
            textViewData.setText("No data received");
        }
        startActivity(new Intent(this, MainActivity.class));
    }
}