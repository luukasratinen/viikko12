package com.example.groceryapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGroceries;
    private Button buttonAddNewGrocery;
    private ArrayList<Grocery> groceries;
    private GroceryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGroceries = findViewById(R.id.rvGroceries);
        buttonAddNewGrocery = findViewById(R.id.buttonAddNewGrocery);

        groceries = new ArrayList<>();
        adapter = new GroceryListAdapter(this, groceries);
        rvGroceries.setAdapter(adapter);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));

        buttonAddNewGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddGroceryActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.updateGroceryList(ListGrocery.getInstance().getGroceries());
    }
}