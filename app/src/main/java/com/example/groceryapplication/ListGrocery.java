package com.example.groceryapplication;

import java.util.ArrayList;

public class ListGrocery {

    private static ListGrocery instance;
    private ArrayList<Grocery> groceries;

    private ListGrocery() {
        groceries = new ArrayList<>();
    }

    public static synchronized ListGrocery getInstance() {
        if (instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceries) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }
}