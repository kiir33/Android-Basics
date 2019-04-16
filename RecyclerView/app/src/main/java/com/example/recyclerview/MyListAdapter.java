package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ProgramViewHolder>  {

    private String[] data;
    private String[] dates;
    private int[] img;
    public MyListAdapter(String[] data, String[] date, int[] img){
        this.data = data;
        this.dates = date;
        this.img = img;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_layout, viewGroup, false);

        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {

        String title = data[i];
        final String date = dates[i];
        int imgTemp = img[i];
        programViewHolder.title.setText(title);
        programViewHolder.date.setText(date);
        programViewHolder.imageView.setImageResource(imgTemp);

    }

    @Override
    public int getItemCount() {

        return data.length;
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title, date;
        RecyclerView parentLayout;

        public ProgramViewHolder (View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            parentLayout = (RecyclerView)itemView.findViewById(R.id.mylist);
        }

    }

}
