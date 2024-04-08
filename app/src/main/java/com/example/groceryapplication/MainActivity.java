package com.example.groceryapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.groceryapplication.fragments.AddGroceryFragment;
import com.example.groceryapplication.fragments.ListGroceryFragment;
import com.example.groceryapplication.fragments.MainPageFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvGroceries;
    private GroceryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Etsi näkymät
        rvGroceries = findViewById(R.id.rvGroceries);

        // Luodaan tyhjä lista ja asetetaan adapteri
        ArrayList<Grocery> groceries = new ArrayList<>();
        adapter = new GroceryListAdapter(this, groceries);
        rvGroceries.setAdapter(adapter);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));

        // Etsi napit
        Button buttonMainPage = findViewById(R.id.button1);
        Button buttonAddItem = findViewById(R.id.button2);
        Button buttonAllItems = findViewById(R.id.button3);

        // Napin toiminta pääsivulle
        buttonMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new MainPageFragment())
                        .commit();
            }
        });

        // Napin toiminta tuotteen lisäämiseksi
        buttonAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new AddGroceryFragment())
                        .commit();
            }
        });

        // Napin toiminta kaikkien tuotteiden näyttämiseksi
        buttonAllItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, new ListGroceryFragment())
                        .commit();
            }
        });
    }

    // Metodi uuden tuotteen lisäämiseksi
    public void addGrocery(String name, String note) {
        Grocery grocery = new Grocery(name, note);
        ListGrocery.getInstance().addGrocery(grocery);
        adapter.updateGroceryList(ListGrocery.getInstance().getGroceries());
    }
}