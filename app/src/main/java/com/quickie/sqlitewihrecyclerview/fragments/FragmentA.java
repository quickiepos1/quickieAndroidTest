package com.quickie.sqlitewihrecyclerview.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.quickie.sqlitewihrecyclerview.R;
import com.quickie.sqlitewihrecyclerview.adapters.ItemGridViewAdapter;
import com.quickie.sqlitewihrecyclerview.database.ItemDBHelper;
import com.quickie.sqlitewihrecyclerview.interfaces.Communicator;
import com.quickie.sqlitewihrecyclerview.model.Item;

import java.util.ArrayList;


public class FragmentA extends Fragment
        //implements AdapterView.OnItemClickListener
        {

    private RecyclerView recyclerView;
    private ItemGridViewAdapter adapter;
    ArrayList<Item> arrayList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    TextView receipt;


    Communicator communicator;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fargment_a, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicator = (Communicator) getActivity();
//        listView = (ListView) getActivity().findViewById(R.id.list_view);
//        arrayList = this.getItems();
//        CustomAdapter adapter = new CustomAdapter(getActivity(),R.id.list_view,arrayList);

        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);

//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(this);

        receipt = (TextView) getActivity().findViewById(R.id.receipt);

        receipt.setPaintFlags(receipt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.grid_recyclerView);

        layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        ItemDBHelper itemDBHelper = new ItemDBHelper(getActivity());
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

        adapter = new ItemGridViewAdapter(getActivity(),arrayList);
        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = recyclerView.indexOfChild(v);
                Item item =  arrayList.get(pos);

                communicator.respond(item);
                communicator.refreshCartList();


            }
        });
        recyclerView.setAdapter(adapter);


    }

//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Item item = this.arrayList.get(position);
//
//        communicator.respond(item);
//        communicator.refreshCartList();
//
//    }
//
//    public ArrayList<Item> getItems() {
//        ArrayList arrayList = new ArrayList<Item>();
//        Item item = new Item("Oil",
//                "Cooking Oil", 70, 300
//        );
//
//        arrayList.add(item);
//
//        Item item2 = new Item("Soda",
//                "Cooking Oil", 70, 300);
//        arrayList.add(item2);
//        return arrayList;
//    }
}

