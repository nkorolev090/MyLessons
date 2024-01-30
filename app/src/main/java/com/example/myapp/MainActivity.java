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

public class MainActivity extends AppCompatActivity {

    EditText editMail;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editMail = findViewById(R.id.editTextTextEmailAddress);
        textView = findViewById(R.id.textView);
    }
    public void onClickActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
// public void onButtonClick(View view){
// String email = editMail.getText().toString();
// textView.setText("Welcome, " + email);
// Toast.makeText(this, "привет, " + email, Toast.LENGTH_LONG).show();
}