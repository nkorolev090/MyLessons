package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit;
    EditText surnameEdit;

    List<User> users;

    User newUser;
    TextView textView;

//    ListView userList;
    TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit = findViewById(R.id.editTextName);
        surnameEdit = findViewById(R.id.editTextSurname);
        textView = findViewById(R.id.textView);
        users = new ArrayList<>();


        //LoadFromDb();

    }
    public void onClickActivity(View view){
        String str_name = nameEdit.getText().toString();
        String str_surname = surnameEdit.getText().toString();

        if(str_name.length() != 0 && str_surname.length() != 0){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        User user = new User(str_name, str_surname);
        intent.putExtra("user", user);

        startActivity(intent);
        }
        else {
            Toast.makeText(this, "Заполните поля", Toast.LENGTH_SHORT).show();
        }

    }

    public  void LoadFromDb(){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name TEXT, surname TEXT, UNIQUE(name))");
        db.execSQL("INSERT OR IGNORE INTO users VALUES ('Никита', 'Королев'), ('Иван', 'Крайнов'), ('Матвей', 'Левашов') ;");

        Cursor query = db.rawQuery("SELECT * FROM users;", null);

        if(query.moveToFirst()){
            String name = query.getString(0);
            String surname = query.getString(1);
            nameEdit.setText(name);
            surnameEdit.setText(surname);
        }
        query.close();
        db.close();
    }
// public void onButtonClick(View view){
// String email = editMail.getText().toString();
// textView.setText("Welcome, " + email);
// Toast.makeText(this, "привет, " + email, Toast.LENGTH_LONG).show();
}