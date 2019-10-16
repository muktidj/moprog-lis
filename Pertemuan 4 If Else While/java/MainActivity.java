package com.example.kelaspaklis4ifelse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.CursorAnchorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.content.Context;

public class MainActivity extends AppCompatActivity {
    private Button menuif, menuwhile, menukeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuif = (Button) findViewById(R.id.btnif);
        menukeluar = (Button) findViewById(R.id.btnkeluar);
        menuwhile = (Button) findViewById(R.id.btnulang);
        menuif.setOnClickListener(new
                                          View.OnClickListener() {
                                              @Override
                                              public void onClick(View view) {
                                                  Intent i = new Intent(MainActivity.this,
                                                          IfActivity.class);
                                                  startActivity(i);
                                              }
                                          });
        menuwhile.setOnClickListener(new
                                             View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View view) {
                                                     Intent i = new Intent(MainActivity.this,
                                                            IfActivity.class);
                                                     startActivity(i);
                                                 }
                                             });
        menukeluar.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                      finish();
                                                  }
                                              });
    }
}