package com.example.groceryapplication;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {

    private Context context;
    private ArrayList<Grocery> groceries;

    public GroceryListAdapter(Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }


    @Override
    public GroceryViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grocery_view, parent, false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder( GroceryViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        holder.textGroceryName.setText(grocery.getName());
        holder.textGroceryNote.setText(grocery.getNote());
    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }

    public void updateGroceryList(ArrayList<Grocery> updatedList) {
        groceries.clear();
        groceries.addAll(updatedList);
        notifyDataSetChanged();
    }
}