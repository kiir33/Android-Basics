package com.example.sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText people_id,name, phone;
    Button add, read, update, delete;
    RecyclerView recyclerView;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(MainActivity.this);
        init();
    }

    public void init(){

        people_id = (EditText) findViewById(R.id.idField);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        add = (Button) findViewById(R.id.btn_add);
        read = (Button) findViewById(R.id.btn_read);
        update = (Button) findViewById(R.id.btn_update);
        delete = (Button) findViewById(R.id.btn_delete);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        add.setOnClickListener(CRUDListener);
        read.setOnClickListener(CRUDListener);
        update.setOnClickListener(CRUDListener);
        delete.setOnClickListener(CRUDListener);

    }

    protected void onStart() {
        super.onStart();
        dbHelper.openDB();
    }

    protected void onStop(){
        super.onStop();
        dbHelper.closeDB();
    }

    public String getValue(EditText editText){
        return editText.getText().toString().trim();
    }

    public View.OnClickListener CRUDListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_add:
                    int did;
                    String data_id = getValue(people_id);
                    String txt = getValue(name);
                    String phn = getValue(phone);
                    if(data_id.length()==0){
                        did = -1;
                    }else {
                        did = Integer.valueOf(data_id);
                    }
                    if(txt.length() == 0 || phn.length() == 0){
                        Toast.makeText(getApplicationContext(),"Enter name and phone no. first", Toast.LENGTH_SHORT).show();
                        (txt.length() != 0 ? phone : name).requestFocus();
                    }
                    else{
                        long rInsert = dbHelper.insert(did, getValue(name), getValue(phone));
                        if (rInsert == -1) {
                            Toast.makeText(getApplicationContext(), "Error in adding data!!!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

                case  R.id.btn_read:

                    Cursor cursor = dbHelper.getAllRecords();

                    ArrayList<String> id = new ArrayList<String>();
                    ArrayList<String> names = new ArrayList<String>();
                    ArrayList<String> phones = new ArrayList<String>();

                    for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){

                        id.add((cursor.getString(cursor.getColumnIndex(dbHelper.id))));
                        names.add((cursor.getString(cursor.getColumnIndex(dbHelper.name))));
                        phones.add((cursor.getString(cursor.getColumnIndex(dbHelper.phone))));
                    }
                    recyclerView.setAdapter(new MyListAdapter(id, names, phones));
                    break;

                case R.id.btn_update:
                    long rUpdate = dbHelper.update(Integer.valueOf(getValue(people_id)),getValue(name),getValue(phone));
                    if(rUpdate == 0){
                        Toast.makeText(getApplicationContext(),"Error in updating data!",Toast.LENGTH_SHORT).show();
                    }else if(rUpdate == 1){
                        Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Error! Multiple records updated!",Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.btn_delete:

                    if(getValue(people_id).length()!=0) {
                        long rDelete = dbHelper.delete(Integer.valueOf(getValue(people_id)));
                        if (rDelete == 0) {
                            Toast.makeText(getApplicationContext(), "Error in deleting!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Deleted record successfully!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Enter ID to be deleted!",Toast.LENGTH_SHORT).show();
                        people_id.requestFocus();
                    }
                    break;
            }
        }
    };
}
