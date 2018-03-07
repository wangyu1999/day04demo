package com.example.day04demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Xiangqing extends AppCompatActivity {

    private ImageView img;
    private TextView contenet;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        initView();
        initData();
        initListener();
    }
    private void initListener() {
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {
        String content1 = getIntent().getStringExtra("content");
        String img1 = getIntent().getStringExtra("img");
        String name1 = getIntent().getStringExtra("name");

        contenet.setText(content1);
        name.setText(name1);
        Picasso.with(Xiangqing.this).load(img1).into(img);
    }
    private void initView() {
        img = (ImageView) findViewById(R.id.img);
        contenet = (TextView) findViewById(R.id.contenet);
        name = (TextView) findViewById(R.id.name);
    }
}
