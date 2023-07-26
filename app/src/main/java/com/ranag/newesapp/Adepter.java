package com.ranag.newesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adepter extends RecyclerView.Adapter<Adepter.ViewHolder> {
      Context context;
      ArrayList<ModelClass> arrayList;

    public Adepter(Context context, ArrayList<ModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public Adepter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.custom,null,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Adepter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, webView.class);
                intent.putExtra("url",arrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.mheading.setText(arrayList.get(position).getTitle());
        holder.author.setText(arrayList.get(position).getAuthor());
        holder.description.setText(arrayList.get(position).getDescription());
        holder.time.setText("     Published At:- "+arrayList.get(position).getPublishedAt());
        Glide.with(context).load(arrayList.get(position).getUrlToImage()).into(holder.imageView);

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mheading,author,time,description;
        ImageView imageView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.mainheading);
            author=itemView.findViewById(R.id.author);
            time=itemView.findViewById(R.id.time);
            description=itemView.findViewById(R.id.description);
            imageView =itemView.findViewById(R.id.imagenews);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}
