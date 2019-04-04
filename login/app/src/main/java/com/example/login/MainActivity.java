package com.example.login;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password;
    Button btn_signup, btn_login;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextInputEditText)findViewById(R.id.username);
        password = (TextInputEditText)findViewById(R.id.password);
        btn_signup = (Button)findViewById(R.id.signup);
        btn_login = (Button)findViewById(R.id.login);
        databaseHelper = new DatabaseHelper(this);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = username.getText().toString();
                String p = password.getText().toString();
                if(u.length()!= 0){
                    AddData(u,p);

                    username.setText("");
                    password.setText("");
                    //Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                    //intent.putExtra("USER", username.getText().toString());
                    //startActivity(intent);
                }

                else{
                    Toast.makeText(getApplicationContext(),"Insert field empty!!!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
                startActivity(intent);

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void AddData(String txt1, String txt2){
        boolean insertData = databaseHelper.addData(txt1,txt2);
        if(insertData){
            Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Insert Failed",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
