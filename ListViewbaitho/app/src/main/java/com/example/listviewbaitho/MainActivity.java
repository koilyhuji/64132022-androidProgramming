package com.example.listviewbaitho;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsBaiTho;
    ListView lisviewBaither = findViewById(R.id.lvBt);;
    ArrayList<String> getData(){
        ArrayList<String> ddsBaiTho = new ArrayList<String>();
        ddsBaiTho.add("than em vua trang lai vua tron");
        ddsBaiTho.add("tron");
        ddsBaiTho.add("Dat nuoc");
        ddsBaiTho.add("Song");
        return ddsBaiTho;
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
        dsBaiTho = getData();
        ArrayAdapter<String> adapterther = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dsBaiTho);

        lisviewBaither.setAdapter(adapterther);
        lisviewBaither.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewPosHandle(i);
            }
        });
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView baither = findViewById(R.id.textView);
                String bt = baither.getText().toString();
                dsBaiTho.add(bt);
                adapterther.notifyDataSetChanged();
            }
        });

    }
    void ListViewPosHandle(int pos){
        String item = dsBaiTho.get(pos);
        Toast.makeText(getApplicationContext(),item,Toast.LENGTH_SHORT).show();
    }
}