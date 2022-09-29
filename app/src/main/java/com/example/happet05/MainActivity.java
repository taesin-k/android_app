package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button memberButton;
    EditText id;
    EditText password;
    String userId;
    boolean userExist;
    SQLiteDatabase newDB;
    DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new DatabaseHelper(this, "new", null, 1);
        loginButton = (Button) findViewById(R.id.btn_login);
        memberButton = (Button) findViewById(R.id.btn_register);
        id = (EditText) findViewById(R.id.et_id);
        password = (EditText) findViewById(R.id.et_pass);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                userExist = false;

                String isId = id.getText().toString().trim();
                String isPass = password.getText().toString().trim();
                if (isId.length() > 4 && isPass.length() > 4)
                    searchData(isId, isPass);
                else
                    Toast.makeText(MainActivity.this, "입력이 잘못되었습니다.", Toast.LENGTH_SHORT);

                if (userExist) {
                    Intent intent = new Intent();
                    intent.putExtra("userId", userId);
                    setResult(Activity.RESULT_OK, intent);
                    Intent intent2 = new Intent(getApplicationContext(), Shopping.class);           //메인으로 이동
                    startActivity(intent2);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "아이디 혹은 비밀번호가" +
                            "없거나 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                }
            }

        });

        Button btn_register = (Button) findViewById(R.id.btn_register);       //회원가입 버튼 누르면 회원가입으로 이동
        btn_register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });


    }

    public void searchData(String isId, String isPass) {
        newDB = helper.getReadableDatabase();
        String sql = ("select userId, password from test");
        Cursor cursor = newDB.rawQuery(sql, null);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String id = cursor.getString(0);
            String password = cursor.getString(1);
            if (id.equals(isId) && password.equals(isPass)) {
                userId = id;
                userExist = true;
                break;
            }
        }
    }

}


