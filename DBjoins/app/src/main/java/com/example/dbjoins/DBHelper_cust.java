package com.example.dbjoins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper_cust extends SQLiteOpenHelper {
    public static String dbname ="kiran_db";
    public static int  VERSION = 1;

    public static String table_name = "CUSTOMER";
    public static String id = "CUSTOMER_ID";
    public static String name = "CUSTOMER_NAME";
    public static String country = "COUNTRY";

    SQLiteDatabase sqLiteDatabase;



    public DBHelper_cust(Context context){
        super(context, dbname,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        String cust_table = "CREATE TABLE IF NOT EXISTS "+ table_name + "(" +
                id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                name + " TEXT NOT NULL," +
                country + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(cust_table);
        /*String order_table = "CREATE TABLE IF NOT EXISTS "+ table2 + "( " +
                id2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                name2 + " INTEGER NOT NULL, " +
                date + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(order_table);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newV){


    }

    public void openDB(){
        sqLiteDatabase = getWritableDatabase();
    }

    public void closeDB(){
        if(sqLiteDatabase!=null && sqLiteDatabase.isOpen()){
            sqLiteDatabase.close();
        }
    }

    public long insert(int cust_id, String cust_name, String cust_country){
        ContentValues contentValues = new ContentValues();
        if(cust_id != -1) {
            contentValues.put(id, cust_id);
        }
        contentValues.put(name,cust_name);
        contentValues.put(country,cust_country);
        return sqLiteDatabase.insert(table_name,null, contentValues);
    }


    public Cursor getAllRecords(){
        String sql = "SELECT * FROM " + table_name;
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public long update(int cust_id, String cust_name, String cust_country){
        ContentValues contentValues = new ContentValues();
        if(cust_id != -1){
            contentValues.put(id,cust_id);
        }
        contentValues.put(name,cust_name);
        contentValues.put(country,cust_country);
        String where = id + " = " + cust_id;
        return sqLiteDatabase.update(table_name,contentValues,where,null);
    }

    public long delete(int cust_id){
        String where = id + " = " + cust_id;
        return sqLiteDatabase.delete(table_name,where,null);
    }
}
