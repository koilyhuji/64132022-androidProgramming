package com.example.profile;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.profile.listviewb.SVListAdapter;
import com.example.profile.listviewb.SinhVien;

import java.util.ArrayList;

public class BaiListView extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        ArrayList<SinhVien> svlist = new ArrayList<>();
        svlist.add(new SinhVien("joe", "someclass", R.drawable.av1));
        svlist.add(new SinhVien("iegu ieufe", "someclass", R.drawable.av2));
        svlist.add(new SinhVien("gee", "someclass", R.drawable.av3));
        svlist.add(new SinhVien("weoe", "someclass", R.drawable.av4));
        svlist.add(new SinhVien("efoe", "someclass", R.drawable.av5));
        svlist.add(new SinhVien("jofefe", "someclass", R.drawable.av6));
        svlist.add(new SinhVien("jfwej", "someclass", R.drawable.av7));
        svlist.add(new SinhVien("fj", "someclass", R.drawable.av2));


        lv = findViewById(R.id.sinhvienitem);
        lv.setAdapter(new SVListAdapter(svlist,this));
    }
}