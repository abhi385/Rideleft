package com.example.sys.rideleft;

/**
 * Created by sys on 6/21/2016.
 */
public class DriverDetails
{

    String name;
    int id;

    public DriverDetails(String name) {
        this.name = name;
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
