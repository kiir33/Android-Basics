package com.example.dbjoins;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ProgramViewHolder>  {

    private ArrayList<Integer> data1;
    private ArrayList<String> data2;
    private ArrayList<String> data3;


    public OrderListAdapter(ArrayList<Integer> data1, ArrayList<String> data2, ArrayList<String> data3){
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    @Override
    public ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_layout, viewGroup, false);

        return new ProgramViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramViewHolder programViewHolder, int i) {


        programViewHolder.idField.setText(String.valueOf(data1.get(i)));
        programViewHolder.field1.setText(data2.get(i));
        programViewHolder.field2.setText(data3.get(i));

    }

    @Override
    public int getItemCount() {

        return data1.size();
    }

    public class ProgramViewHolder extends RecyclerView.ViewHolder{

        TextView idField, field1,field2;
        RecyclerView parentLayout;

        public ProgramViewHolder (View itemView){
            super(itemView);
            idField = (TextView) itemView.findViewById(R.id.id_field);
            field1 = (TextView) itemView.findViewById(R.id.field1);
            field2 = (TextView) itemView.findViewById(R.id.field2);
            parentLayout = (RecyclerView)itemView.findViewById(R.id.order_list);
        }

    }

}