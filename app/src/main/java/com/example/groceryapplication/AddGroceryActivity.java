
package com.example.groceryapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddGroceryActivity extends AppCompatActivity {

    private EditText editGroceryName, editGroceryNote;
    private Button buttonAddGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);

        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        buttonAddGrocery = findViewById(R.id.buttonAddGrocery);

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editGroceryName.getText().toString();
                String note = editGroceryNote.getText().toString();

                Grocery grocery = new Grocery(name, note);
                ListGrocery.getInstance().addGrocery(grocery);

                finish();
            }
        });
    }
}