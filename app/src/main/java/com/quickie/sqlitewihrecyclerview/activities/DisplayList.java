package com.quickie.sqlitewihrecyclerview.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.quickie.sqlitewihrecyclerview.R;
import com.quickie.sqlitewihrecyclerview.adapters.RecyclerAdapter;
import com.quickie.sqlitewihrecyclerview.database.ItemDBHelper;
import com.quickie.sqlitewihrecyclerview.model.Item;

import java.util.ArrayList;

public class DisplayList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

//        BackgroundTask backgroundTask = new BackgroundTask(DisplayList.this);
//         backgroundTask.execute();


        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ItemDBHelper itemDBHelper = new ItemDBHelper(this);
        SQLiteDatabase sqLiteDatabase = itemDBHelper.getReadableDatabase();


        Cursor cursor = itemDBHelper.getInformation(sqLiteDatabase);

        cursor.moveToFirst();
        do {
            Item item =  new Item(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3)
            );
            arrayList.add(item);
        }while(cursor.moveToNext());
        itemDBHelper.close();

        adapter = new RecyclerAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);


    }
}
