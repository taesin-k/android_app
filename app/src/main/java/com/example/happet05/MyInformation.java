package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyInformation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_information);

        Button go_home = (Button) findViewById(R.id.go_home);       //햅펫몰 이동
        go_home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Shopping.class);
                startActivity(intent);
            }
        });

        Button search_hos = (Button) findViewById(R.id.search_hos);       //병원찾기 이동
        search_hos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HospitalSearch.class);
                startActivity(intent);
            }
        });


        EditText id = (EditText) findViewById(R.id.my_id);
        EditText name = (EditText) findViewById(R.id.my_name);
        EditText phone = (EditText) findViewById(R.id.my_phone);
        EditText email = (EditText) findViewById(R.id.my_email);
        DatabaseHelper myHelper = new DatabaseHelper(this,"new",null,1);

        SQLiteDatabase sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor=sqlDB.rawQuery("SELECT * FROM test2 ORDER BY ROWID DESC LIMIT 1;",null);


        String id1="";
        String name1="";
        String phone1="";
        String email1="";
        String ss="ss";

        while(cursor.moveToNext()){
            id1 += cursor.getString(1);
            name1 += cursor.getString(3);
            phone1 += cursor.getString(4);
            email1 += cursor.getString(5);
        }

        id.setText(id1);
        name.setText(name1);
        phone.setText(phone1);
        email.setText(email1);

        cursor.close();
        sqlDB.close();

        Button my_inf = (Button) findViewById(R.id.my_inf);       //내정보 이동
        my_inf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });


    }
}