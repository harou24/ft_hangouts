package com.example.ft_hangouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    DataBase db;
    ArrayList<String> names;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        try {
                            Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                            startActivity(intent);
                        }
                        catch(Exception e)
                        {
                            e.getCause();
                            e.printStackTrace();
                        }
                    }
                }
        );

        db = new DataBase(MainActivity.this);
        names = (ArrayList<String>) db.getAllNames();
        adapter = new CustomAdapter(MainActivity.this, names);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}