package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle argument = getIntent().getExtras();

        textHello = findViewById(R.id.textViewHello);
        if(argument != null) {
        String name = argument.getString("name");
        String surname = argument.get("surname").toString();

        textHello.setText("Добро пожаловать, " + name + " " + surname);
        }
    }
    public void onClickButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }
}