package com.example.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.profile.recycleviewb.BCardAdapter;
import com.example.profile.recycleviewb.CardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaiRecycleView extends AppCompatActivity {
    private RecyclerView rc;

    private ArrayList<CardItem> cardItems = new ArrayList<>();
    private List<String> resultlist = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycle_view);
        fetchlocalImages();
        for (String url: resultlist
             ) {
            cardItems.add(new CardItem(url));
        }
        rc = findViewById(R.id.recyclerViewcard);

        rc.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rc.setAdapter(new BCardAdapter(this,cardItems));
    }
    private void fetchImages() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://huggingface.co/spaces/jsuwi1kjw/imagesomte/raw/main/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        new Thread(() ->  {
            try {
                ImageResponse response = (ImageResponse) apiService.getImages();
                resultlist = response.images;
            } catch (Exception e) {
                // Handle error
                Toast.makeText(this, "Error loading images", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void fetchlocalImages(){
        String[] array = {"https://cdn.pixabay.com/photo/2023/06/11/19/09/fruit-8056663_1280.jpg", "https://cdn.pixabay.com/photo/2018/10/02/16/12/nature-3719233_1280.jpg","https://cdn.pixabay.com/photo/2024/02/08/21/44/foliage-8561873_1280.jpg","https://cdn.pixabay.com/photo/2016/12/17/18/51/spices-1914130_1280.jpg","https://cdn.pixabay.com/photo/2016/08/17/01/39/mystery-1599527_1280.jpg","https://cdn.pixabay.com/photo/2018/01/12/10/19/fantasy-3077928_1280.jpg","https://cdn.pixabay.com/photo/2024/01/27/18/24/squirrel-8536537_1280.jpg","https://cdn.pixabay.com/photo/2024/01/02/14/58/leaf-8483401_1280.jpg","https://cdn.pixabay.com/photo/2022/12/01/14/46/city-7629244_1280.jpg","https://cdn.pixabay.com/photo/2023/08/26/18/01/planet-8215532_1280.png"};
        resultlist.addAll(Arrays.asList(array));
    }
}