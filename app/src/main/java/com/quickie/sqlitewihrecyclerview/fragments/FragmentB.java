package com.quickie.sqlitewihrecyclerview.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.quickie.sqlitewihrecyclerview.R;
import com.quickie.sqlitewihrecyclerview.adapters.CustomAdapter;
import com.quickie.sqlitewihrecyclerview.cart.Cart;
import com.quickie.sqlitewihrecyclerview.model.Item;
import com.quickie.sqlitewihrecyclerview.services.MainController;

import java.util.ArrayList;

public class FragmentB extends Fragment {

    CustomAdapter adapter;
    ArrayList<Item> orderedItems;
    //Map<Item, Integer> orderedItems;
    TextView textView;
    ListView listView;
    static Cart m_cart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_b, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


       orderedItems =  MainController.getInstance().getOrderedItems();


        listView = (ListView) getActivity().findViewById(R.id.list_view_cart);
        adapter = new CustomAdapter(getActivity(), R.id.list_view_cart, orderedItems);
        listView.setAdapter(adapter);

      textView = (TextView) getActivity().findViewById(R.id.receipt);

    }

    public void changeData(Item item) {
        //Resources res = getResources();
        //String [] details = res.getStringArray(R.array.details);

        orderedItems.add(item);
        //orderedItems.put(item, 1);
    }

    public void refreshList() {

        this.adapter.notifyDataSetChanged();

    }



}
