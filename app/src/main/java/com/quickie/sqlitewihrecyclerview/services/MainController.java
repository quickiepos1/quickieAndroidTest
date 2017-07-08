package com.quickie.sqlitewihrecyclerview.services;

import com.quickie.sqlitewihrecyclerview.model.Item;

import java.util.ArrayList;

/**
 * Created by user on 6/15/2017.
 */

public class MainController {

    private static MainController instance;
    private ArrayList<Item> orderedItems;

    String name;
    String category;
    int sale_price;
    int quantity;

//    Map<Item, Integer> m_cart;
//    double m_value = 0;

    private MainController() {
        this.orderedItems = new ArrayList<Item>();
//        m_cart = new LinkedHashMap<>();
    }

    public static MainController getInstance() {
        if (instance == null) {

            instance = new MainController();
        }
        return instance;
    }

    public void addOrderedItems(Item item) {


        Item orderedItem = new Item(name, category, sale_price, quantity);

        this.orderedItems.add(orderedItem);

//        if(m_cart.containsKey(item))
//            m_cart.put(item, m_cart.get(item) + 1);
//        else
//            m_cart.put(item, 1);
//
//        m_value += item.getSale_price();


    }

    public ArrayList<Item> getOrderedItems() {
        return this.orderedItems;
    }
}


 //   public Map<Item, Integer> getOrderedItems(){
  //      return this.m_cart;
   // }
    //experimental
//    int getQuantity(Item item)
//    {
//
//        return m_cart.get(item);
//    }
//
//    public Set getProducts()
//    {
//
//        return m_cart.keySet();
//    }
//
//
//
//    double getValue()
//    {
//        return m_value;
//    }
//
//    int getSize()
//    {
//        return m_cart.size();
//    }
//
//}
