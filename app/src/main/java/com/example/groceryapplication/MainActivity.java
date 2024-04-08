package com.example.groceryapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.groceryapplication.fragments.AddGroceryFragment;
import com.example.groceryapplication.fragments.ListGroceryFragment;
import com.example.groceryapplication.fragments.MainPageFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonMainPage;
    private Button buttonAddItem;
    private Button buttonAllItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMainPage = findViewById(R.id.MainPageFragment2);
        buttonAddItem = findViewById(R.id.AddGroceryFragment2);
        buttonAllItems = findViewById(R.id.ListGroceryFragment2);

        buttonMainPage.setOnClickListener(this);
        buttonAddItem.setOnClickListener(this);
        buttonAllItems.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Fragment fragment;
        int id = v.getId();

        if (id == R.id.MainPageFragment2) {
            fragment = new MainPageFragment();
        } else if (id == R.id.AddGroceryFragment2) {
            fragment = new AddGroceryFragment();
        } else if (id == R.id.ListGroceryFragment2) {
            fragment = new ListGroceryFragment();
        } else {
            fragment = new MainPageFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }

    public void addGrocery(String name, String note) {
        Grocery grocery = new Grocery(name, note);
        ListGrocery.getInstance().addGrocery(grocery);
    }
}