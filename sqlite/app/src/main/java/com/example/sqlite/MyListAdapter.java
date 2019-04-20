package com.example.sqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ProgramViewHolder>  {

    private ArrayList<String> id = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> phone = new ArrayList<>();


    public MyListAdapter(ArrayList<String> id, ArrayList<String> name, ArrayList<String> phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_layout, viewGroup, false);

        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {

        String new_id = id.get(i);
        programViewHolder.sn.setText(new_id + ")\t");

        String new_name = name.get(i);
        programViewHolder.title.setText(new_name);

        String new_phone = phone.get(i);
        programViewHolder.date.setText(new_phone);

    }

    @Override
    public int getItemCount() {

        return id.size();
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{

        TextView sn, title, date;
        RecyclerView parentLayout;

        public ProgramViewHolder (View itemView){
            super(itemView);
            sn = (TextView) itemView.findViewById(R.id.sn);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView)itemView.findViewById(R.id.date);
            parentLayout = (RecyclerView)itemView.findViewById(R.id.recyclerView);
        }

    }

}
