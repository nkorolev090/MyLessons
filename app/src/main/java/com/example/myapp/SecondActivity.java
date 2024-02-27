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
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textHello;

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linearLayout = findViewById(R.id.linear_users);
        LoadFromDb();

        Bundle argument = getIntent().getExtras();
        if(argument != null) {
            User user = argument.getParcelable("user");
        }
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