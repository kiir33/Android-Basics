package com.example.radio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton male, female, others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGrp);
        male = findViewById(R.id.radio1);
        female = findViewById(R.id.radio2);
        others = findViewById(R.id.radio3);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(male.isChecked()==true){
                    Toast.makeText(getApplicationContext(),"You checked MALE !",Toast.LENGTH_SHORT).show();
                } else if(female.isChecked()==true){
                    Toast.makeText(getApplicationContext(),"You checked FEMALE !",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"You checked OTHERS !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
