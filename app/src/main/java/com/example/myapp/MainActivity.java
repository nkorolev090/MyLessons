package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText surname;

    List<User> users;

    User newUser;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurname);
        textView = findViewById(R.id.textView);
        users = new ArrayList<>();
//        users.add(new User("name", "surname"));
//        users.add(new User("name1", "surname1"));
//        users.add(new User("name2", "surname2"));
    }
    public void onClickActivity(View view){
        String str_name = name.getText().toString();
        String str_surname = surname.getText().toString();

        if(str_name.length() != 0 && str_surname.length() != 0){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        User user = new User(str_name, str_surname);
//        intent.putExtra("name", str_name);
//        intent.putExtra("surname", str_surname);
        intent.putExtra("user", user);

//        users.add(new User(str_name, str_surname));
//            for (User user: users
//                 ) {
//                Log.d("Main", user.getName() + " " + user.getSurname());
//            }

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