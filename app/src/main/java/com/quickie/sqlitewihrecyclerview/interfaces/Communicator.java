package com.quickie.sqlitewihrecyclerview.interfaces;

import com.quickie.sqlitewihrecyclerview.model.Item;

/**
 * Created by user on 6/11/2017.
 */

public interface Communicator {

    public void respond(Item item);
    public void refreshCartList();
}
