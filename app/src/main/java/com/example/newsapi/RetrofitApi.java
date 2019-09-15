package com.example.newsapi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("top-headlines?country=us&apiKey=39bf5b151a784c668ba07eeb596de115")
    Call<wraparticles> getArticles();



    //@Query("country")String country,
    //@Query("apiKey")String apiKey

}
