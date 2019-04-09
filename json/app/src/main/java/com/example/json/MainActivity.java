package com.example.json;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;


public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    public String msg = "Khwopa College of Engineering";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.result_view);
        button = findViewById(R.id.load_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadJSON();
            }
        });

    }

    private void loadJSON() {
        try{
            JSONObject object = new JSONObject(loadJSONFromAsset());
            JSONArray array = object.getJSONArray("students");

            for (int i = 0; i<array.length(); i++){
                JSONObject ji = array.getJSONObject(i);
                String name = ji.getString("name");
                String phone = ji.getString("contact");
                msg += "\nName: " + name + ", Contact: " + phone;
            }

            textView.setText(msg);
            Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private String loadJSONFromAsset() {
        String json = null;
        try {

            InputStream inputStream = getResources().openRawResource(getResources().getIdentifier("test","raw",getPackageName()));
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return json;
    }

}
