package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ShowFood extends Activity {

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

        EditText name = (EditText) findViewById(R.id.pro_1);
        EditText protein = (EditText) findViewById(R.id.pro_2);
        EditText fat = (EditText) findViewById(R.id.pro_3);
        EditText cal = (EditText) findViewById(R.id.pro_4);
        EditText com = (EditText) findViewById(R.id.pro_5);
        DatabaseHelper myHelper = new DatabaseHelper(this,"new",null,1);

        SQLiteDatabase sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor=sqlDB.rawQuery("SELECT * FROM food;",null);

        String name1="";
        String protein1="";
        String fat1="";
        String cal1="";
        String com1="";

        name1="이름" + "\r\n" + "__________" + "\r\n";
        protein1="조단백" + "\r\n" + "__________" + "\r\n";
        fat1="조지방" + "\r\n" + "__________" + "\r\n";
        cal1="칼슘" + "\r\n" + "__________" + "\r\n";
        com1="주성분" + "\r\n" + "__________" + "\r\n";

        while(cursor.moveToNext()){
            name1 += cursor.getString(1)+"\r\n";
            protein1 += cursor.getString(2)+"\r\n";
            fat1 += cursor.getString(3)+"\r\n";
            cal1 += cursor.getString(4)+"\r\n";
            com1 += cursor.getString(5)+"\r\n";
        }

        name.setText(name1);
        protein.setText(protein1);
        fat.setText(fat1);
        cal.setText(cal1);
        com.setText(com1);

        cursor.close();
        sqlDB.close();
    }
}
