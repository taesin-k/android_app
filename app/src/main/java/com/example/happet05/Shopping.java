package com.example.happet05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Shopping extends Activity {

    ViewFlipper v_fllipper;
    ViewFlipper v_fllipper2;
    ViewFlipper v_fllipper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        int images[] = {
                R.drawable.food1,
                R.drawable.food2,
                R.drawable.food3
        };
        int images2[] = {
                R.drawable.snack1,
                R.drawable.snack2,
        };
        int images3[] = {
                R.drawable.toy1,
                R.drawable.toy2,
        };
        v_fllipper = findViewById(R.id.image_slide);
        v_fllipper2 = findViewById(R.id.image_slide1);
        v_fllipper3 = findViewById(R.id.image_slide2);

        for(int image : images) {
            fllipperImages(image);

        }
        for(int image : images2) {
            fllipperImages2(image);

        }
        for(int image : images3) {
            fllipperImages3(image);

        }
        v_fllipper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowFood.class);
                startActivity(intent);
            }
        });
        v_fllipper2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowSnack.class);
                startActivity(intent);
            }
        });
        v_fllipper3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ShowToy.class);
                startActivity(intent);
            }
        });


    }

    // 이미지 슬라이더 구현 메서드
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    public void fllipperImages2(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper2.addView(imageView);      // 이미지 추가
        v_fllipper2.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper2.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper2.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper2.setOutAnimation(this,android.R.anim.slide_out_right);
    }
    public void fllipperImages3(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper3.addView(imageView);      // 이미지 추가
        v_fllipper3.setFlipInterval(4000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper3.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper3.setInAnimation(this,android.R.anim.slide_in_left);
        v_fllipper3.setOutAnimation(this,android.R.anim.slide_out_right);
    }


}