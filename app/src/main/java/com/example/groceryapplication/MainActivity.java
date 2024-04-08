package com.example.groceryapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.groceryapplication.Fragments.AddGroceryFragment;
import com.example.groceryapplication.Fragments.ListGroceryFragment;
import com.example.groceryapplication.Fragments.MainPageFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragmentA = findViewById(R.id.MainPageFragment3);
        Button fragmentB = findViewById(R.id.AddGroceryFragment3);
        Button btnTab = findViewById(R.id.ListGroceryFragment3);

        fragmentA.setOnClickListener(listener);
        fragmentB.setOnClickListener(listener);
        btnTab.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            if (view.getId() == R.id.MainPageFragment3) {
                fragment = new MainPageFragment();
            } else if (view.getId() == R.id.AddGroceryFragment3) {
                fragment = new AddGroceryFragment();
            } else if (view.getId() == R.id.ListGroceryFragment3) {
                fragment = new ListGroceryFragment();
            } else {
                fragment = new MainPageFragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.MainPageFragment, fragment)
                    .commit();
        }
    };

    public void addGrocery(String name, String note) {
        Grocery grocery = new Grocery(name, note);
        ListGrocery.getInstance().addGrocery(grocery);
    }
}