package com.example.question12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends AppCompatActivity {
    private Button saveButton;
    public EditText username;
    public EditText coursename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        saveButton = findViewById(R.id.saveButton);

        username   = findViewById(R.id.userName);
        coursename = findViewById(R.id.courseName);

        Toast t = Toast.makeText(this, "Saved!",Toast.LENGTH_SHORT);
        DbHandler handler = new DbHandler(this,"studentDb",null,1);
        Intent intent = new Intent(this,MainActivity.class);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.addStudent(new Student(
                            username.getText().toString(),
                            coursename.getText().toString()
                        )
                );
                t.show();
                startActivity(intent);
            }
        });
    }
}