package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    EditText userId;
    EditText userPassword;
    EditText userName;
    EditText userPhone;
    EditText userEmail;
    SQLiteDatabase newDB;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        helper = new DatabaseHelper(this, "new", null, 1);
        userId = (EditText) findViewById(R.id.et_id);
        userPassword = (EditText) findViewById(R.id.et_pass);
        userName = (EditText) findViewById(R.id.et_name);
        userPhone = (EditText) findViewById(R.id.et_phone);
        userEmail = (EditText) findViewById(R.id.et_email);

        Button btn_register1 = (Button) findViewById(R.id.btn_register1);       //회원 가입 페이지에서 회원가입 버튼 누름
        btn_register1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String id = userId.getText().toString().trim();
                String password = userPassword.getText().toString().trim();
                String name = userName.getText().toString().trim();
                String phone = userPhone.getText().toString().trim();
                String email = userEmail.getText().toString().trim();

                if (id.length() < 6 || password.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "아이디 여섯 글자 이상 \n" +
                            "비밀번호 여섯 글자 이상" +
                            "\n 입력해주세요.", Toast.LENGTH_LONG).show();
                } else {
                    insertData(id, password);
                    insertData2(id, password, name, phone, email);
                    setResult(Activity.RESULT_OK);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
    public void insertData(String id, String password) {
        newDB = helper.getWritableDatabase();

        String sql = ("insert into test(userId, password) values " +
                "(" + "'" + id + "'" + "," + "'" + password + "'" + ")");

        newDB.execSQL(sql);
    }

    public void insertData2(String id, String password, String name, String phone, String email) {
        newDB = helper.getWritableDatabase();

        String sql = ("insert into test2(userId, password, name, phone, email) values " +
                "(" + "'" + id + "'" + "," + "'" + password + "'" + "," + "'" + name + "'"+ "," + "'" + phone + "'"+ "," + "'" + email + "'" + ")");

        newDB.execSQL(sql);
    }
}