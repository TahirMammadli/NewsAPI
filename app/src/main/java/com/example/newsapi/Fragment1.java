package com.example.newsapi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment1 extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<Article> arrayList;
    private ArticleAdapter mArticleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.news_fragment, container, false);
        Log.d("test1", "onCreateView: ");
        recyclerView = view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                new LinearLayoutManager(getActivity()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        arrayList = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);
        Call<wraparticles> call = retrofitApi.getArticles();
        call.enqueue(new Callback<wraparticles>() {
            @Override
            public void onResponse(Call<wraparticles> call, Response<wraparticles> response) {

                List<Article> list = response.body().getArticle();
                for (int i = 0; i < list.size(); i++) {
                    String author = list.get(i).getAuthor();
                    String title = list.get(i).getTitle();
                    String description = list.get(i).getDescription();

                    arrayList.add(new Article(author, title, description));
                    mArticleAdapter = new ArticleAdapter(getActivity(), arrayList);
                    recyclerView.setAdapter(mArticleAdapter);
                }

            }

            @Override
            public void onFailure(Call<wraparticles> call, Throwable t) {

            }
        });
        return view;
    }
}

