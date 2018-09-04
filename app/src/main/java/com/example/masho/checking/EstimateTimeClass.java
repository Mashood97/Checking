package com.example.masho.checking;

/**
 * Created by OK Computers on 8/26/2018.
 */

public class EstimateTimeClass {

    private String Name;
    private int  Age;

    public int getAge() {
        return Age;
    }

    public void setUid(int uid) {
        this.Age = uid;
    }

    public EstimateTimeClass(){}
    public EstimateTimeClass(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setItemName(String itemName) {
        Name = itemName;
    }
}
