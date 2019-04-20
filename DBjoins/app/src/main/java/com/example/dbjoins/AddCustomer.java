package com.example.dbjoins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCustomer extends AppCompatActivity {

    DBHelper_cust dbHelperCust;
    private EditText cust_name;
    private EditText cust_id;
    private EditText country;
    private Button addCust;
    private Button cancelCust;
    private String data_id, txt, con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        dbHelperCust = new DBHelper_cust(this);

        //initialization

        addCust = (Button)findViewById(R.id.add_customer);
        cancelCust = (Button)findViewById(R.id.cancel_cust);

        cust_id = (EditText)findViewById(R.id.add_cust_id_field);
        cust_name = (EditText)findViewById(R.id.name_field);
        country = (EditText)findViewById(R.id.country_field);


        //onClickListeners
        addCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int did;
                data_id = cust_id.getText().toString().trim();
                txt = cust_name.getText().toString().trim();
                con = country.getText().toString().trim();
                if(data_id.length()==0){
                    did = -1;
                }else {
                    did = Integer.valueOf(data_id);
                }
                if(txt.length() == 0 || con.length() == 0){
                    Toast.makeText(getApplicationContext(),"Enter name and phone no. first", Toast.LENGTH_SHORT).show();
                    (txt.length() != 0 ? country : cust_name).requestFocus();
                }
                else{
                    long rInsert = dbHelperCust.insert(did, txt, con);
                    if (rInsert == -1) {
                        Toast.makeText(getApplicationContext(), "Error in adding data!!!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        cancelCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCustomer.super.onBackPressed();
            }
        });

    }



    protected void onStart() {
        super.onStart();
        dbHelperCust.openDB();
    }

    protected void onStop(){
        super.onStop();
        dbHelperCust.closeDB();
    }
}
