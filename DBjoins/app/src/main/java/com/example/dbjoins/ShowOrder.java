package com.example.dbjoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ShowOrder extends AppCompatActivity {

    private ArrayList<Integer> items;
    private ArrayList<String> items1;
    private ArrayList<String> items2;

    DBHelper_cust dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_order);
        dbHelper = new DBHelper_cust(this);

        items = new ArrayList<Integer>();
        items1 = new ArrayList<String>();
        items2 = new ArrayList<String>();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.order_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new OrderListAdapter(items, items1, items2));


    }
}
