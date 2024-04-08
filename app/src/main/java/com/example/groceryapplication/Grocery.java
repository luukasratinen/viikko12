package com.example.groceryapplication;

public class Grocery {

    private final String name;
    private final String note;

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