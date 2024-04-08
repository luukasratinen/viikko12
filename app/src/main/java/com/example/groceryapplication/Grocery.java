package com.example.groceryapplication;

public class Grocery {

    private String name;
    private String note;

    public Grocery(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

}