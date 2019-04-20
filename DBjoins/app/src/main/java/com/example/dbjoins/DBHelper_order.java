package com.example.dbjoins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper_order extends SQLiteOpenHelper {
    public static String dbname ="kiran_db";
    public static int  VERSION = 1;

    public static String table2 = "ORDER";
    public static String id2 = "ORDER_ID";
    public static String name2 = "CUSTOMER_ID";
    public static String date = "DATE";

    SQLiteDatabase sqLiteDatabase;



    public DBHelper_order(Context context){
        super(context, dbname,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newV){
        String order_table = "CREATE TABLE IF NOT EXISTS "+ table2 + "( " +
                id2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                name2 + " INTEGER NOT NULL, " +
                date + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(order_table);
        Log.i("Table Order","Created");
    }

    public void openDB(){
        sqLiteDatabase = getWritableDatabase();
    }

    public void closeDB(){
        if(sqLiteDatabase!=null && sqLiteDatabase.isOpen()){
            sqLiteDatabase.close();
        }
    }


    //for order table
    public long insert(int order_id, int cust_id, String newDate){
        ContentValues contentValues = new ContentValues();
        if(order_id != -1) {
            contentValues.put(id2, order_id);
        }
        contentValues.put(name2,cust_id);
        contentValues.put(date,newDate);
        return sqLiteDatabase.insert(table2,null, contentValues);
    }


    public Cursor getAllRecords(){
        String sql = "SELECT * FROM " + table2;
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public long update(int order_id, String cust_name, String cust_country){
        ContentValues contentValues = new ContentValues();
        if(order_id != -1){
            contentValues.put(id2,order_id);
        }
        contentValues.put(name2,cust_name);
        contentValues.put(date,cust_country);
        String where = id2 + " = " + order_id;
        return sqLiteDatabase.update(table2,contentValues,where,null);
    }

    public long delete(int cust_id){
        String where = id2 + " = " + cust_id;
        return sqLiteDatabase.delete(table2,where,null);
    }
}
