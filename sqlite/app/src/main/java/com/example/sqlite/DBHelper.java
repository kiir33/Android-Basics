package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String dbname ="kiran_db";
    public static int  VERSION = 1;
    public static String table_name = "PHONEBOOK";
    public static String id = "ID";
    public static String name = "NAME";
    public static String phone = "PHONE";

    SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context){
        super(context, dbname,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sql = "CREATE TABLE IF NOT EXISTS "+ table_name + "(" +
                id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                name + " TEXT NOT NULL," +
                phone + " TEXT NOT NULL)";
        //String sql = "CREATE TABLE IF NOT EXISTS PHONEBOOK (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, PHONE TEXT);";
        sqLiteDatabase.execSQL(sql);
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

    public long insert(int Id, String Name, String Phone){
        ContentValues contentValues = new ContentValues();
        if(Id != -1) {
            contentValues.put(id, Id);
        }
        contentValues.put(name,Name);
        contentValues.put(phone,Phone);
        return sqLiteDatabase.insert(table_name,null, contentValues);
    }

    public Cursor getAllRecords(){
        String sql = "SELECT * FROM " + table_name;
        return sqLiteDatabase.rawQuery(sql, null);
    }

    public long update(int Id, String Name, String Phone){
        ContentValues contentValues = new ContentValues();
        if(Id != -1){
            contentValues.put(id,Id);
        }
        contentValues.put(name,Name);
        contentValues.put(phone,Phone);
        String where = id + " = " + Id;
        return sqLiteDatabase.update(table_name,contentValues,where,null);
    }

    public long delete(int Id){
        String where = id + " = " + Id;
        return sqLiteDatabase.delete(table_name,where,null);
    }
}
