package com.example.calculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView display,result;
    private double num1 = Double.NaN;
    private double num2;
    private char sign = '0';
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.light:
                v.setBackgroundColor(getResources().getColor(android.R.color.white));
                Toast.makeText(getApplicationContext(),"light selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.dark:
                v.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                Toast.makeText(getApplicationContext(),"dark selected",Toast.LENGTH_SHORT).show();
                break;

            case R.id.exit:
                Toast.makeText(getApplicationContext(),"BYE BYE !",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return true;
    }

    private void init() {

        display = (TextView) findViewById(R.id.disp);
        result = (TextView)findViewById(R.id.result);
        v = (View)findViewById(R.id.view);

        Button[] num = new Button[10];
        num[0] = (Button)findViewById(R.id.btn0);
        num[1] = (Button)findViewById(R.id.btn1);
        num[2] = (Button)findViewById(R.id.btn2);
        num[3] = (Button)findViewById(R.id.btn3);
        num[4] = (Button)findViewById(R.id.btn4);
        num[5] = (Button)findViewById(R.id.btn5);
        num[6] = (Button)findViewById(R.id.btn6);
        num[7] = (Button)findViewById(R.id.btn7);
        num[8] = (Button)findViewById(R.id.btn8);
        num[9] = (Button)findViewById(R.id.btn9);


        Button pt= (Button)findViewById(R.id.btnPt);
        Button pct = (Button)findViewById(R.id.btnPercent);
        Button eq = (Button)findViewById(R.id.btnEq);
        Button sq = (Button)findViewById(R.id.btnSq);
        Button sqrt = (Button)findViewById(R.id.btnSqrt);

        Button add = (Button)findViewById(R.id.btnAdd);
        Button sub = (Button)findViewById(R.id.btnSub);
        Button mul = (Button)findViewById(R.id.btnMul);
        Button div = (Button)findViewById(R.id.btnDiv);
        Button clr = (Button)findViewById(R.id.btnClear);

        for(int i = 0; i < 10 ; i++){
            num[i].setOnClickListener(CalcListener);
        }

        pt.setOnClickListener(CalcListener);
        pct.setOnClickListener(CalcListener);
        eq.setOnClickListener(CalcListener);
        sq.setOnClickListener(CalcListener);
        sqrt.setOnClickListener(CalcListener);
        add.setOnClickListener(CalcListener);
        sub.setOnClickListener(CalcListener);
        mul.setOnClickListener(CalcListener);
        div.setOnClickListener(CalcListener);
        clr.setOnClickListener(CalcListener);


    }

    public View.OnClickListener CalcListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String prevValue;


            switch (v.getId()){

                case R.id.btn0:
                    display.append("0");
                    break;

                case R.id.btn1:
                    display.append("1");
                    break;

                case R.id.btn2:
                    display.append("2");
                    break;

                case R.id.btn3:
                    display.append("3");
                    break;

                case R.id.btn4:
                    display.append("4");
                    break;

                case R.id.btn5:
                    display.append("5");
                    break;

                case R.id.btn6:
                    display.append("6");
                    break;

                case R.id.btn7:
                    display.append("7");
                    break;

                case R.id.btn8:
                    display.append("8");
                    break;

                case R.id.btn9:
                    display.append("9");
                    break;

                case R.id.btnPt:
                    display.append(".");
                    break;

                case R.id.btnAdd:
                    sign = '+';
                    compute();
                    result.setText(String.valueOf(num1) + "+");
                    display.setText(null);
                    break;

                case R.id.btnSub:
                    sign = '-';
                    compute();
                    result.setText(String.valueOf(num1) + "-");
                    display.setText(null);
                    break;

                case R.id.btnMul:
                    sign = '*';
                    compute();
                    result.setText(String.valueOf(num1) + "x");
                    display.setText(null);
                    break;

                case R.id.btnDiv:
                    sign = '/';
                    compute();
                    result.setText(String.valueOf(num1) + "/");
                    display.setText(null);
                    break;

                case R.id.btnEq:
                    sign = '0';
                    compute();
                    result.setText(result.getText().toString()+ String.valueOf(num2) + " = " + String.valueOf(num1));
                    display.setText(null);
                    break;

                case R.id.btnClear:
                    display.setText(null);
                    result.setText(null);
                    sign = '0';
                    num1 = Double.NaN;
                    break;


            }

        }
    };

    private void compute() {

        if(!Double.isNaN(num1)){
            num2 = Double.parseDouble(display.getText().toString());

            switch (sign){
                case '+':
                    num1 += num2;
                    break;

                case '-':
                    num1 -= num2;
                    break;

                case '*':
                    num1 *= num2;
                    break;

                case '/':
                    num1 /= num2;
                    break;

                case '0':
                    break;

            }
        }else {
            num1 = Double.parseDouble(display.getText().toString());
        }
    }
}
