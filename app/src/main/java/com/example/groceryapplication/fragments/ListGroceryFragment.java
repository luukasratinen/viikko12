package com.example.groceryapplication.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.groceryapplication.R;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.groceryapplication.GroceryListAdapter;
import com.example.groceryapplication.ListGrocery;

public class ListGroceryFragment extends Fragment {

    public ListGroceryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_grocery, container, false);

        RecyclerView rvGroceries = view.findViewById(R.id.rvGroceries);

        GroceryListAdapter adapter = new GroceryListAdapter(getContext(), ListGrocery.getInstance().getGroceries());
        rvGroceries.setAdapter(adapter);
        rvGroceries.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}