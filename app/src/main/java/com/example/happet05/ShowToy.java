package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowToy extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_information);

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

        Button my_inf = (Button) findViewById(R.id.my_inf);       //내정보 이동
        my_inf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });

        EditText name = (EditText) findViewById(R.id.pro_2);
        EditText type = (EditText) findViewById(R.id.pro_3);
        EditText com = (EditText) findViewById(R.id.pro_4);
        DatabaseHelper myHelper = new DatabaseHelper(this,"new",null,1);

        SQLiteDatabase sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor=sqlDB.rawQuery("SELECT * FROM toy;",null);

        String name1="";
        String type1="";
        String com1="";

        name1="이름" + "\r\n" + "__________" + "\r\n";
        type1="종류" + "\r\n" + "__________" + "\r\n";
        com1="주성분" + "\r\n" + "__________" + "\r\n";

        while(cursor.moveToNext()){
            name1 += cursor.getString(1)+"\r\n";
            type1 += cursor.getString(2)+"\r\n";
            com1 += cursor.getString(3)+"\r\n";
        }

        name.setText(name1);
        type.setText(type1);
        com.setText(com1);

        cursor.close();
        sqlDB.close();
    }
}