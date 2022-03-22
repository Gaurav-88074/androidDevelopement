package com.example.chapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button showButton;
    private TextView table;
    private EditText userInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showButton = findViewById(R.id.button);
        table      = findViewById(R.id.table);
        userInput  = findViewById(R.id.userInput);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder res = new StringBuilder();
                int num = Integer.parseInt(userInput.getText().toString());
                for (int i =1 ;i<=10;i++){
                    res.append(convert(num)).append("  x  ").append(i).append(" = ").append(convert(num * i));
                    res.append("\n");
                }
                table.setText(res.toString());
            }
        });
    }
    protected String convert(int value){
        return String.valueOf(value);
    }
}