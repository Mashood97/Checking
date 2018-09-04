package com.example.masho.checking;

/**
 * Created by OK Computers on 8/3/2018.
 */


public class FoodItemclass {
   private String Name;
   private int  Price;
   private int Quantity;

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public FoodItemclass(){}
    public FoodItemclass(String names, int prices)
    {
    Name = names;
    Price = prices;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }


}

