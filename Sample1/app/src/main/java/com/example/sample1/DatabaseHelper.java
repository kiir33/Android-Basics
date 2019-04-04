package com.example.sample1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "people_table";
    private static final String col1 = "ID";
    private static final String col2 = "name";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," + col2 + "TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Boolean addData(String item){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col2, item);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return true;
        }
        else {
            return false;
        }
    }
}
