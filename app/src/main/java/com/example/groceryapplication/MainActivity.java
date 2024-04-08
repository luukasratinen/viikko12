package com.example.groceryapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.groceryapplication.fragments.AddGroceryFragment;
import com.example.groceryapplication.fragments.ListGroceryFragment;
import com.example.groceryapplication.fragments.MainPageFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddItem;
    private Button buttonMainPage;
    private Button buttonAllItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonMainPage = findViewById(R.id.MainPageFragment);
        buttonAddItem = findViewById(R.id.AddGroceryFragment);
        buttonAllItems = findViewById(R.id.ListGroceryFragment);

        buttonMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new MainPageFragment())
                        .commit();
            }
        });

        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new AddGroceryFragment())
                        .commit();
            }
        });

        buttonAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new ListGroceryFragment())
                        .commit();
            }
        });
    }

    public void addGrocery(String name, String note) {
        Grocery grocery = new Grocery(name, note);
        ListGrocery.getInstance().addGrocery(grocery);
    }
}