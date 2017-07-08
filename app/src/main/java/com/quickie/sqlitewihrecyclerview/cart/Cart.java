package com.quickie.sqlitewihrecyclerview.cart;

import com.quickie.sqlitewihrecyclerview.model.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 6/21/2017.
 */

public class
Cart {

    Map<Item, Integer> m_cart;
    double m_value = 0;

    Cart()
    {
        m_cart = new LinkedHashMap<>();
    }

   public  void addToCart(Item item)
    {
        if(m_cart.containsKey(item))
            m_cart.put(item, m_cart.get(item) + 1);
        else
            m_cart.put(item, 1);

        m_value += item.getSale_price();
    }

    int getQuantity(Item item)
    {

        return m_cart.get(item);
    }

    public Set getProducts()
    {

        return m_cart.keySet();
    }



    double getValue()
    {
        return m_value;
    }

    int getSize()
    {
        return m_cart.size();
    }
}
