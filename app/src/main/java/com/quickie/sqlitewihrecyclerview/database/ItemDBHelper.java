package com.quickie.sqlitewihrecyclerview.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by user on 6/4/2017.
 */

public class ItemDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "item_db";
    public static final int DB_VERSION = 5;
    public static final String CREATE_QUERY = " CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME +"("+
                                                    ItemContract.ItemEntry.NAME +" text, "+
                                                   ItemContract.ItemEntry.CATEGORY +" text, "+
                                                    ItemContract.ItemEntry.SALE_PRICE +" INTEGER, " +
                                                   ItemContract.ItemEntry.QUANTITY +" INTEGER);";

    private   static final String DROP_TABLE ="DROP TABLE IF EXISTS "+ ItemContract.ItemEntry.TABLE_NAME;



    public ItemDBHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        Log.d("Database operations","Database is created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_QUERY);
            Log.d("Database operations","Database is created ");

        } catch (SQLiteException exception) {
            Log.d("Database operations","Database error ");
            exception.getMessage();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        onCreate(db);
        Log.d("Database operations","Database is upgraded ");

    }
    public void putInformation (String name,String category,int sale_price , int quantity, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemContract.ItemEntry.NAME,name);
        contentValues.put(ItemContract.ItemEntry.CATEGORY,category);
        contentValues.put(ItemContract.ItemEntry.SALE_PRICE,sale_price);
        contentValues.put(ItemContract.ItemEntry.QUANTITY,quantity);

        long l = db.insert(ItemContract.ItemEntry.TABLE_NAME,null,contentValues);
        Log.d("Database operations","One row inserted");

    }

    public Cursor getInformation (SQLiteDatabase db){

        String [] projections = {ItemContract.ItemEntry.NAME, ItemContract.ItemEntry.CATEGORY, ItemContract.ItemEntry.SALE_PRICE, ItemContract.ItemEntry.QUANTITY};
        Cursor cursor = db.query(ItemContract.ItemEntry.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;

    }
}
