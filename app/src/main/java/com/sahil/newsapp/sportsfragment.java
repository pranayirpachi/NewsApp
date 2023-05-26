package com.sahil.newsapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sportsfragment extends Fragment {

    String api="1f2f7017f2594de782e24732176037c4";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
   // public RecyclerView recyclerViewsports;
    //RecyclerView.LayoutManager layoutManager;
   // RecyclerView.LayoutManager layoutManager;


    private String category="sports";

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerViewsports;
        View V = inflater.inflate(R.layout.sportsfragment,null);

        recyclerViewsports = (RecyclerView) V.findViewById(R.id.sportsfragment);
        modelClassArrayList= new ArrayList<>();
        recyclerViewsports.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewsports.setAdapter(adapter);
       // recyclerViewsports.setAdapter(adapter);

        findNews();

        return V;



    }

    private void findNews() {

        Apiutities.getApiIntergave().getcategoryNews(country,category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }



}
