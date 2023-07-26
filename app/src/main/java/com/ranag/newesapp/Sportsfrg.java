package com.ranag.newesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Sportsfrg extends Fragment {

    String apikey="d52ead92cbb84aa2854dd80ec732789f";
    private RecyclerView recyclerViewspo;
    Adepter adepter;
    ArrayList<ModelClass> arrayList;
    String country="in";
    String category="sports";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sportsfrg, container, false);
        recyclerViewspo=view.findViewById(R.id.recycleofsports);
        recyclerViewspo.setLayoutManager(new LinearLayoutManager(getContext()));
        arrayList=new ArrayList<>();
        adepter=new Adepter(getContext(),arrayList);
        recyclerViewspo.setAdapter(adepter);
        findNews();




        return view;
    }

    private void findNews() {
        ApiUtilitis.getApiInterface().getCategoryNews(country,category,100,apikey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if(response.isSuccessful()){
                    arrayList.addAll(response.body().getArticles());
                    adepter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });


    }
}