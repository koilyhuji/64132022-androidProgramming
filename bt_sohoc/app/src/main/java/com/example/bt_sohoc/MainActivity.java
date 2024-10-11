package com.example.bt_sohoc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bCong, bTru, bNhan, bChia;
    EditText editA,editB;
    TextView tvketqua;
    void getControl(){
        bCong = findViewById(R.id.button);
        bTru = findViewById(R.id.button2);
        bNhan = findViewById(R.id.button3);
        bChia = findViewById(R.id.button4);
        editA = findViewById(R.id.editTextText);
        editB = findViewById(R.id.editTextText2);
        tvketqua = findViewById(R.id.editTextText3);
    }
    public void XuLy_Cong(View v){
        Double a = Double.parseDouble(editA.getText().toString());
        Double b = Double.parseDouble(editB.getText().toString());
    tvketqua.setText(String.valueOf(a+b));
    }
    public void XuLy_Nhan(View v){

    }
    public void XuLy_Tru(View v){

    }
    public void XuLy_Chia(View v){

    }
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
        getControl();
        bCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}