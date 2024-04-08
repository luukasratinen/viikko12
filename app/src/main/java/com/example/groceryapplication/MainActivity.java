package com.example.groceryapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.groceryapplication.Fragments.AddGroceryFragment;
import com.example.groceryapplication.Fragments.MainPageFragment;
import com.example.groceryapplication.Fragments.ListGroceryFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragmentA = findViewById(R.id.MainPageFragment);
        Button fragmentB = findViewById(R.id.AddGroceryFragment);
        Button fragmentC = findViewById(R.id.ListGroceryFragment);

        fragmentA.setOnClickListener(listener);
        fragmentB.setOnClickListener(listener);
        fragmentC.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            if (view.getId() == R.id.MainPageFragment) {
                fragment = new MainPageFragment();
            } else if (view.getId() == R.id.AddGroceryFragment) {
                fragment = new AddGroceryFragment();
            } else if (view.getId() == R.id.ListGroceryFragment) {
                fragment = new ListGroceryFragment();
            } else {
                fragment = new MainPageFragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nakyma, fragment)
                    .commit();
        }
    };

    public void addGrocery(String name, String note) {
        Grocery grocery = new Grocery(name, note);
        ListGrocery.getInstance().addGrocery(grocery);
    }
}