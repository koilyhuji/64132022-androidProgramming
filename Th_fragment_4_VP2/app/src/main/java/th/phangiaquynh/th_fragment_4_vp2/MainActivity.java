package th.phangiaquynh.th_fragment_4_vp2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
         BottomNavigationView bottomNavigationView=findViewById(R.id.botnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.cn1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn1Frag()).commit();
                } else if (item.getItemId() == R.id.cn2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn2Frag()).commit();
                } else if (item.getItemId() == R.id.cn3) {

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn3Frag()).commit();
                } else if (item.getItemId() == R.id.cn4) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Cn4Frag()).commit();
                }
                return true;
            }
        });
    }
}