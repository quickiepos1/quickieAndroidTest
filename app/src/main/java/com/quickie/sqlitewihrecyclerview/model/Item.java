package com.quickie.sqlitewihrecyclerview.model;

/**
 * Created by user on 5/22/2017.
 */

public class Item  {

    private String name;
    private int sale_price;
    private int quantity;
    private String category;


    public Item(
                String name,
                String category,
                int sale_price,
                int quantity) {

        this.setName(name);
        this.setCategory(category);
        this.setSale_price(sale_price);
        this.setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSale_price() {
        return sale_price;
    }

    public void setSale_price(int sale_price) {
        this.sale_price = sale_price;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NAME: " + name +
                "CATEGORY: " + category
                + "SALE PRICE: " + sale_price
                + "QUANTITY: " + quantity;

    }

}
