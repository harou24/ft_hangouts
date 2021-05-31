package com.example.ft_hangouts;
import com.example.ft_hangouts.R;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddContactActivity extends AppCompatActivity {

    Button add;
    EditText firstname;
    EditText lastname;
    EditText nickname;
    EditText mobile;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add = findViewById(R.id.add);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        nickname = findViewById(R.id.nickname);
        mobile = findViewById(R.id.mobile);
        age = findViewById(R.id.age);


        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                DataBase db = new DataBase(AddContactActivity.this);

                db.add_contact(new Contact(0, firstname.getText().toString(),
                        lastname.getText().toString(),
                        nickname.getText().toString(),
                        mobile.getText().toString(),
                        20));
                Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                startActivity(intent);
               
            }
        });
    }
}
