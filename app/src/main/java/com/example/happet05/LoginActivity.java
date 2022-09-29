package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {
    Button button;
    SQLiteDatabase newDB;


    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (newDB == null) {
            String dbName = "new";
            openDatabase(dbName);
        } else {
            Toast.makeText(this, "new", Toast.LENGTH_LONG).show();
        }
        button = (Button) findViewById(R.id.btn_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, 101);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 101 && resultCode == RESULT_OK) {
            String userId = data.getStringExtra("userId");

            Intent intent = new Intent(getApplicationContext(), Shopping.class);
            intent.putExtra("userId", userId);
            startActivityForResult(intent, 102);

        } else {
            //button.setText("로그인에 실패했습니다.\n 다시 로그인 해주세요");
        }
    }

    public void openDatabase(String dbName) {
        DatabaseHelper helper = new DatabaseHelper(this, dbName, null, 1);
        newDB = helper.getWritableDatabase();




    }
}
