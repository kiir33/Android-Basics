package com.example.dbjoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddOrder extends AppCompatActivity {

    private Button addOrder, cancelOrder;
    private EditText order_id, cust_id, date;
    DBHelper_order dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);
        //initialization

        dbHelper = new DBHelper_order(this);
        dbHelper.openDB();

        order_id = (EditText)findViewById(R.id.order_id_field);
        cust_id = (EditText)findViewById(R.id.cust_id_field);
        date = (EditText)findViewById(R.id.date_field);

        Button addOrder = (Button)findViewById(R.id.add_order);
        Button cancelOrder = (Button)findViewById(R.id.cancel_order);

        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int did;
                String data_id = order_id.getText().toString().trim();
                String txt = cust_id.getText().toString().trim();
                String con = date.getText().toString().trim();
                if(data_id.length()==0){
                    did = -1;
                }else {
                    did = Integer.valueOf(data_id);
                }
                if(txt.length() == 0 || con.length() == 0){
                    Toast.makeText(getApplicationContext(),"Enter name and phone no. first", Toast.LENGTH_SHORT).show();
                    (txt.length() != 0 ? date : cust_id).requestFocus();
                }
                else{
                    long rInsert = dbHelper.insert(did, Integer.valueOf(txt), con);
                    if (rInsert == -1) {
                        Toast.makeText(getApplicationContext(), "Error in adding data!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddOrder.super.onBackPressed();
            }
        });

    }

    protected void onStart() {
        super.onStart();
        dbHelper.openDB();
    }

    protected void onStop(){
        super.onStop();
        dbHelper.closeDB();
    }
}
