package com.example.dbjoins;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ShowCustomer extends AppCompatActivity {

    private ArrayList<Integer> items1;
    private ArrayList<String> items2;
    private ArrayList<String> items3;
    DBHelper_cust dbHelperCust;
    Cursor cursor;

    @Override
    protected void onStart() {
        super.onStart();
        dbHelperCust.openDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_customer);
        dbHelperCust = new DBHelper_cust(this);
        dbHelperCust.openDB();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.customer_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        items1 = new ArrayList<Integer>();
        items2 = new ArrayList<String>();
        items3 = new ArrayList<String>();

        cursor = dbHelperCust.getAllRecords();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            items1.add((cursor.getInt(cursor.getColumnIndex(dbHelperCust.id))));
            items2.add(cursor.getString(cursor.getColumnIndex(dbHelperCust.name)));
            items3.add(cursor.getString(cursor.getColumnIndex(dbHelperCust.country)));
        }
        recyclerView.setAdapter(new CustomerListAdapter(items1, items2, items3));
    }

    protected void onStop(){
        super.onStop();
        dbHelperCust.closeDB();
    }
}
