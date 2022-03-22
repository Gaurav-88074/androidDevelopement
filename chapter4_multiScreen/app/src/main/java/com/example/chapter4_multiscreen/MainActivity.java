package com.example.chapter4_multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nameInput;
    public static final String ExtraUserInputName = "userInputName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.nameInput);
    }
    public void openActivity(View v){
        List<String> array  = new LinkedList<>();
        array.add("Gaurav");
        array.add("Vision");
        array.add("Wanda");
        Toast.makeText(this,"opening",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity2.class);
//        String userInputName = nameInput.getText().toString();
        intent.putExtra(ExtraUserInputName,(Serializable)array);
        startActivity(intent);
    }
}