package com.example.spinner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;
    Handler handler = new Handler();
    Runnable refresh;
    public String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        String[] items = {"yyyy-MM-dd   hh:mm:ss", "yyyy/MM/dd","hh:mm:ss"};


        List<String> l = new ArrayList<String>();
        for (int i = 0 ; i < items.length; i++){

            l.add(items[i]);
        }

        ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,l);
        a.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item );
        spinner.setAdapter(a);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                item = parent.getItemAtPosition(position).toString();
                refresh = new Runnable() {
                    public void run() {

                        SimpleDateFormat s = new SimpleDateFormat(item);
                        textView.setText(s.format(new Date()));
                        //Toast.makeText(getApplicationContext(), item + " Selected!",Toast.LENGTH_SHORT).show();

                        handler.postDelayed(refresh, 1000);
                    }
                };
                handler.post(refresh);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Nothing Selected!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
