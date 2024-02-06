package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;

    User newUser;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        textView = findViewById(R.id.textView);
    }
    public void onClickActivity(View view){
        String str_name = name.getText().toString();
        String str_surname = surname.getText().toString();

        if(str_name.length() != 0 && str_surname.length() != 0){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.putExtra("name", str_name);
        intent.putExtra("surname", str_surname);

        startActivity(intent);
        }
        else {
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
        }

    }
// public void onButtonClick(View view){
// String email = editMail.getText().toString();
// textView.setText("Welcome, " + email);
// Toast.makeText(this, "привет, " + email, Toast.LENGTH_LONG).show();
}