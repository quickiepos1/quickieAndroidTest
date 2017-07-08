package com.quickie.sqlitewihrecyclerview.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.quickie.sqlitewihrecyclerview.R;
import com.quickie.sqlitewihrecyclerview.fragments.FragmentB;
import com.quickie.sqlitewihrecyclerview.interfaces.Communicator;
import com.quickie.sqlitewihrecyclerview.model.Item;

public class FragmentActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }


    @Override
    public void respond(Item item) {

       android.app.FragmentManager manager = getFragmentManager();
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment_b);
        fragmentB.changeData(item);

    }

    @Override
    public void refreshCartList() {

        android.app.FragmentManager manager = getFragmentManager();
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment_b);
        fragmentB.refreshList();
    }
}
