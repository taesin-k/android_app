package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalSearch extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_hospital);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.co.kr/maps/search/%EB%8F%99%EB%AC%BC%EB%B3%91%EC%9B%90"));
        startActivity(intent);

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
    }
}
