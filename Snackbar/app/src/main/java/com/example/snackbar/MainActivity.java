package com.example.snackbar;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button clr_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        clr_btn = findViewById(R.id.clr_btn);

        clr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String temp = editText.getText().toString();
                editText.setText("");

                Snackbar.make(v, "You cleared the Text!",Snackbar.LENGTH_LONG)
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        editText.setText(temp);
                                        Toast.makeText(getApplicationContext(),"Snackbars Action Clicked!!",Toast.LENGTH_SHORT).show();
                                    }
                                }).show();

            }
        });
    }
}
