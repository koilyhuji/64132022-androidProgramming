package com.example.finalprojecttest;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    static int green = Color.rgb(4, 168, 46);
    static int grey = Color.rgb(40, 40, 45);
    static int red = Color.rgb(176, 14, 35);
    static int darkgrey = Color.rgb(30, 30, 30);
    static int black = Color.rgb(0, 0, 0);
    static int lightBlack = Color.rgb(20,20,22);
    static int superLightBlack = Color.rgb(10,10,10);

    public static int height;
    public static int width;
    public static View view;
    LinearLayout bar;
    LinearLayout viewContainer;
    LinearLayout pageHolder;
    LinearLayout page;

    LinearLayout.LayoutParams bottomPara;

    public static int id;
    static int identifier = 3;
    static  boolean hasLoadedOnce = false;
    BottomNavigationView bottomNavigation;
    LinearLayout banner;

    private static final String TAG = "MainActivity";


    static boolean inWeightPage = false;

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
        bottomNavigation = findViewById(R.id.bottom_navigation);
        NavigationBarView.OnItemSelectedListener listener = new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int ids = item.getItemId();
                switch (ids) {
                    case R.id.stats_item:
                        pageHolder.removeAllViews();

                        makeStatChooser();

                        pageHolder.addView(page);
                        return true;
                    case R.id.profile_item:
                        // Respond to navigation item 2 click
                        return true;
                    default:
                        return false;
                }
            }
        };
    }
    public void makeStatChooser(){
        page = new LinearLayout(this);
        StatChooserClass.createLayout(view, page);
        page.setLayoutParams(bottomPara);
    }
}