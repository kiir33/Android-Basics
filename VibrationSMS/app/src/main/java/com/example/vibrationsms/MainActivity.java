package com.example.vibrationsms;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button vibBtn,sendBtn,composeBtn;
    private EditText phone, msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibBtn = findViewById(R.id.vibrateBtn);
        phone = findViewById(R.id.phone);
        msg = findViewById(R.id.msg);
        sendBtn = findViewById(R.id.sendBtn);
        composeBtn = findViewById(R.id.composeBtn);


        vibBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(1500);
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = phone.getText().toString();
                String sms = msg.getText().toString();
                sendSMS(num,sms);
            }
        });

        composeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeSMS();
            }
        });

    }

    protected void sendSMS(String num, String sms){
        try{
            SmsManager s = SmsManager.getDefault();
            s.sendTextMessage(num,null,sms,null,null);
            Toast.makeText(getApplicationContext(),"SMS sent!",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"\n SMS Failed!",Toast.LENGTH_SHORT).show();
        }
    }

    protected void composeSMS(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms to: "));
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address",new String("+9779843745263"));
        intent.putExtra("sms-body","Namaste");
        try{
            startActivity(intent);
            finish();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
    }
}
