package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textHello;

    LinearLayout linearLayout;

    ListView userList;
    //TextView header;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linearLayout = findViewById(R.id.linear_users);
        userList = findViewById(R.id.list);
        //LoadFromDb();

        Bundle argument = getIntent().getExtras();
        if(argument != null) {
            User user = argument.getParcelable("user");
        }

        databaseHelper = new DatabaseHelper(getApplicationContext());

    }

    @Override
    public void onResume() {
        super.onResume();

        db = databaseHelper.getReadableDatabase();

        //получаем данные из бд в виде курсора
        userCursor =  db.rawQuery("select * from "+ DatabaseHelper.TABLE, null);
        // определяем, какие столбцы из курсора будут выводиться в ListView
        String[] headers = new String[] {DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_YEAR};
        // создаем адаптер, передаем в него курсор
        userAdapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                userCursor, headers, new int[]{android.R.id.text1, android.R.id.text2}, 0);
        //header.setText("Найдено элементов: " +  userCursor.getCount());
        userList.setAdapter(userAdapter);
    }
    public  void LoadFromDb(){
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);

        Cursor query = db.rawQuery("SELECT * FROM users;", null);

        while(query.moveToNext()){
            String name = query.getString(0);
            String surname = query.getString(1);
            TextView textView = new TextView(this);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 30);

            textView.setText(name + " " + surname);
            linearLayout.addView(textView);
        }
        query.close();
        db.close();
    }
    public void onClickButton(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }
}