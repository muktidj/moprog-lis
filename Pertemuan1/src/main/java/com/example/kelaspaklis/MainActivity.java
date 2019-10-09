package com.example.kelaspaklis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.content.Intent;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1=(Button)findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i =new
                        Intent(getApplicationContext(),HorizontalActivity.class);
                startActivity(i);
            }
        });
        Button button2=(Button)findViewById(R.id.button7);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i =new
                        Intent(getApplicationContext(),VerticalActivity.class);
                startActivity(i);
            }
        });
        Button button3=(Button)findViewById(R.id.button8);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent i =new
                        Intent(getApplicationContext(),RelativeLayout.class);
                startActivity(i);
            }
        });
    }
}

