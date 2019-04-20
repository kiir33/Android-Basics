package com.example.dbjoins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button add_order, add_cust, show_order, show_cust;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_cust = (Button)findViewById(R.id.customer);
        add_order = (Button)findViewById(R.id.order);
        show_cust = (Button)findViewById(R.id.show_cust);
        show_order = (Button)findViewById(R.id.show_order);

        //onClick Add customer
        add_cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddCustomer.class);
                startActivity(intent);
            }
        });

        //onClick Add Order
        add_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddOrder.class);
                startActivity(intent);
            }
        });

        show_cust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShowCustomer.class);
                startActivity(intent);
            }
        });

        show_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShowOrder.class);
                startActivity(intent);
            }
        });
    }
}
