package com.example.profile;

import retrofit2.http.GET;
import retrofit2.Call;

interface ApiService {
    @GET("image.json")
    Call<ImageResponse> getImages();
}