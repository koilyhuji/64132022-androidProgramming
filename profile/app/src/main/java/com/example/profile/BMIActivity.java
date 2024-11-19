package com.example.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class BMIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bmi_layout);


    }
    public void CalcBMI(View v){
        RadioButton chaua = findViewById(R.id.radio_pirates);
        RadioButton chauau = findViewById(R.id.radio_ninjas);
        EditText ed_heightInMeters = findViewById(R.id.editTextNumber1);
        EditText ed_weight = findViewById(R.id.editTextNumber2);
        TextView subresult = findViewById(R.id.subres);
        TextView result = findViewById(R.id.resultCalculate);
        float heightInMeters = 0, weight = 0;
        float bmi;
        try {
            heightInMeters = Float.parseFloat(ed_heightInMeters.getText().toString());
            weight =  Float.parseFloat(ed_weight.getText().toString());
            if(!(heightInMeters > 1 && heightInMeters <2.5) || !(weight > 1 && weight <500) ){
                subresult.setText("chieu cao hoac can nang khong hop le");
            }
        } catch (Exception e) {
            subresult.setText("chieu cao hoac can nang khong hop le");
            throw new Error(e);
        }

        bmi = weight / (heightInMeters * heightInMeters);
        result.setText(String.valueOf(bmi));
        if(chaua.isChecked()){
            if (bmi < 18.5) {
                subresult.setText("Underweight");
            } else if (bmi >= 18.5 && bmi < 25) {
                subresult.setText("Normal weight");
            } else if (bmi >= 25 && bmi < 30) {
                subresult.setText("Overweight");
            } else {
                subresult.setText("Obese");
            }
        }
        else if (chauau.isChecked()){
            if (bmi < 18.5) {
                subresult.setText("Underweight");
            } else if (bmi >= 18.5 && bmi < 22.9) {
                subresult.setText("Normal weight");
            } else if (bmi >= 23 && bmi < 24.9) {
                subresult.setText("Overweight");
            } else {
                subresult.setText("Obese");
            }
        }

    }
}