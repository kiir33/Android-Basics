package com.example.login;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    private ListView listView;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        listView = (ListView)findViewById(R.id.listview);
        databaseHelper = new DatabaseHelper(this);
        populateListView();
    }

    private void populateListView(){

        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
    }
}
