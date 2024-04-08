package com.example.groceryapplication.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.groceryapplication.R;
import android.widget.Button;
import android.widget.EditText;
import com.example.groceryapplication.MainActivity;

public class AddGroceryFragment extends Fragment {

    private EditText editGroceryName, editGroceryNote;

    public AddGroceryFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_grocery, container, false);

        editGroceryName = view.findViewById(R.id.editGroceryName);
        editGroceryNote = view.findViewById(R.id.editGroceryNote);
        Button buttonAddGrocery = view.findViewById(R.id.buttonAddGrocery);

        buttonAddGrocery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editGroceryName.getText().toString();
                String note = editGroceryNote.getText().toString();

                MainActivity activity = (MainActivity) getActivity();
                if (activity != null) {
                    activity.addGrocery(name, note);
                    editGroceryName.getText().clear();
                    editGroceryNote.getText().clear();
                }
            }
        });

        return view;
    }
}